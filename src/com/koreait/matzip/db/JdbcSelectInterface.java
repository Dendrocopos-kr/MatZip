package com.koreait.matzip.db;

import java.sql.*;
import java.util.List;

public interface JdbcSelectInterface {
	void prepard(PreparedStatement ps) throws SQLException;
	void executeQuery(ResultSet rs) throws SQLException;

}
