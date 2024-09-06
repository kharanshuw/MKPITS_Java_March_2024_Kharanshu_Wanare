<%-- 
    Document   : Myjsp2
    Created on : Jul 26, 2024, 12:53:44 PM
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
                <jsp:useBean id="student" class="BeanClasses.StudentBean" scope="application"   > </jsp:useBean>

<jsp:setProperty name="student" property="nameString" param="nm"></jsp:setProperty>

<jsp:setProperty name="student" property="rollnoString" param="rn"></jsp:setProperty>

<jsp:setProperty name="student" property="marks" param="marks"></jsp:setProperty>

<jsp:getProperty name="student" property="nameString"></jsp:getProperty>


<jsp:getProperty name="student" property="rollnoString"></jsp:getProperty>


<jsp:getProperty name="student" property="marks"></jsp:getProperty>

    </body>
</html>
