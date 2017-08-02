<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>猥琐发育，别浪</title>
<script type="text/javascript">
    function resetValue(){
    	document.getElementById("userName").value="";
    	document.getElementById("password").value="";
    }
</script>
</head>
<body>
    <div align="center" style="padding-top: 50px;">
        <form action="login" method="post">
        <table align="center" width="740" height="500" background="images/login.jpg" border="0">
            <tr height="180">
                <td colspan="4 "></td>
            </tr>
            <tr height="10">
                <td width="40%">1</td>
                <td width="10%">用户名：</td>
                <td><input type="text" value="${userName }" name="userName" id="userName"></input></td>
                <td width="30%"></td>
            </tr>
            <tr height="10">
                <td width="40%">1</td>
                <td width="10%">密    码：</td>
                <td><input type="text" value="${password }" name="password" id="password"></input></td>
                <td width="30%"></td>
            </tr>
            <tr height="10">
                <td width="40%"></td>
                <td width="10%"><input type="submit" value="登录"/></td>
                <td><input type="button" value="重置" onclick="resetValue()"/></td>
                <td width="30%"></td>                
            </tr>
            <tr height="10">
                <td width="40%"></td>
               <td colspan="3">
                   <font color="red">${error }</font>
               </td>                
            </tr>
            <tr>
                <td></td>
             </tr>
      
        </table>   
        </form>
    </div>

</body>
</html>