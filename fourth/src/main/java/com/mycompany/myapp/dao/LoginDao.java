package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Login;


@Component
public class LoginDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//로그인 사용자 ID
	public Login selectByIstuserid(String istuserid){
		
		String sql = "select * from IT_INSTRUMENT_LOGIN where IST_USERID = ?";

		List<Login> list = jdbcTemplate.query(sql, new Object[]{istuserid}, new RowMapper<Login>(){

			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				Login login = new Login();
				login.setIst_userid(rs.getString("ist_userid"));
				login.setIst_password(rs.getString("ist_password"));
				login.setIst_email(rs.getString("ist_email"));
				login.setIst_tel(rs.getString("ist_tel"));
				return login;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}
	
	//로그인 사용자 PASSWORD
	public Login selectByIstpassword(String istpassword){
		
		String sql = "select * from IT_INSTRUMENT_LOGIN where IST_PASSWORD = ?";
		
		List<Login> list = jdbcTemplate.query(sql, new Object[]{istpassword}, new RowMapper<Login>(){

			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				Login login = new Login();
				login.setIst_userid(rs.getString("ist_userid"));
				login.setIst_password(rs.getString("ist_password"));
				login.setIst_email(rs.getString("ist_email"));
				login.setIst_tel(rs.getString("ist_email"));
				return login;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}
}
