package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.MemberDao;

public class MemberService {
// 로직 부분 처리

	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	// 메소드를 사용하기 위해서 객체가 필요 -> 객체 생성해야 함
	MemberDao memberDao = MemberDao.getInstance();
	
	public void sign(List<Object> param) {
		memberDao.sign(param);
	}

	
	// 객체를 만들었으면 메소드를 사용할 수 있음
	public boolean login(List<Object> param, int role) {
		Map<String, Object> member = memberDao.login(param);
		
		// 로그인 실패
		if (member == null) {
			return false;
		}
		// 로그인 성공
		if (role == 1) {
			// 1. 일반 회원 -> member에 넣어줌
			MainController.sessionStorage.put("member", member);
		}
		if (role == 2) {
			// 2. 관리자
			MainController.sessionStorage.put("admin", member);
		}
		return true;
	}

	public void sindId(List<Object> param) {
		memberDao.sindId(param);
		
	}

	public void sindPw(List<Object> param) {
		memberDao.sindPw(param);
	}

	public void modifyMember(List<Object> param) {
		memberDao.modifyMember(param);
		
	}
	
}