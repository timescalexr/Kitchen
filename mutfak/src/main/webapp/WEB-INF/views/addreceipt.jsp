<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<p>receipt</p>

<c:url var="saveReceipt" value="/savereceipt" ></c:url>

<form:form action="${saveReceipt}" modelAttribute="receipt">
<table>
	<c:if test="${!empty receipt.title}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="title">
				<spring:message text="Title"/>
			</form:label>
		</td>
		<td>
			<form:input path="title" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="content">
				<spring:message text="Content"/>
			</form:label>
		</td>
		<td>
			<form:input path="content" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="preparation">
				<spring:message text="Preparation"/>
			</form:label>
		</td>
		<td>
			<form:input path="preparation" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="receiptDate">
				<spring:message text="ReceiptDate"/>
			</form:label>
		</td>
		<td>
			<form:input path="receiptDate" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="owner">
				<spring:message text="Owner"/>
			</form:label>
		</td>
		<td>
			<form:input path="owner" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty receipt.title}">
				<input type="submit"
					value="<spring:message text="Edit Receipt"/>" />
			</c:if>
			<c:if test="${empty receipt.title}">
				<input type="submit"
					value="<spring:message text="Save Receipt"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Receipt List</h3>
<c:if test="${!empty receipts}">
	<table class="tg">
	<tr>
		<th width="80">Receipt ID</th>
		<th width="120">Receipt Name</th>
		<th width="120">Receipt Content</th>
		<th width="120">Receipt Preparation</th>
		<th width="120">Receipt Date</th>
		<th width="120">Receipt Owner</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${receipts}" var="receipt">
		<tr>
			<td>${receipt.id}</td>
			<td>${receipt.title}</td>
			<td>${receipt.content}</td>
			<td>${receipt.preparation}</td>
			<td>${receipt.receiptDate}</td>
			<td>${receipt.owner}</td>
			<td><a href="<c:url value='/edit/${receipt.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${receipt.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


<script src="<c:url value="/resources/js/jquery-3.5.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>
</body>
</html>