<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<HTML>
<BODY>

<c:set var="data" value="medJSP" />

Length of the string <b>${data }</b>: ${fn:length(data)}

<br/><br/>

Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}

<br/><br/>

Does the string start with <b>${data}</b> start with<b> med</b>?: ${fn:startsWith(data,"med")}

</BODY>
</HTML>
