<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
//Just create a sample data ... normally provided by MVC
String[] cities = {"New York", "London", "Sydney"};

pageContext.setAttribute("myCities", cities);
%>

<html>
<body>
<c:forEach var="tempCity" items="${myCities}">

${tempCity } <br/>

</c:forEach>


</body>
</html>