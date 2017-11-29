package second.division.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import second.sample.dao.SampleDAO;

@Service("sampleService")
public class DivisionServiceImpl implements DivisionService{

	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectBoardList(map);
	}
	
	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
	    sampleDAO.insertBoard(map);
	}

}
