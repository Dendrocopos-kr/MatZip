package com.koreait.matzip.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate {
	public static void executeQuery(String sql, JdbcSelectInterface jdbc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbManager.getConn();
			ps = conn.prepareStatement(sql);
			jdbc.prepard(ps);
			rs = ps.executeQuery();
			jdbc.executeQuery(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.close(conn, ps, rs);
		}
	}

	public static int executeUpdate(String sql, JdbcUpdateInterface jdbc) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DbManager.getConn();
			ps = conn.prepareStatement(sql);
			result = jdbc.update(ps);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.close(conn, ps);
		}
		return result;
	}
}
