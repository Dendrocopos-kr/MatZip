<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<title>${title }</title>
</head>
<body>
	<h1>HTTP 상태 ${err_type }</h1>
	<hr>
	<p>
		<b>타입</b> ${err_type }
	</p>
	<p>
		<b>메시지</b> ${err_msg }
	</p>
	<p>
		<b>설명</b> ${err_des }
	</p>
</body>
</html>