package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstPurchase;


@Component
public class IstPurchaseDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 구매 검색 페이지
	public List<IstPurchase> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_purchid, ist_divisid, ist_userid, ist_offer, ist_ofday, ist_usage, ist_oderday, ist_wareday, ist_sendday, "
							+ "ist_purstatus, ist_quantity, ist_unitprice, ist_divisprice, ist_totalprice, soft_del "
				+ "from IT_INSTRUMENT_PURCHASE "
				+ "where SOFT_DEL = ? order by IST_PURCHID desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstPurchase> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstPurchase>(){

			@Override
			public IstPurchase mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstPurchase istPurchase = new IstPurchase();
				istPurchase.setIst_purchid(rs.getInt("ist_purchid"));
				istPurchase.setIst_divisid(rs.getInt("ist_divisid"));
				istPurchase.setIst_userid(rs.getString("ist_userid"));
				istPurchase.setIst_offer(rs.getString("ist_offer"));
				istPurchase.setIst_ofday(rs.getDate("ist_ofday"));
				istPurchase.setIst_usage(rs.getString("ist_usage"));
				istPurchase.setIst_oderday(rs.getDate("ist_oderday"));
				istPurchase.setIst_wareday(rs.getDate("ist_wareday"));
				istPurchase.setIst_sendday(rs.getDate("ist_sendday"));
				istPurchase.setIst_purstatus(rs.getInt("ist_purstatus"));
				istPurchase.setIst_quantity(rs.getInt("ist_quantity"));
				istPurchase.setIst_unitprice(rs.getInt("ist_unitprice"));
				istPurchase.setIst_divisprice(rs.getInt("ist_divisprice"));
				istPurchase.setIst_totalprice(rs.getInt("ist_totalprice"));
				istPurchase.setSoft_del(rs.getString("soft_del"));
				
				return istPurchase;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 구매 검색
	public IstPurchase selectByIstPurchid(String istPurchid){
		
		String sql = "select * from IT_INSTRUMENT_PURCHASE where IST_PURCHID = ? AND SOFT_DEL = ? ";

		List<IstPurchase> list = jdbcTemplate.query(sql, new Object[]{istPurchid, 0}, new RowMapper<IstPurchase>(){

			@Override
			public IstPurchase mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstPurchase istPurchase = new IstPurchase();
				istPurchase.setIst_purchid(rs.getInt("ist_purchid"));
				istPurchase.setIst_divisid(rs.getInt("ist_divisid"));
				istPurchase.setIst_userid(rs.getString("ist_userid"));
				istPurchase.setIst_offer(rs.getString("ist_offer"));
				istPurchase.setIst_ofday(rs.getDate("ist_ofday"));
				istPurchase.setIst_usage(rs.getString("ist_usage"));
				istPurchase.setIst_oderday(rs.getDate("ist_oderday"));
				istPurchase.setIst_wareday(rs.getDate("ist_wareday"));
				istPurchase.setIst_sendday(rs.getDate("ist_sendday"));
				istPurchase.setIst_purstatus(rs.getInt("ist_purstatus"));
				istPurchase.setIst_quantity(rs.getInt("ist_quantity"));
				istPurchase.setIst_unitprice(rs.getInt("ist_unitprice"));
				istPurchase.setIst_divisprice(rs.getInt("ist_divisprice"));
				istPurchase.setIst_totalprice(rs.getInt("ist_totalprice"));
				istPurchase.setSoft_del(rs.getString("soft_del"));
				
				return istPurchase;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 구매 삽입
	public int insertIstPurchase(IstPurchase istPurchase) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_PURCHASE(ist_purchid, ist_divisid, ist_userid, ist_offer, ist_ofday, ist_usage, ist_oderday, ist_wareday, ist_sendday, "
							+ "ist_purstatus, ist_quantity, ist_unitprice, ist_divisprice, ist_totalprice, soft_del) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istPurchase.getIst_purchid(),
				istPurchase.getIst_divisid(),
				istPurchase.getIst_userid(),
				istPurchase.getIst_offer(),
				istPurchase.getIst_ofday(),
				istPurchase.getIst_usage(),
				istPurchase.getIst_oderday(),
				istPurchase.getIst_wareday(),
				istPurchase.getIst_sendday(),
				istPurchase.getIst_purstatus(),
				istPurchase.getIst_quantity(),
				istPurchase.getIst_unitprice(),
				istPurchase.getIst_divisprice(),
				istPurchase.getIst_totalprice(),
				istPurchase.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 구매 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstPurchid(String istPurchid) {
		String sql = "update IT_INSTRUMENT_PURCHASE set SOFT_DEL = ? where IST_PURCHID like ?";
		int row = jdbcTemplate.update(sql, 1, istPurchid);
		return row;
	}
	
	/*//1개 전산장비 구매 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 구매 카운트
	public int countIstPurchase() {
		String sql = "select count(*) from IT_INSTRUMENT_PURCHASE";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
