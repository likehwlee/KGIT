package com.team404.freereply.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.ReplyVO;
import com.team404.freereply.mapper.FreeReplyMapper;
import com.team404.util.Criteria;
import com.team404.util.ReplyPageVO;

@Service("freeReplyService")
public class FreeReplyServiceImpl implements FreeReplyService{

	@Autowired
	private FreeReplyMapper freeReplyMapper;
	@Override
	public int regist(ReplyVO vo) {
		
		return freeReplyMapper.regist(vo);
	}
	/* 목록처리
	 * @Override public ArrayList<ReplyVO> getList(int bno) {
	 * 
	 * return freeReplyMapper.getList(bno); }
	 */
	
	@Override
	public int pwCheck(ReplyVO vo) {
		
		
		
		return freeReplyMapper.pwCheck(vo);
	}

	@Override
	public int delete(ReplyVO vo) {
		
		return freeReplyMapper.delete(vo);
	}
	@Override
	public int update(ReplyVO vo) {
		
		return freeReplyMapper.update(vo);
	}
	
	@Override
	public ReplyPageVO getList(Criteria cri, int bno) {
		
		//1. 페이징된 List를 구해옴
		//2. 전체게시글 수를 구함(각각 다른 2개의 데이터를 마이바티스 전송할때 @Param어노테이션을 사용
		//3. list와 replyCount를 VO에 저장
		ArrayList<ReplyVO> list = freeReplyMapper.getList(cri, bno);
		int replyCount = freeReplyMapper.getTotal(bno);
		ReplyPageVO vo = new ReplyPageVO(list,replyCount);
		
		return vo;
	}

	
	
}
