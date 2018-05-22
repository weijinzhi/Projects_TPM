<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>职位添加</title>
<style type="text/css" media="screen">
input.focus{
border:1px solid #99BBE8;
background:#e0e9f9;
height:18px;
}
input.blur{
border:1px solid #99BBE8;
background:#FFFFFF;
height:18px;
}

input.alert{
border:1px solid #DB1111;
background:#FFC7C7;
line-height:16px;
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

<%
	System.out.println(request.getParameter("position_id"));
%>

<center>

	<s:form action="pos-update" method="post" cssClass="blur">
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
		
		<s:textfield name="position_name" label="职位"></s:textfield>
		<br><br>
		<s:textfield name="salary" label="工资"></s:textfield>
		<br><br>
		
		<s:select list="#request.sections" listKey="section_id" label="所属部门" 
						 listValue="section_name" name="section.section_id"></s:select>
		<s:submit></s:submit>  <s:reset></s:reset>
	</s:form>
	
</center>
</body>
</html>