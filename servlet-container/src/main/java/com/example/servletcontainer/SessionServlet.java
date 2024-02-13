package com.example.servletcontainer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "sessionServlet", value = "/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer count = session.getAttribute("count") == null ? 0 : (Integer) session.getAttribute("count");

        session.setAttribute("count", count);

        resp.getWriter().write("Welcome back! You have visited this page " + count + " times.");
        resp.setContentType("text/html");
    }
}
