$(document)
		.ready(
				function() {

					$("#email_err").hide();
					$("#matKhau_err").hide();
					$("#nhapLai_err").hide();
					$("#hoTen_err").hide();
					$("#dienThoai_err").hide();

					var error_email = false;
					var error_matKhau = false;
					var error_nhapLai = false;
					var error_hoTen = false;
					var error_dienThoai = false;

					$("#email").focusout(function() {
						check_email();
					});
					$("#matKhau").focusout(function() {
						check_matKhau();
					});
					$("#nhapLai").focusout(function() {
						check_nhapLai();
					});
					$("#hoTen").focusout(function() {
						check_hoTen();
					});
					$("#dienThoai").focusout(function() {
						check_dienThoai();
					});

					function check_email() {
						var pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
						var email = $("#email").val();
						if (pattern.test(String(email).toLowerCase())) {
							$("#val-email").css("color", "#808080");
							$("#email_err").hide();
						} else {
							$("#email_err").html("Email không hợp lệ");
							$("#email_err").show();
							$("#val-email").css("color", "#e22b2b");
							error_email = true;
						}
						if (email == '') {
							$("#email_err").html("Email không được bỏ trống");
							$("#val-email").css("color", "#e22b2b");
							$("#email_err").show();
							error_email = true;
						}
					}

					function check_matKhau() {
						var matKhau = $("#matKhau").val();
						if (matKhau.length >= 8) {
							$("#val-matKhau").css("color", "#808080");
							$("#matKhau_err").hide();
						} else {
							$("#matKhau_err").html(
									"Mật khẩu có ít nhất 8 ký tự");
							$("#val-matKhau").css("color", "#e22b2b");
							$("#matKhau_err").show();
							error_matKhau = true;
						}
						if (matKhau == '') {
							$("#matKhau_err").html(
									"Mật khẩu không được bỏ trống");
							$("#val-matKhau").css("color", "#e22b2b");
							$("#matKhau_err").show();
							error_matKhau = true;
						}
					}

					function check_nhapLai() {
						var nhapLai = $("#nhapLai").val();
						var matKhau = $("#matKhau").val();
						if (nhapLai == matKhau) {
							$("#val-nhapLai").css("color", "#808080");
							$("#nhapLai_err").hide();
						} else {
							$("#nhapLai_err").html(
									"Mật khẩu nhập lại không chính xác");
							$("#val-nhapLai").css("color", "#e22b2b");
							$("#nhapLai_err").show();
							error_nhapLai = true;
						}
						if (nhapLai == '') {
							$("#nhapLai_err").html(
									"Mật khẩu nhập lại không được bỏ trống");
							$("#val-nhapLai").css("color", "#e22b2b");
							$("#nhapLai_err").show();
							error_nhapLai = true;
						}
					}

					function check_hoTen() {
						var hoTen = $("#hoTen").val();
						if (hoTen.length < 50) {
							$("#val-hoTen").css("color", "#808080");
							$("#hoTen_err").hide();
						} else {
							$("#hoTen_err").html("Họ tên không quá 50 ký tự");
							$("#val-hoTen").css("color", "#e22b2b");
							$("#hoTen_err").show();
							error_hoTen = true;
						}
						if (hoTen == '') {
							$("#hoTen_err").html("Họ tên không được bỏ trống");
							$("#val-hoTen").css("color", "#e22b2b");
							$("#hoTen_err").show();
							error_hoTen = true;
						}
					}
					function check_dienThoai() {
						var pattern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
						var sdt = $("#dienThoai").val();
						if (pattern.test(String(sdt).toLowerCase())) {
							$("#val-dienThoai").css("color", "#808080");
							$("#dienThoai_err").hide();
						} else {
							$("#dienThoai_err").html("Số điện thoại không hợp lệ");
							$("#dienThoai_err").show();
							$("#val-dienThoai").css("color", "#e22b2b");
							error_dienThoai = true;
						}
						if (sdt == '') {
							$("#dienThoai_err").html(
									"Số điện thoại không được bỏ trống");
							$("#val-dienThoai").css("color", "#e22b2b");
							$("#dienThoai_err").show();
							error_dienThoai = true;
						}
					}
				

					$("#registerForm").submit(
							function(event) {
								error_email = false;
								error_matKhau = false;
								error_nhapLai = false;
								error_hoTen = false;
								error_dienThoai = false;

								check_email();
								check_matKhau();
								check_nhapLai();
								check_hoTen();
								check_dienThoai();

								if (!error_email && !error_matKhau
										&& !error_nhapLai && !error_hoTen && !error_dienThoai) {
									console.log("Login success");
									return true;
								} else {
									console.log("Login fail");
									return false;
								}
							});
					  // =========================================================================
					
					
});