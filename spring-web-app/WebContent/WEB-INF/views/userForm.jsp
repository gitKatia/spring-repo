<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js" ></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="static/css/style.css" />
<title>User form Page Title</title>
</head>
<body>
<div class="container">
	<h1>Add User Form</h1>
	<fieldset>
	<form:form method="post" modelAttribute="user" action="user">
		<div class="row">
			<div class="col-md-3">
				 <form:label path="firstName">First Name</form:label><br/>
				 <form:input path="firstName" /><br/>
				 <form:errors path="firstName" cssClass="form-error" />
			</div>
			<div class="col-md-3">
				<form:label path="lastName">Last Name</form:label><br/>
				<form:input path="lastName" /><br/>
				<form:errors path="lastName" cssClass="form-error" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<form:label path="email">Email</form:label><br/>
				<form:input path="email" /><br/>
				<form:errors path="email" cssClass="form-error" />
			</div>
			<div class="col-md-3">
				<form:label path="country">Country</form:label><br/>
				<form:select path="country">
					<form:options items="${countries}" itemValue="code" itemLabel="name"/>
				</form:select><br/>
				<form:errors path="country" cssClass="form-error" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<form:label path="newsLetter">Subscribe to newsletter</form:label><br/>
				<form:checkbox path="newsLetter" checked="checked"></form:checkbox>
			</div>
			<div class="col-md-3">
				<input class="btn btn-primary" type="submit" value="Create"/>
			</div>
		</div>
	</form:form>
	</fieldset>
</div>
</body>
</html>