<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	<h4 class="modal-title">分类编辑</h4>
</div>
<div class="modal-body">
	<form id="series-form" method="post" class="form-horizontal" action="${ctx}/admin/series/save">
	<input type="hidden" name="id" value="${series.id}"/>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">名称</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="name" name="name" value="${series.name}"/>
		</div>
	</div>
	<div class="form-group">
		<label for="code" class="col-sm-2 control-label">编码</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="code" name="code" value="${series.code}"/>
		</div>
	</div>
	<div class="form-group">
		<label for="sort" class="col-sm-2 control-label">排序</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" id="sort" name="sort" value="${series.sort}"/>
		</div>
	</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button class="btn btn-default submit">保存</button>
</div>