package co.ojun.firstproject.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int productQuantity;

	@Override
	public String toString() {
		return " [ productCode : " + productCode + ", productName: " + productName + ", productPrice: " + productPrice
				+ ", productDescription: " + productDescription + ", productQuantity: " + productQuantity + " ]";
	}
}
