/**
 * 
 */
function userCreate() {
	f.action = "user_write_form.jsp";
	f.submit();
}

function login() {
	if (document.f.userId.value == "") {
		alert("사용자 아이디를 입력하십시요.");
		f.userId.focus();
		return false;
	}
	if (document.f.password.value == "") {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return false;
	}

	document.f.method = "POST";
	document.f.action = "user_login_action.jsp";
	document.f.submit();
}