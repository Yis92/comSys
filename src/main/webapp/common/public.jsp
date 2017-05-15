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

<!-- JS START -->
<!-- dataTable -->
<script type="text/javascript" src="${basePath }common/jquery/jquery-1.10.0.min.js"></script>
<!-- bootstrap -->
<script type="text/javascript" src="${basePath }common/bootstrap/js/bootstrap.js"></script>
<%-- <script type="text/javascript" src="${basePath }common/bootstrap/js/npm.js"></script> --%>
<link rel="stylesheet" href="${basePath }common/bootstrap/css/bootstrap.css" type="text/css"></link>
<!-- CSS END -->