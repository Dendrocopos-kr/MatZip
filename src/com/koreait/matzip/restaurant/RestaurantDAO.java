package com.koreait.matzip.restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.matzip.db.JdbcSelectInterface;
import com.koreait.matzip.db.JdbcTemplate;
import com.koreait.matzip.db.JdbcUpdateInterface;
import com.koreait.matzip.vo.RestaurantVO;

public class RestaurantDAO {

	public int search(RestaurantVO param) {
		// 반환형 리스트로 변경
		String sql = " select * from t_restaurant where = ? ";
		JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {
			
			@Override
			public void prepard(PreparedStatement ps) throws SQLException {
				int arg0 = 1;
				ps.setNString(arg0++, param.getNm());
			}
			
			@Override
			public void executeQuery(ResultSet rs) throws SQLException {
				// 결과 리스트로 받기
				
			}
		});
		return 0;
	}

	public int insertRest(RestaurantVO param) {
		String sql = " insert into t_restaurant( nm, addr, lat, lng, cd_category, i_user) values (?,?,?,?,?,?)  "; 
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {
			
			@Override
			public int update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getNm());
				ps.setNString(2, param.getAddr());
				ps.setDouble(3, param.getLat());
				ps.setDouble(4, param.getLng());
				ps.setNString(5, param.getCd_category());
				ps.setInt(6, param.getI_user());
				return ps.executeUpdate();
			}
		});
	}

	public List<RestaurantVO> ajaxGetList(RestaurantVO param) {
		List<RestaurantVO> list = new ArrayList();
		String sql = " select * from t_restaurant ";
		JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {
			
			@Override
			public void prepard(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void executeQuery(ResultSet rs) throws SQLException {
				while(rs.next()) {
					RestaurantVO param = new RestaurantVO();
					param.setI_rest(rs.getInt("i_rest"));
					param.setNm(rs.getNString("nm"));
					param.setAddr(rs.getNString("addr"));
					param.setLat(rs.getDouble("lat"));
					param.setLng(rs.getDouble("lng"));
					param.setCd_category(rs.getString("cd_category"));
					param.setI_user(rs.getInt("i_user"));
					list.add(param);
				}
				
			}
		});
		
		return list;
	}
}
