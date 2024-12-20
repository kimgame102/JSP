package com.app.jdbc.product.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.product.dao.ProductDAO;
import com.app.jdbc.product.vo.ProductVO;

public class ProductRead extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		String input = req.getParameter("id");
		Long id = Long.valueOf(input);
		ProductVO productVO = productDAO.selectById(id);
		req.setAttribute("product", productVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}

}
