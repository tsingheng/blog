<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
		<link href="${ctx}/assets/admin/admin.css" rel="stylesheet">
		<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
		<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${ctx}/assets/admin/jquery.validate.js"></script>
		<script type="text/javascript" src="${ctx}/assets/admin/jquery.form.js"></script>
		<title></title>
		<script type="text/javascript">var ctx = '${ctx}';</script>
	</head>
	<body>
		<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
		  <div class="container">
		    <div class="navbar-header">
		      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a href="${ctx}/admin/main" class="navbar-brand">Dashboard</a>
		    </div>
		    <nav class="collapse navbar-collapse bs-navbar-collapse">
		      <ul class="nav navbar-nav">
		        <li>
		          <a href="${ctx}/admin/series">分类</a>
		        </li>
		      </ul>
		    </nav>
		  </div>
		</header>
		<div class="container bs-doc-container">
			<t:insertAttribute name="content"/>
		</div>
	</body>
</html>