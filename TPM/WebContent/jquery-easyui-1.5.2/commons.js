
// 自定义的校验器
$.extend($.fn.validatebox.defaults.rules, {   
		midLength: {   
	 			validator: function(value, param){   
								return value.length >= param[0] && value.length <= param[1];    
				},   
				message: ''  
		} ,
		equalLength : {
	 			validator: function(value, param){   
								return value.length == param[0];    
				},   
				message: '密码必须为4个字符!'  
		}
}); 



$.extend($.fn.datagrid.defaults.editors, {   
    datetimebox: {   
        init: function(container, options){   
            var box = $('<input />').appendTo(container);   
            box.datetimebox(options);
            return box;   
        },   
        getValue: function(target){   
            return $(target).datetimebox('getValue');   
        },   
        setValue: function(target, value){   
            $(target).datetimebox('setValue',value);
        },   
        resize: function(target, width){   
            var box = $(target);   
			box.datetimebox('resize' , width);
        } ,
        destroy:function(target){
        	$(target).datetimebox('destroy');
        }
    }   
});  


//关于按钮
function showAbout(){
	$.messager.alert("车站售票系统","制作团队: 节操君的团队<br/>邮箱: 123456@qq.com");
}

//注销按钮
$(function() {
	/*$('#logout').click(function(){
		top.location.href = "head.jsp";
	});*/
	$('#tip').click(function(){
		top.location.href = "head.jsp";
	});
});
