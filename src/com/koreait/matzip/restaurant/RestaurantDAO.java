package com.koreait.matzip.restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koreait.matzip.db.JdbcSelectInterface;
import com.koreait.matzip.db.JdbcTemplate;
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

}
