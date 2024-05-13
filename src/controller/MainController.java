package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.MemberService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print {
	
	// sessionStorage : 데이터를 담을 수 있게 관리
	//				  : 로그인 된 정보를 넣어줌
	static public Map<String, Object> sessionStorage = new HashMap<>();
	// memberService 객체 만듦
	MemberService memberService = MemberService.getInstance();
	
	boolean debug = true;
	

	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case ADMIN:
				view = admin();
				break;
			case LOGIN:
				view = login();
				break;
			case SIGN:
				view = sign();
				break;
			case RESERVE:
				view = reserve();
				break;
			default:
				break;
			}
		}
	}
	
	public View reserve() {
		return null;
	}
	
	public View admin() {
		return null;
	}

	
	public View sign() {
//		아이디 / *비밀번호 / *이메일 / *이름 / *전화번호 / *생년월일 입력
		if (debug) System.out.println("회원가입 메뉴");
		
		List<Object> param = new ArrayList<Object>();
		
		String id = ScanUtil.nextLine("ID >> ");
		String pw = ScanUtil.nextLine("PASS >> ");
		String email = ScanUtil.nextLine("EMAIL >> ");
		String name = ScanUtil.nextLine("NAME >> ");
		String telno = ScanUtil.nextLine("TELNO >> ");
		String birthday = ScanUtil.nextLine("BIRTHDAY >> ");
		
		param.add(id);
		param.add(pw);
		param.add(email);
		param.add(name);
		param.add(telno);
		param.add(birthday);
		
		memberService.sign(param);
		return View.HOME;
	}
	
	public View login() {
		if (debug) System.out.println("============== 1. 로그인 ==============");
		
		System.out.println("1. 로그인");
		System.out.println("2. 아이디 찾기");
		System.out.println("3. 비밀번호 찾기");
		System.out.println("4. 회원정보 수정");
		
		int sel = ScanUtil.menu();
		if (sel == 1) {
			int memId = ScanUtil.nextInt("아이디 : ");
			int memPw = ScanUtil.nextInt("비밀번호 : ");
			
			List<Object> param = new ArrayList();
			param.add(memId);
			param.add(memPw);
			param.add(2);
			
			boolean loginChk = memberService.login(param, 2);
			if (!loginChk) {
				System.out.println("로그인 실패");
				return View.LOGIN;
			} else {
				Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
				System.out.println(member.get("NAME") + "님 환영합니다");
				return View.RESERVE;
			}
		}
		else if (sel == 2) {
			if (debug) System.out.println("2. 아이디 찾기");
			String findName = ScanUtil.nextLine("이름을 입력하세요 >> ");
			String findEmail = ScanUtil.nextLine("이메일을 입력하세요 >> ");
			
			List<Object> param = new ArrayList();
			param.add(findName);
			param.add(findEmail);
			memberService.sindId(param);
			
			boolean idChk = memberService.login(param, 2);	// 수정 필요
			Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
			if (!idChk) {
				System.out.println(member.get("NAME") + "님의 아이디는 " + member.get("ID") + "입니다.");
				return View.LOGIN;
			} else {
				System.out.println(member.get("NAME") + "님의 정보는 없습니다.");
				return View.LOGIN;
			}
		}
		
		else if (sel == 3) {
			if (debug) System.out.println("3. 비밀번호 찾기");
			String findId = ScanUtil.nextLine("아이디를 입력하세요 >> ");
			String findEmail = ScanUtil.nextLine("이메일을 입력하세요 >> ");
			
			List<Object> param = new ArrayList();
			param.add(findId);
			param.add(findEmail);
			memberService.sindPw(param);
			
			boolean idChk = memberService.login(param, 2);	// 수정 필요
			Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
			if (!idChk) {
				// 비밀번호 출력이 아니라 재입력할 수 있게 만들어주기
				System.out.println(member.get("NAME") + "님의 아이디는 " + member.get("ID") + "입니다.");
				return View.LOGIN;
			} else {
				System.out.println(member.get("NAME") + "님의 정보는 없습니다.");
				return View.LOGIN;
			}
		}
		
		else if (sel == 4) {
			if (debug) System.out.println("4. 회원정보 수정");
			String checkId = ScanUtil.nextLine("아이디를 입력하세요 >> ");
			String checkPw = ScanUtil.nextLine("비밀번호를 입력하세요 >> ");
			
			List<Object> param = new ArrayList();
			param.add(checkId);
			param.add(checkPw);
			memberService.modifyMember(param);
			
			// 회원 정보 맞는지 확인
		}
		return View.HOME;
	}
	
	
	private View home() {
		if (debug) System.out.println("============== 홈 ==============");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		
		int sel = ScanUtil.menu();
		if (sel == 1)  return View.LOGIN;
		else if (sel == 2) return View.SIGN;
		else if (sel == 0) return View.ADMIN;
		else return View.HOME;
	}

}
