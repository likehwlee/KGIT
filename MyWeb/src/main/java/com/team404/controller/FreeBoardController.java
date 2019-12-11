package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.freeBoardVO;
import com.team404.freeboard.service.FreeBoardService;
import com.team404.util.Criteria;
import com.team404.util.PageVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired // 자동주입
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value="/registForm")
	public String registForm (freeBoardVO vo,
			Model model, RedirectAttributes RA) {
		freeBoardService.regist(vo);
		model.addAttribute(vo.getTitle());
		model.addAttribute(vo.getWriter());
		model.addAttribute(vo.getContent());
		
		//리다이렉트시에 1회성 소멸데이터로 리다이렉트시 한 번만 사용하고 싶을 때
		RA.addFlashAttribute("msg","게시물이 정상적으로 등록되었습니다.");
		//다시 컨트롤러를 태워서 보냄 redirect
		return "redirect:/freeBoard/freeList";
	}
	
	@RequestMapping(value="/freeList",method=RequestMethod.GET)
	public String freeList(Model model, Criteria cri) {
		//일반
		//ArrayList<freeBoardVO>freelist=freeBoardService.getList();
		
		//기본 페이징
		
		ArrayList<freeBoardVO>freelist = freeBoardService.getList(cri);
		
		int total = freeBoardService.getTotal(cri);													
	
		PageVO pageVO = new PageVO(cri, total);
		
		System.out.println("넘어오는값:"+cri.toString());
		
		model.addAttribute("pageVO",pageVO);  //페이지네이션 정보
		model.addAttribute("freelist",freelist);//게시글 정보
		
		System.out.println(pageVO.toString());
		
		return "freeBoard/freeList";
	}
	
	  @RequestMapping(value="/freeDetail",method=RequestMethod.GET) public String
	  freeDetail(@RequestParam("bno") int bno,Model model) {
	  
	  model.addAttribute("list",freeBoardService.content(bno)); 
	  return
	 "freeBoard/freeDetail"; }
	 


	
	 @RequestMapping(value="/freeModify",method=RequestMethod.POST) public String
	 freeModify(@RequestParam("bno") int bno,Model model) {
	 System.out.println(bno);
	 
	 freeBoardVO vo = freeBoardService.content(bno);
	 model.addAttribute("content",vo);
	 
	 
	  return "freeBoard/freeModify"; }
	 
	@RequestMapping(value="/freeRegist",method=RequestMethod.GET)
	public String freeRegist() {
		
		return "freeBoard/freeRegist";
	}
	/*
	 * @RequestMapping(value= {"/freeDetail","/freeModify"}) public void
	 * view(@RequestParam("bno") int bno,Model model) {
	 * 
	 * freeBoardVO vo = freeBoardService.content(bno);
	 * model.addAttribute("freeList",vo); //요청의 경로로 리졸버 뷰로 전달됩니다. }
	 */
		
	@RequestMapping(value="/freeUpdate")
	public String freeUpdate(freeBoardVO vo,RedirectAttributes RA, Model model) {
		
	
		if(freeBoardService.update(vo)==true) {
			RA.addFlashAttribute("msg","게시물 수정이 정상 처리되었습니다.");
			return"redirect:/freeBoard/freeList";
		}else {
			RA.addFlashAttribute("msg","게시물 수정에 실패했습니다");
			return"redirect:/refreeBoard/freeList";
		}
		
	}
	
	@RequestMapping(value="/freeDelete")
	public String freeDelete(freeBoardVO vo, RedirectAttributes RA) {
		if(freeBoardService.delete(vo)==true) {
		RA.addFlashAttribute("msg","게시물이 삭제되었습니다");
		}else {
			RA.addFlashAttribute("msg","게시물 삭제에 실패했습니다");
		}
		return "redirect:/freeBoard/freeList";
	
	}
	
	

}
