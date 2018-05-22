<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	<div class="style_changer">
		<div class="style_changer_text">选择:</div>
		<input type="submit" value="1"
			onclick="setActiveStyleSheet('style1');" /> <input type="submit"
			value="2" onclick="setActiveStyleSheet('style2');" /> <input
			type="submit" value="3" onclick="setActiveStyleSheet('style3');" />
	</div>

	<div class="form_content">
		<form id="test" action="emp-save" method="get">
			<fieldset>
				<legend>个人信息</legend>
				<div class="form-row">
					<div class="field-label">
						<label for="field1">姓名</label>:
					</div>
					<div class="field-widget">
						<input name="name" id="field1" class="required"
							title="Enter your name" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field2">性别</label>:
					</div>
					<div class="field-widget">
						<input type="radio" class="radio_input" name="sex" id="s1"
							value="1" />男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="radio" class="radio_input" name="sex" id="s2" value="2" />女<br />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">年龄</label>:
					</div>
					<div class="field-widget">
						<input name="age" id="age" class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">住址</label>:
					</div>
					<div class="field-widget">
						<input name="address" id="address" class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">联系方式</label>:
					</div>
					<div class="field-widget">
						<input name="phone" id="phone" class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">电子邮箱</label>:
					</div>
					<div class="field-widget">
						<input name="email" id="email" class="required" />
					</div>
				</div>

				<div class="row">
					<div class="field-label">
						<label for="field3">出生日期</label>:
					</div>
					<div class="field-widget">
						<input type="text" name="birth" class="easyui-datebox" value="" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field6">婚姻状况</label>:
					</div>
					<div class="field-widget">
						<select id="field6" name="mary" class="validate-selection">
							<option>已婚</option>
							<option>未婚</option>
						</select>
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">身高</label>:
					</div>
					<div class="field-widget">
						<input name="height" id="email" class="required" />
					</div>
				</div>

			</fieldset>
			<fieldset>
				<legend>工作信息</legend>

				<div class="form-row">
					<div class="field-label">
						<label for="field4">政治面貌</label>:
					</div>
					<div class="field-widget">
						<input name="polity" id="idcard" class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field4">身份证号</label>:
					</div>
					<div class="field-widget">
						<input name="idcard" id="idcard" class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field5">银行账号</label>:
					</div>
					<div class="field-widget">
						<input name="account" id="account" class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field5">银行名称</label>:
					</div>
					<div class="field-widget">
						<input name="bank_name" id="account"
							class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">到岗日期</label>:
					</div>
					<div class="field-widget">
						<input name="arrival" id="arrival" class="easyui-datebox" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field3">密码</label>:
					</div>
					<div class="field-widget">
						<input name="password" id="password"
							class="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">
						<label for="field6">在职状态</label>:
					</div>
					<div class="field-widget">
						<select id="field6" name="Incumbency" class="validate-selection">
							<option>在职</option>
							<option>离退</option>
							<option>停薪留职</option>
							<option>挂靠</option>
						</select>
					</div>
				</div>

			</fieldset>
			<input type="submit" class="submit" value="Submit" /> <input
				class="reset" type="button" value="Reset"
				onclick="valid.reset(); return false" />
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