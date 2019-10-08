package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet(description = "Extends HttpServlet", urlPatterns = { "/delete" })
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取参数   由于设置了复选框 可能拿到多个id
		String[] ids = request.getParameterValues("id");
		
		//2.执行操作
		if(ids != null && ids.length>0) {
			for(String id:ids) {
				userService.delete(Integer.parseInt(id));
			}
		}
		
		//3.重定位返回list视图
		response.sendRedirect(request.getContextPath()+"/list");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
