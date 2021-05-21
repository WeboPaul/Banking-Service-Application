<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
</body>
<c:if test="${not empty lists}">
    <c:forEach items="${lists}" var="lists">
        ${lists}
    </c:forEach>
</c:if>
</html>