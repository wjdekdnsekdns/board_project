package com.bullteinboard.DTO;

import java.sql.Timestamp;

public class boardDTO {

	private String userName;
	private int boardId;
	private String subject;
	private String content;
	private Timestamp creatboard;
	private int userid;
	private int userNum;

	public boardDTO() {
	}

	public boardDTO(String userName, int boardId, String subject, String content, Timestamp creatboard, int userid) {
		super();
		this.userName = userName;
		this.boardId = boardId;
		this.subject = subject;
		this.content = content;
		this.creatboard = creatboard;
		this.userid = userid;
	}

	public boardDTO(int boardId, String subject, String content, Timestamp creatboard) {
		this.boardId = boardId;
		this.subject = subject;
		this.content = content;
		this.creatboard = creatboard;
	}

	public boardDTO(String subject, String content, Timestamp creatboard) {
		this.subject = subject;
		this.content = content;
		this.creatboard = creatboard;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}



	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public Timestamp getCreatboard() {
		return creatboard;
	}

	public void setCreatboard(Timestamp creatboard) {
		this.creatboard = creatboard;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}