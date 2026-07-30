<%
    String rawFirstNumber = request.getParameter("firstNumber");
    double firstNumber = Double.parseDouble(rawFirstNumber);

    String rawSecondNumber = request.getParameter("secondNumber");
    double secondNumber = Double.parseDouble(rawSecondNumber);

    double sum = firstNumber + secondNumber;
%>

<p>
    <%= rawFirstNumber %> + <%= rawSecondNumber %> = <%= sum %>
</p>