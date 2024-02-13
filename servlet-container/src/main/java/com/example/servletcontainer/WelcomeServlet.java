package com.example.servletcontainer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "welcomeServlet", value = "/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        System.out.println("name: " + name);

        Cookie[] cookies = req.getCookies();

        int count = 0;
        for (Cookie cookie : cookies) {
            if ("count".equals(cookie.getName())) {
                count = Integer.parseInt(cookie.getValue());
            }
        }

        count++;

        Cookie cookie = new Cookie("count", String.valueOf(count));
        cookie.setHttpOnly(true);

        resp.addCookie(cookie);

        resp.getWriter().write("Welcome back" + name +"! You have visited this page " + count + " times.");
        resp.setContentType("text/html");
    }
}
