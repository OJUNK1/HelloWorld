package co.yedam.product2.H20230725.src.co.yedam.product;

import java.io.Serializable;

public class Sale implements Serializable {
	private int saleStock = 0;
	private String saleDate = null;

	public Sale(int saleStock, String saleDate) {
		super();
		this.saleStock = saleStock;
		this.saleDate = saleDate;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public int getSaleStock() {
		return saleStock;
	}

	public void setSaleStock(int saleStock) {
		this.saleStock = saleStock;
	}

	public void addStock(int stock) {
		saleStock += stock;
	}

	@Override
	public String toString() {
		return " 판매수량: " + saleStock + ", 판매일: " + saleDate;
	}
}
