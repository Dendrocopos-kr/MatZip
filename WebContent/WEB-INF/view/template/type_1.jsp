<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/res/css/common.css">
<title>${title}</title>
</head>
<body>
	<div id="containerGird">
		<header id="header">
			<div class="headerLeft">
				<div class="containerImg">
					<c:choose>
						<c:when test="${login_user.profile_img != null}">
							<img class="pImg" alt=""
								src="/res/img/user/${login_user.i_user}/${login_user.profile_img}">
						</c:when>
						<c:otherwise>
							<img class="pImg" alt="" src="/res/img/default_profile.png">
						</c:otherwise>
					</c:choose>
				</div>
				<div id="headerNm">${login_user.nm}님환영합니다.</div>
				<div class="btn">
					<a href="/user/logout">
						<button id="logout" type="button">로그아웃</button>
					</a>
				</div>
			</div>
			<div class="headerRight btn">
				<a href="/restaurant/reg"><button>등록</button></a> 
				<a href="/user/favorite"><button>찜</button></a>
			</div>
		</header>
		<div id="menubar">
			<div class="delimiter">
				<span>Menubar</span>
			</div>
		</div>
		<section id="container">
			<jsp:include page="/WEB-INF/view/${view}.jsp"></jsp:include>
		</section>
		<footer id="footer">
			<div class="delimiter">
				<span>회사정보</span>
			</div>
		</footer>
	</div>
</body>
</html>