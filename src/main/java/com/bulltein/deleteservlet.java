package com.bulltein;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullteinboard.DAO.boardDAO;
import com.bullteinboard.DTO.boardDTO;

@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boardDAO dao = new boardDAO();
		boardDTO dto = new boardDTO();
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action.equals("delete")) {
				dto.setSubject(request.getParameter("subject"));
				dto.setContent(request.getParameter("content"));
				dao.delete(dto);
				response.sendRedirect("/bbs/mainpage");
		}
	}
}
