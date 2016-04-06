<@override name="title">登录</@override>
<@override name="header">
</@override>
<@override name="body">
<div class="container idx_body">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>

    <div class="col-md-3"></div>
    <form class="form-horizontal col-md-6" action="/login.do">
        <div class="form-group">
            <label for="userName" class="col-md-2 control-label">用户名:</label>

            <div class="col-md-10">
                <input class="form-control" id="userName" name="username"/>
            </div>
        </div>
        <div class="form-group">
            <label for="userPwd" class="col-md-2  control-label ">密码:</label>

            <div class="col-md-10">
                <input class="form-control" type="password" id="userPwd" name="password"/>
            </div>
        </div>
        <div class="form-group  text-center">
            <input type="button" class="btn btn-info" value="登录"/>&nbsp;&nbsp;
            <small>没有用户？<a href="/register.html">注册</a>一个</small>
        </div>
    </form>
    <div class="col-md-3"></div>
</div>
</@override>
<@extends name="layout/index.ftl"/>