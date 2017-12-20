package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstSuppliesDao;
import com.mycompany.myapp.dto.IstSupplies;

@Component
public class IstSuppliesService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstSuppliesDao istSuppliesDao;
	
	//모든 전산장비 소모품 검색 페이지
	public List<IstSupplies> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istSuppliesDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 소모품 검색
	public IstSupplies searchByIstSupplid(String istSupplid){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istSuppliesDao.selectByIstSupplid(istSupplid);
				
	}
	
	//1개 전산장비 소모품 삽입
	public int addIstSupplies(IstSupplies IstSupplies){
		int row = istSuppliesDao.insertIstSupplies(IstSupplies);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 소모품 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstSupplid(String istSupplid){
		int row = istSuppliesDao.deleteByIstSupplid(istSupplid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 소모품 카운트
	public int countIstSupplies(){
		return istSuppliesDao.countIstSupplies();
	}
}
