
<%@page contentType="text/html" pageEncoding="UTF-8" import="Bank.DisplayUserDetails,java.sql.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>display Page</title>
    </head>
    <body>
        <jsp:useBean id="account" class="Bank.AccountHolderMaster"></jsp:useBean>

	<jsp:setProperty name="account" property="userid" value="1"></jsp:setProperty>

	<jsp:setProperty name="account" property="emailString" value="kk@gmail.com"></jsp:setProperty>

	<jsp:setProperty name="account" property="address" value="nagpur"></jsp:setProperty>

	<jsp:setProperty name="account" property="name" value="kk"></jsp:setProperty>

	<jsp:setProperty name="account" property="passwordString" value="123"></jsp:setProperty>

	<jsp:setProperty name="account" property="city" value="nagpur"></jsp:setProperty>

	<jsp:setProperty name="account" property="phone_number" value="9689025233"></jsp:setProperty>

	<jsp:getProperty name="account" property="userid"></jsp:getProperty>


	<jsp:getProperty name="account" property="emailString"></jsp:getProperty>


	<jsp:getProperty name="account" property="name"></jsp:getProperty>

	<jsp:getProperty name="account" property="passwordString"></jsp:getProperty>
	<jsp:getProperty name="account" property="city"></jsp:getProperty>
	<jsp:getProperty name="account" property="phone_number"></jsp:getProperty>

	<%
	    DisplayUserDetails displayUserDetails = new DisplayUserDetails();
	    displayUserDetails.connectdb();
	    String messageString = displayUserDetails.displayResultSet(account);
	    out.print(messageString);

	    out.print(account.getAddress());
	    out.print(account.getEmailString());
	    out.print(account.getUserid());
	    out.print(account.getName());
	    out.print(account.getCity());
	%>
    </body>
</html>
