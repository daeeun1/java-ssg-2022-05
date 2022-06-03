package com.kor.java.ssg.container;

import com.kor.java.ssg.dao.ArticleDao;
import com.kor.java.ssg.dao.MemberDao;
import com.kor.java.ssg.service.ArticleService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	
	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
	}
}
