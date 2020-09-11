package com.koreait.matzip.restaurant;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.CommonDAO;
import com.koreait.matzip.Const;
import com.koreait.matzip.SecurityUtils;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.vo.RestaurantVO;
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

	public String restReg(HttpServletRequest request) {
		final int I_M = 1; // 카테고리 코드
		request.setAttribute(Const.VIEW, "/restaurant/restReg");
		request.setAttribute(Const.TITLE, "레스토랑 등록");
		request.setAttribute("categoryList", CommonDAO.selectCodeList(I_M));
		return ViewRef.TEMP_TYPE_1;
	}

	public String restRegProc(HttpServletRequest request) {
		request.setAttribute(Const.VIEW, "/restaurant/restMap");
		request.setAttribute(Const.TITLE, "레스토랑 지도");
		RestaurantVO param = new RestaurantVO(); 
		param.setAddr(request.getParameter("addr"));
		param.setNm(request.getParameter("nm"));
		param.setLat(Double.parseDouble(request.getParameter("lat")));
		param.setLng(Double.parseDouble(request.getParameter("lng")));
		param.setCd_category(request.getParameter("cd_category"));
		param.setI_user(SecurityUtils.getLoginUser(request).getI_user());
		
		service.insertRestaurant(param);
		return "redirect:/restaurant/restMap";
	}

	public String insertChk(HttpServletRequest request) {
		RestaurantVO param = new RestaurantVO(); 
		param.setAddr(request.getParameter("addr"));
		param.setNm(request.getParameter("nm"));
		param.setLat(Double.parseDouble(request.getParameter("lat")));
		param.setLng(Double.parseDouble(request.getParameter("lng")));
		param.setCd_category(request.getParameter("cd_category"));
		param.setI_user(SecurityUtils.getLoginUser(request).getI_user());
		
		int result = service.insertRestaurant(param);
		System.out.println(result);
		return String.format("ajax:{\"result\":%s}",result);
	}

	public String ajaxGetList(HttpServletRequest request) {
		RestaurantVO param = new RestaurantVO();
		return "ajax:"+service.ajaxGetList(param);
	}
}
