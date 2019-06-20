/**
 * 
 */

$(document)
		.ready(
				function(){
					
					function reload(){
						var name =$("#name").val();
						var email =$("#email").val();
						var sdt = $("#sdt").val()
						var dc =$("#dc").val()
						if(name!=""){
							document.getElementById("name").value = "";
							document.getElementById("name").placeholder = name;
							
						}
						if(email!=""){
							document.getElementById("email").value = "";
							document.getElementById("email").placeholder = email;
							
						}
						if(sdt!=""){
							document.getElementById("sdt").value = "";
							document.getElementById("sdt").placeholder = sdt;
							
						}
						if(dc!=""){
							document.getElementById("dc").value = "";
							document.getElementById("dc").placeholder = dc;
							
						}
						document.getElementById("update").disabled = true
					}
					function updateUser(){
						var user ={
							id : $("#iduser").val(),
							userName : $("#name").val(),
							email : $("#email").val(),
							sdt : $("#sdt").val(),
							dc : $("#dc").val()
								
						}
						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/updateUser",
							data : JSON.stringify(user),
							dataType : 'json',
						}).done(function (result){
							if(result.mes === 'true'){
								$(".nameAcc").html(user.userName);
								alert('Cập nhật thành công!')
								console.log(nameAcc);
								
							}
							else{
								alert('Cập nhật thất bại!')
							}
						});
					
					}
					
					$("#updateUserForm").submit(
							function(event) {
								event.preventDefault()
								updateUser();
								reload();
							}
					);
					function b_update(){
						var name =$("#name").val();
						var email =$("#email").val();
						var sdt = $("#sdt").val()
						var dc =$("#dc").val()
						var check = false;
						
						if(name !="") check = true;
						if(email!= "") check = true;
						if(sdt!= "") check = true;
						if(dc!= "") check = true;
						if(check == true) document.getElementById("update").removeAttribute("disabled");
						else document.getElementById("update").disabled = true;
					}
});