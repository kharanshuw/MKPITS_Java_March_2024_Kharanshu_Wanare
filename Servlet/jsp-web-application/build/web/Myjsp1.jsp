
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bean jsp communication  Page</title>
    </head>
    <body>
        <jsp:useBean id="student" class="BeanClasses.StudentBean" scope="application"   > </jsp:useBean>

<jsp:setProperty name="student" property="nameString" value="pratik"></jsp:setProperty>

<jsp:setProperty name="student" property="rollnoString" value="15"></jsp:setProperty>

<jsp:setProperty name="student" property="marks" value="50"></jsp:setProperty>

<jsp:getProperty name="student" property="nameString"></jsp:getProperty>


<jsp:getProperty name="student" property="rollnoString"></jsp:getProperty>


<jsp:getProperty name="student" property="marks"></jsp:getProperty>
    </body>
</html>
