package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ReserveDao {
	private static ReserveDao instance;

	private ReserveDao() {

	}

	public static ReserveDao getInstance() {
		if (instance == null) {
			instance = new ReserveDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	

	public List<Map<String, Object>> noticeList() {
		String sql = "SELECT NT_NO, NT_TITLE, NT_CONTENT \r\n"
				+ "FROM NOTICE";
		return jdbc.selectList(sql);
	}

	public List<Map<String, Object>> reviewList() {
		String sql = "SELECT REVIEW_NO, REVIEW_TITLE, REVIEW_CONTENT, REVIEW_SCORE\r\n"
				+ "FROM REVIEW";
		return jdbc.selectList(sql);
	}
	
}


