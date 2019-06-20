$(document)
		.ready(
				function() {
					$("#email").focusout(function(event) {
						event.preventDefault();
						ajaxPost();
					});
				});
				function ajaxPost() {
						var formData = {
							email : $("#email").val()
						}
						
						
						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/checkEmail",
							data : JSON.stringify(formData),
							dataType : 'json',
							success : function(result) {
							if(result.mes === 'false'){
								$("#email_err").hide();
								
							}else{
								$("#val-email").css("color", "#e22b2b");
								$("#email_err").html("Email đã tồn tại");
								$("#email_err").show();
							}
							console.log("success: " , result.mes);
							},
							error : function(e) {

								console.log("ERROR : ", e);

							}
						});
				}
					
