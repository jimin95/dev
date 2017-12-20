package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstRental1;


@Component
public class IstRental1Dao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 활용 검색 페이지
	public List<IstRental1> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_rental1id, ist_divisid, ist_userid, ist_appliday, ist_usage, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_RENTAL1 "
				+ "where SOFT_DEL = ? order by IST_RENTAL1ID desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstRental1> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstRental1>(){

			@Override
			public IstRental1 mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstRental1 istRental1 = new IstRental1();
				istRental1.setIst_rental1id(rs.getInt("ist_rental1id"));
				istRental1.setIst_divisid(rs.getInt("ist_divisid"));
				istRental1.setIst_userid(rs.getString("ist_userid"));
				istRental1.setIst_appliday(rs.getDate("ist_appliday"));
				istRental1.setIst_usage(rs.getString("ist_usage"));
				istRental1.setIst_remark(rs.getString("ist_remark"));
				istRental1.setSoft_del(rs.getString("soft_del"));
				
				return istRental1;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 활용 검색
	public IstRental1 selectByIstRental1id(String istRental1id){
		
		String sql = "select * from IT_INSTRUMENT_RENTAL1 where IST_RENTAL1ID = ? AND SOFT_DEL = ? ";

		List<IstRental1> list = jdbcTemplate.query(sql, new Object[]{istRental1id, 0}, new RowMapper<IstRental1>(){

			@Override
			public IstRental1 mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstRental1 istRental1 = new IstRental1();
				istRental1.setIst_rental1id(rs.getInt("ist_rental1id"));
				istRental1.setIst_divisid(rs.getInt("ist_divisid"));
				istRental1.setIst_userid(rs.getString("ist_userid"));
				istRental1.setIst_appliday(rs.getDate("ist_appliday"));
				istRental1.setIst_usage(rs.getString("ist_usage"));
				istRental1.setIst_remark(rs.getString("ist_remark"));
				istRental1.setSoft_del(rs.getString("soft_del"));
				
				return istRental1;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 활용 삽입
	public int insertIstRental1(IstRental1 istRental1) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_RENTAL1(ist_rental1id, ist_divisid, ist_userid, ist_appliday, ist_usage, ist_remark, soft_del) "
				+ "values(?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istRental1.getIst_rental1id(),
				istRental1.getIst_divisid(),
				istRental1.getIst_userid(),
				istRental1.getIst_appliday(),
				istRental1.getIst_usage(),
				istRental1.getIst_remark(),
				istRental1.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 수리 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstRental1id(String istRental1id) {
		String sql = "update IT_INSTRUMENT_RENTAL1 set SOFT_DEL = ? where IST_RENTAL1ID like ?";
		int row = jdbcTemplate.update(sql, 1, istRental1id);
		return row;
	}
	
	/*//1개 전산장비 활용 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 활용 카운트
	public int countIstRental1() {
		String sql = "select count(*) from IT_INSTRUMENT_RENTAL1";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
