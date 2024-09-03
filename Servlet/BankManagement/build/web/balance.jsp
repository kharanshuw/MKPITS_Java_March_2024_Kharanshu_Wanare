<%@page import="Bank.Balance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Balance Page</title>
    </head>
    <body>
        <jsp:useBean id="accountholder" class="Bank.AccountHolderMaster" scope="application"></jsp:useBean>
	<%
	    String email = session.getAttribute("email").toString();
	    Balance balance = new Balance();
	    balance.connectdb();
	    double acc_balance = balance.displayBalance(email);
	    out.println(acc_balance);
	%>
    </body>
</html>
