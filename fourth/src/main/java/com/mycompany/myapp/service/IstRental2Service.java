package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstRental2Dao;
import com.mycompany.myapp.dto.IstRental2;

@Component
public class IstRental2Service {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstRental2Dao istRental2Dao;
	
	//모든 전산장비 대여 검색 페이지
	public List<IstRental2> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istRental2Dao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 대여 검색
	public IstRental2 searchByIstRental2id(String istRental2id){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istRental2Dao.selectByIstRental2id(istRental2id);
				
	}
	
	//1개 전산장비 대여 삽입
	public int addIstRental2(IstRental2 IstRental2){
		int row = istRental2Dao.insertIstRental2(IstRental2);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 대여 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstRental2id(String istRental2id){
		int row = istRental2Dao.deleteByIstRental2id(istRental2id);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 대여 카운트
	public int countIstRental2(){
		return istRental2Dao.countIstRental2();
	}
}
