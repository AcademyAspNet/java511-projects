<%@ page pageEncoding="UTF-8" import="java.util.Date, java.util.Random" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8" />
        <title>Домашняя страница</title>
    </head>
    <body>
        <p>JSP Expressions (JSP Выражения)</p>

        <p>1 + 4 = <%= 1 + 4 %></p>
        <p>100 + 100 = <%= 100 + 100 %></p>
        <p>1024 * 2 = <%= 1024 * 2 %></p>
        <p><%= "Hello, " + "World!" %></p>
        <p><%= "Сумма: " + (1024 + 4096) %></p>
        <p><%= new Date() %></p>

        <%
            Random random = new Random();
            int a = random.nextInt();
            int b = random.nextInt();
        %>

        <p><%= a %> + <%= b %> = <%= a + b %></p>
    </body>
</html>