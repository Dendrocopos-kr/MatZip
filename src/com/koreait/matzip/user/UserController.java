package com.koreait.matzip.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		String err = request.getParameter("Err");
		if( err != null ) {
			switch(err) {
			case "2":
				request.setAttribute("Err", "아이디 없음");
				break;
			case "3":
				request.setAttribute("Err", "비밀번호 틀림");
				break;
			}
		}
		request.setAttribute(Const.VIEW, "/user/login");
		request.setAttribute(Const.TITLE, "로그인");
		return ViewRef.TEMP_DEFAULT;
	}

	public String loginProc(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		
		switch (service.login(param)) {
		case 0:
			return "redirect:/user/login?Err="+"2";
		case 1:
			HttpSession hs = request.getSession();
			hs.setAttribute(Const.LOGIN_USER, param);
			return "redirect:/restaurant/restMap";
		case 2:
			return "redirect:/user/login?Err="+"3";
		}
		
		return "redirect:/user/login";
	}
	
	public String join(HttpServletRequest request) {

		request.setAttribute(Const.VIEW, "/user/join");
		request.setAttribute(Const.TITLE, "회원가입");
		return ViewRef.TEMP_DEFAULT;
	}

	public String joinProc(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nm = request.getParameter("nm");

		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		param.setNm(nm);

		service.join(param);

		return "redirect:/user/login";
	}

	public String ajaxIdChk(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw("");
		int result = service.login(param);
		
		return String.format("ajax:{\"result\":%s}",result);
	}

	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/user/login";
	}
}
