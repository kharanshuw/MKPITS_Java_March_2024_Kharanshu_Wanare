<%@page contentType="text/html" pageEncoding="UTF-8" import="Bank.Deposit" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Page</title>
    </head>
    <body>
	<jsp:useBean id="accountholder" class="Bank.AccountHolderMaster" scope="application"></jsp:useBean>

<jsp:setProperty name="accountholder" property="emailString" param="email"></jsp:setProperty>
<jsp:setProperty name="accountholder" property="passwordString" param="password"></jsp:setProperty>
<jsp:getProperty name="accountholder" property="emailString"></jsp:getProperty>
<jsp:getProperty name="accountholder" property="passwordString"></jsp:getProperty>


<%
String email=session.getAttribute("email").toString();
  Deposit deposit=new Deposit();

deposit.connectdb();
String amountString=request.getParameter("depositAmount");
double amount=Double.parseDouble(amountString);
if(amount>0){
boolean result=deposit.depositAmount(email, amount );
if (result == true) {
	response.sendRedirect("http://localhost:8080/BankManagement/deposit_successful.html");
    }
}
else{
System.out.println("amount is less than 0 cannot deposit");
 response.sendRedirect("http://localhost:8080/BankManagement/deposit_failed.html");
}


%>
    </body>
</html>
