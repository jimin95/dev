package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstSupplies;


@Component
public class IstSuppliesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 소모품 검색 페이지
	public List<IstSupplies> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_supplid, ist_divisid, ist_userid, ist_appliday, ist_supply, ist_quantity, ist_suppstatus, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_SUPPLIES "
				+ "where SOFT_DEL = ? order by IST_SUPPLID desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstSupplies> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstSupplies>(){

			@Override
			public IstSupplies mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstSupplies istSupplies = new IstSupplies();
				istSupplies.setIst_supplid(rs.getInt("ist_supplid"));
				istSupplies.setIst_divisid(rs.getInt("ist_divisid"));
				istSupplies.setIst_userid(rs.getString("ist_userid"));
				istSupplies.setIst_appliday(rs.getDate("ist_appliday"));
				istSupplies.setIst_supply(rs.getString("ist_supply"));
				istSupplies.setIst_quantity(rs.getInt("ist_quantity"));
				istSupplies.setIst_suppstatus(rs.getInt("ist_suppstatus"));
				istSupplies.setIst_remark(rs.getString("ist_remark"));
				istSupplies.setSoft_del(rs.getString("soft_del"));
				
				return istSupplies;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 소모품 검색
	public IstSupplies selectByIstSupplid(String istSupplid){
		
		String sql = "select * from IT_INSTRUMENT_SUPPLIES where IST_SUPPLID = ? AND SOFT_DEL = ? ";

		List<IstSupplies> list = jdbcTemplate.query(sql, new Object[]{istSupplid, 0}, new RowMapper<IstSupplies>(){

			@Override
			public IstSupplies mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstSupplies istSupplies = new IstSupplies();
				istSupplies.setIst_supplid(rs.getInt("ist_supplid"));
				istSupplies.setIst_divisid(rs.getInt("ist_divisid"));
				istSupplies.setIst_userid(rs.getString("ist_userid"));
				istSupplies.setIst_appliday(rs.getDate("ist_appliday"));
				istSupplies.setIst_supply(rs.getString("ist_supply"));
				istSupplies.setIst_quantity(rs.getInt("ist_quantity"));
				istSupplies.setIst_suppstatus(rs.getInt("ist_suppstatus"));
				istSupplies.setIst_remark(rs.getString("ist_remark"));
				istSupplies.setSoft_del(rs.getString("soft_del"));
				
				return istSupplies;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 소모품 삽입
	public int insertIstSupplies(IstSupplies istSupplies) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_SUPPLIES(ist_supplid, ist_divisid, ist_userid, ist_appliday, ist_supply, ist_quantity, ist_suppstatus, ist_remark, soft_del) "
				+ "values(?,?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istSupplies.getIst_supplid(),
				istSupplies.getIst_divisid(),
				istSupplies.getIst_userid(),
				istSupplies.getIst_appliday(),
				istSupplies.getIst_supply(),
				istSupplies.getIst_quantity(),
				istSupplies.getIst_suppstatus(),
				istSupplies.getIst_remark(),
				istSupplies.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 소모품 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstSupplid(String istSupplid) {
		String sql = "update IT_INSTRUMENT_SUPPLIES set SOFT_DEL = ? where IST_SUPPLID like ?";
		int row = jdbcTemplate.update(sql, 1, istSupplid);
		return row;
	}
	
	/*//1개 전산장비 소모품 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 소모품 카운트
	public int countIstSupplies() {
		String sql = "select count(*) from IT_INSTRUMENT_SUPPLIES";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
