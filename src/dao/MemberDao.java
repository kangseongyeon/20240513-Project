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
	
	public void sign(List<Object> param) {
		String sql = "INSERT INTO MEMBER\r\n" + 
				"VALUES ((SELECT NVL(MAX(MEM_NO),0) + 1 FROM MEMBER), ?, ?, ?, ?, ?, ?, 'N')";
		
		jdbc.update(sql, param);
	}
	
	
	public Map<String, Object> login(List <Object> param) {
		
		String sql = "SELECT MEM_NAME \r\n" + 
					 "FROM MEMBER \r\n" + 
					 "WHERE MEM_ID = ?\r\n" + 
					 "AND MEM_PW = ?";	 
		
		return jdbc.selectOne(sql, param);
		
	}
	
	public Map<String, Object> sindId(List<Object> param) {
		String sql = "SELECT MEM_ID\r\n" + 
				 "FROM MEMBER \r\n" + 
				 "WHERE MEM_NAME = ?\r\n" + 
				 "AND MEM_EMAIL = ?";	 
		return jdbc.selectOne(sql, param);
	}
	
	
	public Map<String, Object> sindPw(List<Object> param) {
		String sql = "SELECT MEM_PW\r\n" + 
				 "FROM MEMBER \r\n" + 
				 "WHERE MEM_ID = ?\r\n" + 
				 "AND MEM_EMAIL = ?";	 
		return jdbc.selectOne(sql, param);
	}

	public Map<String, Object> modifyMember(List<Object> param) {
		String sql = " ";	 
		return jdbc.selectOne(sql, param);
	}

}
