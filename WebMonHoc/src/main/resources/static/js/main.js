$(document).ready(function(){
    $("#email_err").hide();
    $("#pass_err").hide();

    var error_femail = false;
    var error_fpass = false;
    
    $("#form_femail").focusout(function(){
        check_femail();
        $("#err_form").hide();
    });
    $("#form_fpass").focusout(function(){
        check_fpass();
        $("#err_form").hide();
    });

    function check_femail(){
        var pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var femail = $("#form_femail").val();
        if(pattern.test(String(femail).toLowerCase()) && femail !== ''){
             $("#email_err").hide();
             $("#val-email").css("color","#808080");
        }else{
            $("#email_err").html("Email không hợp lệ");
            $("#email_err").show();
            $("#val-email").css("color","#e22b2b");
            error_femail = true;
        }
    }

    function check_fpass(){
        var fpass = $("#form_fpass").val();
        if(fpass !== ''){
             $("#pass_err").hide();
             $("#val-pass").css("color","#808080");
        }else{
            $("#pass_err").html("Vui lòng nhập mật khẩu");
            $("#pass_err").show();
            $("#val-pass").css("color","#e22b2b");
            error_fpass = true;
        }
    }
    $("#login_form").submit(function(){
        error_femail = false;
        error_fpass = false;

        check_femail();
        check_fpass();

        if(error_femail==false && error_fpass == false){
            return true;
        }else{
            return false;
        }
    });

    //=========================================================================
        $("#email2_err").hide();
        var error_femail2 = false;

        $("#huy").click(function(){
         $("#email2_err").hide();
          $("#val2-email").css("color","#808080");
          $("#email2_err").html("");
          $("#id01").css("display","none")

    });

        $("#fg_emial").focusout(function(){
        check_fgemail();
    });

        function check_fgemail(){
            var pt = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var fg_email = $("#fg_email").val();
        if(pt.test(String(fg_email).toLowerCase()) && fg_email !== ''){
             $("#email2_err").hide();
             $("#val2-email").css("color","#808080");
             
        }else{
            $("#email2_err").html("Email không hợp lệ");
             $("#email2_err").show();
             $("#val2-email").css("color","#e22b2b");
            error_femail2 = true;
        } 
        }

        $("#forget_form").submit(function(){
         error_femail2 = false;

        check_fgemail();

        if(error_femail2==false){
            alert("Please check email");
            return true;
        }else{
            alert("Fail");
            return false;
        }
    });
});