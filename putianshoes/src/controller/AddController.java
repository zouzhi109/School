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
 * Servlet implementation class AddController
 */
@WebServlet( "/add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService = new AdminService();
	private UserService userService = new UserService();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//得到网管信息 提供下拉框选择
		List<AdminEntity> adminList = adminService.getAll();
		
		request.setAttribute("adminList", adminList);
		request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取参数
		Integer idCard = Integer.parseInt(request.getParameter("idCard"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		Integer tel = Integer.parseInt(request.getParameter("tel"));
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer aId = Integer.parseInt(request.getParameter("adminId"));
		
		//2.执行操作
		UserEntity userEntity = new UserEntity();
		userEntity.setIdCard(idCard);
		userEntity.setName(name);
		userEntity.setSex(sex);
		userEntity.setTel(tel);
		userEntity.setPrice(price);
		userEntity.setaId(aId);
		
		//3.调用insert方法
		userService.insert(idCard, name, sex, tel, price, aId);
		
		//4.调用视图V---返回list界面
		response.sendRedirect(request.getContextPath()+"/list");
		
	}

}
