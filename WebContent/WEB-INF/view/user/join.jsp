<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="sectionContainerCenter">
	<div>
		<div class="err">${Err}</div>
		<form class="frm" id="frm" action="/user/joinProc" method="post" onsubmit="return chk()">
		<div id="idChkResult" class="msg"></div>
			<div>
				<label>아이디</label><input type="text" name="user_id" placeholder="아이디" value="${tempData.getUser_id()}" required>
				<button type="button" onclick="chkId()">중복확인</button>
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
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
function chkId(){
	const user_id = frm.user_id.value
	
	if (frm.user_id.value.length < 5) {
		alert('아이디는 5글자 이상이 되어야합니다.');
		frm.user_id.focus();
		return;
	}
	
	axios.get('/user/chkIdProc',{
		params:{
			user_id
			}
	}).then(function(res){
		console.log(res)
		if(res.data.result == 2){
			idChkResult.innerText = '이미 사용중인 아이디입니다.'
		}else if (res.data.result == 0){
			idChkResult.innerText = '사용가능한 아이디입니다.'
		}
	});
}
</script>