package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstDivision;


@Component
public class IstDivisionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 구분 검색 페이지
	public List<IstDivision> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_divisid, ist_category, ist_model, ist_name, ist_serial, ist_mac, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_DIVISION "
				+ "where SOFT_DEL = ? order by ist_divisid desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstDivision> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstDivision>(){

			@Override
			public IstDivision mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstDivision istDivision = new IstDivision();
				istDivision.setIst_divisid(rs.getInt("ist_divisid"));
				istDivision.setIst_category(rs.getInt("ist_category"));
				istDivision.setIst_model(rs.getInt("ist_model"));
				istDivision.setIst_name(rs.getString("ist_name"));
				istDivision.setIst_serial(rs.getString("ist_serial"));
				istDivision.setIst_mac(rs.getString("ist_mac"));
				istDivision.setIst_remark(rs.getString("ist_remark"));
				istDivision.setSoft_del(rs.getString("soft_del"));
				
				return istDivision;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 구분 검색
	public IstDivision selectByIstDivisid(String istdivisid){
		
		String sql = "select * from IT_INSTRUMENT_DIVISION where IST_DIVISID = ? AND SOFT_DEL = ? ";

		List<IstDivision> list = jdbcTemplate.query(sql, new Object[]{istdivisid, 0}, new RowMapper<IstDivision>(){

			@Override
			public IstDivision mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstDivision istDivision = new IstDivision();
				istDivision.setIst_divisid(rs.getInt("ist_divisid"));
				istDivision.setIst_category(rs.getInt("ist_category"));
				istDivision.setIst_model(rs.getInt("ist_model"));
				istDivision.setIst_name(rs.getString("ist_name"));
				istDivision.setIst_serial(rs.getString("ist_serial"));
				istDivision.setIst_mac(rs.getString("ist_mac"));
				istDivision.setIst_remark(rs.getString("ist_remark"));
				istDivision.setSoft_del(rs.getString("soft_del"));
				
				return istDivision;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 구분 삽입
	public int insertIstDivision(IstDivision istDivision) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_DIVISION(ist_divisid, ist_category, ist_model, ist_name, ist_serial, ist_mac, ist_remark, soft_del ) "
				+ "values(?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istDivision.getIst_divisid(),
				istDivision.getIst_category(),
				istDivision.getIst_model(),
				istDivision.getIst_name(),
				istDivision.getIst_serial(),
				istDivision.getIst_mac(),
				istDivision.getIst_remark(),
				istDivision.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 구분 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteIstDivision(String istdivisid) {
		String sql = "update IT_INSTRUMENT_DIVISION set SOFT_DEL = ? where IST_DIVISID like ?";
		int row = jdbcTemplate.update(sql, 1, istdivisid);
		return row;
	}
	
	/*//1개 전산장비 구분 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 구분 카운트
	public int countIstDivision() {
		String sql = "select count(*) from IT_INSTRUMENT_DIVISION";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
