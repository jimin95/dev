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
	
	//��� ������� �Ҹ�ǰ �˻� ������
	public List<IstSupplies> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istSuppliesDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� �Ҹ�ǰ �˻�
	public IstSupplies searchByIstSupplid(String istSupplid){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istSuppliesDao.selectByIstSupplid(istSupplid);
				
	}
	
	//1�� ������� �Ҹ�ǰ ����
	public int addIstSupplies(IstSupplies IstSupplies){
		int row = istSuppliesDao.insertIstSupplies(IstSupplies);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� �Ҹ�ǰ ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstSupplid(String istSupplid){
		int row = istSuppliesDao.deleteByIstSupplid(istSupplid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� �Ҹ�ǰ ī��Ʈ
	public int countIstSupplies(){
		return istSuppliesDao.countIstSupplies();
	}
}
