package com.team404.command;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {

	private int bno;
	private int rno;
	
	private String reply;
	private String replyId;
	private String replyPw;
	private Timestamp replyDate;
	private Timestamp updateDate;	
	
	
	
	
	
}
