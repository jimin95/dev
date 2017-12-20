package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstRental1Dao;
import com.mycompany.myapp.dto.IstRental1;

@Component
public class IstRental1Service {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstRental1Dao istRental1Dao;
	
	//��� ������� Ȱ�� �˻� ������
	public List<IstRental1> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istRental1Dao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� Ȱ�� �˻�
	public IstRental1 searchByIstRental1id(String istRental1id){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istRental1Dao.selectByIstRental1id(istRental1id);
				
	}
	
	//1�� ������� Ȱ�� ����
	public int addIstRental1(IstRental1 IstRental1){
		int row = istRental1Dao.insertIstRental1(IstRental1);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� Ȱ�� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstRental1id(String istRental1id){
		int row = istRental1Dao.deleteByIstRental1id(istRental1id);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� Ȱ�� ī��Ʈ
	public int countIstRental1(){
		return istRental1Dao.countIstRental1();
	}
}
