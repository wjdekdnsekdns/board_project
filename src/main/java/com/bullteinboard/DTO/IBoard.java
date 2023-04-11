package com.bullteinboard.DTO;

import java.util.ArrayList;

public interface IBoard {

	ArrayList<boardDTO> select();
	int insert(boardDTO dto);
	int update(boardDTO dto);
	int delete(boardDTO dto);
	ArrayList<boardDTO> viewboard();
}
