package service;

import java.util.List;
import java.util.Map;

import dao.ReviewDao;

public class ReviewService {
	private static ReviewService instance;

	private ReviewService() {

	}

	public static ReviewService getInstance() {
		if (instance == null) {
			instance = new ReviewService();
		}
		return instance;
	}
	
	
	ReviewDao reviewDao = ReviewDao.getInstance();
	

	public void insert(List<Object> param) {
		reviewDao.insert(param);
		
	}

	public int delete(List<Object> param) {
		
		return reviewDao.delete(param);
	}

	public void update(List<Object> param) {
		reviewDao.update(param);
		
	}
}