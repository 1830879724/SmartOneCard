
layui.use('layer', function(){
    var layer = layui.layer;
});


//新增人员
function addManagement() {
    layer.open({

        anim: 1,
        type:2,
        title:'新增人员',
        shadeClose:true,
        shade:false,
        maxmin:true,
        id:'addpeo',
        area:['350','350'],
        content:['/SmartOneCard_war_exploded/jsp/addpeople.jsp','no'],
        end:function () {
           $("#chaxun").click();
        }
    });
}


//修改人员
function alter(node) {
    var path = $("#path").val();
    var pname = $(node).parent().siblings(".pname").text();
    var paccount =  $(node).parent().siblings(".paccount").text();

    layer.open({
        anim: 1,
        type:2,
        title:'修改人员',
        shadeClose:true,
        shade:false,
        maxmin:true,
        id:'alterp',
        area:['400','400'],
        content:['/SmartOneCard_war_exploded/jsp/alterpeople.jsp','no'],
        success:function (layero,index) {
            var body = layer.getChildFrame('body',index);
            body.contents().find("#pname").val(pname);
            body.contents().find("#paccount").val(paccount);

        },
        end:function () {
            $("#chaxun").click();
        }

    });
}


//重置密码
function rest(node) {
    var flag = confirm("是否重置密码");
    var pname = $(node).parent().siblings(".pname").text();
    var path = $("#path").val();
    if (flag == true){
        $.ajax({
            url:path+"/adminServlet?methodName=setpwd",
            data:"pname="+pname,
            success:function (data) {
                if (data == "成功") {
                    alert("恭喜你修改成功,默认密码:123456")
                }
            }
        });
    }
}

//卡入库

function addcard() {
    layer.open({

        anim: 1,
        type:2,
        title:'卡入库',
        shadeClose:true,
        shade:false,
        maxmin:true,
        id:'addcard',
        area:['350','350'],
        content:['/SmartOneCard_war_exploded/jsp/addcard.jsp','no'],

    });
}