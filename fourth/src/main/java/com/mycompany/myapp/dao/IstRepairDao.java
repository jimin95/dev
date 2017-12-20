package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstRepair;


@Component
public class IstRepairDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 수리 검색 페이지
	public List<IstRepair> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_repairid, ist_divisid, ist_userid, ist_appliday, ist_symptom, ist_cooper, "
							+ "ist_repastatus, ist_price, ist_totalprice, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_REPAIR "
				+ "where SOFT_DEL = ? order by IST_REPAIRID desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstRepair> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstRepair>(){

			@Override
			public IstRepair mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstRepair istRepair = new IstRepair();
				istRepair.setIst_repairid(rs.getInt("ist_repairid"));
				istRepair.setIst_divisid(rs.getInt("ist_divisid"));
				istRepair.setIst_userid(rs.getString("ist_userid"));
				istRepair.setIst_appliday(rs.getDate("ist_appliday"));
				istRepair.setIst_symptom(rs.getString("ist_symptom"));
				istRepair.setIst_cooper(rs.getString("ist_cooper"));
				istRepair.setIst_repastatus(rs.getInt("ist_repastatus"));
				istRepair.setIst_price(rs.getInt("ist_price"));
				istRepair.setIst_totalprice(rs.getInt("ist_totalprice"));
				istRepair.setIst_remark(rs.getString("ist_remark"));
				istRepair.setSoft_del(rs.getString("soft_del"));
				
				return istRepair;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 수리 검색
	public IstRepair selectByIstRepairid(String istRepairid){
		
		String sql = "select * from IT_INSTRUMENT_REPAIR where IST_REPAIRID = ? AND SOFT_DEL = ? ";

		List<IstRepair> list = jdbcTemplate.query(sql, new Object[]{istRepairid, 0}, new RowMapper<IstRepair>(){

			@Override
			public IstRepair mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstRepair istRepair = new IstRepair();
				istRepair.setIst_repairid(rs.getInt("ist_repairid"));
				istRepair.setIst_divisid(rs.getInt("ist_divisid"));
				istRepair.setIst_userid(rs.getString("ist_userid"));
				istRepair.setIst_appliday(rs.getDate("ist_appliday"));
				istRepair.setIst_symptom(rs.getString("ist_symptom"));
				istRepair.setIst_cooper(rs.getString("ist_cooper"));
				istRepair.setIst_repastatus(rs.getInt("ist_repastatus"));
				istRepair.setIst_price(rs.getInt("ist_price"));
				istRepair.setIst_totalprice(rs.getInt("ist_totalprice"));
				istRepair.setIst_remark(rs.getString("ist_remark"));
				istRepair.setSoft_del(rs.getString("soft_del"));
				
				return istRepair;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 수리 삽입
	public int insertIstRepair(IstRepair istRepair) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_REPAIR(ist_repairid, ist_divisid, ist_userid, ist_appliday, ist_symptom, ist_cooper, "
							+ "ist_repastatus, ist_price, ist_totalprice, ist_remark, soft_del) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istRepair.getIst_repairid(),
				istRepair.getIst_divisid(),
				istRepair.getIst_userid(),
				istRepair.getIst_appliday(),
				istRepair.getIst_symptom(),
				istRepair.getIst_cooper(),
				istRepair.getIst_repastatus(),
				istRepair.getIst_price(),
				istRepair.getIst_totalprice(),
				istRepair.getIst_remark(),
				istRepair.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 수리 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstRepairid(String istRepairid) {
		String sql = "update IT_INSTRUMENT_REPAIR set SOFT_DEL = ? where IST_REPAIRID like ?";
		int row = jdbcTemplate.update(sql, 1, istRepairid);
		return row;
	}
	
	/*//1개 전산장비 수리 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 수리 카운트
	public int countIstRepair() {
		String sql = "select count(*) from IT_INSTRUMENT_REPAIR";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
