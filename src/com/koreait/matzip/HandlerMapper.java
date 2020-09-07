package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.user.UserController;

public class HandlerMapper {
	private UserController userController;

	public HandlerMapper() {
		super();
		userController = new UserController();
	}

	public String nav(HttpServletRequest request) {
		String[] uriArr = request.getRequestURI().split("/");

		if (uriArr.length < 3) {
			return "400";
		}

		switch (uriArr[1]) {
		case ViewRef.URI_USER:
			switch (uriArr[2]) {
			case "login":
				return userController.login(request);
			case "join" :
				return userController.join(request);
			}
			break;
		}
		return "404";
	}

}
