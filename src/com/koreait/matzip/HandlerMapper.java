package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.restaurant.RestaurantController;
import com.koreait.matzip.user.UserController;

public class HandlerMapper {
	private UserController userController;
	private ErrorController errorController;
	private RestaurantController restaurantController;

	public HandlerMapper() {
		super();
		userController = new UserController();
		errorController = new ErrorController();
		restaurantController = new RestaurantController();
	}

	public String nav(HttpServletRequest request) {
		String[] uriArr = request.getRequestURI().split("/");

		if (uriArr.length < 3) {
			return errorController.error(request, "404 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
		}
		switch (uriArr[1]) {
		case ViewRef.URI_USER:
			switch (uriArr[2]) {
			case "login":
				return userController.login(request);
			case "loginProc":
				return userController.loginProc(request);
			case "logout":
				return userController.logout(request);
			case "join":
				return userController.join(request);
			case "joinProc":
				return userController.joinProc(request);
			case "chkIdProc":
				return userController.ajaxIdChk(request);
			}
			break;
		case ViewRef.URI_REST:
			switch (uriArr[2]) {
			case "restMap":
				return restaurantController.viewMap(request);
			case "restReg":
				return restaurantController.restReg(request);
			case "restRegProc":
				return restaurantController.restRegProc(request);
			case "insertChk":
				return restaurantController.insertChk(request);
			case "getList":
				return restaurantController.ajaxGetList(request);
			}
			break;
		}

		return errorController.error(request, "400 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
	}

}
