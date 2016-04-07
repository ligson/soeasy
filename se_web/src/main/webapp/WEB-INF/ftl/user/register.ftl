<@override name="title">注册</@override>
<@override name="header">
<link rel="stylesheet" type="text/css" href="/assets/js/lib/bootstrap-validator/css/bootstrapValidator.min.css">
<script type="text/javascript" src="/assets/js/lib/bootstrap-validator/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="/assets/js/custom/register.js"></script>
</@override>
<@override name="body">
<div class="container idx_body">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>

    <div class="col-md-3"></div>
    <form class="form-horizontal col-md-6" action="/register.do" id="reg_form">
        <div class="form-group">
            <label for="userName" class="col-md-2 control-label">用户名:</label>

            <div class="col-md-10">
                <input class="form-control" id="userName" name="name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="userPwd" class="col-md-2  control-label ">密码:</label>

            <div class="col-md-10">
                <input class="form-control" type="password" id="userPwd" name="password"/>
            </div>
        </div>
        <div class="form-group">
            <label for="userPwd2" class="col-md-2  control-label ">再次输入密码:</label>

            <div class="col-md-10">
                <input class="form-control" type="password" id="userPwd2" name="password2"/>
            </div>
        </div>
        <div class="form-group  text-center">
            <input type="button" class="btn btn-info" value="注册"/>
        </div>
    </form>
    <div class="col-md-3"></div>
</div>
</@override>
<@extends name="layout/index.ftl"/>