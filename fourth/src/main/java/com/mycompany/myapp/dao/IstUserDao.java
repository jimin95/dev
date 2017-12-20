package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.IstUser;


@Component
public class IstUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//��� ���� ������� �˻� ������
	public List<IstUser> selectAll(int pageNo, int rowsPerPage){
		
		String sql = "select * "
				+ "from( "
				+ "select * "
				+ "from(select rownum as rn, ist_userid, ist_divisid, ist_username, ist_dpt, ist_position, ist_area, ist_address, ist_retire, ist_usage, ist_remark, soft_del "
				+ "from IT_INSTRUMENT_USER "
				+ "where SOFT_DEL = ? order by ist_userid desc) "
				+ "where rownum <= ?) "
				+ "where rn >= ? ";

		List<IstUser> list = jdbcTemplate.query(sql, new Object[]{0, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1)}, new RowMapper<IstUser>(){

			@Override
			public IstUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstUser istUser = new IstUser();
				istUser.setIst_userid(rs.getString("ist_userid"));
				istUser.setIst_divisid(rs.getInt("ist_divisid"));
				istUser.setIst_username(rs.getString("ist_username"));
				istUser.setIst_dpt(rs.getInt("ist_dpt"));
				istUser.setIst_dpt(rs.getInt("ist_position"));
				istUser.setIst_dpt(rs.getInt("ist_area"));
				istUser.setIst_username(rs.getString("ist_address"));
				istUser.setIst_retire(rs.getDate("ist_retire"));
				istUser.setIst_dpt(rs.getInt("ist_usage"));
				istUser.setIst_username(rs.getString("ist_remark"));
				istUser.setIst_username(rs.getString("soft_del"));
				
				return istUser;
			}
			
		});
		
		return list;
	}
	
	//1�� ���� ������� �˻�
	public IstUser selectByIstUserid(String istuserid){
		
		String sql = "select * from IT_INSTRUMENT_USER where IST_USERID = ? AND SOFT_DEL = ? ";

		List<IstUser> list = jdbcTemplate.query(sql, new Object[]{istuserid, 0}, new RowMapper<IstUser>(){

			@Override
			public IstUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				IstUser istUser = new IstUser();
				istUser.setIst_userid(rs.getString("ist_userid"));
				istUser.setIst_divisid(rs.getInt("ist_divisid"));
				istUser.setIst_username(rs.getString("ist_username"));
				istUser.setIst_dpt(rs.getInt("ist_dpt"));
				istUser.setIst_dpt(rs.getInt("ist_position"));
				istUser.setIst_dpt(rs.getInt("ist_area"));
				istUser.setIst_username(rs.getString("ist_address"));
				istUser.setIst_retire(rs.getDate("ist_retire"));
				istUser.setIst_dpt(rs.getInt("ist_usage"));
				istUser.setIst_username(rs.getString("ist_remark"));
				istUser.setIst_username(rs.getString("soft_del"));
				
				return istUser;
			}
			
		});
		
		return (list.size() != 0) ? list.get(0):null;
	}

	//1�� ���� ������� ����
	public int insertIstUser(IstUser istUser) {
		String sql = "insert into "
				+ "IT_INSTRUMENT_USER(ist_userid, ist_divisid, ist_username, ist_dpt, ist_position, ist_area, ist_address, ist_retire, ist_usage, ist_remark) "
				+ "values(?,?,?,?,?,?,?,?,?,?) ";
		
		int row = jdbcTemplate.update(
				sql,
				istUser.getIst_userid(),
				istUser.getIst_divisid(),
				istUser.getIst_username(),
				istUser.getIst_dpt(),
				istUser.getIst_position(),
				istUser.getIst_area(),
				istUser.getIst_address(),
				istUser.getIst_retire(),
				istUser.getIst_usage(),
				istUser.getIst_remark()
				);
		return row;
	}
	
	//1�� ���� ������� ����(����Ʈ ����Ʈ Ȱ��, 0:����Ʈ, 1:����)
	public int deleteByIstUserid(String istuserid) {
		String sql = "update IT_INSTRUMENT_USER set SOFT_DEL = ? where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, 1, istuserid);
		return row;
	}
	
	/*//1�� ���� ������� ����
	public int deleteIstUser(String istuserid) {
		String sql = "delete from IT_INSTRUMENT_USER where IST_USERID like ?";
		int row = jdbcTemplate.update(sql, istuserid);
		return row;
	}*/
	
	//���� ������� ī��Ʈ
	public int countIstUser() {
		String sql = "select count(*) from IT_INSTRUMENT_USER";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	
}
