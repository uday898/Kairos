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
<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger">Checkout cancelled!</h1>

                    <p>Your checkout process is cancelled! You may continue shopping.</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<c:url value="/getAllWatches" />" class="btn btn-primar">Watches</a></p>
        </section>
        </div>
        </div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>