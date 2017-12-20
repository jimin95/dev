package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstRental1Dao;
import com.mycompany.myapp.dto.IstRental1;

@Component
public class IstRental1Service {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstRental1Dao istRental1Dao;
	
	//모든 전산장비 활용 검색 페이지
	public List<IstRental1> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istRental1Dao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 활용 검색
	public IstRental1 searchByIstRental1id(String istRental1id){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istRental1Dao.selectByIstRental1id(istRental1id);
				
	}
	
	//1개 전산장비 활용 삽입
	public int addIstRental1(IstRental1 IstRental1){
		int row = istRental1Dao.insertIstRental1(IstRental1);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 활용 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstRental1id(String istRental1id){
		int row = istRental1Dao.deleteByIstRental1id(istRental1id);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 활용 카운트
	public int countIstRental1(){
		return istRental1Dao.countIstRental1();
	}
}
