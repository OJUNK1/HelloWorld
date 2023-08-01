package co.ojun.firstproject.product.service;

import java.util.List;

public interface ProductService { // CRUD
	List<ProductVO> productListAll(); // 전체조회

	ProductVO productSelectByCode(ProductVO vo); // 상품 코드로 조회
	
	ProductVO productSelectByName(ProductVO vo); // 상품 이름으로 조회
	
	int productInsert(ProductVO vo); // 상품 등록

	int productDelete(ProductVO vo); // 상품 삭제

	int productEditPrice(ProductVO vo); // 상품가격 변경
	
	int productEditName(ProductVO vo); // 상품이름 변경
	
	int productEditDescription(ProductVO vo); //상품설명 변경
}
