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
            <div class="jumbotron" style="background-color:#ccffff;">
                <div class="container">
                    <h2>Cart is Empty</h2>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="/getAllWatches" />" class="btn btn-primar">Browse all Watches</a></p>
        </section>
</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>