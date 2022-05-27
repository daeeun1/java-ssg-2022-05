package com.kor.java.ssg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kor.java.ssg.dto.Article;
import com.kor.java.ssg.dto.Member;
import com.kor.java.ssg.util.Util;

public class MemberController extends Controller {
	
	private List<Member> members;
	private Scanner sc;
	private String command;
	private String actionMethodName;
	
	public MemberController( Scanner sc){
		this.sc = sc;
		
		members = new ArrayList<Member>();
	}
	
	@Override
	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;
		
		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default :
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
		
	}
	
	private void doLogout() {
		if (isLogined() == false) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		
		loginedMember = null;
		System.out.println("로그아웃 되었습니다.");
	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexById(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}
	
	public int getMemberIndexById(String loginId) {
		int i = 0;
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}
		}

		return -1;
	}
	
	public Member getMemberById(String loginId) {
		int index = getMemberIndexById(loginId);

		if (index == -1) {
			return null;
		}
		
		return members.get(index);
	}
	
	public void makeTestData() {
		System.out.println("테스트를 위한 회원데이터를 생성합니다.");

		members.add(new Member(1, Util.getNowDateStr(), "admin", "admin", "관리자"));
		members.add(new Member(2, Util.getNowDateStr(), "user1", "user1", "유저1"));
		members.add(new Member(3, Util.getNowDateStr(), "user2", "user2", "유저2"));
	}

	private void doLogin() {
		if (isLogined() ) {
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		System.out.printf("로그인 아이디 : ");
		String loginId = sc.nextLine();
		System.out.printf("로그인 비번 : ");
		String loginIdPw = sc.nextLine();
		
		Member member = getMemberById(loginId);
		
		if (member == null) {
			System.out.println("해당회원은 존재하지 않습니다.");
			return;
		}
		
		if (member.loginIdPw.equals(loginIdPw) == false) {
			System.out.println("비밀번호를 확인해주세요.");
			return;
		}
		
		loginedMember = member;
		System.out.printf("로그인 성공!, %s님 환영합니다.\n", loginedMember.name);
		
	}
	
	public void doJoin() {

		int id = members.size() + 1;
		String regDate = Util.getNowDateStr();
		String loginId = null;

		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n", loginId);
				continue;
			} else {
				break;
			}
		}

		String loginIdPw = null;
		String loginIdPwConfirm = null;

		while (true) {
			System.out.printf("로그인 비번 : ");
			loginIdPw = sc.nextLine();
			System.out.printf("로그인 비번확인 : ");
			loginIdPwConfirm = sc.nextLine();

			if (loginIdPw.equals(loginIdPwConfirm)) {
				break;
			}
			System.out.println("비밀번호를 다시 입력해주세요.");
		}

		System.out.printf("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, loginId, loginIdPw, name);
		members.add(member);

		System.out.printf("%d번 글이 생성되었습니다.\n", id);
	}

	
}
