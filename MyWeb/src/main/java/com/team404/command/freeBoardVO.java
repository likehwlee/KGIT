package com.team404.command;

import java.sql.Timestamp;

import lombok.Data;
//롬복 라이브러리 추가시 @Data 어노테이션 getter,setter, toString을  자동생성
//@AllArgsConstructor 어노테이션은 모든 변수를 초기화 하는 생성자
//@NoArgsConstructor 어노테이션은 기본생성자


@Data
public class freeBoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private Timestamp updatedate;

}
