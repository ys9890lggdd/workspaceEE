package com.itwill.user;

public interface UserService {

	/*
	 * 회원가입
	 */
	int create(User user) throws Exception;

	int login(String userId, String password) throws Exception;

	/*
	 * 회원상세보기
	 */
	User findUser(String userId) throws Exception;

	/*
	 * 회원수정
	 */
	int update(User user) throws Exception;

	/*
	 * 회원탈퇴
	 */
	int remove(String userId) throws Exception;

}