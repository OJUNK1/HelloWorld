package co.yedam.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
	List<Product> products = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	public ProductManage() {
		readFromFile();
	}
	// 재고 업데이트

	// 상품등록
	boolean productR(Product product) {
		if (products.add(product)) {
			return true;
		}
		return false;
	}

	// 판매관리
	boolean salesManage(String productNum, int quantity, String date) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum().equals(productNum)) {
				products.get(i).setSaleQuantity(quantity);
				products.get(i).setSaleDate(date);
				return true;
			}
		}
		return false;
	}

	// 구매관리
	boolean purchaseManage(String productNum, int quantity, String date) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum().equals(productNum)) {
				products.get(i).setPurchaseQuantity(quantity);
				products.get(i).setPurchaseDate(date);
				return true;
			}
		}
		return false;
	}

	// 재고관리
	boolean stockManage(String productNum) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNum().equals(productNum)) {
				products.get(i).setStock(products.get(i).getPurchaseQuantity() - products.get(i).getSaleQuantity());
				System.out.println("현재 재고> " + products.get(i).getStock() + "개입니다.");
				return true;
			}
		}
		return false;
	}

	// 조회
	public void searchProduct() {
		System.out.println("상품코드 입력>> ");
		String productNum = scn.nextLine();
		int Count = 0;
		for (Product product : products) {
			if (product.getProductNum().equals(productNum)) {
//				product.setStock(product.getPurchaseQuantity() - product.getSaleQuantity());
				product.updateStock();
				System.out.println(product.toString());
				Count++;
			}
		}
		if (Count == 0) {
			System.out.printf("상품코드 %s은 없는 상품입니다.\n", productNum);
		}
	}

	// 출력스트림.
	public void storeToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/product.txt");
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

	// 입력스트림.
	public void readFromFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/product.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			products = (List<Product>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
