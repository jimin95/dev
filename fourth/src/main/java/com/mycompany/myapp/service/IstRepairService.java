package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstRepairDao;
import com.mycompany.myapp.dto.IstRepair;

@Component
public class IstRepairService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstRepairDao istRepairDao;
	
	//모든 전산장비 수리 검색 페이지
	public List<IstRepair> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istRepairDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 수리 검색
	public IstRepair searchByIstRepairid(String istRepairid){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istRepairDao.selectByIstRepairid(istRepairid);
				
	}
	
	//1개 전산장비 수리 삽입
	public int addIstRepair(IstRepair IstRepair){
		int row = istRepairDao.insertIstRepair(IstRepair);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 수리 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstRepairid(String istRepairid){
		int row = istRepairDao.deleteByIstRepairid(istRepairid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 수리 카운트
	public int countIstRepair(){
		return istRepairDao.countIstRepair();
	}
}
