<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="theLocale"
value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
scope="session"/>

<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="com.testTags.jsp.tagDemo.i18n.resources.mylabels"/>
<html>

<body>
<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a>
<a href="i18n-messages-test.jsp?theLocale=es_ES">Espanol (ES)</a>
<a href="i18n-messages-test.jsp?theLocale=de_DE">Deutsche (DE)</a>

<hr>
<fmt:message key="label.greeting" /> <br/><br/>
<fmt:message key="label.firstname" /> <i>Med</i><br/>
<fmt:message key="label.lastname" /> <i>Sep</i><br/><br/>
<fmt:message key="label.welcome" /> <br/>

<hr>
Selected locale: ${theLocale}
</hr>


</body>
</html>