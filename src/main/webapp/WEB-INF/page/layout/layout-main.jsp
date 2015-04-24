<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="common-meta.jsp"/>
		<title><spring:message code="${title}"/></title>
	</head>
	<body>
		<jsp:include page="common-header.jsp"/>
		<div class="container bs-doc-container">
			<t:insertAttribute name="content"/>
		</div>
		<jsp:include page="common-footer.jsp"/>
	</body>
</html>