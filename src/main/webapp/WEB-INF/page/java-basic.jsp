<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row">
	<div class="col-md-9">
		${post.content}
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