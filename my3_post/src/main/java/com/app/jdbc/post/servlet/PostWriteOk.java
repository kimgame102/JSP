package com.app.jdbc.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.post.dao.PostDAO;
import com.app.jdbc.post.vo.PostVO;


public class PostWriteOk extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String postTitle = req.getParameter("postTitle");
		int postLiked = Integer.parseInt(req.getParameter("postLiked"));
		PostVO userVO = new PostVO();
		PostDAO postDAO = new PostDAO();
		
		userVO.setPostTitle(postTitle);
		userVO.setPostLiked(postLiked);
		
		postDAO.insert(userVO);
		
		resp.sendRedirect(req.getContextPath()+"/list");
	}
}