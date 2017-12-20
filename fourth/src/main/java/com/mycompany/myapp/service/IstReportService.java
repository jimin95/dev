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
	
	//��� ������� ���� �˻� ������
	public List<IstReport> searchAll(int pageNo, int rowsPerPage){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istReportDao.selectAll(pageNo, rowsPerPage);
		
	}
	
	//1�� ������� ���� �˻�
	public IstReport searchByIstReportid(String istReportid){
		
		//�ٸ� dao��� join�ؾ� ��(���� �ӽ�)
		return istReportDao.selectByIstReportid(istReportid);
				
	}
	
	//1�� ������� ���� ����
	public int addIstReport(IstReport IstReport){
		int row = istReportDao.insertIstReport(IstReport);
		if(row == 1) return ADD_SUCCESS;
		else return ADD_FAIL;
	}
	
	//1�� ������� ���� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int removeByIstReportid(String istReportid){
		int row = istReportDao.deleteByIstReportid(istReportid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//������� ���� ī��Ʈ
	public int countIstReport(){
		return istReportDao.countIstReport();
	}
}
