<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" >
	
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Mutfak</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active"  href="<c:url value="/"/>">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="<c:url value="/lunch"/>" >Lunch</a>
      <a class="nav-item nav-link" href="<c:url value="/dinner"/>" >Dinner</a>
    </div>
  </div>
    <form class="form-inline">
    <div>
    <a class="nav-item nav-link my-2 my-sm-0" href="<c:url value="/logout"/>">Logout</a>
    </div>
    <div>
    <a class="nav-item nav-link my-2 my-sm-0" href="<c:url value="/addreceipt"/>">Add Receipt</a>
	</div>
	</form>
</nav>

<br>
<br>
<p>lunch</p>


<script src="<c:url value="/resources/js/jquery-3.5.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>
</body>
</html>