package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.LoginDao;
import com.mycompany.myapp.dto.Login;

@Component
public class IstUserService {
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_ISTUSERID = 1;
	public static final int LOGIN_FAIL_ISTPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL = 1;
	
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	@Autowired
	private LoginDao loginDao;
	
	public int login(String istuserid, String istpassword){
		
		Login login = loginDao.selectByIstuserid(istuserid);
		if(login == null){
			return LOGIN_FAIL_ISTUSERID;
		}else if(login.getIst_password().equals(istpassword) == false){
			return LOGIN_FAIL_ISTPASSWORD;
		}else{
			return LOGIN_SUCCESS;
		}
		
	}
}
