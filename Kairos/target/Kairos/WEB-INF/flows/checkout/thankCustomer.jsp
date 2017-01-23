<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/include/links.jsp" %>
<html>
<head>
<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css}">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Watches</title>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
</head>
<body><br><br><br>
<div class="container-wrapper">
    <div class="container">
       
            <div class="jumbotron" style="background-color:#ccffff;">
                <div class="container">
                    <h2>Order Placed successfully</h2>

                    <p>Your order will be shipped in two business days!</p>
                </div>
            </div>
        

        <section class="container">
            <p><a href="<c:url value="/" />" class="btn btn-primar">OK</a></p>
        </section>
        </div>
        </div>
<br><br><br><br><br><br>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>