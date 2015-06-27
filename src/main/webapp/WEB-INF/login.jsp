<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<div class="container">
		<h1>Login!</h1>
		<p>
			Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
		</p>
		<c:url var="logoutUrl" value="/login" />
		<form class="form-inline" action="${logoutUrl}" method="post">
			<input type="text" id="username" name="username"></input>
			<input type="password" id="password" name="password"></input>
			<input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>