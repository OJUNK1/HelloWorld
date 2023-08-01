package co.ojun.firstproject.stock.service;

import java.sql.Date;

import lombok.Data;

@Data
public class StockVO {
	private String productCode;
	private int stock;
	private int stockIn;
	private int stockOut;
	private Date stockDate;

	public StockVO() {

	}

	public StockVO(String productCode, int stock, int stockIn, int stockOut, Date stockDate) {
		this.productCode = productCode;
		this.stock = stock;
		this.stockIn = stockIn;
		this.stockOut = stockOut;
		this.stockDate = stockDate;
	}

	@Override
	public String toString() {
		System.out.print("제품코드: " + productCode + " /  ");
		System.out.print("재고량: " + stock + "개" + " /  ");
		System.out.print("입고수량: " + stockIn + "개" + " /  ");
		System.out.print("출고수량: " + stockOut + "개" + " /  ");

		System.out.println("입출고 날짜 : " + stockDate);

		return null;
	}

}
