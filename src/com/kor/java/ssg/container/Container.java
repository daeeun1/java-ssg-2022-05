package com.kor.java.ssg.container;

import com.kor.java.ssg.dao.ArticleDao;
import com.kor.java.ssg.dao.MemberDao;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	
	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
	}
}
