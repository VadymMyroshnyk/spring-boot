package com.example.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;

import javax.sql.DataSource;
import java.util.Map;

public class MyNamedParameterJdbcTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyNamedParameterJdbcTemplate.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MyNamedParameterJdbcTemplate(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public String queryForString(@NonNull String sql) {
        long start = System.currentTimeMillis();
        LOGGER.info("Executing query: {}", sql);
        String result = namedParameterJdbcTemplate.queryForObject(sql, Map.of(), String.class);
        LOGGER.info("Query executed successfully, took {}ms", System.currentTimeMillis() - start);
        return result;
    }

    public int update(@NonNull String sql,
                      @NonNull Map<String, ?> paramMap) {
        long start = System.currentTimeMillis();
        LOGGER.info("Executing update: {}", sql);
        int row = namedParameterJdbcTemplate.update(sql, paramMap);
        LOGGER.info("Update executed successfully, took {}ms", System.currentTimeMillis() - start);
        return row;
    }
}
