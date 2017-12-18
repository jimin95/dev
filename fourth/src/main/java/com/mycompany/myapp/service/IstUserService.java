package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstUserDao;
import com.mycompany.myapp.dto.IstUser;

@Component
public class IstUserService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstUserDao istUserDao;
	
	//��� ���� ������� �˻� ������
	public List<IstUser> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istUserDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ���� ������� �˻�
	public IstUser searchByIstUserid(String istuserid){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istUserDao.selectByIstUserid(istuserid);
				
	}
	
	//1�� ���� ������� ����
	public int addIstUser(IstUser istUser){
		int row = istUserDao.insertIstUser(istUser);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ���� ������� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstUser(String istuserid){
		int row = istUserDao.deleteIstUser(istuserid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//���� ������� ī��Ʈ
	public int countIstUser(){
		return istUserDao.countIstUser();
	}
}
