package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.IstUser;
import com.mycompany.myapp.service.IstUserService;
import com.mycompany.myapp.service.LoginService;

@Controller
@RequestMapping("/ist")
public class IstController {
	private static final Logger logger = LoggerFactory.getLogger(IstController.class);
	
	@Autowired
	IstUserService istUserService;
	
	//모든 유저 전산장비 검색 페이지
	@RequestMapping(value="/istUserList", method=RequestMethod.GET)
	public String istUserList(String pageNo, Model model, HttpSession session){
		if((String)session.getAttribute("login") != null){
			
			logger.info("[모든 유저 전산장비 검색 페이지]");
			
			int intPageNo = 1;
			if(pageNo == null){
				pageNo = (String)session.getAttribute("pageNo");
				if(pageNo != null){
					intPageNo = Integer.parseInt(pageNo);
				}
			}else{
				intPageNo = Integer.parseInt(pageNo);
			}
			session.setAttribute("pageNo", String.valueOf(intPageNo));
			
			int rowsPerPage = 5;
			int pagesPerGroup = 5;
			int totalBoardNo = istUserService.countIstUser();
			
			int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0);
			int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup!=0)?1:0);
			int groupNo = (intPageNo-1)/pagesPerGroup+1;
			int startPageNo = (groupNo-1)*pagesPerGroup+1;
			int endPageNo = startPageNo + pagesPerGroup-1;
			if(groupNo == totalGroupNo){
				endPageNo = totalPageNo;
			}
			
			List<IstUser> list = istUserService.searchAll(intPageNo, rowsPerPage);
			model.addAttribute("pageNo",intPageNo);
			model.addAttribute("rowsPerPage",rowsPerPage);
			model.addAttribute("pagesPerGroup",pagesPerGroup);
			model.addAttribute("totalBoardNo",totalBoardNo);
			model.addAttribute("totalPageNo",totalPageNo);
			model.addAttribute("totalGroupNo",totalGroupNo);
			model.addAttribute("groupNo",groupNo);
			model.addAttribute("startPageNo",startPageNo);
			model.addAttribute("endPageNo",endPageNo);
			model.addAttribute("list", list);
			
			return "ist/istList";
		}else{
			return "login/loginForm";
		}
	}
	
	//1개 유저 전산장비 검색
	@RequestMapping(value="/istUserDetail", method=RequestMethod.GET)
	public String istUserDetail(String istuserid, Model model, HttpSession session){
		logger.info("[1개 유저 전산장비]");
		
		IstUser istUser = istUserService.searchByIstUserid(istuserid);
		model.addAttribute("istUserDetail", istUser);
		
		return "ist/istUserDetail";
		
	}
	
	//1개 유저 전산장비 삽입
	@RequestMapping(value="/istUserAdd", method=RequestMethod.POST)
	public String istUserAdd(IstUser istUser, Model model, HttpSession session){
		logger.info("[1개 유저 전산장비 삽입]");
		
		if(istUserService.addIstUser(istUser) == 1){
			model.addAttribute("Result", "1");
		}else{
			model.addAttribute("Result", "0");
		}
		
		return "ist/istUserResult";
	}
	
	//1개 유저 전산장비 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	@RequestMapping(value="/istUserAdd", method=RequestMethod.GET)
	public String istUserDelete(String istuserid,  Model model, HttpSession session){
		if(istUserService.removeByIstUser(istuserid) == 1){
			model.addAttribute("Result", "1");
		}else{
			model.addAttribute("Result", "0");
		}
		
		return "ist/istUserResult";
	}
	
	
}
