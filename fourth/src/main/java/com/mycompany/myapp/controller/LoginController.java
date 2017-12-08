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
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(String login_id, String login_pw, HttpSession session, Model model){
		logger.info("login_id: "+login_id);
		logger.info("login_pw: "+login_pw);
		
		int result = loginService.login(login_id, login_pw);
		
		if(result == LoginService.LOGIN_FAIL_ISTPASSWORD){
			model.addAttribute("result", "LOGIN_FAIL_ISTPASSWORD");
			logger.info("[패스워드 오류]");
			return "user/loginResult";
		
		}else if(result == LoginService.LOGIN_FAIL_ISTUSERID){
			model.addAttribute("result", "LOGIN_FAIL_ISTUSERID");
			logger.info("[아이디 오류]");
			return "user/loginResult";
		
		}else{
			model.addAttribute("result", "LOGIN_SUCCESS");
			session.setAttribute("login", login_id);
			logger.info("[로그인 성공]");
			return "user/loginResult";
		}
	}
	
	
}
