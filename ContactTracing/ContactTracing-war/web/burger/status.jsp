<%-- 
    Document   : status
    Created on : Nov 24, 2020, 9:50:39 PM
    Author     : dehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="margin-bottem:10px;"> 
        <%--Huidige score: ${sessionScope.score} --%>
        Huidige status: <label id = "STATUS"><%--onderaan aangevullen --%></label> 
        </h1> 
        <br>
        
        
        <script>
        function updateStatus(){
            
            if(${sessionScope.score}>0){
                s="<p style='color:red;display:inline;'>Onveilig </p><br>Vraag een test aan:";        
                s += "<form action='ResController' method='Post'><input type='hidden' name='sub' value='burgerTest'><input type='Submit'value='Test'></form>";
                
                document.getElementById('STATUS').innerHTML  = s;
            }
            else{
                document.getElementById('STATUS').innerHTML = "<p style='color:green;display:inline;'>Veilig</p>"
            }
        }
        updateStatus();
    </script>
    <br>
    <form action="ResController" method="Post">       
                <input type="hidden" name="sub" value="burger">
                <input type="Submit" value="Terug">
        </form>
    </body>
    <jsp:include page="../footer.jsp"/>
</html>
