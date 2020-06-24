//定义构造函数
var Upfile = function(ele, opt,code,type) {
    console.log("code",code);
    console.log("type",type)
    var uploadInst;
    this.SetInst = function(obj) {
        uploadInst = obj;
    }
//列表tbody节点
    console.log("ele",ele)
    console.log("上传按钮id",$(ele).parent('div').find('button').eq(1).attr('id'))
    var demoListView = $(ele).parent('div').find('tbody');
    this.defaults = {
        elem: ele,
        url: baseURL+'sys/oss/upload',
        accept: 'file',
        acceptMime:'*',
        multiple: true,
        auto: false,
        bindAction: '#' + $(ele).parent('div').find('button').eq(1).attr('id'),
        before:function(input){
          var data ={};
            // data.ossEntity="{\"crmSaleCode\":\""+code+"\",\"updateStatus\":\""+type+"\"}";
            // console.log(JSON.stringify(data))
            data.crmSaleCode=code;
            data.updateStatus = type;
          this.data= data;
        },
        choose: function(obj) {
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function(index, file, result) {
                var tr = $(['<tr id="upload-' + index + '">', '<td>' + file.name + '</td>', '<td>' + getfilesize(file.size) + '</td>', '<td>等待上传</td>', '<td>', '<button class="layui-btn layui-btn-xs demo-reload layui-hide" style="background:red">重传</button>', '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>', '</td>', '</tr>'].join(''));
                if(file.type.indexOf("image") != -1) {
                    tr = $(['<tr id="upload-' + index + '">', '<td><a class="demo-a" href="javascript:" style="text-decoration: underline;color: #3091e2;"><img src="' + result + '" style="width:20px;height:20px;margin-right:10px"/>' + file.name + '</a></td>', '<td>' + getfilesize(file.size) + '</td>', '<td>等待上传</td>', '<td>', '<button class="layui-btn layui-btn-xs demo-reload layui-hide" style="background:red">重传</button>', '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">移除</button>', '</td>', '</tr>'].join(''));
                }
                //单个重传
                tr.find('.demo-reload').on('click', function() {
                    obj.upload(index, file);
                });
                //
                // tr.find('.demo-a').on("click", function() {
                //     imgView(result)
                // })
                //删除
                tr.find('.demo-delete').on('click', function() {
                    console.log(uploadInst)
                    delete files[index]; //删除对应的文件
                    uploadInst.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    tr.remove();
                });

                demoListView.append(tr);

            });
        },
        done: function(res, index, upload) {
            if(res.code == 0) { //上传成功
                console.log(res)
                var tr = demoListView.find('tr#upload-' + index),
                    tds = tr.children();
                tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                tds.eq(3).html('<button type="button" class="layui-btn layui-btn-xs layui-btn-danger deltemp" id="'+res.data.id+'" ">删除</button>'); //清空操作
                tds.eq(3).on('click',function () {
                   alert($(this).find('button').attr('id'))
                })
                return delete this.files[index]; //删除文件队列已经上传成功的文件
            }
            this.error(index, upload);
        },
        error: function(index, upload) {
            var tr = demoListView.find('tr#upload-' + index),
                tds = tr.children();
            tds.eq(2).html('<span style="color: #ff5722;">上传失败</span>');
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
    }
    this.options = $.extend({}, this.defaults, opt);
    function delbtn(e){
        alert(e);
    }
    // 计算文件大小函数(保留两位小数),Size为字节大小
    // size：初始文件大小
    function getfilesize(size) {
        if (!size)
            return "";

        var num = 1024.00; //byte

        if (size < num)
            return size + "B";
        if (size < Math.pow(num, 2))
            return (size / num).toFixed(2) + "K"; //kb
        if (size < Math.pow(num, 3))
            return (size / Math.pow(num, 2)).toFixed(2) + "M"; //M
        if (size < Math.pow(num, 4))
            return (size / Math.pow(num, 3)).toFixed(2) + "G"; //G
        return (size / Math.pow(num, 4)).toFixed(2) + "T"; //T
    }
};

//
// //在插件中使用对象
// $.fn.upfile = function() {
//     var upfile = new Upfile(this);
//
//     layui.use('upload', function() {
//         var upload = layui.upload;
//         var UplodeIn = upload.render(upfile.options);
//         upfile.SetInst(UplodeIn)
//
//     });
//
// }