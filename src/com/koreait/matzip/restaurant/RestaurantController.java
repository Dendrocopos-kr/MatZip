package com.koreait.matzip.restaurant;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.CommonDAO;
import com.koreait.matzip.CommonUtils;
import com.koreait.matzip.Const;
import com.koreait.matzip.SecurityUtils;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.vo.RestaurantRecommendMenuDomain;
import com.koreait.matzip.vo.RestaurantRecommendMenuVO;
import com.koreait.matzip.vo.RestaurantVO;
import com.koreait.matzip.vo.UserVO;

public class RestaurantController {

	private RestaurantService service;

	public RestaurantController() {
		service = new RestaurantService();
	}

	public String restMap(HttpServletRequest request) {
		request.setAttribute(Const.TITLE, "지도보기");
		request.setAttribute(Const.VIEW, "restaurant/restMap");
		return ViewRef.TEMP_MENU_TEMP;
	}

	public String restReg(HttpServletRequest request) {
		final int I_M = 1; // 카테고리 코드
		request.setAttribute("categoryList", CommonDAO.selCodeList(I_M));

		request.setAttribute(Const.TITLE, "가게 등록");
		request.setAttribute(Const.VIEW, "restaurant/restReg");
		return ViewRef.TEMP_MENU_TEMP;
	}

	public String restRegProc(HttpServletRequest request) {
		String nm = request.getParameter("nm");
		String addr = request.getParameter("addr");
		double lat = CommonUtils.getDoubleParameter("lat", request);
		double lng = CommonUtils.getDoubleParameter("lng", request);
		int cd_category = CommonUtils.getIntParameter("cd_category", request);

		UserVO loginUser = SecurityUtils.getLoginUser(request);

		RestaurantVO param = new RestaurantVO();
		param.setNm(nm);
		param.setAddr(addr);
		param.setLat(lat);
		param.setLng(lng);
		param.setI_user(loginUser.getI_user());
		param.setCd_category(cd_category);

		int result = service.restReg(param);

		return "redirect:/restaurant/restMap";
	}

	public String ajaxGetList(HttpServletRequest request) {
		return "ajax:" + service.getRestList();
	}

	public String restDetail(HttpServletRequest request) {
		int i_rest = CommonUtils.getIntParameter("i_rest", request);

		RestaurantVO param = new RestaurantVO();
		param.setI_rest(i_rest);

		request.setAttribute("css", new String[] { "restaurant" });

		request.setAttribute("recommendMenuList", service.getRecommendMenuList(param));
		request.setAttribute("menuList", service.getMenuList(param));
		request.setAttribute("data", service.getRest(param));
		request.setAttribute(Const.TITLE, "디테일");
		request.setAttribute(Const.VIEW, "restaurant/restDetail");
		return ViewRef.TEMP_MENU_TEMP;
	}

	public String addRecMenusProc(HttpServletRequest request) {
		int result = service.addRecMenus(request);

		return "redirect:/restaurant/restDetail?i_rest=" + result;
	}

	public String addMenusProc(HttpServletRequest request) {
		int result = service.addMenus(request);
		return "redirect:/restaurant/restDetail?i_rest=" + result;
	}

	public String ajaxDelRecMenu(HttpServletRequest request) {
		int i_rest = CommonUtils.getIntParameter("i_rest", request);
		int seq = CommonUtils.getIntParameter("seq", request);
		// 파일 삭제 추가 1
		String fileNm = request.getParameter("fileNm");
		// 파일 삭제 끝 1
		// System.out.println(fileNm);

		RestaurantRecommendMenuDomain param = new RestaurantRecommendMenuDomain();
		param.setI_user(SecurityUtils.getLoginUser(request).getI_user());
		param.setI_rest(i_rest);
		param.setSeq(seq);
		int result = service.delRecMenu(param);
		// 파일 삭제 추가 2
		String savePath = request.getServletContext().getRealPath("/res/img/restaurant") + "/" + i_rest + "/" + fileNm;

		// System.out.println(savePath);

		File file = new File(savePath);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("파일삭제 성공");
			} else {
				System.out.println("파일삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		// 파일 삭제 끝 2

		return "ajax:{\"result\":" + result + "}";
	}

	public String ajaxDelMenu(HttpServletRequest request) {
		int i_rest = CommonUtils.getIntParameter("i_rest", request);
		int seq = CommonUtils.getIntParameter("seq", request);
		// 파일 삭제 추가 1
		String fileNm = request.getParameter("fileNm");
		// 파일 삭제 끝 1
		// System.out.println(fileNm);

		RestaurantRecommendMenuDomain param = new RestaurantRecommendMenuDomain();
		param.setI_user(SecurityUtils.getLoginUser(request).getI_user());
		param.setI_rest(i_rest);
		param.setSeq(seq);
		int result = service.delMenu(param);
		// 파일 삭제 추가 2
		String savePath = request.getServletContext().getRealPath("/res/img/restaurant") + "/" + i_rest + "/" + fileNm;

		// System.out.println(savePath);

		File file = new File(savePath);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("파일삭제 성공");
			} else {
				System.out.println("파일삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		// 파일 삭제 끝 2

		return "ajax:{\"result\":" + result + "}";
	}

}
