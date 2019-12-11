package com.team404.freeboard.mapper;

import java.util.ArrayList;

import com.team404.command.freeBoardVO;
import com.team404.util.Criteria;

public interface FreeBoardMapper {

	public void regist(freeBoardVO vo);
	//public ArrayList<freeBoardVO> getList();//기본목록
	public ArrayList<freeBoardVO>getList(Criteria cri);//기본페이징
	public freeBoardVO content(int bno);
	public boolean update(freeBoardVO vo);
	public boolean delete(freeBoardVO vo );
	public int getTotal(Criteria cri);
}
