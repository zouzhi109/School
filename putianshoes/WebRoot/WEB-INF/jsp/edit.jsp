<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网吧管理-用户编辑</title>
</head>
<body>
	<h2>编辑用户信息</h2>
	<form action="" method="post">
		<input name="id" type="hidden" value="${user.id }">
		用户身份证号：<input type="text" name="idCard" value="${user.idCard }"><br><br>
		用户姓名：<input type="text" name="name" value="${user.name }"><br><br>
		<!-- 判断修改前的性别并显示 -->
		用户性别：
			<c:choose>
				<c:when test="${user.sex=='男' }">
					<input type="radio" name="sex" value="男" checked="checked">男
					<input type="radio" name="sex" value="女">女
				</c:when>
				<c:otherwise>
					<input type="radio" name="sex" value="男">男
					<input type="radio" name="sex" value="女" checked="checked">女
				</c:otherwise>
			</c:choose><br><br>
		用户电话：<input type="text" name="tel" value="${user.tel }"><br><br>
		用户余额：<input type="text" name="price" value="${user.price }"><br><br>
		操作人：
			<select name="aId">
				<c:forEach items="${adminList }" var="a">
					<option value="${a.id }"${user.aId==a.id?' selected="selected"':''}>${a.name}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="确认编辑">
	</form>
</body>
</html>