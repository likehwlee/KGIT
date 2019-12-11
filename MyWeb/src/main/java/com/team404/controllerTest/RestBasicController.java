package com.team404.controllerTest;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.TestVO;

@RestController
@RequestMapping("/restControl")
public class RestBasicController {

	
		//1. RestController는 기본적으로 return에 실린값이 리졸버뷰로 가는것이 아니라 요청된 주소(화면)으로 반환됩니다.
		
	@RequestMapping(value = "/getText", produces = "text/html; charset=utf-8")
	public String getText() {
		
		return "안뇽~";
	}
	
	//나는 객체로 반환보낼게(단, 잭슨-데이터바인딩 라이브러리가 필요)
	@RequestMapping(value ="/getObject")
	public TestVO getObject() {
		
		TestVO vo = new TestVO(20,"홍길순","kkk123");
		
		return vo;
	}
	//나 num을 받고, 컬렉션보낼게
	@RequestMapping(value="/getCollection")
	public ArrayList<TestVO> getCollection(@RequestParam("num") int num){
		
		ArrayList<TestVO> list = new ArrayList<>();
		for(int i =0 ; i <= num; i++) {
			
			TestVO vo = new TestVO(i,"길자"+i,"kkk"+i);
			
			list.add(vo);
		
		}
		
		
		return list;
	}
	//String으로 값을 2개 받고, Map형태로 반환할게
	@RequestMapping("/getPath/{id}/{pw}")
	public HashMap<String, TestVO> getPath(@PathVariable("id") String id, @PathVariable("pw") String pw ) {
		
		System.out.println(id);
		System.out.println(pw);
		HashMap<String,TestVO> map = new HashMap<>();
		map.put("info", new TestVO(10,"홍길순","hh"));
		
		return map;
	}

	//@RequestBody json객체를 자바 vo에 자동맵핑합니다.
	//구글 rest client 설치
	@RequestMapping("/getJson")
	public ArrayList<TestVO> getJson(@RequestBody TestVO vo,HttpServletRequest request ) {
		
		ArrayList<TestVO> list = new ArrayList<>();
		list.add(new TestVO(20,"심사임당","kkk123"));
		System.out.println("요청주소:"+request.getRemoteAddr());
		return list;
	}
	
	
	//http://localhost:8181/myweb/restControl/getMember/1/1
	
	@RequestMapping(value="/getMember/{var1}/{var2}")
	public TestVO getMember(@PathVariable("var1") String var1,
							@PathVariable("var2") String var2  ){
		
		if(var1.equals(var2)) {
			TestVO vo = new TestVO(40,"황인호","황인호");
			
			return vo;
		
		}else {
			
			return null;
	
		}
		
	}
	
	
	
	
	
	
	
	
	
}
