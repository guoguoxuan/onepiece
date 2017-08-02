package cn.icat.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.icat.dao.UserDao;
import cn.icat.model.User;
import cn.icat.util.DbUtil;
import cn.icat.util.StringUtil;

public class LoginServlet extends HttpServlet {
	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		if (StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)) {
			request.setAttribute("error", "用户名或密码为空！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser == null) {
				request.setAttribute("error", "用户名或密码错误");
				//服务器跳转
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				//获取Session
				HttpSession session = request.getSession();
				session.setAttribute("currentUser1", currentUser);
				
				//客户端跳转
				response.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
