<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-4">
		<ul class="list-group">
			<c:forEach items="${seriesList}" var="item">
			<li class="list-group-item ${item.id eq seriesId ? 'active' : ''}">
				<a class="item-name" href="${ctx}/admin/series?seriesId=${item.id}">${item.name}</a>
				<div class="btn-group">
					<a class="btn btn-default toggle-series-form" href="javascript:;" data-href="${ctx}/admin/series/form?id=${item.id}">编辑</a>
					<a class="btn btn-danger" href="javascript:;">删除</a>
				</div>
			</li>
			</c:forEach>
			<li class="list-group-item">
				<a class="add-series toggle-series-form" href="javascript:;" data-href="${ctx}/admin/series/form">添加新分类</a>
			</li>
		</ul>
	</div>
	<div class="col-md-8">
		<c:if test="${not empty series}">
		<div class="panel panel-default">
			<div class="panel-heading">
				${series.name}
				<a class="panel-tool add-post" href="javascript:;">添加文章</a>
			</div>
			<table class="table" id="post-list">
				<tbody>
					<c:forEach items="${postList}" var="item">
					<tr data-id="${item.id}">
						<td width="40">${item.sort}</td>
						<td>${item.title}</td>
						<td class="td-edit"><a href="javascript:;" class="edit-post">编辑</a></td>
						<td class="td-remove"><a href="javascript:;" class="remove-post">删除</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panel-body post-form-wrapper" style="display:none;">
				<form class="form-horizontal" id="post-form" method="post" action="${ctx}/admin/post/save">
					<input type="hidden" name="id" id="post-id"/>
					<input type="hidden" name="seriesId" value="${series.id}"/>
					<div class="form-group">
						<label for="post-code" class="col-sm-2 control-label">URL</label>
						<div class="col-sm-6">
							<input type="text" name="code" id="post-code" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">标题</label>
						<div class="col-sm-6">
							<input type="text" name="title" id="title" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="post-sort" class="col-sm-2 control-label">排序</label>
						<div class="col-sm-6">
							<input type="text" name="sort" id="post-sort" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="seoTitle" class="col-sm-2 control-label">页面标题</label>
						<div class="col-sm-6">
							<input type="text" name="seoTitle" id="seoTitle" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="seoKeywords" class="col-sm-2 control-label">页面关键字</label>
						<div class="col-sm-6">
							<input type="text" name="seoKeywords" id="seoKeywords" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="seoDescription" class="col-sm-2 control-label">页面描述</label>
						<div class="col-sm-6">
							<input type="text" name="seoDescription" id="seoDescription" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<textarea name="content" rows="10" class="form-control"></textarea>
						</div>
					</div>
					<div class="from-group">
						<div class="col-sm-12">
							<button class="btn btn-default">保存</button>
							<a class="btn btn-default post-cancel" href="javascript:;">取消</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		</c:if>
	</div>
</div>
<div class="modal" id="series-modal">
	<div class="modal-dialog">
		<div class="modal-content">
		
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/admin/post.js"></script>