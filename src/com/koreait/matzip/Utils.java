package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static void Add_Error_Code(HttpServletRequest request,String errCode, String errMsg, String errDes) {
		request.setAttribute(Const.ERROR_TYPE, errCode);
		request.setAttribute(Const.ERROR_MSG, errMsg);
		request.setAttribute(Const.ERROR_DESCRIPTION, errDes);
	}
}
