package service;

import java.util.List;
import java.util.Map;

import dao.ReserveDao;

public class ReserveService {
	private static ReserveService instance;

	private ReserveService() {

	}

	public static ReserveService getInstance() {
		if (instance == null) {
			instance = new ReserveService();
		}
		return instance;
	}
	
	ReserveDao reserveDao = ReserveDao.getInstance();
	
//	공지사항 출력
	public List<Map<String, Object>> noticeList() {
		return reserveDao.noticeList();
	}

//	리뷰 전체 출력
	public List<Map<String, Object>> reviewList() {
		return reserveDao.reviewList();
	}

}
