<%@ page import="panx.entity.AllUser" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PanX
  Date: 2020/8/4
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<AllUser> list = (List<AllUser>) request.getSession().getAttribute("panxuserlist");
    for (AllUser arr : list) {
        if(arr.getGods().equals("0")){
            arr.setGods("否");
        }else if(arr.getGods().equals("1")){
            arr.setGods("是");
        }else{
            arr.setGods("不清楚");
        }
        response.getWriter().println("账号" + arr.getUsernum() + "&nbsp&nbsp&nbsp&nbsp&nbsp密码：" + arr.getPassword()+"&nbsp&nbsp&nbsp&nbsp&nbsp用户名："+arr.getUsername()+ "&nbsp&nbsp&nbsp&nbsp&nbsp现有书本是：" + arr.getNowbook()
                + "&nbsp&nbsp&nbsp&nbsp&nbsp已借：" + arr.getAllbooknum()+ "&nbsp&nbsp&nbsp&nbsp&nbsp是否管理员：" + arr.getGods()+"</br>");
    }
%>
</body>
</html>
