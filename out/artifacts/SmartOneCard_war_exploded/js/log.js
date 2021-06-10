
function jqAjax() {

    var paccount = $("#paccount").val();
    var ppassword = $("#ppassword").val();

    var vCode = $("#vCode").val();
    console.log(paccount+":"+ppassword);

    var admin = {"paccount":paccount,"ppassword":ppassword,};
    var adminJson = JSON.stringify(admin);
    console.log(admin);

    var path = $("#path").val();

    $.ajax({
        url:path+"/l?methodName=login",
        type:"post",
        data:"paccount="+paccount+"&ppassword="+ppassword+"&vCode="+vCode,
        dataType:"text",
        beforSend:function () {
            alert("发送之前");
            // return false;
            //相关信息的验证
            // if (account.length<5){
            //     return false;
            // }
            // $("[value=jq登录]").prop("disabled","disabled");
        },
        success:function (data) {
            alert(data);
            if (data == "登录成功"){
                location.href = path+"/menuServlet?methodName=findMenuByRole";
                // alert("后台响应");

            }else {
                changeImag();
            }
        },
        error:function () {
            alert("网络繁忙");
            changeImag();
        },
        complete:function () {
            // alert("响应结束");
            // $("[value=jq登录]").prop("disabled","false");
        },
    });

}



function changeImag() {

    var path = $("#path").val();
    $("#vCodeImg").attr("src",path+"/verifyCodeServlet?date="+new Date());
}
