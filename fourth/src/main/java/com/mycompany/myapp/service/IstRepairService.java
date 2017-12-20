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
	
	//��� ������� ���� �˻� ������
	public List<IstRepair> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istRepairDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� ���� �˻�
	public IstRepair searchByIstRepairid(String istRepairid){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istRepairDao.selectByIstRepairid(istRepairid);
				
	}
	
	//1�� ������� ���� ����
	public int addIstRepair(IstRepair IstRepair){
		int row = istRepairDao.insertIstRepair(IstRepair);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� ���� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstRepairid(String istRepairid){
		int row = istRepairDao.deleteByIstRepairid(istRepairid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� ���� ī��Ʈ
	public int countIstRepair(){
		return istRepairDao.countIstRepair();
	}
}
