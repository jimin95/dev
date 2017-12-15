package com.mycompany.myapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.service.LoginService;

@Controller
@RequestMapping("/loginForm")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String ist_userid, String ist_password, HttpSession session, Model model){
		logger.info("login_id: "+ist_userid);
		logger.info("login_pw: "+ist_password);
		
		int result = loginService.login(ist_userid, ist_password);
		
		if(result == LoginService.LOGIN_FAIL_ISTPASSWORD){
			logger.info("[패스워드 오류]");
			model.addAttribute("result", "LOGIN_FAIL_ISTPASSWORD");
			return "login/loginForm";
		
		}else if(result == LoginService.LOGIN_FAIL_ISTUSERID){
			logger.info("[아이디 오류]");
			model.addAttribute("result", "LOGIN_FAIL_ISTUSERID");
			return "login/loginForm";
		
		}else{
			session.setAttribute("login", ist_userid);
			logger.info("[로그인 성공]");
			model.addAttribute("result", "LOGIN_SUCCESS");
			return "ist/istList";
		}
	}
	
	
}
