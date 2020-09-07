package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

public class ErrorController {
	public String error(HttpServletRequest request,String errCode, String errMsg, String errDes) {
		request.setAttribute(Const.TITLE, "ERROR PAGE");
		request.setAttribute(Const.VIEW, "error");
		Add_Error_Code(request, errCode, errMsg, errDes);
		return ViewRef.TEMP_DEFAULT;
	}
	public void Add_Error_Code(HttpServletRequest request,String errCode, String errMsg, String errDes) {
		request.setAttribute(Const.ERROR_TYPE, errCode);
		request.setAttribute(Const.ERROR_MSG, errMsg);
		request.setAttribute(Const.ERROR_DESCRIPTION, errDes);
	}
}
