<%--
  Created by IntelliJ IDEA.
  User: PanX
  Date: 2020/8/2
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="panx.entity.AllBook" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<AllBook> list = (List<AllBook>) request.getSession().getAttribute("panxbooklist");
    for (AllBook arr : list) {
        if(arr.getIsin().equals("0")){
            arr.setIsin("是");
        }else if(arr.getIsin().equals("1")){
            arr.setIsin("否");
        }else{
            arr.setIsin("不清楚");
        }
        response.getWriter().println("ID是" + arr.getCodenum() + "&nbsp&nbsp&nbsp&nbsp&nbsp书名是：" + arr.getBookname()+ "&nbsp&nbsp&nbsp&nbsp&nbsp书编码是：" + arr.getBooknum()
                + "&nbsp&nbsp&nbsp&nbsp&nbsp存放位置是：" + arr.getInsite()+ "&nbsp&nbsp&nbsp&nbsp&nbsp是否在馆：" + arr.getIsin()+ "&nbsp&nbsp&nbsp&nbsp&nbsp返回时间：" + arr.getBacktime()+"</br>");
        }
%>
</body>
</html>
