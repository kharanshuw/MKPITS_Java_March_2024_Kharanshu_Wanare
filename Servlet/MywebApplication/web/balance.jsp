<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" import="java.sql.*" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Balance Page</title>

	<style>
	    body {
		font-family: Arial, sans-serif;
		background-color: #f9f9f9;
		margin: 0;
		padding: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
	    }
	    .container {
		background-color: #ffffff;
		border-radius: 8px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		padding: 20px;
		width: 300px;
		text-align: center;
	    }
	    h1 {
		font-size: 24px;
		color: #00796b;
		margin-bottom: 20px;
	    }
	</style>

    </head

    <body>



        <%
	    String emailString = session.getAttribute("email").toString();
	
	    String useridString = null;
	    String nameString = null;
	    double balance = 0;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");

	    PreparedStatement pre = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");

	    pre.setString(1, emailString);

	    ResultSet resultSet = pre.executeQuery();

	    while (resultSet.next()) {
		String email = resultSet.getString("email");
		String passwordString = resultSet.getString("password");
		System.out.println("email" + email);
		balance = Double.parseDouble(resultSet.getString("balance"));
		System.out.println(" balance " + balance);
		useridString = resultSet.getString("userid");
		nameString = resultSet.getString("name");

	    }

	%>

	<div class="container">
	    <h1>Your Name</h1>
	    <p><%= nameString%></p>
	    <h1>Your ID</h1>
	    <p><%= useridString%></p>
	    <h1>Your Account Balance</h1>
	    <p class="balance"><%= balance%></p>
	</div>

    </body>
</html>
