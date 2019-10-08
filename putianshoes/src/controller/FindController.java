package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserEntity;
import service.UserService;

/**
 * Servlet implementation class FindController
 */
@WebServlet("/query")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到输入框中的数据
		String name = request.getParameter("name");
		//调用service层中的模糊查询方法，得到的值放在list中
		List<UserEntity> list = userService.getLikeName(name);
		
		//判断模糊查询的结果是否为空
		if(null == list||list.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/jsp/empty.jsp").forward(request, response);
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		}
		
	}

}
