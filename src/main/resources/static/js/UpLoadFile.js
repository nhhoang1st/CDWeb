/**
 * 
 */
$(document).ready(function(){
	function uploadAnh(){
		var form_data =  new FormData(document.getElementById('uploadAnh'));
		form_data.append('id',$("#idu").val());
		form_data.append('fileData', $('#files')[0].files[0]);
		for (var value of form_data.values()) {
			   console.log(value); 
			}
		 console.log("asdsad:",form_data); 
		$.ajax({
			 type: "POST",
			 enctype: 'multipart/form-data',
		      data: form_data,
		      url: "/updateAnh",
		      contentType: false,
		      processData: false,
		      
		}).done(function (result){
			console.log(result.mes);
			document.getElementById("anhdaidien").src = result.mes;
			document.getElementById("anhdaidien1").src = result.mes;
		});
	}
	function reload(){
		
	}
	$("#files").change(function(event) {
		  event.preventDefault();
		  uploadAnh();
		});
	
	
	
});