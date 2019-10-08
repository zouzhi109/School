package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.AdminEntity;
import entity.UserEntity;
import service.AdminService;
import service.UserService;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	private AdminService adminService = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		//2.获取当前id对应的用户信息
		UserEntity user = userService.getById(id);
		
		//3.获取管理员列表
		List<AdminEntity> adminList = adminService.getAll();
		
		//4.返回视图，调用V-请求转发
		request.setAttribute("user", user);
		request.setAttribute("adminList", adminList);
		request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer idCard = Integer.parseInt(request.getParameter("idCard"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		Integer tel = Integer.parseInt(request.getParameter("tel"));
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer aId = Integer.parseInt(request.getParameter("aId"));
		
		//2.执行操作
		UserEntity userEntity = new UserEntity(id, idCard, name, sex, tel, price, aId);
		userService.update(userEntity);
		
		//3.返回视图    通过重定向返回list界面
		response.sendRedirect(request.getContextPath()+"/list");
		
	}

}
