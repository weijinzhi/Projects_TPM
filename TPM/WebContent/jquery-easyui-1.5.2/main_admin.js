
function showAbout(){
	$.messager.alert("关于系统","车站售票管理系统");
}

function logout(){
	$.messager.confirm('提示信息' , '确认注销并退出系统?' , function(r){
		if(r){
			window.location.href = "passenger-logout.action";
		}
		else return;
	});
}