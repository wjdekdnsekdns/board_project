package com.bulltein;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullteinboard.DAO.userDAO;
import com.bullteinboard.DTO.userDTO;


@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginservlet() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		userDAO dao = new userDAO();
		String userid = request.getParameter("userID");
		String userpassword = request.getParameter("userPassword");
		userDTO userdto = dao.login(userid, userpassword);
		
		if(userdto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", userid);
			session.setAttribute("userPassword", userpassword);
			session.setAttribute("userName", userdto.getUserName());
			session.setAttribute("userNum", userdto.getUserNum());
			response.sendRedirect("/bbs/mainpage");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('아이디 비밀번호를 확인하세요'); location.href='"+"login.jsp"+"';</script>");
			writer.close();
		}
	}
}
