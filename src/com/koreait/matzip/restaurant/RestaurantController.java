package com.koreait.matzip.restaurant;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.Const;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.vo.UserVO;

public class RestaurantController {
	private RestaurantServices service;
	
	public RestaurantController() {
		super();
		service = new RestaurantServices();
	}
	
	public String viewMap(HttpServletRequest request) {
		request.setAttribute(Const.VIEW, "/restaurant/restMap");
		request.setAttribute(Const.TITLE, "레스토랑 지도");		
		return ViewRef.TEMP_TYPE_1;
	}
}
