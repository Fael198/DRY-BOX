<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var='teste' value='4'/>


<c:set var='nome' value='Cavalca' />

<c:forEach var='i' begin='1' end='6'>
	Variavel <c:out value='${teste}' /><br>
</c:forEach>

<c:out value='${nome}' />