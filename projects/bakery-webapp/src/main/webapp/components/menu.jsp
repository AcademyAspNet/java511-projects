<%@ page pageEncoding="UTF-8" %>
<%@ page import="ru.academy.bakery.model.Product" %>

<%
    Product[] products = (Product[]) request.getAttribute("products");
%>

<section id="menu" class="bg-white py-5">
    <div class="container">
        <h2 class="section-title fw-bold">Наши хиты</h2>
        <div class="row g-4">
            <% for (Product product : products) { %>
                <div class="col-md-4 col-sm-6">
                    <div class="product-card">
                        <img src="<%= product.imageUrl() %>"
                            class="rounded-4 w-100 mb-3" alt="<%= product.name() %>" />
                        <h5 class="fw-bold"><%= product.name() %></h5>
                        <p class="text-muted mb-3"><%= product.description() %></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <span class="fs-5 fw-bold"><%= product.price() %> ₽</span>
                            <% if (product.isAvailable()) { %>
                                <button class="btn btn-outline-dark btn-sm">В корзину</button>
                            <% } else { %>
                                <button class="btn btn-outline-dark btn-sm" disabled>
                                    Товар закончился
                                </button>
                            <% } %>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>
    </div>
</section>