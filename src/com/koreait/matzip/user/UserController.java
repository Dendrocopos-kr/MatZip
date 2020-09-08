package com.koreait.matzip.user;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.Const;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.vo.UserVO;

public class UserController {
	private UserServices service;
	
	public UserController() {
		super();
		service = new UserServices();
	}

	public String login(HttpServletRequest request) {

		request.setAttribute(Const.VIEW, "/user/login");
		request.setAttribute(Const.TITLE, "로그인");
		return ViewRef.TEMP_DEFAULT;
	}

	public String join(HttpServletRequest request) {

		request.setAttribute(Const.VIEW, "/user/join");
		request.setAttribute(Const.TITLE, "회원가입");
		return ViewRef.TEMP_DEFAULT;
	}
	

	public String joinProc(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nm = request.getParameter("nm");
		
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		param.setUser_nm(user_nm);
		
		service.join(param);
		
		return "redirect:/user/login";
	}
}
