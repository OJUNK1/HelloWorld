package co.yedam.product2.H20230725.src.co.yedam.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
	private String no;
	private String name;
	private int price;
	private int stock;
	private List<Sale> saleInfo = new ArrayList<Sale>();
	private List<Purchase> purchaseInfo = new ArrayList<Purchase>();

	public Product(String no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}

	public Product(String no, String name, String price) {
		super();
		this.no = no;
		this.name = name;
		this.price = Integer.parseInt(price);
	}

	// getter & setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Sale> getSaleInfo() {
		return saleInfo;
	}

	public List<Purchase> getPurchaseInfo() {
		return purchaseInfo;
	}

	// getter & setter end

	public boolean addSale(int stock, String date) {
		if (this.stock - stock < 0) {
			System.out.println("**재고부족**");
			return false;
		}

		this.stock -= stock;
		return saleInfo.add(new Sale(stock, date));
	}

	public void addPurchase(int stock, String date) {
		this.stock += stock;
		purchaseInfo.add(new Purchase(stock, date));
	}

	@Override
	public String toString() {
		return "상품코드: " + no + ", 상품명: " + name + ", 재고: " + stock;
	}
}
