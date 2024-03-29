layui.use(['form','layer',"jquery",'upload'],function(){
    var form = layui.form,
    upload = layui.upload,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    form.render();
    form.on("submit(addUser)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.5});
        // 实际使用时的提交信息
        // $.post("上传路径",{
        //     userName : $(".userName").val(),  //登录名
        //     userEmail : $(".userEmail").val(),  //邮箱
        //     userSex : data.field.sex,  //性别
        //     userGrade : data.field.userGrade,  //会员等级
        //     userStatus : data.field.userStatus,    //用户状态
        //     newsTime : submitTime,    //添加时间
        //     userDesc : $(".userDesc").text(),    //用户简介
        // },function(res){
        //
        // })
        setTimeout(function(){
            $.ajax(
                {
                    url: "/ren/addUser.action",
                    data: JSON.stringify(data.field),
                    dataType: "json",
                    type: "post",
                    contentType: "application/json",
                    success: function (d) {
                        // d.msg == "success"
                        if (d>0) {
                            reid = d;
                            // $("#uploadImg").trigger("click");
                            // layer.msg("添加成功！")
                            top.layer.close(index);
                            top.layer.msg("用户添加成功！");
                            top.layer.closeAll();
                            // layer.close(layer.index)
                            //刷新父页面
                            parent.location.reload();
                           // location.href="/ren/tableuser.action"
                        } else {
                            layer.msg("添加失败")
                        }
                    }
                }
            )
        },2000);
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