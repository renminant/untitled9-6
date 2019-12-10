layui.use(['form','layer',"jquery",'upload'],function(){
    var form = layui.form,
    upload = layui.upload,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;



    form.on("submit(UpdateUser)",function(data) {
        //弹出loading
        console.log(data);
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.5});
        // 实际使用时的提交信息
        // var key, userInfo2 = '';
        // userInfo2 = {
        //     'userName': $(".userName").val(),
        //     'password': $(".password").val(),''''''''''''''''''''\
        //     'userE mail': $(".userEmail").val(),
        //     'userSex': data.field.userSex,
        //     'userGrade': data.field.userGrade,
        //     'userStatus': data.field.userStatus,
        //     'userDesc': $(".userDesc").val(),
        //
        // };

        // $.post('updatetable.action', data.field, function (flag) {
        //     if (flag == 1) {
        //         layer.msg("修改成功", {icon: 6});
        //         layer.closeAll();
        //
        //         table.reload('testReload', {});//修改后返回列表页面进行刷新
        //     } else {
        //         layer.msg("修改失败", {icon: 6});
        //     }
        // })
        setTimeout(function(){
            $.ajax(
                {

                    url: "/ren/updatetable.action",
                    data: JSON.stringify(data.field),
                    dataType: "json",
                    type: "post",
                    contentType: "application/json",
                    success: function (d) {
                        // d.msg == "success"
                        if (d>0) {
                            layer.close(index);
                            layer.msg("修改成功！");
                            layer.close(layer.index)
                            //刷新父页面
                            parent.location.reload();
                        } else {
                            layer.msg("修改失败")
                        }
                    }
                }
            )
        },2000);

        // for (key in data.field) {
        //     if (key.indexOf("like") != -1) {
        //         userInfo2[key] = "on";
        //     }
        // }
        // window.sessionStorage.setItem("userInfo", JSON.stringify(userInfo2));
        // setTimeout(function () {
        //     layer.close(index);
        //     layer.msg("提交成功！");
        // }, 2000);
        return false;
    })



    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());
})
