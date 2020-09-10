package com.koreait.matzip.restaurant;

import com.koreait.matzip.vo.RestaurantVO;

public class RestaurantServices {
	private RestaurantDAO dao;

	public RestaurantServices() {
		super();
		dao = new RestaurantDAO();
	}

	public int searchRestaurant(RestaurantVO param) {
		// 반환형 리스트로 변경
		return dao.search(param);
	}
}
