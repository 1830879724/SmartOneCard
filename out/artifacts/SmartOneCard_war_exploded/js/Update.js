function  update(obj) {
    var pname = $(obj).parent().parent("tr").children("td").eq(1).html();
    pstate = $(obj).parent().parent("tr").children("td").eq(4).html();
    var path = $("#path").val();
    var state = $(obj).val();
    var flag = confirm("确认"+state);
    if (pstate=="启用"){
        pstate="禁用";
    }else {
        pstate="启用"
    }
    var xhr = new XMLHttpRequest();//1.创建核心对象(XHR)
    xhr.open("post",path+"/updateServlet");
    xhr.send(pname+"&"+pstate);
    if (flag==true) {
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {
                alert(xhr.responseText);
            }
            if (xhr.responseText == "修改成功") {

                if (pstate == "禁用") {
                    $(obj).parent().parent("tr").children("td").eq(4).text("禁用");
                    $(obj).parent().parent("tr").children("td").eq(5).children("input").eq(0).val("启用");

                } else {
                    $(obj).parent().parent("tr").children("td").eq(4).text("启用");
                    $(obj).parent().parent("tr").children("td").eq(5).children("input").eq(0).val("禁用");
                }
            }
        }
    }

}

$(function () {
    re=$("#iframe")
})

function dian(node) {
   re.attr("src",node.title);
}



function shanchu(node) {
    var flag = confirm("是否确定删除");
    var pname = $(node).parent().siblings(".pname").text();
    var path = $("#path").val();
    if (flag == true){
        $.ajax({
            url:path+"/adminServlet?methodName=deleuser",
            data:"pname="+pname,
            success:function (data) {
                if (data=="成功"){
                    $(node).parent().siblings(".pstate").html("已删除");
                    $(node).parent().empty();
                }
            }
        })
    }
}

// function xiugai(node) {
//
//     var pname = $(node).parent().siblings(".pname").text();
//     var path = $("#path").val();
//
//         $.ajax({
//             url:path+"/adminServlet?methodName=xiugai",
//             data:"pname="+pname,
//             success:function (data) {
//                 if (data=="成功"){
//                    alert("修改成功");
//                 }
//             }
//         })
//
// }




