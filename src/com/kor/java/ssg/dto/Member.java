package com.kor.java.ssg.dto;

public class Member extends dto{
	public String loginId;
	public String loginIdPw;
	public String name;
	
	public Member(int id, String regDate, String loginId, String loginIdPw, String name) {
		this.id = id;
		this.regDate = regDate;
		this.loginId = loginId;
		this.loginIdPw = loginIdPw;
		this.name = name;
	}
}
