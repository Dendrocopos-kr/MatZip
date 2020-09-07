package com.koreait.matzip;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Container extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapper mapper;

	public Container() {
		super();
		mapper = new HandlerMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proc(request, response);
	}

	private void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = "/WEB-INF/view/error.jsp";
		request.setAttribute(Const.TITLE, "ERROR PAGE");
		
		temp = mapper.nav(request);

		switch (temp) {
		case "400":
			Utils.Add_Error_Code(request, "400 요청 오류", "잘못 된 경로 입니다.", "경로를 다시 확인해 주십시오.");
			break;
		case "404":
			Utils.Add_Error_Code(request, "404 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
			break;
		}

		request.getRequestDispatcher(temp).forward(request, response);
	}
}
