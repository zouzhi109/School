<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用网吧管理系统</title>
</head>
<body>

	<h2>网吧管理</h2>
	
	<!-- 表单名为query 输入框提取输入信息 submit提交按钮 -->
	<form action="query" method="get">
	请输入姓名进行查找&nbsp;&nbsp;<input type="text" name="name" />&nbsp;&nbsp;
	<input type="submit" value="查找">
	</form><br><br>
	<a href="add?id=${user.id }">添加用户</a>
	<br><br>
	
	<!-- 将list中所有的数据遍历显示在table中 -->
	<form action="" method="get">
		<table border="1">
			<thead>
			<tr>
				<th>选择</th>
				<th>卡号</th>
				<th>身份证号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>电话</th>
				<th>余额</th>
				<th>操作人</th>
				<th>操作</th>
			</tr>
			</thead>
			<c:forEach items="${list }" var="s">
			<tbody>
			<tr>
			<!-- 复选框选择删除的用户 -->
			<td><input type="checkbox" name="id" value="${s.id }"></td>
			<td>${s.id }</td>
			<td>${s.idCard }</td>
			<td>${s.name }</td>
			<td>${s.sex }</td>
			<td>${s.tel }</td>
			<td>${s.price }</td>
			<td>${s.admin.name }</td>
			<td>
			<!-- 跳转到编辑界面，弹窗提示是否编辑 -->
			<a href="edit?id=${s.id }">编辑</a>
			<a href="delete?id=${s.id }" onclick="return confirm('确认要删除这个用户吗？');">删除</a>
			</td>
			</tr>
			</tbody>
			</c:forEach>
		</table><br>
		<!-- 复选框提交按钮 -->
		<div>
		<input type="submit" value="删除用户" onclick="return confirm('确认要删除这些用户吗？')">
		</div>
	</form>

</body>
</html>