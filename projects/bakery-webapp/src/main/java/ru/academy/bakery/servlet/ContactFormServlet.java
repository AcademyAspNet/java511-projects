package ru.academy.bakery.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/contact-form")
public class ContactFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        System.out.println("Получено новое обращение от пользователя:");
        System.out.println("Имя пользователя: " + name);
        System.out.println("Адрес электронной почты: " + email);
        System.out.println("Сообщение от пользователя: " + message);

        response.sendRedirect(request.getContextPath() + "/?feedbackSent=1");
    }
}
