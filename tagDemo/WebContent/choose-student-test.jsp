<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.testTags.jsp.tagDemo.Student"%>

<%
//create test data
List<Student> data=  new ArrayList<>();

data.add(new Student("Al","Pac", false));
data.add(new Student("Cal","Mac", false));
data.add(new Student("Mal","Jac", true));

pageContext.setAttribute("myStudents", data);
%>

<html>
<body>

<table border="1">

<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Gold Customer</th>
</tr>

<c:forEach var="tempStudent" items="${myStudents}">
<tr>
<td>${tempStudent.firstName}</td>
<td> ${tempStudent.lastName}</td>
<td>
<c:choose>

 <c:when test ="${tempStudent.goldCustomer}">Special discount</c:when>
 <c:otherwise>Nothing here</c:otherwise>

</c:choose>


</td>
</tr>
<br/>
</c:forEach>

</body>
</html>