package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Action;
import com.app.mvc.Result;
import com.app.mvc.domain.ProductVO;
import com.app.mvc.repository.ProductDAO;

public class UpdateController implements Action {

    @Override
    public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
        // ProductDAO 객체 생성
        ProductDAO productDAO = new ProductDAO();
        Result result = new Result();

        // 요청 파라미터에서 ID와 수정된 상품 정보를 가져오기
        Long id = Long.valueOf(req.getParameter("id"));
        String productName = req.getParameter("productName");
        int productPrice = Integer.parseInt(req.getParameter("productPrice"));

        // ProductVO 객체에 수정된 정보 설정
        ProductVO productVO = new ProductVO();
        productVO.setId(id);
        productVO.setProductName(productName);
        productVO.setProductPrice(productPrice);

        // 상품 정보 업데이트
        productDAO.update(productVO);

        // 성공적으로 업데이트된 후, 리스트 페이지로 리다이렉트
        result.setPath("/list.product");
        result.setRedirect(true);
        
        return result;
    }
}
