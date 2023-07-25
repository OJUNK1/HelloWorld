package co.yedam.product;

import java.io.Serializable;

public class Product implements Serializable {
	String productNum;
	String name;
	String saleDate;
	String purchaseDate;
	int price;
	int saleQuantity;
	int purchaseQuantity;
	int stock;

	public Product(String productNum, String name, int price) { // 상품등록
		this.productNum = productNum;
		this.name = name;
		this.price = price;
	}

	public Product(String productNum, int quantity, String date, boolean isSale) { // 판매관리
		if (isSale) {
			this.productNum = productNum;
			this.saleQuantity = quantity;
			this.saleDate = date;
		} else {
			this.productNum = productNum;
			this.purchaseQuantity = quantity;
			this.purchaseDate = date;
		}
	}

	public Product(int stock) {
		this.stock = stock;
	}

	public Product() {
		
	}

	@Override
	public String toString() {
		return "상품코드: " + productNum + ", 상품명: " + name + ", 판매수량: " + saleQuantity + ", 판매날짜: " + saleDate + ", 구매수량: "
				+ purchaseQuantity + ", 구매날짜: " + purchaseDate + ", 재고수량: " + stock;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleQuantity() {
		return saleQuantity;
	}

	public void setSaleQuantity(int saleQuantity) {
		this.saleQuantity = saleQuantity;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	// 재고 업데이트
	public void updateStock() {
		stock = purchaseQuantity - saleQuantity;
		if(stock < 0) {
			System.out.println("구매수량보다 판매수량이 더 많습니다.");
		}
	}

}
