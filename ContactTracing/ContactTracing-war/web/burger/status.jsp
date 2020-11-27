<%-- 
    Document   : status
    Created on : Nov 24, 2020, 9:50:39 PM
    Author     : dehan
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
        <h1 style="margin-bottem:10px;"> 
        <%--Huidige score: ${sessionScope.score} --%>
        Huidige status: <label id = "STATUS"><%--onderaan aangevullen --%></label> 
        </h1> 
        <br>
        
        
        <table border = "1" style="width:100%">
            <tr>
              <th>Nauwe contacten </th>
              <th>Gewone contacten</th> 
              <th>Veilige contacten</th>
            </tr>
            <tr>
              <td>
                  <table id = "T1"></table>
              </td>
              <td>
                  <table id = "T2"> </table>
              </td>
              <td>
                  <table id = "T3"> </table>
              </td>
            </tr>

        </table>
        
        <script>
        var c1 = [];
        var c2 = [];
        var c3 = [];
        var count = 0;
        <c:forEach items="${contacten}" var="c">
            if("${c.type}" == "1"){
                c1.push("${c.persoon2}");
            }
            else if(${c.type} == 2){
                c2.push("${c.persoon2}");
            }
            else if(${c.type} == 3){
                c3.push("${c.persoon2}");
            }
        </c:forEach>
        </script>
        <script>
        function updateTabel(){
            var inhoud
            
            inhoud= "";
            for (var i = 0; i < c1.length; i++) {
                inhoud+=("<tr><td>"+c1[i]+ "</td></tr>");
            }
            document.getElementById('T1').innerHTML  = inhoud; 
            
            inhoud= "";
            for (var i = 0; i < c2.length; i++) {
                inhoud+=("<tr><td >"+c2[i]+ "</td></tr>");
            }
            document.getElementById('T2').innerHTML  = inhoud; 
            
            inhoud= "";
            for (var i = 0; i < c3.length; i++) {
                inhoud+=("<tr><td>"+c3[i]+ "</td></tr>");
            }
            document.getElementById('T3').innerHTML  = inhoud; 
        }
        updateTabel();
    </script>
     <script>
        function updateStatus(){
            if(${sessionScope.score}>0){
                document.getElementById('STATUS').innerHTML  = "<p style='color:red;display:inline;'>Onveilig </p>";
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
