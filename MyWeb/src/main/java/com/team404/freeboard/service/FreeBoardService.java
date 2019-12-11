package com.team404.freeboard.service;

import java.util.ArrayList;

import com.team404.command.freeBoardVO;
import com.team404.util.Criteria;

public interface FreeBoardService {
	
	public void regist(freeBoardVO vo);//등록
	//public ArrayList<freeBoardVO>getList();//일반
	//기본페이징
	//public ArrayList<freeBoardVO> getList(Criteria cri);
	//public int getTotal();
	public ArrayList<freeBoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	
	public freeBoardVO content(int bno);
	public boolean update(freeBoardVO vo);//게시글 업뎃
	public boolean delete(freeBoardVO vo);//게시글 삭제
	
}
