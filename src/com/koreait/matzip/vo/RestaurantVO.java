package com.koreait.matzip.vo;

public class RestaurantVO {
	int i_rest;
	String nm;
	String addr;
	double lat;
	double lng;
	String cd_category;
	int i_user;
	String r_dt;
	String m_dt;

	public String getNm() {
		return nm;
	}

	public int getI_rest() {
		return i_rest;
	}

	public void setI_rest(int i_rest) {
		this.i_rest = i_rest;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCd_category() {
		return cd_category;
	}

	public void setCd_category(String cd_category) {
		this.cd_category = cd_category;
	}

	public int getI_user() {
		return i_user;
	}

	public void setI_user(int i_user) {
		this.i_user = i_user;
	}

	public String getR_dt() {
		return r_dt;
	}

	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}

	public String getM_dt() {
		return m_dt;
	}

	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

}
