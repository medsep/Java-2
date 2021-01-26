<html>
<body>
<h3>Training Portal</h3>

<!-- read the favourite programming langauge -->

<%

String favLang = "Java";

Cookie[] theCookies =  request.getCookies();

if (theCookies !=null){
	for (Cookie tempCookie: theCookies){
		if("myApp.favouriteLanguage".equals(tempCookie.getName())){
			favLang = tempCookie.getValue();
			break;
		}
	}
}


%>

<!-- now display peronalise paged -->


<!-- show books for the language -->

<h4>New books for <%= favLang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>New news reports for <%= favLang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>New jobs for <%= favLang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>



<a href="cookies-personalise-form.html">Personalise this page</a>
</body>




</html>