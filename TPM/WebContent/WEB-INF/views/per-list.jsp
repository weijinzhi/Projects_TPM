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
<title>人事变更管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" href="css/style.css" rel="stylesheet">
<link type="text/css" href="css/My97DatePicker/WdatePicker.js" rel="stylesheet">
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
		$('#personnel').datagrid({
			idField : 'id', //只要创建数据表格 就必须要加 ifField
			title : '部门列表',
			url : 'json/Personnel-list',
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
				field : 'id',
				title : 'ID号',
				align : 'center',
				sortable : true,
				width : 100,
			}, {
				field : 'name',
				title : '员工姓名',
				align : 'center',
				sortable : true,
				width : 100
			}, {
				field : 'oldId',
				title : '旧员工号',
				align : 'center',
				width : 100
			}, {
				field : 'newId',
				title : '新员工号',
				align : 'center',
				width : 100
			}, {
				field : 'oldSection',
				title : '旧部门',
				align : 'center',
				width : 100
			}, {
				field : 'newSection',
				title : '新部门',
				align : 'center',
				width : 100
			}, {
				field : 'oldPosition',
				title : '旧职位',
				align : 'center',
				width : 100
			}, {
				field : 'newPosition',
				title : '新职位',
				align : 'center',
				width : 100
			}, {
				field : 'oldsalary',
				title : '旧工资',
				align : 'center',
				width : 100
			}, {
				field : 'newsalary',
				title : '新工资',
				align : 'center',
				width : 100
			}, {
				field : 'reason',
				title : '理由',
				align : 'center',
				width : 100
			}, {
				field : 'date',
				title : '变更时间',
				align : 'center',
				width : 100
			} ] ],
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					flag = 'add';
					$('#mydialog').dialog({
						title : '添加'
					});
					$('#myform').get(0).reset();
					  //改变弹出框的位置
                    $('#mydialog').window('open').window('resize',{width:'258px',height:'400px',top:'80px',left:'432px'});

				}
			},'-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					flag = 'edit';
					var arr = $('#personnel').datagrid('getSelections');
					if (arr.length == 0) {
						$.messager.show({
							title : '提示信息!',
							msg : '请选择一条信息进行修改!'
						});
					}else if (arr.length > 1) {
						$.messager.show({
							title : '提示信息!',
							msg : '只能选择一行记录进行修改!'
						});
					}else {
						$('#mydialog').dialog({
							title : '修改'
						});
						 $('#mydialog').window('open').window('resize',{width:'258px',height:'260px',top:'80px',left:'432px'});
						//$('#myform').get(0).reset();   //清空表单数据 
						$('#myform').form('load', { //调用load方法把所选中的数据load到表单中,非常方便
							id : arr[0].id,
							name : arr[0].name,
							oldId : arr[0].oldId,
							newId : arr[0].newId,
							oldSection : arr[0].oldSection,
							newSection : arr[0].newSection,
							oldPosition : arr[0].oldPosition,
							newPosition : arr[0].newPosition,
							oldsalary : arr[0].oldsalary,
							newsalary : arr[0].newsalary,
							reason : arr[0].reason,
							date : arr[0].date
						});

					}
				}
			},'-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					var arr = $('#personnel').datagrid('getSelections');
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
									ids += arr[i].id + ',';
								}								
								ids = ids.substring(0, ids.length - 1);
								$.post('json/Personnel-delete', {
									ids : ids
								}, function(result) {
									//1 刷新数据表格 
									$('#personnel').datagrid('reload');
									//2 清空idField   
									$('#personnel').datagrid('unselectAll');
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
							url : flag == 'add' ? 'json/Personnel-save'
									: 'json/Personnel-update',
							cache : false,
							data : $('#myform').serialize(),
							dataType : 'json',
							success : function(result) {
								//1 关闭窗口
								$('#mydialog').dialog('close');
								//2刷新datagrid 
								$('#personnel').datagrid('reload');
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
	function doSearch() {
		$('#personnel').datagrid('load', {
			name: $('#name').val(),
		});
	}
	
	//点击清空按钮出发事件
	function clearSearch() {
		$("#personnel").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
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
		$('#personnel').datagrid('load', {
	        'date1':$("#date1").datebox("getValue"),
			date2:$("#date2").datebox("getValue")
		});
	}
	
</script>
</head>
<body>

	<div id="dg">
			从: <input id="date1" name="date1" value="date1" class="easyui-datebox" style="width:110px">
			到: <input id="date2" name="date2" value="date2" class="easyui-datebox" style="width:110px">
			<a href="javascript:doS();" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>

	<div id="lay" class="easyui-layout"
		style="width: 870px; height: 522px; overflow: hidden;">
		<div region="north" title="人事变更查询" collapsed=true style="height: 60px;">
			<form id="search" action="" method="post">
			
				部门:&nbsp;&nbsp;&nbsp;<input name="name" class="easyui-validatebox"
					id="name" value="" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					
					<a id="searchbtn" class="easyui-linkbutton"
					href="javascript:doSearch();">查询</a> <a id="clearbtn"
					class="easyui-linkbutton" href="javascript:clearSearch()">清空</a>
			</form>

		</div>

		<div region="center">
			<table id="personnel"></table>
		</div>
	</div>

	<div id="mydialog" title="人事变更管理" modal=true draggable=false
		class="easyui-dialog" closed=true style="width: 300px;">

		<form id="myform" action="" method="post">
			<input hidden name="id" value="" />
			<table>
				<tr>
					<td>员工姓名:</td>
					<td><input type="text" name="name" class="easyui-validatebox"
						 value="" /></td>
				</tr>
				<tr>
					<td>旧员工号:</td>
					<td><input type="text" name="oldId"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>新员工号:</td>
					<td><input type="text" name="newId"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>旧部门:</td>
					<td><input type="text" name="oldSection"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>新部门:</td>
					<td><input type="text" name="newSection"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>旧职位:</td>
					<td><input type="text" name="oldPosition"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>新职位:</td>
					<td><input type="text" name="newPosition"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>旧底薪:</td>
					<td><input type="text" name="oldsalary"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>新底薪:</td>
					<td><input type="text" name="newsalary"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>变更理由:</td>
					<td><input type="text" name="reason"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>变更时间:</td>
					<td><input name="date" class="easyui-datebox" style="width:80px"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
						<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>