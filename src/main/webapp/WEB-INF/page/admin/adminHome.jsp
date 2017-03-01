<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String contextPath = request.getContextPath();
    String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath;
    String ctx = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + request.getContextPath();
    request.setAttribute("path",  contextPath+"/");
    request.setAttribute("basePath",  path+"/");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>DTU</title>
    <link href="${basePath}common/images/favicon.png" rel="shortcut icon">
    <link rel="stylesheet" type="text/css" href="${basePath}common/html/css/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}common/html/css/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}common/html/css/Hui-iconfont/1.0.7/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}common/html/icheck/icheck.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}common/html/css/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${basePath}common/html/css/h-ui.admin/css/style.css" />
</head>
<body style="overflow:hidden;">
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="${basePath}myHome/goMyHome">DTU&nbsp;管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="${basePath }myHome/goMyHome">DTU</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">V1.0</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar ">
                <ul class="cl">
                    <!-- <li>超级管理员</li> -->
                    <li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">${sessionScope.loginInfoSession.result.user_id}<i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <!--<li><a href="#">我的信息</a></li>-->
                           <%-- <li><a href="${basePath}userHome/myInfo" >我的信息</a></li>--%>
                            <li><a href="${basePath}home/exit">退出</a></li>
                        </ul>
                    </li>
                    <%--  <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>--%>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <input runat="server" id="divScrollValue" type="hidden" value="" />
    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <dt><i class="Hui-iconfont">&#xe60d;</i> 个人信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="${basePath}userHome/myInfo" data-title="我的信息" href="javascript:void(0)">我的信息</a></li>
                </ul>
            </dd>
        </dl>
        <c:forEach items="${units}" var="com" varStatus ="status">
            <dl id="menu-picture">
                <dt><i class="Hui-iconfont">&#xe616;</i> ${com.unit_name}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
                <dd>
                    <ul>
                        <li><a _href="${basePath }myHome/goComInfo?id=${com.unit_no}" data-title="本单位信息维护" href="javascript:void(0)">本单位信息维护</a></li>
                        <li><a _href="${basePath }myHome/goComUser?id=${com.unit_no}" data-title="本单位信息维护" href="javascript:void(0)">本单位用户维护</a></li>
                        <li><a _href="${basePath }myHome/goDTUConfig?id=${com.unit_no}" data-title="DTU维护" href="javascript:void(0)">DTU维护</a></li>
                            <%-- <li><a _href="${basePath}userHome/myInfo" data-title="我的信息" href="javascript:void(0)">我的信息</a></li>--%>
                        <!--                    <li><a _href="${basePath }userHome/otherReply.do" data-title="非关键字回复" href="javascript:void(0)">非关键字回复</a></li>-->
                    </ul>
                </dd>
            </dl>
        </c:forEach>
        <%--<dl id="menu-picture">
            <dt><i class="Hui-iconfont">&#xe616;</i> 迪辉科技（北京）<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="${basePath }myHome/goComInfo" data-title="本单位信息维护" href="javascript:void(0)">本单位信息维护</a></li>
                    <li><a _href="${basePath }myHome/goComUser" data-title="本单位信息维护" href="javascript:void(0)">本单位用户维护</a></li>
                    <li><a _href="${basePath }myHome/goDTUConfig" data-title="DTU维护" href="javascript:void(0)">DTU维护</a></li>
                   &lt;%&ndash; <li><a _href="${basePath}userHome/myInfo" data-title="我的信息" href="javascript:void(0)">我的信息</a></li>&ndash;%&gt;
                    <!--                    <li><a _href="${basePath }userHome/otherReply.do" data-title="非关键字回复" href="javascript:void(0)">非关键字回复</a></li>-->
                </ul>
            </dd>
        </dl>--%>

        <%--<dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe616;</i> 迪辉科技（天津）<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="${basePath }myHome/goComInfo" data-title="本单位信息维护" href="javascript:void(0)">本单位信息维护</a></li>
                    <li><a _href="${basePath }myHome/goComUser" data-title="本单位信息维护" href="javascript:void(0)">本单位用户维护</a></li>
                    <li><a _href="${basePath }myHome/goDTUConfig" data-title="DTU维护" href="javascript:void(0)">DTU维护</a></li>
                   &lt;%&ndash; <li><a _href="${basePath}userHome/myInfo" data-title="我的信息" href="javascript:void(0)">我的信息</a></li>&ndash;%&gt;
                    <!--                    <li><a _href="${basePath }userHome/otherReply.do" data-title="非关键字回复" href="javascript:void(0)">非关键字回复</a></li>-->
                </ul>
            </dd>
        </dl>--%>
        <!--<dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe60d;</i> 关注推送<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="${basePath }userHome/attentionReply.do" data-title="关注推送" href="javascript:void(0)">关注推送</a></li>
                </ul>
            </dd>
        </dl>-->
        <!-- <dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="system-base.html" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
                    <li><a _href="system-category.html" data-title="密码管理" href="javascript:void(0)">密码管理</a></li>
                </ul>
            </dd>
        </dl> -->
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="我的桌面" data-href="${basePath }userHome/welcome">欢迎页</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" id="index_iframe" src="${basePath}userHome/welcome.do"></iframe>
        </div>
    </div>
</section>
<script type="text/javascript" src="${basePath}common/html/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}common/html/js/layer.js"></script>
<script type="text/javascript" src="${basePath}common/html/css/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${basePath}common/html/css/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
    /*资讯-添加*/
    function article_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    function goInfo(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*图片-添加*/
    function picture_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*产品-添加*/
    function product_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
</script>
<script type="text/javascript">
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s)})();
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>