package co.ojun.firstproject.stock.service;


import java.sql.Date;

import lombok.Data;

@Data
public class StockVO {
	private String productCode;
	private int stock00;
	private int stockIn;
	private int stockOut;
	private int stock99;
	private Date stockDate;

	public StockVO() {

	}

	public StockVO(String productCode, int stock00, int stockIn, int stockOut, int stock99, Date stockDate) {
		this.productCode = productCode;
		this.stock00 = stock00;
		this.stockIn = stockIn;
		this.stockOut = stockOut;
		this.stock99 = stock99;
		this.stockDate = stockDate;
	}

	@Override
	public String toString() {
		System.out.print("제품코드: " + productCode + " /  ");
		System.out.print("기초재고: " + stock00 + "개" + " /  ");
		System.out.print("입고수량: " + stockIn + "개" + " /  ");
		System.out.print("출고수량: " + stockOut + "개" + " /  ");
		System.out.println("기말재고: " + stock99 + "개" + " /  ");
		System.out.println("입출고 날짜 : " + stockDate);
		
		return null;
	}

}
