package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import util.ScanUtil;

public class Print {
	
	public void printVar() {
		System.out.println("===================================");
		
	}
	
	public void printLn(int num) {
		for (int i = 0; i < num; i++) System.out.println();
	}
	

	public void printReview() {
		printVar();
		
		System.out.println("1. 리뷰 조회");
		System.out.println("2. 리뷰 작성");
		System.out.println("3. 리뷰 수정");
		System.out.println("4. 리뷰 삭제");
	}
	
//	리뷰 전체 조회
	public void reviewListPirnt(List<Map<String, Object>> reviewList) {
		printVar();
		System.out.println("리뷰 번호" + "\t" + "리뷰 제목" + "\t" + "\t"+ "리뷰 내용" + "\t" + "별점");
		for (Map<String,Object> map:reviewList) {
			String reviewNo = (String)map.get("REVIEW_NO");
			String reviewTitle = (String)map.get("REVIEW_TITLE");
			String reviewContent = (String)map.get("REVIEW_CONTENT");
			BigDecimal reviewScore = (BigDecimal)map.get("REVIEW_SCORE");
			System.out.println(reviewNo + "\t" + reviewTitle + "\t" + reviewContent  + "\t" + reviewScore );
		}
		printVar();
	}
	
//	공지사항 전체 조회
	public void noticeListPrint(List<Map<String, Object>> noticeList) {
		printVar();
		System.out.println("공지 번호" + "\t" + "공지 제목" + "\t" + "공지 내용");
		for (Map<String,Object> map:noticeList) {
			String ntNo = (String)map.get("NT_NO");
			String ntTitle = (String)map.get("NT_TITLE");
			String ntContent = (String)map.get("NT_CONTENT");
			System.out.println(ntNo + "\t" + ntTitle + "\t" + ntContent);
		}
		printVar();
	}
	
	public void printReserve() {
		printVar();
		
		System.out.println("1. 예약하기");
		System.out.println("2. 공지사항 출력");
		System.out.println("3. 리뷰 출력");
	}
	
	public void printLogin() {
		printVar();

		System.out.println("1. 로그인");
		System.out.println("2. 아이디 찾기");
		System.out.println("3. 비밀번호 찾기");
		System.out.println("4. 회원정보 수정");
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		printLn(5);
		printVar();
	}
	
	public void printMain() {
//		로고 출력
	}
}