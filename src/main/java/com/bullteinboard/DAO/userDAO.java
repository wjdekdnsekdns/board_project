package com.bullteinboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bullteinboard.DTO.boardDTO;
import com.bullteinboard.DTO.userDTO;
import com.bullteinboard.utils.DBHelper;

public class userDAO {
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public userDAO() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	public int join(userDTO dto) {
		
		int resultcount = 0;
		String query = " INSERT INTO user (user_id,user_password,user_name) "
				+ "VALUES (?,?,?) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPassword());
			pstmt.setString(3, dto.getUserName());
			resultcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultcount;
		

	}
	public userDTO login(String userId, String userPassword) {
		String SQL = "SELECT * FROM user WHERE user_id = ? AND user_password = ? ";
		userDTO dto = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId); 
			pstmt.setString(2, userPassword);
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String userid = rs.getString("user_id");
				String userpassword = rs.getString("user_password");
				String username = rs.getString("user_name");
				int usernum= rs.getInt("user_num");
				
				dto = new userDTO(userid, userpassword, username,usernum);
				dto.setUserId(userid);
				dto.setUserPassword(userpassword);
				dto.setUserName(username);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return dto;  
	}
		
	

}
