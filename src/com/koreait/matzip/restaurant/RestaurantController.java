package com.koreait.matzip.restaurant;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.CommonDAO;
import com.koreait.matzip.Const;
import com.koreait.matzip.ViewRef;

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

	public String restReg(HttpServletRequest request) {
		final int I_M = 1; // 카테고리 코드
		request.setAttribute(Const.VIEW, "/restaurant/restReg");
		request.setAttribute(Const.TITLE, "레스토랑 등록");
		request.setAttribute("categoryList", CommonDAO.selectCodeList(I_M));
		return ViewRef.TEMP_TYPE_1;
	}
}
