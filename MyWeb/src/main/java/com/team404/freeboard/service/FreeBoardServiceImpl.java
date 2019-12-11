package com.team404.freeboard.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.freeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;
import com.team404.util.Criteria;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{

	@Autowired
	private FreeBoardMapper freeBoradMapper;
	
	@Override
	public void regist(freeBoardVO vo) {
		freeBoradMapper.regist(vo);
	}

	/*//기본
	 * @Override public ArrayList<freeBoardVO> getList() {
	 * 
	 * return freeBoradMapper.getList(); }
	 */

	@Override
	public freeBoardVO content(int bno) {
		
		return freeBoradMapper.content(bno);
	}

	@Override
	public boolean update(freeBoardVO vo) {
		
		return freeBoradMapper.update(vo);
	}

	@Override
	public boolean delete(freeBoardVO vo) {
		
		return freeBoradMapper.delete(vo);
	}

	@Override
	public ArrayList<freeBoardVO> getList(Criteria cri) {
		
		return freeBoradMapper.getList(cri);
	}

	
	
	
	@Override
	public int getTotal(Criteria cri) {
		
		return freeBoradMapper.getTotal(cri);
		 
	}

	
	
	
	
	
}
