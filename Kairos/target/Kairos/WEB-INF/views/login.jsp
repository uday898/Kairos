<head>
<%@ include file="include/links.jsp" %>
<%@ include file="include/Navbar.jsp" %>
<title>Login</title>
<style type="text/css">
body{
    font-size: 150%;
	background: url(resources/images/bg.jpg) no-repeat 0px 0px;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    -ms-background-size: cover;
    background-attachment: fixed;
	
}
</style>

<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css }">
</head>
<html>
<body>
<br>
<br>
<br>
<br>
<div class="container-wrapper" >
    <div class="container">
    <div class="row">
    <div class="col-md-3 col-sm-8 col-xs-12"></div>
    <div class="col-md-6 col-sm-8 col-xs-12">
    <div class ="jumbotron">
    
        <div id="login-box">
           <h2> Login <a href="<c:url value="/registration"/>" class="btn btn-primar pull-right">SignUp</a><span style="padding-right:10px" class="pull-right"><h5>New to Kairos ?</h5></span></h2>
            
            <c:if test="${registrationSuccess !=null}">
          <div class="error" style="color:rgb(0,128,0);">  ${registrationSuccess }</div></c:if>
          
          <c:if test="${Success !=null}">
          <div class="error" style="color:rgb(0,128,0);">  ${Success }</div></c:if>
            
            <c:if test="${not empty logout}">
                <div class="error" style="color: #ff0000;">${logout}</div>
           
            </c:if>
            
            <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
                
            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
               
                 <br/>
                <div class="form-group">
                   <label for="username">Username: </label>
        <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>            
                    <input type="text" id="username" name="j_username" class="form-control" placeholder="Username"/>
                    </div>
                </div>
                
                <div class="form-group">
                    &nbsp;<label for="password">Password:</label>
                     <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>  
                    <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" />
                </div>
                </div>
                <br>
                <button type="submit" class="btn btn-primar btn-lg btn-block">Login</button>
            </form>
            <label>Forgot Password ?</label><a href="<c:url value="/retrive"/>" style="text-decoration:none;">Click Here</a>
        </div>
    </div>
</div>
<div class="col-md-3 col-sm-8 col-xs-12"></div>
</div>
</div>
</div>
<br>
<br>
<br>
</body>
</html>