
$(function() {
    validateRule();
	$('.imgcode').click(function() {
        console.log("更改验证码");
		var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
		$(".imgcode").attr("src", url);
	});
});

$.validator.setDefaults({
    submitHandler: function() {
        console.log("hello");
		login();
    }
});

function login() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var username = $.common.trim($("input[name='username']").val());
    var password = $.common.trim($("input[name='password']").val());
    var userType = $("input[name='userType']:checked").val();
    var test = $('#status option:selected').text();//选中的文本
    var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    console.log("[login.js] username = "+username+"  password = "+password+" userType = "+userType+" remeberMe = "+rememberMe);

    $.ajax({
        type: "post",
        url: ctx + "login",
        data: {
            "username": username,
            "password": password,
            "userType": userType,
            "test": test,
            "validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
            if (r.code == 0) {
                location.href = ctx + 'index';
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$(".code").val("");
            	$.modal.msg(r.msg);
            }
        }
    });

}

function validateRule() {
    // var icon = "<i class='fa fa-times-circle'></i> ";
    console.log("mdzz")
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            },
        },
        messages: {
            username: {
                required: "请输入您的用户名",
            },
            password: {
                required: "请输入您的密码",
            }
        }
    });
}
