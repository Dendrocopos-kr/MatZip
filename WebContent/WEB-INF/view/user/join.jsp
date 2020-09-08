<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="sectionContainerCenter">
	<div>
		<div class="err">${Err}</div>
		<form class="frm" id="frm" action="/user/joinProc" method="post" onsubmit="return chk()">
			<div>
				<label>아이디</label><input type="text" name="user_id" placeholder="아이디" value="${tempData.getUser_id()}" required>
			</div>
			<div>
				<label>비밀번호</label><input type="password" name="user_pw" placeholder="비밀번호" required>
			</div>
			<div>
				<label>비밀번호 확인</label><input type="password" name="user_pwre" placeholder="비밀번호 확인" required>
			</div>
			<div>
				<label>이름</label><input type="text" name="nm" placeholder="이름" value="${tempData.getUser_nm()}" required>
			</div>
			<div>
				<button type="submit">SUBMIT</button>
			</div>
		</form>
		<div>
			<a class="btn" href="/user/login"><button>로그인 화면으로</button></a>
		</div>
	</div>
</div>
