$(document).ready(function(){
	function initValidate(){
		$('#series-form').validate({
			rules: {
				'name': {
					required: true
				},
				'code': {
					required: true
				},
				'sort': {
					required: true
				}
			},
			messages: {
				'name': {
					required: '名称必填'
				},
				'code': {
					required: '编码必填'
				},
				'sort': {
					required: '排序必填'
				}
			},
			errorClass: 'has-error',
			errorPlacement: function(error, ele){
				var formGroup = ele.closest('.form-group');
				if(formGroup.find('[id^=-error]').length == 0){
					formGroup.append(error.addClass('control-label'));
				}
			},
			highlight: function(element, errorClass, validClass){
				$(element).closest('.form-group').addClass(errorClass);
			},
			unhighlight: function(element, errorClass, validClass){
				$(element).closest('.form-group').removeClass(errorClass);
			}
		});
	}
	$('.toggle-series-form').click(function(){
		$('#series-modal .modal-content').load($(this).data('href'), function(){
			$('#series-modal').modal('show');
			initValidate();
		});
	});
	$('#series-modal').on('click', '.submit', function(){
		if(!$('#series-form').valid()){
			return;
		}
		var validator = $('#series-form').validate();
		$('#series-form').ajaxSubmit({
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
				window.document.location.reload();
			}
		});
	});
	
	$('.add-post').click(function(){
		var $form = $('#post-form');
		$form[0].reset();
		if($form.parent().is(':visible')){
			return;
		}
		$form.find('input[name="id"]').val('');
		$('#post-list').slideUp(function(){
			$form.parent().slideDown();
		});
	});
	$('.post-cancel').click(function(){
		var $form = $('#post-form');
		if($form.parent().is(':visible')){
			$form.parent().slideUp(function(){
				$('#post-list').slideDown();
			});
		}
	});
	$('#post-form').validate({
		rules: {
			'title': {
				required: true
			},
			'code': {
				required: true
			},
			'sort': {
				required: true
			},
			'seoTitle': {
				required: true
			},
			'seoKeywords': {
				required: true
			},
			'seoDescription': {
				required: true
			},
			'content': {
				required: true
			}
		},
		messages: {
			'title': {
				required: '标题必填'
			},
			'code': {
				required: '编码必填'
			},
			'sort': {
				required: '排序必填'
			},
			'seoTitle': {
				required: 'seo-标题必填'
			},
			'seoKeywords': {
				required: 'seo-关键字必填'
			},
			'seoDescription': {
				required: 'seo-描述必填'
			},
			'content': {
				required: '内容必填'
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
					window.document.location.reload();
				}
			});
		}
	});
	$('.edit-post').click(function(){
		var id = $(this).closest('tr').data('id');
		$.ajax({
			url: ctx + '/admin/post',
			data: {
				id: id
			},
			dataType: 'json',
			success: function(post){
				$('#post-form [name]').each(function(){
					if($(this).attr('name') in post){
						$(this).val(post[$(this).attr('name')]);
					}
				});
				if(!$('.post-form-wrapper').is(':visible')){
					$('#post-list').slideUp(function(){
						$('.post-form-wrapper').slideDown();
					});
				}
			}
		});
	});
});