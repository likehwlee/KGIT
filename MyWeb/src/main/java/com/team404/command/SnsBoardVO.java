package com.team404.command;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SnsBoardVO {
	
	private int bno;
	private String writer;//글쓴이
	private String uploadpath;//fileloca를 포함한 업로드경로
	private String fileloca;//날짜폴더경로
	private String filename;//변경해서 저장할 이름
	private String filerealname;//원본이름
	private String content;//내용
	private Timestamp regdate;//등록일
	
	
	
}
