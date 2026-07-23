package ru.academy.bakery.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.academy.bakery.model.Product;
import ru.academy.bakery.service.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService productService = new ProductService();
        Product[] products = productService.getRandomProducts(10);

        request.setAttribute("products", products);

        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }
}
