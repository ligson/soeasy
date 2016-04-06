<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><@block name="title">标题</@block></title>
    <link rel="stylesheet" type="text/css" href="/assets/js/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/assets/js/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="/assets/css/base.css">
    <script type="text/javascript" src="/assets/js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/assets/js/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<@block name="header"></@block>
</head>
<body>
<nav class="navbar navbar-inverse nav_top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">SE</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">快速入门<span class="sr-only">(current)</span></a></li>
                <li><a href="#">开发文档</a></li>
                <li><a href="#">常见问题</a></li>
                <li><a href="#">常用插件</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">菜单<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">我的文章</a></li>
                        <li><a href="#">我的问题</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">修改个人信息</a></li>
                        <li><a href="#">修改密码</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<@block name="body"></@block>
<footer>
    <div class="container"><p class="text-center" style="padding:10px;">京ICP备11008151号京公网安备11010802014853</p></div>
</footer>
</body>
</html>