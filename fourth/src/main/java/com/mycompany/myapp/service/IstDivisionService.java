package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstDivisionDao;
import com.mycompany.myapp.dto.IstDivision;

@Component
public class IstDivisionService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstDivisionDao istDivisionDao;
	
	//모든 전산장비 구분 검색 페이지
	public List<IstDivision> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istDivisionDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 구분 검색
	public IstDivision searchByIstDivisid(String istDivisid){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istDivisionDao.selectByIstDivisid(istDivisid);
				
	}
	
	//1개 전산장비 구분 삽입
	public int addIstDivision(IstDivision istDivision){
		int row = istDivisionDao.insertIstDivision(istDivision);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 구분 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstDivision(String istDivisid){
		int row = istDivisionDao.deleteIstDivision(istDivisid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 구분 카운트
	public int countIstDivision(){
		return istDivisionDao.countIstDivision();
	}
}
