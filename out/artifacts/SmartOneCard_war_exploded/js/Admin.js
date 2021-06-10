function guanbi() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

//新增人员
function addpeople(node) {
    var pname = $("#pname").val();
    var psection = $("#psection").val();
    var prole = $("#prole").val();
    var ppassword = $("#ppassword").val();
    var ppassword1 = $("#ppassword1").val();
    var path = $("#path").val();

    if (pname == null || pname == ""){
        alert("姓名不能为空");
    }else if (ppassword == null || ppassword == ""){
        alert("密码不能为空");
    }else if (ppassword != ppassword1){
        alert("两次密码不一致");
    }else if (prole == null || prole == ""){
        alert("角色不能为空");
    }else if (psection == null || psection == ""){
        alert("科室不能为空");
    }else {

        $.ajax({
            url: path + "/adminServlet?methodName=addpeople",
            data:"pname="+pname+"&psection="+psection+"&prole="+prole+"&ppassword="+ppassword+"&ppassword1="+ppassword1,
            success: function (data) {
                    alert("新增成功");
                    guanbi();
            }
        })

    }

}

//修改人员信息
function setpeople() {
    var psection = $("#psection").val();
    var prole = $("#prole").val();
    var paccount = $("#paccount").val();

    var path = $("#path").val();

    if (prole == null || prole == ""){
        alert("角色不能为空");
    }else if (psection == null || psection == ""){
        alert("科室不能为空");
    }else {

        $.ajax({
            url: path + "/adminServlet?methodName=setpeople",
            data:"paccount="+paccount+"&psection="+psection+"&prole="+prole,
            success: function (data) {
                if (data == "成功") {
                    alert("修改成功");
                    guanbi();
                }else {
                    alert("修改失败");
                }
            }
        })
    }

}

