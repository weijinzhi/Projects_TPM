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
<title>工资管理</title>
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
		$('#salary').datagrid({
			idField : 'id', //只要创建数据表格 就必须要加 ifField
			title : '工资列表',
			url : 'json/Salary-find?name=${loginmanagername}',
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
				field : 'absence',
				title : '缺勤扣除',
				align : 'center',
				width : 100
			}, {
				field : 'business',
				title : '出差奖励',
				align : 'center',
				width : 100
			}, {
				field : 'basic',
				title : '基本工资',
				align : 'center',
				width : 100
			}, {
				field : 'salary',
				title : '实际工资',
				align : 'center',
				width : 100
			}, {
				field : 'annual',
				title : '年薪',
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
                    $('#mydialog').window('open').window('resize',{width:'258px',height:'260px',top:'80px',left:'432px'});

				}
			},'-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					flag = 'edit';
					var arr = $('#salary').datagrid('getSelections');
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
							absence : arr[0].absence,
							business : arr[0].business,
							basic : arr[0].basic,
							salary : arr[0].salary,
							annual : arr[0].annual
						});

					}
				}
			},'-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					var arr = $('#salary').datagrid('getSelections');
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
								$.post('json/Salary-delete', {
									ids : ids
								}, function(result) {
									//1 刷新数据表格 
									$('#salary').datagrid('reload');
									//2 清空idField   
									$('#salary').datagrid('unselectAll');
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
							url : flag == 'add' ? 'json/Salary-save'
									: 'json/Salary-update',
							cache : false,
							data : $('#myform').serialize(),
							dataType : 'json',
							success : function(result) {
								//1 关闭窗口
								$('#mydialog').dialog('close');
								//2刷新datagrid 
								$('#salary').datagrid('reload');
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
		$('#salary').datagrid('load', {
			name: $('#name').val(),
		});
	}
	
	//点击清空按钮出发事件
	function clearSearch() {
		$("#salary").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
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
		$('#salary').datagrid('load', {
	        cc : $('#cc').combobox('getValues'),
		});
	}
</script>
</head>
<body>

	<div id="tb" >
		<div id="dg">
			查询条件： <select id="cc" name="cc" class="easyui-combobox" style="width:110px">
				<option value="aa">缺勤扣除</option>
				<option value="bb">出差奖励</option>
				<option value="cc">基本工资</option>
				<option value="dd">实际工资</option>
				<option value="ee">年薪</option>
			</select>
			<a href="javascript:doS();" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>

	<div id="lay" class="easyui-layout"
		style="width: 870px; height: 522px; overflow: hidden;">
		<div region="north" title="查询" collapsed=true style="height: 60px;">
			<form id="search" action="" method="post">
			
				员工:&nbsp;&nbsp;&nbsp;<input name="name" class="easyui-validatebox"
					id="name" value="" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					
					<a id="searchbtn" class="easyui-linkbutton"
					href="javascript:doSearch();">查询</a> <a id="clearbtn"
					class="easyui-linkbutton" href="javascript:clearSearch()">清空</a>
			</form>

		</div>

		<div region="center">
			<table id="salary"></table>
		</div>
	</div>

	<div id="mydialog" title="部门管理" modal=true draggable=false
		class="easyui-dialog" closed=true style="width: 230px;">

		<form id="myform" action="" method="post">
			<input hidden name="id" value="" />
			<table>
				<tr>
					<td>员工姓名:</td>
					<td><input type="text" name="name" class="easyui-validatebox"
						 value="" /></td>
				</tr>
				<tr>
					<td>缺勤扣除:</td>
					<td><input type="text" name="absence"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>出差奖励:</td>
					<td><input type="text" name="business"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>基本工资:</td>
					<td><input type="text" name="basic"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>实际工资:</td>
					<td><input type="text" name="salary"
						class="easyui-validatebox" 
						value="" /></td>
				</tr>
				<tr>
					<td>年薪:</td>
					<td><input type="text" name="annual"
						class="easyui-validatebox" 
						value="" /></td>
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