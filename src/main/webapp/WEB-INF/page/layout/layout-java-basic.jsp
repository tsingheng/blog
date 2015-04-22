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
			<div class="row">
				<div class="col-md-9">
					<t:insertAttribute name="content"/>
				</div>
				<div class="col-md-3">
					<nav data-spy="affix" data-offset-top="60" data-offset-bottom="200" class="bs-docs-sidebar hidden-print hidden-xs hidden-sm affix-top">
						<ul class="nav bs-docs-sidenav">
							<li class="active">
  								<a href="${ctx}/java-basic/install-jdk">JDK安装</a>
							</li>
							<li>
  								<a href="${ctx}/java-basic/install-jdk">数据类型</a>
							</li>
						</ul>
						<a class="back-to-top" href="javascript:;">返回顶部</a>
					</nav>
				</div>
			</div>
		</div>
		<jsp:include page="common-footer.jsp"/>
	</body>
</html>