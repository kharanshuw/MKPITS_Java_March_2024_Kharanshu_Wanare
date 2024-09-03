

<%@page import="Bank.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bank.History,java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction Page</title>
    

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
    <body>
	<%
	    String dateString;
	    String id = null;
	    String emailString = session.getAttribute("email").toString();
	    History history = new History();
	    history.connectdb();
ArrayList<Transaction > arrayList=new  ArrayList<Transaction>();
Transaction transaction =new Transaction();
	  arrayList = history.displayHistory(emailString);
%>
 
<div class="container mt-4">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>User Id</th>
        <th>Date</th>
        <th>Amount</th>
        <th>uidAccno</th>
        <th>Transaction Type</th>
      </tr>
    </thead>
    <tbody>
      <% for(Transaction tran:arrayList){ %>
        <tr>
          <td><%=tran.getIdString()%></td>
          <td><%=tran.getDateString() %></td>
          <td><%=tran.getAmountString() %></td>
          <td><%=tran.getUid_accno() %></td>
          <td><%=tran.getTransaction_typeString() %></td>
        </tr>
      <% } %>
    </tbody>
  </table>
</div>


    </body>
</html>