<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>企业人事后台管理系统</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link type="text/css" href="css/style.css" rel="stylesheet">
<script src="content/js/jquery/jquery-1.8.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/web.css">
<link rel="stylesheet" type="text/css" href="css/common1.css" >
<link rel="stylesheet" type="text/css" href="css/slider.css" >
<link rel="stylesheet" type="text/css" href="css/wu.css" >
<script type="text/javascript" src="jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="jquery-easyui-1.5.2/themes/metro/easyui.css"
	type="text/css"/>
<link rel="stylesheet"
	href="jquery-easyui-1.5.2/themes/icon.css"
	type="text/css"/>
<script type="text/javascript" src="jquery-easyui-1.5.2/commons.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.2/main_admin.js"></script>

<script type="text/javascript">

$(function(){
	$('a[title]').click(function(){
			var src = $(this).attr('title');
			var title = $(this).html();
			if($('#tt').tabs('exists' ,title)){
				$('#tt').tabs('select',title);
			} else {
				$('#tt').tabs('add',{
				    title:title,   
				    content:'<iframe frameborder=0 style=width:100%;height:100% src='+ src +' ></iframe>',   
				    closable:true  
				});  
			}
	});
});

</script>
</head>
<body>
	
    
   <div id="cc" class="easyui-layout" fit=true style="width:100%;height:100%;">
   
   			<div region="north" split="false" border="true" style="height:50px;overflow:hidden;background-color:#708069;" >
				<div id="topbar" class="title" >
					<div id="title" class="left" style="margin-top: 0px">
						<span style="font-family:华文新魏;font-size:36px;color:#fff;">企业人事后台管理系统</span>		
					</div>
					
					<div id="topbar-logon" class="right" style="margin-top: 10px;color:#fff;">
						欢迎您,&nbsp;&nbsp;&nbsp;<span style="color:#fff;"><strong>${loginmanagername}</strong></span>&nbsp;&nbsp;&nbsp;
						<a id="logout" onclick="logout()" icon="icon-remove" class="easyui-linkbutton" plain="true" style="color:#fff;">退出</a>	
					</div>
				</div>
			</div>
   
		    <div region="west"  split="false" title="菜单" style="width:200px;">
		    <div id="accor" class="easyui-accordion" style="width:200px;">
		    	
		    	<div title="个人信息查看">
		    		<ul>
		    			<li><a title="employee-find?name=${loginmanagername}" style="color:black; font-family:华文新魏;font-size:20px;">个人信息查看</a></li>
		    		</ul>
		    	</div>
		    	
		    	<div title="工资查看">
		    		<ul>
		    			<li><a title="to-sal1-list?name=${loginmanagername}" style="font-family:华文新魏;font-size:20px;">工资查看</a></li>
		    		</ul>
		    	</div>
		    	
		    	<div title="考勤查看">
		    		<ul>
		    			<li><a title="to-she-list.action?name=${loginmanagername}" style="font-family:华文新魏;font-size:20px;">考勤查看</a></li>
		    		</ul>
		    	</div>
		    	
		    	<div title="人事变更申请">
		    		<ul>
		    			<li><a title="to-per-list.action" style="font-family:华文新魏;font-size:20px;">人事变更申请查看</a></li>
		    		</ul>
		    	</div>
		    	
		    </div>
		    </div>
		    
		    <div region="center"   style="padding:0px;overflow:hidden;">
				<div id="tt" class="easyui-tabs" fit=true>
				    <div title="首页" style="loverflow:hidden;" >
				    	 <img src="content/images/tt.jpg" style="padding-top:0px;padding-left:0px;width: 100%;"/>
				    </div>
				</div>  
		    </div>  
		</div>
       
    
</body>
</html>