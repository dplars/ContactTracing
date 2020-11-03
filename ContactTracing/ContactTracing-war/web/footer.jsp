<%-- Loic Dehan
    Document   : footer
    Created on : 5-okt-2020, 14:25:10
    Author     : r0714500 Loic Dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            
        <form style="margin-top:20px;" action="<c:url value='ResController'/>" method="Post">
            <input type="hidden" name="sub" value="afbreken">
            <input type="Submit" value="Log uit">
        </form>


    </body>
</html>
