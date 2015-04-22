<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="${ctx}/" class="navbar-brand">宋老师教Java</a>
    </div>
    <nav class="collapse navbar-collapse bs-navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="${menu eq 'java-basic' ? 'active' : ''}">
          <a href="${ctx}/java-basic/">JAVA起步</a>
        </li>
      </ul>
      <%-- 
      <ul class="nav navbar-nav navbar-right">
        <li><a href="" target="_blank"></a></li>
      </ul>
      --%>
    </nav>
  </div>
</header>