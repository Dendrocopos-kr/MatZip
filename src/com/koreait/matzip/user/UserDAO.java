package com.koreait.matzip.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.koreait.matzip.db.JdbcTemplate;
import com.koreait.matzip.db.JdbcUpdateInterface;
import com.koreait.matzip.vo.UserVO;

public class UserDAO {
	public int join(UserVO param) {
		String sql = " insert into t_user "
				+ " (user_id,user_pw,nm,salt) "
				+ " VALUES "
				+ " (?,?,?,?) ";
		
		return  JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {
			
			@Override
			public int update(PreparedStatement ps) throws SQLException {
				int arg0 = 1;
				ps.setNString(arg0++, param.getUser_id());
				ps.setNString(arg0++, param.getUser_pw());
				ps.setNString(arg0++, param.getUser_nm());
				ps.setNString(arg0++, param.getSalt());
				return ps.executeUpdate();
			}
		});
	}
}
