package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstReport;


@Component
public class IstReportDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//모든 전산장비 보고서 검색 페이지
	public List<IstReport> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_reportid, ist_divisid, ist_userid, ist_calculday, ist_appliday, ist_supply, "
							+ "ist_cooper, ist_reporstatus, ist_quantity, ist_price, ist_totalprice, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_REPORT "
				+ "where SOFT_DEL = ? order by IST_REPORTID desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstReport> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstReport>(){

			@Override
			public IstReport mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstReport istReport = new IstReport();
				istReport.setIst_reportid(rs.getInt("ist_reportid"));
				istReport.setIst_divisid(rs.getInt("ist_divisid"));
				istReport.setIst_userid(rs.getString("ist_userid"));
				istReport.setIst_calculday(rs.getDate("ist_calculday"));
				istReport.setIst_appliday(rs.getDate("ist_appliday"));
				istReport.setIst_supply(rs.getString("ist_supply"));
				istReport.setIst_cooper(rs.getString("ist_cooper"));
				istReport.setIst_reporstatus(rs.getInt("ist_reporstatus"));
				istReport.setIst_quantity(rs.getInt("ist_quantity"));
				istReport.setIst_price(rs.getInt("ist_price"));
				istReport.setIst_totalprice(rs.getInt("ist_totalprice"));
				istReport.setIst_remark(rs.getString("ist_remark"));
				istReport.setSoft_del(rs.getString("soft_del"));
				
				return istReport;
			}
			
		});
		
		return list;
	}
	
	//1개 전산장비 보고서 검색
	public IstReport selectByIstReportid(String istReportid){
		
		String sql = "select * from IT_INSTRUMENT_REPORT where IST_REPORTID = ? AND SOFT_DEL = ? ";

		List<IstReport> list = jdbcTemplate.query(sql, new Object[]{istReportid, 0}, new RowMapper<IstReport>(){

			@Override
			public IstReport mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstReport istReport = new IstReport();
				istReport.setIst_reportid(rs.getInt("ist_reportid"));
				istReport.setIst_divisid(rs.getInt("ist_divisid"));
				istReport.setIst_userid(rs.getString("ist_userid"));
				istReport.setIst_calculday(rs.getDate("ist_calculday"));
				istReport.setIst_appliday(rs.getDate("ist_appliday"));
				istReport.setIst_supply(rs.getString("ist_supply"));
				istReport.setIst_cooper(rs.getString("ist_cooper"));
				istReport.setIst_reporstatus(rs.getInt("ist_reporstatus"));
				istReport.setIst_quantity(rs.getInt("ist_quantity"));
				istReport.setIst_price(rs.getInt("ist_price"));
				istReport.setIst_totalprice(rs.getInt("ist_totalprice"));
				istReport.setIst_remark(rs.getString("ist_remark"));
				istReport.setSoft_del(rs.getString("soft_del"));
				
				return istReport;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1개 전산장비 보고서 삽입
	public int insertIstReport(IstReport istReport) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_REPORT(ist_reportid, ist_divisid, ist_userid, ist_calculday, ist_appliday, ist_supply, "
							+ "ist_cooper, ist_reporstatus, ist_quantity, ist_price, ist_totalprice, ist_remark, soft_del) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istReport.getIst_reportid(),
				istReport.getIst_divisid(),
				istReport.getIst_userid(),
				istReport.getIst_calculday(),
				istReport.getIst_appliday(),
				istReport.getIst_supply(),
				istReport.getIst_cooper(),
				istReport.getIst_reporstatus(),
				istReport.getIst_quantity(),
				istReport.getIst_price(),
				istReport.getIst_totalprice(),
				istReport.getIst_remark(),
				istReport.getSoft_del()
				);
		return row;
	}
	
	//1개 전산장비 보고서 삭제(소프트 딜리트 활용, 0:디폴트, 1:삭제)
	public int deleteByIstReportid(String istReportid) {
		String sql = "update IT_INSTRUMENT_REPORT set SOFT_DEL = ? where IST_REPORTID like ?";
		int row = jdbcTemplate.update(sql, 1, istReportid);
		return row;
	}
	
	/*//1개 전산장비 보고서 삭제
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//전산장비 보고서 카운트
	public int countIstReport() {
		String sql = "select count(*) from IT_INSTRUMENT_REPORT";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
