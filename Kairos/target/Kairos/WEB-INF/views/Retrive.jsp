<head>

<%@ include file="include/links.jsp" %>
<%@ include file="include/Navbar.jsp" %>

<style type="text/css">
body{
    font-size: 150%;
	background: url(resources/images/bg1.jpg) no-repeat 0px 0px;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    -ms-background-size: cover;
    background-attachment: fixed;
	
}

</style>
</head>
<html>
<body>
<br>
    <div class="container">
    
    <c:if test="${failed != null}">
                    <div class="error" style="color: #ff0000;">${failed}</div>
                </c:if>
   
        <c:url value="/forgot" var="url"></c:url>
        <form action="${url}"  method="POST">
     
      <div class="row">
            
      <div class="row">
            
        <div class="page-header">
            <h2>Enter Valid Username</h2>
        </div>
        </div>
    
       
                    <div class="form-group">
                   <label for="usern ame">Username: </label>
        <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>            
                    <input type="text" name="username" class="form-control" placeholder="Username"/>
                    </div>
                </div>
                
                </div>
                
                   <button type="submit" class="btn btn-primar btn-lg btn-block">Submit</button>

</form>
</div>
</body>
</html>
        