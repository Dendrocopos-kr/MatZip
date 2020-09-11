package com.koreait.matzip.restaurant;

import com.google.gson.Gson;
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

	public int insertRestaurant(RestaurantVO param) {
		return dao.insertRest(param);
		
	}

	public String ajaxGetList(RestaurantVO param) {
		Gson gson = new Gson();
		return gson.toJson(dao.ajaxGetList(param));
	}
}
