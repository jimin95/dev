package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.IstPurchaseDao;
import com.mycompany.myapp.dto.IstPurchase;

@Component
public class IstPurchaseService {
	
	public static final int ADD_SUCCESS = 1;
	public static final int ADD_FAIL = 0;
	
	public static final int REMOVE_SUCCESS = 1;
	public static final int REMOVE_FAIL = 0;
	
	
	@Autowired
	private IstPurchaseDao istPurchaseDao;
	
	//��� ������� ���� �˻� ������
	public List<IstPurchase> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istPurchaseDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� ���� �˻�
	public IstPurchase searchByIstPurchid(String istPurchid){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istPurchaseDao.selectByIstPurchid(istPurchid);
				
	}
	
	//1�� ������� ���� ����
	public int addIstPurchase(IstPurchase IstPurchase){
		int row = istPurchaseDao.insertIstPurchase(IstPurchase);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� ���� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstPurchid(String istPurchid){
		int row = istPurchaseDao.deleteByIstPurchid(istPurchid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� ���� ī��Ʈ
	public int countIstPurchase(){
		return istPurchaseDao.countIstPurchase();
	}
}
