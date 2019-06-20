$(document).ready(function() {
	$(".btnDetail").click(function(event) {
		event.preventDefault();
			
			var valDetail = {
				value : $(this).attr("value")
			}
			console.log(valDetail);
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/getDetail",
				data : JSON.stringify(valDetail),
				dataType : 'json',
				success : function(result) {
					var data = result;
					var json = "<h3><strong>Tên môn học :</strong> "
						+data.tenmh+
						"</h3><h3><strong>Tên rút gọn :</strong> "
						+data.tenrutgon+
						"</h3><h3><strong>Học kì :</strong> "
						+data.mucmh+
						"</h3><h3><strong>Ngày bắt đầu :</strong> "
						+data.ngaybd+
						"</h3><h3><strong>Ngày kết thúc :</strong> "
						+data.ngaykt+
						"</h3><h3><strong>Sỉ số :</strong> "
						+data.soThanhVien+
						"</h3><h3><strong>Số thông báo:</strong> "
						+data.soThongBao+
						"</h3><h3><strong>Số bài tập :</strong> "
						+data.soBaiTap+
						"</h3><h3><strong>Mô tả :</strong> "
						+data.mota+
						"</h3>"
						
						;

					$("#chitiet").html(json);
					document.getElementById('details').style.display = 'block';
					console.log("success: ", result);
				},
				error : function(e) {
					console.log("ERROR : ", e);

				}
			});
	});
	//-----------------tham gia lop---------------
	$(".btnJoinClass").click(function(event) {
		event.preventDefault();
		$(this).text("Đã tham gia");
		$(this).prop("disabled",true);
			var valDetail = {
					idUser : $(this).attr("id"),
					idMonhoc : $(this).attr("value")
			}
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/joinClass",
				data : JSON.stringify(valDetail),
				dataType : 'json',
				success : function(result) {
					value = true;
					console.log("success: ", result.mes);
				},
				error : function(e) {
					console.log("ERROR : ", e);

				}
			});
			
	});
	
	//------------------------------nop bai-------------------
	var idUserVal ;
	var idBaiTapVal ;
	$(".btnNopBai").click(function(event) {
		  event.preventDefault();
		  idUserVal = $(this).attr("value");
		idBaiTapVal = $(this).attr("id");
		});
	
		function reload(){
			
		}
		$("#formNopBai").submit(function(event) {
			  event.preventDefault();
			  
			  var form_data1 =  new FormData(document.getElementById('#formNopBai'));
				form_data1.append('idUser',idUserVal);
				form_data1.append('idBaiTap',idBaiTapVal);
				form_data1.append('fileData', $('#files')[0].files[0]);
			  
			  console.log(form_data1);
				
				$.ajax({
					 type: "POST",
					 enctype: 'multipart/form-data',
				      data: form_data1,
				      url: "/nopBai",
				      contentType: false,
				      processData: false,
				      
				}).done(function (result){
					if(result.mes==="true"){
						alert('Nộp bài thành công');
						document.getElementById('nopbai').style.display='none';
					}else{
						alert('Nộp bài thất bại');
					}
					console.log(result.mes);
				});
			});
		
		
		$(".btnTb").click(function(event) {
			event.preventDefault();
				
				var valDetail = {
					value : $(this).attr("value")
				}
				console.log(valDetail);
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/getDetailTb",
					data : JSON.stringify(valDetail),
					dataType : 'json',
					success : function(result) {
						var data = result;
						var json = "<h3><strong>Thông báo :</strong> "
							+data.tenmh+
							"</h3><h3><strong>Ngày thông báo :</strong> "
							+data.ngaybd+
							"</h3><h3><strong>Chi tiết :</strong> "
							+data.mota+
							"</h3>"
							
							;

						$("#chitiet").html(json);
						document.getElementById('details').style.display = 'block';
						console.log("success: ", result);
					},
					error : function(e) {
						console.log("ERROR : ", e);

					}
				});
		});
		
		//----------------------------------
		//moi code
		$("#updateBtn").click(function(event) {
			event.preventDefault();
			
			var id= $("#idu").val();
			console.log('id là: ' +id);
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "/updateMonHocc",
					data : id,
					dataType : 'json'
			}).done(function (result){
				
				var user = result.user;
				var obj = result.datg;
				console.log("load thành công!")
				var txt ='<table class="table v-middle" id="dataTable"><thead><tr class="bg-light"><th class="border-top-0">Môn học</th><th class="border-top-0">Giảng viên</th><th class="border-top-0">Ngày bắt đầu</th><th class="border-top-0">Ngày kết thúc</th><th class="border-top-0">Thao tác</th></tr></thead><tbody>';
				for (x in obj) {
					var idmh ='"'+ obj[x].idmh + '"';
					
					txt+='<tr><td><div class="d-flex align-items-center"><div class="m-r-10"><a class="btn btn-circle btn-info text-white" >'+obj[x].tenrutgon+'</a></div>'
					+'<div class=""><h4 class="m-b-0 font-16" >'+obj[x].tenmh+'</h4>'
					+'</div></div></td><td >'+user.username+'</td>'
					+'<td><label class="label label-danger" >'+obj[x].ngaybd+'</label></td>'
					+'<td><label class="label label-danger" >'+obj[x].ngaykt+'</label></td>'
					+'<td><button type="button" class="btn btn-info">Sửa</button><button th:id="'+obj[x].idmh+'" type="button" th:value="'+obj[x].idmh+'" class="btn btn-warning btnDetail">Chi tiết</button>'
					+'<a th:href="@{/admin/{id}/delete(id=${'+obj[x].idmh+'})}"><button sec:authorize="hasAuthority("USER")" type="button" class="btn btn-danger">Xóa</button></a></td></tr>';
				}
				txt+='</tbody></table>';
				$('#daTG').html(txt);
				console.log('Load!'+txt);
			}).fail(function(){
				console.log('Load thất bại!');
			})
			
		});
		$("#updateBtn2").click(function(event) {
			event.preventDefault();
			
			var id= $("#idu").val();
			
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "/updateMonHocc",
					data : id,
					dataType : 'json'
			}).done(function (result){
				
				var user = result.user;
				var obj = result.chuatg;
				var txt ='<table class="table v-middle" id="dataTable"><thead><tr class="bg-light"><th class="border-top-0">Môn học</th><th class="border-top-0">Giảng viên</th><th class="border-top-0">Ngày bắt đầu</th><th class="border-top-0">Ngày kết thúc</th><th class="border-top-0">Thao tác</th></tr></thead><tbody>';
				for (x in obj) {
					var idmh ='"'+ obj[x].idmh + '"';
					
					txt+='<tr><td><div class="d-flex align-items-center"><div class="m-r-10"><a class="btn btn-circle btn-info text-white" >'+obj[x].tenrutgon+'</a></div>'
					+'<div class=""><h4 class="m-b-0 font-16" >'+obj[x].tenmh+'</h4>'
					+'</div></div></td><td >'+user.username+'</td>'
					+'<td><label class="label label-danger" >'+obj[x].ngaybd+'</label></td>'
					+'<td><label class="label label-danger" >'+obj[x].ngaykt+'</label></td>'
					+'<td><button type="button" class="btn btn-info">Sửa</button><button id="'+obj[x].idmh+'" type="button" value="'+obj[x].idmh+'" class="btn btn-warning btnDetail">Chi tiết</button>'
					+'<a th:href="@{/admin/{id}/delete(id=${'+obj[x].idmh+'})}"><button sec:authorize="hasAuthority("USER")" type="button" class="btn btn-danger">Xóa</button></a></td></tr>';
				}
				txt+='</tbody></table>';
				document.getElementById('chuaTG').innerHTML = txt;
			});
		});
	
});
