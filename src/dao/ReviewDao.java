package dao;

import java.util.List;

import util.JDBCUtil;

public class ReviewDao {
	private static ReviewDao instance;

	private ReviewDao() {

	}

	public static ReviewDao getInstance() {
		if (instance == null) {
			instance = new ReviewDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void insert(List<Object> param) {
		String sql = " ";
		
		jdbc.update(sql, param);
		
	}

	public int delete(List<Object> param) {
		String sql = " ";
		
		return jdbc.update(sql, param);
	}

	public void update(List<Object> param) {
		String sql = " ";
		
		jdbc.update(sql, param);
		
	}
}
