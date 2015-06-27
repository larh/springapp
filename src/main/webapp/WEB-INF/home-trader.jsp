<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Example :: Spring Application</title>
</head>
<body>
  <div class="container">
    <h1>Home Trader!</h1>
    <p>
      Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>
    </p>
    <c:url var="logoutUrl" value="/logout"/>
    <form class="form-inline" action="${logoutUrl}" method="post">
      <input type="submit" value="Log out" />
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </div>
</body>
</html>