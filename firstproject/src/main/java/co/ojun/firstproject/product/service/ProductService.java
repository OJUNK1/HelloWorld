package co.ojun.firstproject.product.service;

import java.util.List;

public interface ProductService { // CRUD
	List<ProductVO> productListAll(); // 전체조회

	ProductVO productSelect(ProductVO vo); // 단건조회

	int productInsert(ProductVO vo); // 상품 등록

	int productDelete(ProductVO vo); // 상품 삭제

	int productEdit(ProductVO vo); // 상품 수정

}
