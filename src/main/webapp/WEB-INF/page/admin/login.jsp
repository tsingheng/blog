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
		<div class="container bs-doc-container">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<div class="panel panel-default" style="margin-top:200px;">
						<div class="panel-heading">请登录</div>
						<div class="panel-body">
							<form action="${ctx}/admin/login" method="post" id="login-form" class="form-horizontal">
								<div class="form-group">
									<label for="username" class="col-sm-2 control-label">Username</label>
									<div class="col-sm-6">
										<input type="text" name="username" class="form-control" id="username">
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-6">
										<input type="password" name="password" class="form-control" id="password">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-10 col-sm-offset-2">
										<button class="btn btn-default">登录</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		$(document).ready(function(){
			$('#login-form').validate({
				rules: {
					username: {
						required: true
					},
					password: {
						required: true
					}
				},
				messages: {
					username: {
						required: 'username'
					},
					password: {
						required: 'password'
					}
				},
				errorClass: 'has-error',
				errorPlacement: function(error, ele){
					var formGroup = ele.closest('.form-group');
					if(formGroup.find('[id^=-error]').length == 0){
						if(ele.is('textarea')){
							error.addClass('control-label').insertAfter(ele);
						}else{
							formGroup.append(error.addClass('control-label'));
						}
					}
				},
				highlight: function(element, errorClass, validClass){
					$(element).closest('.form-group').addClass(errorClass);
				},
				unhighlight: function(element, errorClass, validClass){
					$(element).closest('.form-group').removeClass(errorClass);
				},
				submitHandler: function(form){
					var validator = $(form).validate();
					$(form).ajaxSubmit({
						dataType: 'json',
						success: function(response){
							if(response.errors){
								validator.showErrors(response.errors);
								return;
							}
							if(!response.success){
								alert(response.messaeg);
								return;
							}
							window.document.location = ctx + '/admin/main';
						}
					});
				}
			});
		});
		</script>
	</body>
</html>