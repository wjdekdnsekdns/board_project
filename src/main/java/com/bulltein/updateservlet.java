package com.bulltein;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullteinboard.DAO.boardDAO;
import com.bullteinboard.DTO.boardDTO;
import com.bullteinboard.DTO.userDTO;

@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateservlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		boardDAO dao = new boardDAO();
		boardDTO dto = new boardDTO();
		String action = request.getParameter("action");

		if (action.equals("update")) {

			dto.setSubject(request.getParameter("subject"));
			dto.setContent(request.getParameter("content"));
			dto.setBoardId(Integer.parseInt(request.getParameter("boardId")));
			dao.update(dto);

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('수정되었습니다'); location.href='" + "mainpage" + "';</script>");
			writer.close();

		}
	}

}
