package co.yedam.product2.H20230725.src.co.yedam.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductManager {
	private List<Product> products = new ArrayList<Product>();

	public ProductManager() {
		load();
	}

	// 상품등록 - 상품코드, 상품명, 상품가격
	public boolean addProduct(Product product) {
		return products.add(product);
	}

	// 판매관리 - 상품코드, 판매수량, 판매일
	public boolean saleProduct(String no, String stock) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);

		return saleProduct(no, Integer.parseInt(stock), date);
	}

	public boolean saleProduct(String no, String stock, String date) {
		return saleProduct(no, Integer.parseInt(stock), date);
	}

	public boolean saleProduct(String no, int stock, String date) {
		int idx = getNoToIndex(no);
		if (idx == -1) {
			return false;
		}

		return products.get(idx).addSale(stock, date);
	}
	// 판매관리 end

	// 구매관리 - 상품코드, 구매수량, 구매일
	public boolean purchaseProduct(String no, String stock) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);

		return purchaseProduct(no, Integer.parseInt(stock), date);
	}

	public boolean purchaseProduct(String no, String stock, String date) {
		return purchaseProduct(no, Integer.parseInt(stock), date);
	}

	public boolean purchaseProduct(String no, int stock, String date) {
		int idx = getNoToIndex(no);
		if (idx == -1) {
			return false;
		}

		products.get(idx).addPurchase(stock, date);
		return true;
	}
	// 구매관리 end

	public List<Product> getProductList() {
		return products;
	}

	public Product getProduct(String no) {
		int idx = getNoToIndex(no);
		if (idx == -1) {
			return null;
		}

		return products.get(idx);
	}

	public int getNoToIndex(String no) {
		for (int i = 0; i < products.size(); ++i) {
			if (products.get(i).getNo().equals(no)) {
				return i;
			}
		}
		return -1;
	}

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/products.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			products = (List<Product>) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {
			//
		}
	}

	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/products.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(products);

			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
