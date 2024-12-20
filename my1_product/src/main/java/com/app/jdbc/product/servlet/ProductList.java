package com.app.jdbc.product.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.product.dao.ProductDAO;
import com.app.jdbc.product.vo.ProductVO;

public class ProductList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		List<ProductVO> products = productDAO.selectAll();
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
		
	}
}
