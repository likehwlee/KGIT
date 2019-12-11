package com.team404.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {

	@RequestMapping("/snsList")
	public String snsList() {
				
		return "snsBoard/snsList";
	}


	@RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,
    					 @RequestParam("content") String content) {
		
		System.out.println(file);
		System.out.println(content);
	//1.날짜별로 20191211형식으로 upload아래에 폴더를 생성
	//2.uploadPath는 날짜폴더를 포함한 경로
	//3.fileRealName은 변경하기 전 파일이름
	//4.fileName은 변경해서 저장할 파일
    //5.fileLoca 20191211형식으로 만들어진 폴더이름
    //6.transferTo()메서드를 이요해서 전송되온 파일을 해당날짜에 업로드
	//7.DB에 insert메서드를 통해서 값들을 저장
	//8.성공시에 화면에 success반환, 실패시 fail반환	
		
	//파일명변경 ex) 
	UUID uuid = UUID.randomUUID();
	String uuids = uuid.toString().replaceAll("-", "");
	System.out.println(uuids);
	
		return null;
	}
	
	@RequestMapping("/view")
	   @ResponseBody
	   public byte[] view(@RequestParam("fileLoca") String fileLoca,
	                  @RequestParam("fileName") String fileName
	         ) {
	      
	      File file = new File("C:\\dev\\leehongwoo_spring\\upload\\" + fileLoca + "\\" + fileName);
	      
	      byte[] result = null;
	      try {
	         // 스프링의 파일데이터를 읽어서 바이트배열형으로 리턴하는 메서드(매개값으로 file타입을 받음)
	         result = FileCopyUtils.copyToByteArray(file);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return result;
	   }
	
	

}

