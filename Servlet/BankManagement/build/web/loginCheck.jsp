<%@page contentType="text/html" pageEncoding="UTF-8" import="Bank.LoginCheck"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login jsp</title>
    </head>
    <body>
<jsp:useBean id="accountholder" class="Bank.AccountHolderMaster" scope="application"></jsp:useBean>
<jsp:setProperty name="accountholder" property="emailString" param="email"></jsp:setProperty>

<jsp:setProperty name="accountholder" property="passwordString" param="password"></jsp:setProperty>

<jsp:getProperty name="accountholder" property="emailString"></jsp:getProperty>
<jsp:getProperty name="accountholder" property="passwordString"></jsp:getProperty>
<%
 LoginCheck loginCheck=new  LoginCheck();

loginCheck.connectdb();
boolean result=loginCheck.verifyLogin(accountholder);
if (accountholder.getEmailString().isEmpty()==false) {
	session.setAttribute("email",accountholder.getEmailString());
}
out.println(result);
if (result==true) {
	response.sendRedirect("http://localhost:8080/BankManagement/home.jsp");
    }
else{
response.sendRedirect("http://localhost:8080/BankManagement/loginFailed.jsp");
}
%>
    </body>
</html>
