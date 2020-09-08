
function chk() {
	if (frm.user_id.value.length < 5) {
		alert('아이디는 5글자 이상이 되어야합니다.');
		frm.user_id.focus();
		return false;
	}
	if (frm.user_pw.value.length < 8) {
		alert('비밀번호는 8글자 이상이 되어야합니다.');
		frm.user_pw.focus();
		return false;
	}
	if (frm.user_pw.value != frm.user_pwre.value) {
		alert('비밀번호가 같지 않습니다.');
		frm.user_pwre.focus();
		return false;
	}
	if (frm.nm.value.length > 0) {
		const korean = /[^가-힣]/;
		if (korean.test(frm.nm.value)) {
			alert('이름은 한글만 사용해주세요.')
			frm.nm.focus();
			return false;
		}
	}
	if (frm.email.value.length > 0) {
		const email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (!email.test(frm.email.value)) {
			alert('이메일 형식에 맞춰서 입력해주세요.')
			frm.eamil.focus();
			return false;
		}
	}
}