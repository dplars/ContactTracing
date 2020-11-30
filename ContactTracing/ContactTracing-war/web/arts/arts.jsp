<%-- 
    Document   : arts
    Created on : Nov 3, 2020, 5:09:57 PM
    Author     : dehan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artsen</title>
    </head>
    <script>
        function submit_form() {
            //alert("clicked");
            var testnr = document.getElementById("testnr");
            var positief = document.getElementById("testpositief");
            var positieflabel = document.getElementById("poslabel");
            var negatief = document.getElementById("testnegatief");
            var negatieflabel = document.getElementById("neglabel");
            //var form = document.getElementById("artsform");
            var submitbtn = document.getElementById("submitbutton");
            goed = 1;
            
            if(testnr.value === ""){
                testnr.style.border = "1px solid red";
                goed = 0;
            }
            if(!positief.checked && !negatief.checked){
                positieflabel.style.color = "red";
                negatieflabel.style.color = "red";
                goed = 0;
            }
            if (goed === 1) {
                submitbtn.click();
            }
        }
    </script>
    
    <body>
        <div class="container" style="margin-top: 10%">
    <div class="row">
		<div class="span12">
                    <div id="legend">
			      <legend class="">Arts</legend>
                    </div>
        <!--<h1>Dit is de arts pagina</h1>-->
        <form method="POST" action="../ResController" id="artsform">
            <a style="color:red;"><c:if test="${!empty sessionScope.error}">
                ${sessionScope.error}<br>
                </c:if>
            </a>
            <a style="color:green;"><c:if test="${!empty sessionScope.msg}">
                ${sessionScope.msg}<br>
                </c:if>
            </a>
                
            <label for="testnr">Nummer van de test</label>
            <input type="number" id="testnr" name="testnr" required 
                   <c:if test="${!empty sessionScope.testnr}">
                       value="${sessionScope.testnr}"
                   </c:if>
                       /><br>
            
            <label for="testpositief" id="poslabel">Positief</label>
            <input type="radio" id="testpositief" name="testresultaat" value="positief"/>
            <label for="testnegatief" id="neglabel">Negatief</label>
            <input type="radio" id="testnegatief" name="testresultaat" value="negatief"/><br>
            
            <input type="button" onclick="submit_form();" name="sub" value="doorgaan"/>
            <input type="submit" style="display:none;" id="submitbutton" name="sub" value="doorgaan"/>
        </form>
                </div></div></div>
    </body>
    
  <jsp:include page="../footer.jsp"/>
</html>
