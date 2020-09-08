<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/res/css/common.css">
<title>${title}</title>
</head>
<body>
	<div id="containerGird">
		<div id="nav">
			<div  class="delimiter">
				<span>Navi</span>
			</div>
		</div>
		<div id="menubar">
			<div class="delimiter">
				<span>Menubar</span>
			</div>
		</div>
		<div id="container">
			<div class="delimiter">
				<span>container</span>
			</div>
			<jsp:include page="/WEB-INF/view/${view}.jsp"></jsp:include>
		</div>
		<div id="footer">
			<div class="delimiter">
				<span>footer</span>
			</div>
		</div>
	</div>
</body>
<script src="/res/js/test.js"></script>
</html>