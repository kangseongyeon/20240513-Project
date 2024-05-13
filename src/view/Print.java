package view;

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