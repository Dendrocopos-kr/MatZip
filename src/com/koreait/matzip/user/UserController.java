package com.koreait.matzip.user;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.Const;
import com.koreait.matzip.ViewRef;

public class UserController {
	public String login(HttpServletRequest request) {

		request.setAttribute(Const.VIEW, "user/login");
		request.setAttribute(Const.TITLE, "로그인");
		return ViewRef.TEMP_DEFAULT;
	}

	public String join(HttpServletRequest request) {

		request.setAttribute(Const.VIEW, "user/join");
		request.setAttribute(Const.TITLE, "회원가입");
		return ViewRef.TEMP_DEFAULT;
	}
	

	public String joinProc(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nm = request.getParameter("nm");
				
		return "redirect:/user/login";
	}
}
