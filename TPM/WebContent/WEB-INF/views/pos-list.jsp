<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/struts-tags"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>职位管理</title>
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

<script type="text/javascript">
	$(function() {
		var flag;
		$('#positions').datagrid({
			idField : 'position_id', //只要创建数据表格 就必须要加 ifField
			title : '职位列表',
			url : 'json/Position-list',
			height : 490,
			fitColumns : true,
			striped : true, //ֻ只要创建数据表格 就必须要加 ifField
			loadMsg : '数据正在加载,请耐心的等待...',
			rownumbers : true, //序号
			frozenColumns : [ [ //冻结列特性 ,不要与fitColumns 特性一起使用
			{
				field : 'ck',
				width : 50,
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'position_id',
				title : 'ID号',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				field : 'position_name',
				title : '职位',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				field : 'salary',
				title : '工资',
				align : 'center',
				width : 100
			}, {
				field : 'section.section_name',
				title : '所属部门',
				align : 'center',
				width : 100,
				formatter: function(value,row,index){
					return new Object(row["section"]).section_name;
				}
			} ] ],
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			toolbar : [ {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					var arr = $('#positions').datagrid('getSelections');
					if (arr.length <= 0) {
						$.messager.show({
							title : '提示信息!',
							msg : '至少选择一行记录进行删除!'
						});
					} else {
						$.messager.confirm('提示信息', '确认删除?', function(r) {
							if (r) {
								var ids = '';
								for (var i = 0; i < arr.length; i++) {
									ids += arr[i].position_id + ',';
								}								
								ids = ids.substring(0, ids.length - 1);
								$.post('json/Position-delete', {
									ids : ids
								}, function(result) {
									//1 刷新数据表格 
									$('#positions').datagrid('reload');
									//2 清空idField   
									$('#positions').datagrid('unselectAll');
									//3 给提示信息 
									$.messager.show({
										title : '提示信息!',
										msg : '操作成功!'
									});
								});
							} else {
								return;
							}
						});
					}

				}
			},'-', {
				text : '查询',
				iconCls : 'icon-search',
				handler : function() {
					$('#lay').layout('expand', 'north');
				}
			}
			]
		});
		//提交表单方法
		$('#btn1').click(
				function() {
					if ($('#myform').form('validate')) {
						$.ajax({
							type : 'post',
							url : flag == 'add' ? 'json/Section-save'
									: 'json/Section-update',
							cache : false,
							data : $('#myform').serialize(),
							dataType : 'json',
							success : function(result) {
								//1 关闭窗口
								$('#mydialog').dialog('close');
								//2刷新datagrid 
								$('#positions').datagrid('reload');
								//3 提示信息
								$.messager.show({
									title : result.status,
									msg : result.message
								});
							},
							error : function(result) {
								$.messager.show({
									title : result.status,
									msg : result.message
								});
							}
						});
					} else {
						$.messager.show({
							title : '提示信息!',
							msg : '数据验证不通过,不能保存!'
						});
					}
				});

		//关闭窗口方法
		$('#btn2').click(function() {
			$('#mydialog').dialog('close');
		});
		
		
	});
	
	function editUser(index){  
	    $('#positions').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#positions').datagrid('getSelected');  
	    if (row){  
	        href = "pos-edit?position_id="+row.position_id;  
	    }  
	}
	
	function doSearch() {
		$('#positions').datagrid('load', {
			position_name: $('#position_name').val()
		});
	}
	
	//点击清空按钮出发事件
	function clearSearch() {
		$("#positions").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
		$("#search").find("input").val("");//找到form表单下的所有input标签并清空
	}
	
	//js方法：序列化表单 			
	function serializeForm(form) {
		var obj = {};
		$.each(form.serializeArray(), function(index) {
			if (obj[this['name']]) {
				obj[this['name']] = obj[this['name']] + ',' + this['value'];
			} else {
				obj[this['name']] = this['value'];
			}
		});
		return obj;
	}
	
	function doS() {
		$('#positions').datagrid('load', {
	        s1 : $("#s1").val(),
			s2 : $("#s2").val(),
		});
	}
	
</script>
</head>
<body>

	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<a href="pos-input" class="easyui-linkbutton" iconCls="icon-add"
				plain="true"></a> <a href="pos-edit" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true"></a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-save" plain="true"></a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true"></a>
		</div>
		<div id="dg">
			工资范围： <input id="s1" name="s1" class="easyui-validatebox" style="width:110px">
			到: <input id="s2" name="s2" class="easyui-validatebox" style="width:110px">
			<a href="javascript:doS();" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>

	<div id="lay" class="easyui-layout"
		style="width: 870px; height: 522px; overflow: hidden;">
		<div region="north" title="职位查询" collapsed=true style="height: 60px;">
			<form id="search" action="" method="post">

				职位:&nbsp;&nbsp;&nbsp;<input name="position_name"
					class="easyui-validatebox" id="position_name" value="" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="searchbtn"
					class="easyui-linkbutton" href="javascript:doSearch();">查询</a> <a
					id="clearbtn" class="easyui-linkbutton"
					href="javascript:clearSearch()">清空</a>
			</form>

		</div>

		<div region="center">
			<table id="positions"></table>
		</div>
	</div>

</body>
</html>