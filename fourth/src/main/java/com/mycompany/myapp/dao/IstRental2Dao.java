package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstRental2;


@Component
public class IstRental2Dao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 대여 검색 페이지
	public List<IstRental2> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_rental2id, ist_divisid, ist_userid, ist_appliday, ist_project, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_RENTAL2 "
				+ "where SOFT_DEL = ? order by IST_RENTAL2ID desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstRental2> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstRental2>(){

			@Override
			public IstRental2 mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstRental2 istRental2 = new IstRental2();
				istRental2.setIst_rental2id(rs.getInt("ist_rental2id"));
				istRental2.setIst_divisid(rs.getInt("ist_divisid"));
				istRental2.setIst_userid(rs.getString("ist_userid"));
				istRental2.setIst_appliday(rs.getDate("ist_appliday"));
				istRental2.setIst_project(rs.getString("ist_project"));
				istRental2.setIst_remark(rs.getString("ist_remark"));
				istRental2.setSoft_del(rs.getString("soft_del"));
				
				return istRental2;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 대여 검색
	public IstRental2 selectByIstRental2id(String istRental2id){
		
		String sql = "select * from IT_INSTRUMENT_RENTAL2 where IST_RENTAL2ID = ? AND SOFT_DEL = ? ";

		List<IstRental2> list = jdbcTemplate.query(sql, new Object[]{istRental2id, 0}, new RowMapper<IstRental2>(){

			@Override
			public IstRental2 mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstRental2 istRental2 = new IstRental2();
				istRental2.setIst_rental2id(rs.getInt("ist_rental2id"));
				istRental2.setIst_divisid(rs.getInt("ist_divisid"));
				istRental2.setIst_userid(rs.getString("ist_userid"));
				istRental2.setIst_appliday(rs.getDate("ist_appliday"));
				istRental2.setIst_project(rs.getString("ist_project"));
				istRental2.setIst_remark(rs.getString("ist_remark"));
				istRental2.setSoft_del(rs.getString("soft_del"));
				
				return istRental2;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 대여 삽입
	public int insertIstRental2(IstRental2 istRental2) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_RENTAL2(ist_rental2id, ist_divisid, ist_userid, ist_appliday, ist_project, ist_remark, soft_del) "
				+ "values(?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istRental2.getIst_rental2id(),
				istRental2.getIst_divisid(),
				istRental2.getIst_userid(),
				istRental2.getIst_appliday(),
				istRental2.getIst_project(),
				istRental2.getIst_remark(),
				istRental2.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 대여 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstRental2id(String istRental2id) {
		String sql = "update IT_INSTRUMENT_RENTAL2 set SOFT_DEL = ? where IST_RENTAL2ID like ?";
		int row = jdbcTemplate.update(sql, 1, istRental2id);
		return row;
	}
	
	/*//1개 전산장비 활용 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 대여 카운트
	public int countIstRental2() {
		String sql = "select count(*) from IT_INSTRUMENT_RENTAL2";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
