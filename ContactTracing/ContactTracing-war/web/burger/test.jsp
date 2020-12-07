<%-- 
    Document   : test
    Created on : Nov 3, 2020, 5:44:12 PM
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
        <div id="aanvragen"></div>
        
        <br>
        <select name="TestTid" id = "TestTid" onChange="resultaat()">
            <c:forEach var="test" items="${applicationScope.testLijst}" >
                <option value="${test.tid}"> ${test.tid} </option> 
            </c:forEach>                    
        </select>
        <label id = "TestResultaat"> </label>
        
        
        <script>
        var Ttid = [];
        var Tres = [];
        <c:forEach items="${testLijst}" var="test">
            Ttid.push("${test.tid}");
            Tres.push("${test.testresultaat}");
        </c:forEach>
        function resultaat() { 
            tid = (document.getElementById('TestTid').value);
    
            var arrayLength = Ttid.length;
            
            entry = 'Nog geen testen';
            for (var i = 0; i < arrayLength; i++) {
                if(tid == Ttid[i]){
                    if(Tres[i]==1){
                        entry = "Negatief";
                    }
                    else if(Tres[i]==2){
                        entry = "Positief";
                    }
                    else{
                        entry = "In behandeling";
                    }
                   
                    break;
                }
                
            }
            document.getElementById('TestResultaat').innerHTML  = entry;
        } 
        resultaat();
         </script>
         <script>
             s = ""
             
             if(Tres[0] != 0){
                s +=  "<h1>Vraag een nieuwe test aan:</h1>";
                s +="<form action='../ResController' method='Post'>  ";
                s +="<input type='hidden' name='sub' value='nieuweTest'>";
                s+="<input type='Submit' value='Nieuwe test'>";
                s+="</form>";
         
             }
             else{
                 s +="<h1>Vorige test (Testnummer:"+Ttid[0]+") is nog in behandeling</h1>"; 
             }
             document.getElementById('aanvragen').innerHTML  = s;
       
      
        </script>
        <br><br>
        <form action="../ResController" method="Post">       
                <input type="hidden" name="sub" value="burger">
                <input type="Submit" value="Terug">
        </form>
    </body>
    <jsp:include page="../footer.jsp"/>
</html>
