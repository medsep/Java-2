<%@ page import="java.util.*" %>
<html>
<body>

<!-- Step 1: HTML -->

<form action="todo-demo.jsp">
Add new item: <input type="text" name="theItem"/>

<input type="submit" value="Submit" />
 </form>
<br>
Item entered: <%= request.getParameter("theItem") %>
<!-- Step 2: Add new item to list -->
<%
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	if (items==null){
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}
	
	String theItem = request.getParameter("theItem");
	if (theItem !=null){
		items.add(theItem);
	}

%>
<!-- Step 3: Display all "To do" item for session -->
<hr>
<b>To List Items:</b><br/>

<ol>
<%
for (String temp:items){
	out.println("<li>" + temp + "</li>");
}
%>
</ol>
</body>
</html>