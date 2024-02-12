package com.example;

import com.example.template.MyNamedParameterJdbcTemplate;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnMissingBean(DataSource.class)
@EnableConfigurationProperties(MyDatabaseProperties.class)
public class MyDatabaseAutoconfigure {

    @Bean
    public DataSource dataSource(MyDatabaseProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(properties.getJdbcUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClassName());

        return dataSource;
    }

    @Bean
    public MyNamedParameterJdbcTemplate myNamedParameterJdbcTemplate(DataSource dataSource) {
        return new MyNamedParameterJdbcTemplate(dataSource);
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
            .dataSource(dataSource)
            .locations("classpath:db/migration")
            .createSchemas(true)
            .baselineOnMigrate(true)
            .load();
    }
}
