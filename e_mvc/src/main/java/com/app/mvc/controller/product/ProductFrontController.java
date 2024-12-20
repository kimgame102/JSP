package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Result;

// .product로 끝나는 모든 요청을 처리해주는 FrontController
public class ProductFrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 모든 GET 요청을 POST 메서드로 처리
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // 요청 URI를 가져옴
	    String uri = req.getRequestURI();
	    Result result = null;
	    // 컨텍스트 경로를 제외한 URI 부분을 추출하고 ".product" 확장자를 제거
	    String target = uri.substring(req.getContextPath().length());
	    target = target.split("\\.")[0];

	    if (target.equals("/write")) {
	        result = new Result();
	        result.setPath("write.jsp");
	    } else if (target.equals("/write/ok")) {
	        result = new WriteOkController().execute(req, resp);
	    } else if (target.equals("/list")) {
	        result = new ListController().execute(req, resp);
	    } else if (target.equals("/read")) {
	        result = new ReadController().execute(req, resp);
	    } else if (target.equals("/update")) {
	        // ReadController를 호출하여 productVO 설정 후 update.jsp로 포워딩
	        Result readResult = new ReadController().execute(req, resp);
	        // ReadController의 결과에서 제품 정보를 얻었으므로 update.jsp로 포워딩
	        result = new Result();
	        result.setPath("update.jsp");
	    } else if (target.equals("/update/ok")) {
	        result = new UpdateController().execute(req, resp);
	    }
	     else if (target.equals("/delete")) {
	         result = new DeleteController().execute(req, resp);
	     }

	    if(result != null) {
	        if(result.isRedirect()) {
	            resp.sendRedirect(req.getContextPath() + result.getPath());
	        } else {
	            req.getRequestDispatcher(result.getPath()).forward(req, resp);
	        }
	    }
	}

}

