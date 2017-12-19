package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstInventoryDao;
import com.mycompany.myapp.dto.IstInventory;

@Component
public class IstInventoryService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstInventoryDao istInventoryDao;
	
	//모든 전산장비 재고 검색 페이지
	public List<IstInventory> searchAll(int pageNo, int rowsPerPage){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istInventoryDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1개 전산장비 재고 검색
	public IstInventory searchByIstNumber(String istNumber){
		
		//다른 dao들과 join해야 함(밑은 임시)
		return istInventoryDao.selectByIstNumber(istNumber);
				
	}
	
	//1개 전산장비 재고 삽입
	public int addIstInventory(IstInventory IstInventory){
		int row = istInventoryDao.insertIstInventory(IstInventory);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1개 전산장비 재고 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int removeByIstNumber(String istNumber){
		int row = istInventoryDao.deleteIstNumber(istNumber);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//전산장비 재고 카운트
	public int countIstInventory(){
		return istInventoryDao.countIstInventory();
	}
}
