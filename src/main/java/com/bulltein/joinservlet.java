package com.bulltein;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullteinboard.DAO.userDAO;
import com.bullteinboard.DTO.userDTO;

@WebServlet("/joinservlet")
public class joinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public joinservlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDTO dto = new userDTO();
		userDAO dao = new userDAO();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("join")) {
			dto.setUserId(request.getParameter("userID"));
			dto.setUserPassword(request.getParameter("userPassword"));
			dto.setUserName(request.getParameter("userName"));
			int result = dao.join(dto);
			System.out.println("result : " + result);
			response.sendRedirect("login.jsp");
	}

	}
	
}
