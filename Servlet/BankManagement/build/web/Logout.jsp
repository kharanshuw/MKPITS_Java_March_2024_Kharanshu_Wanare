<%-- 
    Document   : newjsp
    Created on : Jul 30, 2024, 5:14:38 PM
    Author     : Kharanshu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <% session.invalidate(); %>
    <h1>Successfully logout </h1>
<h1>Login again</h1>
    <a href="http://localhost:8080/BankManagement/index.html"> Login </a>

    </body>
</html>
