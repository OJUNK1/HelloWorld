package co.yedam.product2.H20230725.src.co.yedam.product;

import java.io.Serializable;

public class Purchase implements Serializable{
	private int purchaseStock = 0;
	private String purchaseDate = null;

	public Purchase(int purchaseStock, String purchaseDate) {
		super();
		this.purchaseStock = purchaseStock;
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchaseStock() {
		return purchaseStock;
	}

	public void setPurchaseStock(int purchaseStock) {
		this.purchaseStock = purchaseStock;
	}
	
	public void addStock(int stock) {
		purchaseStock += stock;
	}
	
	@Override
	public String toString() {
		return " 구매수량: " + purchaseStock + ", 구매일: " + purchaseDate;
	}
}
