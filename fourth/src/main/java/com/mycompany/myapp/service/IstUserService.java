package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstUserDao;
import com.mycompany.myapp.dto.IstUser;

@Component
public class IstUserService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstUserDao istUserDao;
	
	//모든 유저 전산장비 검색 페이지
	public List<IstUser> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istUserDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 유저 전산장비 검색
	public IstUser searchByIstUserid(String istuserid){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istUserDao.selectByIstUserid(istuserid);
				
	}
	
	//1개 유저 전산장비 삽입
	public int addIstUser(IstUser istUser){
		int row = istUserDao.insertIstUser(istUser);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 유저 전산장비 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstUser(String istuserid){
		int row = istUserDao.deleteIstUser(istuserid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//유저 전산장비 카운트
	public int countIstUser(){
		return istUserDao.countIstUser();
	}
}
