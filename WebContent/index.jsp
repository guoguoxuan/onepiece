<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>猥琐发育，别浪</title>
        <link rel="stylesheet" type="text/css" href="css/default.css"/>
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        
    </head>
    <body>
        <article class="htmleaf-container">
            <header class="htmleaf-header">
                <h1>沈阳龙飏信息科技</h1>
                <div class="htmleaf-links">

                </div>
            </header>
            <form action="login" method="post">
            <div class="panel-lite">
                <div class="thumbur">
                    <div class="icon-lock"></div>
                </div>
                <h4>用户登录</h4>
                <div class="form-group">
                    <input required="required" value="${userName }"  name="userName" id="userName" class="form-control"/>
                    <label class="form-label">用户名    </label>
                </div>
                <div class="form-group">
                    <input type="password" value="${password }" name="password" id="password"  required="required" class="form-control"/>
                    <label class="form-label">密　码</label>
                </div>
                <a href="#">${error }</a>
                <button class="floating-btn"><i class="icon-arrow"></i></button>
            </div>
            </form>

        </article>
<div style="text-align:center;">
</div>
    </body>
</html>