package com.kor.java.ssg.controller;

import com.kor.java.ssg.dto.Member;

public abstract class Controller {
	public static Member loginedMember; // 로그인 된 맴버

	public abstract void doAction(String command, String actionMethodName);
	public abstract void makeTestData();
	public boolean isLogined() {
		return loginedMember != null;
	}
}
