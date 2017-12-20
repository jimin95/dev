package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstInventory;


@Component
public class IstInventoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 재고 검색 페이지
	public List<IstInventory> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_number, ist_userid, ist_divisid, ist_pday, ist_sday, ist_quantity, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_INVENTORY "
				+ "where SOFT_DEL = ? order by IST_NUMBER desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstInventory> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstInventory>(){

			@Override
			public IstInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstInventory IstInventory = new IstInventory();
				IstInventory.setIst_divisid(rs.getInt("ist_number"));
				IstInventory.setIst_userid(rs.getString("ist_userid"));
				IstInventory.setIst_divisid(rs.getInt("ist_divisid"));
				IstInventory.setIst_pday(rs.getDate("ist_pday"));
				IstInventory.setIst_sday(rs.getDate("ist_sday"));
				IstInventory.setIst_quantity(rs.getInt("ist_quantity"));
				IstInventory.setIst_remark(rs.getString("ist_remark"));
				IstInventory.setSoft_del(rs.getString("soft_del"));
				
				return IstInventory;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 재고 검색
	public IstInventory selectByIstNumber(String istNumber){
		
		String sql = "select * from IT_INSTRUMENT_INVENTORY where IST_NUMBER = ? AND SOFT_DEL = ? ";

		List<IstInventory> list = jdbcTemplate.query(sql, new Object[]{istNumber, 0}, new RowMapper<IstInventory>(){

			@Override
			public IstInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstInventory IstInventory = new IstInventory();
				IstInventory.setIst_divisid(rs.getInt("ist_number"));
				IstInventory.setIst_userid(rs.getString("ist_userid"));
				IstInventory.setIst_divisid(rs.getInt("ist_divisid"));
				IstInventory.setIst_pday(rs.getDate("ist_pday"));
				IstInventory.setIst_sday(rs.getDate("ist_sday"));
				IstInventory.setIst_quantity(rs.getInt("ist_quantity"));
				IstInventory.setIst_remark(rs.getString("ist_remark"));
				IstInventory.setSoft_del(rs.getString("soft_del"));
				
				return IstInventory;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 재고 삽입
	public int insertIstInventory(IstInventory istInventory) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_INVENTORY(ist_number, ist_userid, ist_divisid, ist_pday, ist_sday, ist_quantity, ist_remark, soft_del) "
				+ "values(?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istInventory.getIst_number(),
				istInventory.getIst_userid(),
				istInventory.getIst_divisid(),
				istInventory.getIst_pday(),
				istInventory.getIst_sday(),
				istInventory.getIst_quantity(),
				istInventory.getIst_remark(),
				istInventory.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 재고 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstNumber(String istNumber) {
		String sql = "update IT_INSTRUMENT_INVENTORY set SOFT_DEL = ? where IST_NUMBER like ?";
		int row = jdbcTemplate.update(sql, 1, istNumber);
		return row;
	}
	
	/*//1개 전산장비 재고 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 재고 카운트
	public int countIstInventory() {
		String sql = "select count(*) from IT_INSTRUMENT_INVENTORY";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
