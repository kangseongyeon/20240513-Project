package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.ReserveService;
import service.ReserveService;
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
	ReserveService reserveService = ReserveService.getInstance();
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
			case LOGIN:
				view = login();
				break;
			case RESERVE:
				view = reserve();
				break;
			case RESERVATION:
				view = reservation();
				break;
			case NOTICE:
				view = noticeList();
				break;
			case REVIEW_LIST:
				view = review_list();
				break;
			case REVIEW:
				view = review();
				break;
			case REVIEW_INSERT:
				view = review_insert();
				break;
			case REVIEW_UPDATE:
				view = review_update();
				break;
			case REVIEW_DELETE:
				view = review_delete();
				break;
			default:
				break;
			}
		}
	} 
	

	private View review_delete() {
		
		return View.REVIEW_LIST;
	}
	
	private View review_update() {
		return View.REVIEW_LIST;
	}
	
	private View review_insert() {
		if (debug) System.out.println("-------- 리뷰 작성 --------");
		List<Object> param = new ArrayList();
		
		
		
		return View.REVIEW_LIST;
	}
	
	private View review() {
		if (debug) System.out.println("============= 리뷰 =============");
		printReview();
		
		int sel = ScanUtil.menu();
		
		if (sel == 1) {
			if (debug) System.out.println("============= A) 리뷰 조회 =============");
			return View.REVIEW_LIST;
		}
		else if (sel == 2) {
			if (debug) System.out.println("============= B) 리뷰 작성 =============");
			return View.REVIEW_INSERT;
		}
		else if (sel == 3) {
			if (debug) System.out.println("============= C) 리뷰 수정 =============");
			return View.REVIEW_UPDATE;
		}
		else if (sel == 4) {
			if (debug) System.out.println("============= D) 리뷰 삭제 =============");
			return View.REVIEW_DELETE;
		}
		return View.HOME;
	}
	
//	리뷰 전체 조회
	private View review_list() {
		List<Map<String, Object>> reviewList = reserveService.reviewList();
		reviewListPirnt(reviewList);

		return View.REVIEW;
	}
	
//	공지사항 전체 조회
	private View noticeList() {
		List<Map<String, Object>> noticeList = reserveService.noticeList();
		noticeListPrint(noticeList);
		return View.RESERVE;
	}
	
//	실제 예약 진행 코드 작성 필요
	private View reservation() {
		
		
		return View.REVIEW;
	}
	
	private View reserve() {
		printReserve();
		
		int sel = ScanUtil.menu();
		
		if (sel == 1) {
			if (debug) System.out.println("============= A) 예약하기 =============");
			return View.RESERVATION;
		}
		else if (sel == 2) {
			if (debug) System.out.println("============= B) 공지사항 =============");
			return View.NOTICE;
		}
		else if (sel == 3) {
			if (debug) System.out.println("============= C) 리뷰 =============");
			return View.REVIEW_LIST;
		}
//		수정 필요
		return View.HOME;
	}
	
	private View login() {
		if (debug) System.out.println("============= 로그인 =============");
		printLogin();
		
		int sel = ScanUtil.menu();
		
		if (sel == 1) {
			int memId = ScanUtil.nextInt("아이디 : ");
			int memPw = ScanUtil.nextInt("비밀번호 : ");
			
			
			List<Object> param = new ArrayList<Object>();
			param.add(memId);
			param.add(memPw);	
			param.add(1);
//			int role = (int) sessionStorage.get("role");
			
			boolean loginChk = memberService.login(param, 1);
			if (!loginChk) {
				System.out.println("로그인 실패");
				return View.LOGIN;
			} else {
				Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
				System.out.println(member.get("NAME") + "님 환영합니다");
				return View.RESERVE;
			}
		}
//		수정 필요
		return View.HOME;
		
	}
	 
	private View home() {
		printMain();
		if (debug) System.out.println("============== 홈 ==============");
		printHome();
		
		int sel = ScanUtil.menu();
//		if (sel == 1)  return View.LOGIN;
		if (sel == 1)  return View.RESERVE;
		else if (sel == 2) return View.SIGN;
		else if (sel == 0) return View.ADMIN;
		else return View.HOME;
	}
}
