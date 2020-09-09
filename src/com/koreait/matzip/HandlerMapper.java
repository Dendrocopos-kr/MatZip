package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.user.UserController;

public class HandlerMapper {
	private UserController userController;
	private ErrorController errorController;

	public HandlerMapper() {
		super();
		userController = new UserController();
		errorController = new ErrorController();
	}

	public String nav(HttpServletRequest request){
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
				request.setAttribute(Const.VIEW, "/restaurant/restMap");
				request.setAttribute(Const.TITLE, "레스토랑 지도");
				return ViewRef.TEMP_TYPE_1;
				
			// return restController.view(request);
			}
			break;
		}

		return errorController.error(request, "400 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
	}

}
