<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.tpms.entities.Salary"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
				<meta http-equiv="description" content="This is my page">
					<link type="text/css" href="css/style.css" rel="stylesheet">
						<link rel="stylesheet" type="text/css" href="css/common1.css" />
						<script src="content/js/jquery/jquery-1.8.1.min.js"></script>
						<script type="text/javascript"
							src="jquery-easyui-1.5.2/jquery.min.js"></script>
						<script type="text/javascript"
							src="jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
						<script type="text/javascript"
							src="jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
						<link rel="stylesheet"
							href="jquery-easyui-1.5.2/themes/metro/easyui.css"
							type="text/css" />
						<link rel="stylesheet" href="jquery-easyui-1.5.2/themes/icon.css"
							type="text/css" />
						<script type="text/javascript"
							src="jquery-easyui-1.5.2/commons.js"></script>
<script src="scriptaculous/lib/prototype.js" type="text/javascript"></script>
<script src="scriptaculous/src/effects.js" type="text/javascript"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
	//<![CDATA[
	<!--
	// Alternative Style: Working With Alternate Style Sheets
	// http://www.alistapart.com/articles/alternate/
	function setActiveStyleSheet(title) {
		var i, a, main;
		for (i = 0; (a = document.getElementsByTagName("link")[i]); i++) {
			if (a.getAttribute("rel").indexOf("style") != -1
					&& a.getAttribute("title")) {
				a.disabled = true;
				if (a.getAttribute("title") == title)
					a.disabled = false;
			}
		}
	}
	//-->
	//]]>
</script>
<link title="style1" rel="stylesheet" href="style.css" type="text/css" />
<link title="style2" rel="alternate stylesheet" href="style2.css"
	type="text/css" />
<link title="style3" rel="alternate stylesheet" href="style3.css"
	type="text/css" />
</head>
<body>

<%
	Salary sal = (Salary)request.getAttribute("sal");
%>

	<div class="style_changer">
		<div class="style_changer_text">选择:</div>
		<input type="submit" value="1"
			onclick="setActiveStyleSheet('style1');" /> <input type="submit"
			value="2" onclick="setActiveStyleSheet('style2');" /> <input
			type="submit" value="3" onclick="setActiveStyleSheet('style3');" />
	</div>

	<div class="form_content">
		<form id="test" action="salary-save" method="get">
			<fieldset>
				<legend>工资信息</legend>
				<div class="form-row">
					<div class="field-label">
						<label for="field1">姓名</label>:
					</div>
					<div class="field-widget">
						<input name="name" id="field1" class="required" value="<%=sal.getName() %>"
							title="Enter your name" />
					</div>
				</div>


			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
		function formCallback(result, form) {
			window.status = "valiation callback for form '" + form.id
					+ "': result = " + result;
		}

		var valid = new Validation('test', {
			immediate : true,
			onFormValidate : formCallback
		});
		Validation.addAllThese([ [ 'validate-password', '> 6 characters', {
			minLength : 7,
			notOneOf : [ 'password', 'PASSWORD', '1234567', '0123456' ],
			notEqualToField : 'field1'
		} ], [ 'validate-password-confirm', 'please try again.', {
			equalToField : 'field8'
		} ] ]);
	</script>

</body>
</html>