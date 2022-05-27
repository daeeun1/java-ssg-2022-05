package com.kor.java.ssg;

import java.util.Scanner;

import com.kor.java.ssg.controller.ArticleController;
import com.kor.java.ssg.controller.Controller;
import com.kor.java.ssg.controller.MemberController;

public class App {
	
	public void start() {
		System.out.println("== 프로그램 시작 ==");
		

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);

		articleController.makeTestData();
		memberController.makeTestData();
		
		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine();

			command = command.trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}
			
			String[] commandBits = command.split(" "); // article detail
			
			if (commandBits.length == 1) {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
			
			String controllerName = commandBits[0];
			String actionMethodName = commandBits[1];

			Controller controller = null;
			
			if (controllerName.equals("article")) {
				controller = articleController;
			}
			else if (controllerName.equals("member")) {
				controller = memberController;
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다.\n");
				continue;
			}
			controller.doAction(command, actionMethodName);
		}

		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}

	
}
