package second.user.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import second.user.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return userDAO.selectBoardList(map);
	}
	
	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
	    userDAO.insertBoard(map);
	}

}
