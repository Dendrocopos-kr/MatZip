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

		String temp = mapper.nav(request);
		//System.out.println(temp.substring(temp.indexOf("/")));
		if (temp.indexOf("/") >= 0 && "redirect:".equals(temp.substring(0, temp.indexOf("/")))) {
			//System.out.println(temp.substring(temp.indexOf("/")));
			response.sendRedirect(temp.substring(temp.indexOf("/")));
			return;
		}
		
		request.getRequestDispatcher(temp).forward(request, response);
	}
}
