package com.bullteinboard.DTO;

public class userDTO {

	private int userNum;
	private String userId;
	private String userPassword;
	private String userName;

	public userDTO(String userId, String userPassword, String userName, int userNum) {
		this.userNum = userNum;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
	}

	public userDTO(String userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public userDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
