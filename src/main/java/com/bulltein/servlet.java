package com.bulltein;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullteinboard.DAO.boardDAO;
import com.bullteinboard.DTO.boardDTO;

@WebServlet("/mainpage")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		boardDAO boardDAO = new boardDAO();
		ArrayList<boardDTO> resultlist = boardDAO.select();
		request.setAttribute("list", resultlist);
		request.getRequestDispatcher("/bullteinboad2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boardDAO boardDAO = new boardDAO();
		boardDTO boardDTO = new boardDTO();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("insert")) {
			boardDTO.setSubject(request.getParameter("subject")); 
			boardDTO.setContent(request.getParameter("content"));
			boardDTO.setUserNum(Integer.parseInt(request.getParameter("userNum")));
			System.out.println(request.getParameter("subject"));
			System.out.println(request.getParameter("content"));
			System.out.println(request.getParameter("userNum"));
			boardDAO.insert(boardDTO);
			response.sendRedirect("/bbs/mainpage");
		}
	}
}
