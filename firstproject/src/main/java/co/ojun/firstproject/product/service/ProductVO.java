package co.ojun.firstproject.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode;
	private String productName;
	private int productPrice;
	private String productDescription;

	public ProductVO() {

	}

	public ProductVO(String code, String name, int price, String details) {
		this.productCode = code;
		this.productName = name;
		this.productPrice = price;
		this.productDescription = details;

	}

	@Override
	public String toString() {
		System.out.print("[ 제품코드: " + productCode + " || ");
		System.out.print("제품이름: " + productName + " || ");
		System.out.print("제품가격: " + productPrice + "원" + " || ");
		System.out.println("제품설명: " + productDescription + " ]");

		return null;
	}

}
