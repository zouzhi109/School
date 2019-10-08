<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网吧管理-增加用户</title>
</head>
<body>
	<h2>添加用户</h2>
	<form action="" method="post">
		<input name="id" type="hidden" value="${user.id }">
		用户身份证号：<input type="text" name="idCard" value=""><br><br>
		用户姓名：<input type="text" name="name" value=""><br><br>
		用户性别：<input type="radio" name="sex" value="男" checked="checked">男
		<input type="radio" name="sex" value="女">女<br><br>
		用户电话：<input type="text" name="tel" value=""><br><br>
		用户余额：<input type="text" name="price" value=""><br><br>
		操作人：
			<select name="adminId">
				<c:forEach items="${adminList }" var="a">
					<option value="${a.id }"${user.adminId==a.id?' selected="selected"':''}>${a.name}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="提交">
	</form>
</body>
</html>