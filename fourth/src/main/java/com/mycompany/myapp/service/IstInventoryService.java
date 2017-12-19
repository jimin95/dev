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
	
	//��� ������� ��� �˻� ������
	public List<IstInventory> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istInventoryDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� ��� �˻�
	public IstInventory searchByIstNumber(String istNumber){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istInventoryDao.selectByIstNumber(istNumber);
				
	}
	
	//1�� ������� ��� ����
	public int addIstInventory(IstInventory IstInventory){
		int row = istInventoryDao.insertIstInventory(IstInventory);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� ��� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstNumber(String istNumber){
		int row = istInventoryDao.deleteIstNumber(istNumber);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� ��� ī��Ʈ
	public int countIstInventory(){
		return istInventoryDao.countIstInventory();
	}
}
