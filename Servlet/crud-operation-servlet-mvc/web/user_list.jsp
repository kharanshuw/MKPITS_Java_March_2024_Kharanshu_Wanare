
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>User Management</title>

	<style>
	    body {
		font-family: Arial, sans-serif;
		margin: 0;
		padding: 0;
	    }

	    header {
		background-color: #333;
		color: #fff;
		padding: 20px;
		display: flex;
		justify-content: space-between;
		align-items: center;
	    }

	    nav ul {
		list-style: none;
		margin: 0;
		padding: 0;
		display: flex;
	    }

	    nav li {
		margin-right: 20px;
	    }

	    .container {
		max-width: 800px;
		margin: 20px auto;
	    }

	    h2 {
		text-align: center;
	    }

	    table {
		width: 100%;
		border-collapse: collapse;
	    }

	    th, td {
		padding: 12px 15px;
		border: 1px solid #ddd;
		text-align: left;
	    }

	    th {
		background-color: #f2f2f2;
	    }

	    .add-user-btn, .edit-btn, .delete-btn {
		text-decoration: none;
		color: #333;
		padding: 5px 10px;
		border: 1px solid #ddd;
		border-radius: 5px;
	    }

	    .add-user-btn {
		background-color: #4CAF50;
		color: #fff;
	    }

	    .delete-btn {
		color: #f00;
	    }

	    .table-wrapper {
		margin: 10px 70px 70px;
		box-shadow: 0px 35px 50px rgba(0, 0, 0, 0.2);
	    }

	    .fl-table {
		border-radius: 5px;
		font-size: 12px;
		font-weight: normal;
		border: none;
		border-collapse: collapse;
		width: 100%;
		max-width: 100%;
		white-space: nowrap;
		background-color: white;
	    }

	    .fl-table td, .fl-table th {
		text-align: center;
		padding: 8px;
	    }

	    .fl-table td {
		border-right: 1px solid #f8f8f8;
		font-size: 12px;
	    }

	    .fl-table thead th {
		color: #ffffff;
		background: #4FC3A1;
	    }

	    .fl-table thead th:nth-child(odd) {
		color: #ffffff;
		background: #324960;
	    }

	    .fl-table tr:nth-child(even) {
		background: #F8F8F8;
	    }

	    /* Responsive */

	    @media (max-width: 767px) {
		.fl-table {
		    display: block;
		    width: 100%;
		}
		.table-wrapper:before {
		    content: "Scroll horizontally >";
		    display: block;
		    text-align: right;
		    font-size: 11px;
		    color: white;
		    padding: 0 0 10px;
		}
		.fl-table thead, .fl-table tbody, .fl-table thead th {
		    display: block;
		}
		.fl-table thead th:last-child {
		    border-bottom: none;
		}
		.fl-table thead {
		    float: left;
		}
		.fl-table tbody {
		    width: auto;
		    position: relative;
		    overflow-x: auto;
		}
		.fl-table td, .fl-table th {
		    padding: 20px .625em .625em .625em;
		    height: 60px;
		    vertical-align: middle;
		    box-sizing: border-box;
		    overflow-x: hidden;
		    overflow-y: auto;
		    width: 120px;
		    font-size: 13px;
		    text-overflow: ellipsis;
		}
		.fl-table thead th {
		    text-align: left;
		    border-bottom: 1px solid #f7f7f9;
		}
		.fl-table tbody tr {
		    display: table-cell;
		}
		.fl-table tbody tr:nth-child(odd) {
		    background: none;
		}
		.fl-table tr:nth-child(even) {
		    background: transparent;
		}
		.fl-table tr td:nth-child(odd) {
		    background: #F8F8F8;
		    border-right: 1px solid #E6E4E4;
		}
		.fl-table tr td:nth-child(even) {
		    border-right: 1px solid #E6E4E4;
		}
		.fl-table tbody td {
		    display: block;
		    text-align: center;
		}
	    }

	</style>

    </head>
    <body>
	<header>
	    <nav>
		<div class="logo">
		    <h1>User Management App</h1>
		</div>
		<ul>
		    <li><a href="<%=request.getContextPath()%>/list">Users List</a></li>
		</ul>
	    </nav>
	</header>

	<div class="container">
	    <h2>List of Users</h2>
	    <hr>
	    <a href="<%=request.getContextPath()%>/new" class="add-user-btn">Add New User</a>

	    <div class="table-wrapper">
		<table class="fl-table">
		    <thead>
			<tr>
			    <th>ID</th>
			    <th>Name</th>
			    <th>Email</th>
			    <th>Country</th>
			    <th>Action</th>

			</tr>
		    </thead>
		    <tbody>
			<c:forEach var="u" items="${alluser}">
			    <tr>
				<td><c:out value="${u.id}" /></td>
				<td><c:out value="${u.nameString}" /></td>
				<td><c:out value="${u.emailString}" /></td>
				<td><c:out value="${u.countryString}" /></td>
				<td>
				    <a href="edit?id=<c:out value='${u.id}' />" class="edit-btn">Edit</a>
				    <a href="delete?id=<c:out value='${u.id}' />" class="delete-btn">Delete</a>
				</td>
			    </tr>
			    
			</c:forEach>
		    <tbody>
		</table>
	    </div>
	</div>

	<script src="script.js"></script>
    </body>
</html>


