package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstReportDao;
import com.mycompany.myapp.dto.IstReport;

@Component
public class IstReportService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstReportDao istReportDao;
	
	//모든 전산장비 구매 검색 페이지
	public List<IstReport> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istReportDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 구매 검색
	public IstReport searchByIstReportid(String istReportid){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istReportDao.selectByIstReportid(istReportid);
				
	}
	
	//1개 전산장비 구매 삽입
	public int addIstReport(IstReport IstReport){
		int row = istReportDao.insertIstReport(IstReport);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 구매 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstReportid(String istReportid){
		int row = istReportDao.deleteByIstReportid(istReportid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 구매 카운트
	public int countIstReport(){
		return istReportDao.countIstReport();
	}
}
