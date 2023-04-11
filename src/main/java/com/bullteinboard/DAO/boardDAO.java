package com.bullteinboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bullteinboard.DTO.IBoard;
import com.bullteinboard.DTO.boardDTO;
import com.bullteinboard.utils.DBHelper;

public class boardDAO implements IBoard {
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public boardDAO() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	// 전체 글 보이는 기능( 이름 제목 작성시간만 나오게)
	@Override
	public ArrayList<boardDTO> select() {

		ArrayList<boardDTO> list = new ArrayList<>();

		String query = " SELECT user.user_name, board.board_id, board.subject, board.content, board.creatboard,board.user_id "
				+ " FROM user "
				+ " join board "
				+ " on user.user_num = board.user_id ";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String username = rs.getString("user_name");
				int boardid = rs.getInt("board_id");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Timestamp creatboard = rs.getTimestamp("creatboard");
				int userid = rs.getInt("user_id");
				boardDTO dto = new boardDTO(username,boardid,subject,content, creatboard,userid);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public boardDTO selectById(int id){
		boardDTO dto = null;
		String query = " SELECT user.user_name, board.board_id, board.subject, board.content, board.creatboard,board.user_id "
				+ " FROM user "
				+ " join board "
				+ " on user.user_num = board.user_id "
				+ " where board.board_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String username = rs.getString("user_name");
				int boardid = rs.getInt("board_id");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Timestamp creatboard = rs.getTimestamp("creatboard");
				int userid = rs.getInt("user_id");
				dto = new boardDTO(username,boardid,subject,content, creatboard,userid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// 게시글 작성 기능
	@Override
	public int insert(boardDTO dto) {
		int resultcount = 0;
		String query = " INSERT INTO board(subject, content, creatboard, user_id) "
				+ "VALUES( ? , ? , now(), ? ) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getUserNum());
			resultcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultcount;

	}

	// 작성글 수정
	@Override
	public int update(boardDTO dto) {
		int resultcount = 0;
		String query = " UPDATE board SET subject = ?, content = ? WHERE board_id = ?  ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBoardId());
			resultcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultcount;

	}

	// 게시글 삭제 기능
	@Override
	public int delete(boardDTO dto) {
		int resultcount = 0;
		String query = " DELETE FROM board WHERE subject = ? AND content = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			resultcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultcount;
	}

	@Override
	public ArrayList<boardDTO> viewboard() {
		ArrayList<boardDTO> list = new ArrayList<>();

		String query = " SELECT subject,name,creatboard,content FROM board ";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String subject = rs.getString("subject");
				String name = rs.getString("name");
				Timestamp creatboard = rs.getTimestamp("creatboard");
				String content = rs.getString("content");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
