<html>

<head><title>Confirmation</title></head>

<%

String favLang = request.getParameter("favouriteLanguage"); 

Cookie theCookie = new Cookie("myApp.favouriteLanguage", favLang);

theCookie.setMaxAge(60*60*24*365);

response.addCookie(theCookie);
%>

<body>
Thanks for setting the favourite language to: ${param.favouriteLanguage}
<br/><br/>
<a href="cookies-homepage.jsp">Return to homepage.</a>
</body>




</html>