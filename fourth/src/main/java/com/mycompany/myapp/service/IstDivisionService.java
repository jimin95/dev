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
	
	//��� ������� ���� �˻� ������
	public List<IstDivision> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istDivisionDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� ���� �˻�
	public IstDivision searchByIstDivisid(String istDivisid){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istDivisionDao.selectByIstDivisid(istDivisid);
				
	}
	
	//1�� ������� ���� ����
	public int addIstDivision(IstDivision istDivision){
		int row = istDivisionDao.insertIstDivision(istDivision);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� ���� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstDivision(String istDivisid){
		int row = istDivisionDao.deleteIstDivision(istDivisid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� ���� ī��Ʈ
	public int countIstDivision(){
		return istDivisionDao.countIstDivision();
	}
}
