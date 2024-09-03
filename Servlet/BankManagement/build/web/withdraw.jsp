

<%@page import="Bank.Withdraw"%>
<%@page import="Bank.Deposit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>withdraw jsp Page</title>
    </head>
    <body>
        <jsp:useBean id="accountholder" class="Bank.AccountHolderMaster" scope="application"></jsp:useBean>


	<%
	    String email = session.getAttribute("email").toString();
	    Withdraw withdraw = new Withdraw();
	    withdraw.connectdb();
	    String withdraw_amount_String = request.getParameter("withdrawAmount");
	    double withdraw_amount = Double.parseDouble(withdraw_amount_String);
	    if (withdraw_amount < 0) {
		System.out.println("withdraw amount is less than 0 please enter amount grater than 0");
	    } else {
		
		boolean result = withdraw.withdrawAmount(email, withdraw_amount);
		if (result == true) {
		    out.print("amount withdrawn successfully");
		    RequestDispatcher requestDispatcher = request.getRequestDispatcher("withdrawSuccessful.jsp");
		    requestDispatcher.forward(request, response);
		} else {
		    out.print("some problem occured please try again");
		}
	    }
	    
	%>
    </body>
</html>
