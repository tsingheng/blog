<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="宋老师 tsingheng@163.com">
<c:if test="${not empty seoKeywords}">
<meta name="keywords" content="${seoKeywords}">
</c:if>
<c:if test="${empty seoKeywords}">
<meta name="keywords" content="<spring:message code="${keywords}"/>">
</c:if>
<c:if test="${not empty seoDescription}">
<meta name="description" content="${seoDescription}">
</c:if>
<c:if test="${empty seoDescription}">
<meta name="description" content="<spring:message code="${description}"/>">
</c:if>

<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/assets/blog.css" rel="stylesheet">
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/blog.js"></script>
