<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>企业人事管理系统</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>企业人事后台管理系统</h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">管理员登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">员工登录</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
    
            
			<div class="login_form">
				<form action="manager-login" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
               <input type="hidden" name="to" value="log"/>
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">账户：</label>
                <div class="inputOuter" id="uArea">
                    
                    <input type="text" id="u" name="username" class="inputstyle"/>
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" id="p" name="password" class="inputstyle"/>
                </div>
                </div>
               
                <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/></div>
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>

  <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login"><form name="form2" id="regUser" accept-charset="utf-8"  action="employee-login" method="post">
	      <input type="hidden" name="to" value="reg"/>
		      		       <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
                <li>
                	
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="name" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="password" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                    <div style="padding-left:50px;margin-top:20px;">
                        <input type="submit" value="登 录" style="width:150px;" class="button_blue"/>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
           
    
    </div>
   
    
    </div>
    <!--注册end-->
</div>
</body></html>