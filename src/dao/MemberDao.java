package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDao {
	// DB 관련된 sql문 처리
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String, Object> login(List <Object> param) {
		
		String sql = "SELECT MEM_ID\r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEM_ID = ? \r\n"
				+ "      AND MEM_PW = ? \r\n"
				+ "      AND MEM_DELYN = 'N' \r\n"
				+ "      AND MEM_GU = ?\r\n";
		
		return jdbc.selectOne(sql, param);
		
	}
}
