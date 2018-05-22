
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>职位添加</title>
<style type="text/css">
body {
	background-color: #555555;
}

#titel_img {
	width: 417px;
}

#log_image {
	z-index: 0;
	position: absolute;
	left: 50%;
	top: 50%;
	height: 151px;
	width: 400;
	margin-left: -200px;
	margin-top: -100px;
}

#text_box {
	position: absolute;
	top: 65px;
	left: 40px;
	z-index: 1;
	/* background-color: #FF0000;*/
}

#text_box div {
	color: #FFFFFF;
}

#titel_text {
	position: absolute;
}
</style>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" href="css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common1.css" />
<script src="content/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="jquery-easyui-1.5.2/themes/metro/easyui.css" type="text/css" />
<link rel="stylesheet" href="jquery-easyui-1.5.2/themes/icon.css"
	type="text/css" />
<script type="text/javascript" src="jquery-easyui-1.5.2/commons.js"></script>
</head>
<body>

	<center>
	<s:form action="pos-save" method="post" cssClass="blur">
		<div id="log_image">
			<div id="text_box">
				<div>
					<s:if test="position_id != null">
						<s:hidden name="position_id"></s:hidden>
						<%-- 
			<!-- 通过添加隐藏域的方式把未显式提交的字段值提交到服务器 -->
			<s:hidden name="lastName"></s:hidden>
			<s:hidden name="createTime"></s:hidden>
			--%>
					</s:if>
					<s:else>
						<s:textfield name="position_id"></s:textfield>
					</s:else>
				</div>
				<div>
					<s:textfield name="position_name" label="职位"></s:textfield>
				</div>
				<div>
					<s:textfield name="salary" label="工资"></s:textfield>
				</div>
				<div>
					<s:select list="#request.sections" listKey="section_id"
						label="所属部门" listValue="section_name" name="section.section_id"></s:select>
				</div>
				<div>
					<s:submit></s:submit>
				</div>
			</div>
		</div>
		</s:form>

	</center>
	
	
</body>
</html>
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加页面</title>

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<link rel="Stylesheet" type="text/css" href="style/loginDialog.css" />

</head>
<body>
<center>
	<a href="#" id="example">职位添加</a>
</center>
	<form action="pos-save" method="post">
		<div id="LoginBox" style="text-align: center;">
			<!--  
		<div class="row1">
			<s:if test="position_id != null">
				<s:hidden name="position_id"></s:hidden>
			</s:if>
			<s:else>
				<s:textfield name="position_id"></s:textfield>
			</s:else>
		</div>
		-->
			<div class="row1">
				职位添加<a href="javascript:void(0)" title="关闭窗口" class="close_btn"
					id="closeBtn">×</a>
			</div>
			<div class="row">
				职位: <span class="inputBox"> <input type="text"
					name="position_name" placeholder="" />
			</div>
			<div class="row">
				工资: <span class="inputBox"> <input type="text" name="salary"
					placeholder="" />
			</div>
			<div class="row">
				<s:select list="#request.sections" listKey="section_id" label="所属部门"
					listValue="section_name" name="section.section_id"></s:select>
			</div>
			<div class="row">
				<input type="submit" id="loginbtn" name="" placeholder="" />
			</div>
		</div>
	</form>

	<script type="text/javascript">
		$(function($) {
			//弹出登录
			$("#example").hover(function() {
				$(this).stop().animate({
					opacity : '1'
				}, 600);
			}, function() {
				$(this).stop().animate({
					opacity : '0.6'
				}, 1000);
			}).on('click', function() {
				$("body").append("<div id='mask'></div>");
				$("#mask").addClass("mask").fadeIn("slow");
				$("#LoginBox").fadeIn("slow");
			});
			//
			//按钮的透明度
			$("#loginbtn").hover(function() {
				$(this).stop().animate({
					opacity : '1'
				}, 600);
			}, function() {
				$(this).stop().animate({
					opacity : '0.8'
				}, 1000);
			});
			//文本框不允许为空---按钮触发
			$("#loginbtn").on('click', function() {
				var txtName = $("#txtName").val();
				var txtPwd = $("#txtPwd").val();
				if (txtName == "" || txtName == undefined || txtName == null) {
					if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
						$(".warning").css({
							display : 'block'
						});
					} else {
						$("#warn").css({
							display : 'block'
						});
						$("#warn2").css({
							display : 'none'
						});
					}
				} else {
					if (txtPwd == "" || txtPwd == undefined || txtPwd == null) {
						$("#warn").css({
							display : 'none'
						});
						$(".warn2").css({
							display : 'block'
						});
					} else {
						$(".warning").css({
							display : 'none'
						});
					}
				}
			});
			//文本框不允许为空---单个文本触发
			$("#txtName").on('blur', function() {
				var txtName = $("#txtName").val();
				if (txtName == "" || txtName == undefined || txtName == null) {
					$("#warn").css({
						display : 'block'
					});
				} else {
					$("#warn").css({
						display : 'none'
					});
				}
			});
			$("#txtName").on('focus', function() {
				$("#warn").css({
					display : 'none'
				});
			});
			//
			$("#txtPwd").on('blur', function() {
				var txtName = $("#txtPwd").val();
				if (txtName == "" || txtName == undefined || txtName == null) {
					$("#warn2").css({
						display : 'block'
					});
				} else {
					$("#warn2").css({
						display : 'none'
					});
				}
			});
			$("#txtPwd").on('focus', function() {
				$("#warn2").css({
					display : 'none'
				});
			});
			//关闭
			$(".close_btn").hover(function() {
				$(this).css({
					color : 'black'
				})
			}, function() {
				$(this).css({
					color : '#999'
				})
			}).on('click', function() {
				$("#LoginBox").fadeOut("fast");
				$("#mask").css({
					display : 'none'
				});
			});
		});
	</script>
</body>
</html>