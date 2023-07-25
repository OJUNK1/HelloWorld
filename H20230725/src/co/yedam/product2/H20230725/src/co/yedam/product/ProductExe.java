package co.yedam.product2.H20230725.src.co.yedam.product;

import java.util.List;
import java.util.Scanner;

public class ProductExe {
	public static void main(String[] args) {
		String str;
		String[] data;
		boolean isSuccess;
		String result;
		
		Scanner scn = new Scanner(System.in);
		boolean isLoop = true;
		ProductManager manager = new ProductManager();

		while (isLoop) {
			System.out.println("1.상품등록 2.판매 3.구매 4.상품목록 5.재고현황 6.종료");

			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				continue;
			}
		
			switch (menu) {
			case 1:
				System.out.println("입력(상품코드 상품명 가격)>>");
				do {
					str = scn.nextLine();
					data = str.split(" ");
					
					if (data.length != 3) {
						System.out.println("입력오류, 재입력>>");
					}
				}while(data.length != 3);
				
				isSuccess = manager.addProduct(new Product(data[0], data[1], data[2]));

				result = (isSuccess) ? "성공" : "실패";
				System.out.println("**" + "등록" + result + "**");
				
				break;
			case 2:
				System.out.println("입력(상품코드 판매수량 판매일)>>");
				str = scn.nextLine();
				data = str.split(" ");

				if (data.length == 2) {
					isSuccess = manager.saleProduct(data[0], data[1]);
				} else if (data.length == 3) {
					isSuccess = manager.saleProduct(data[0], data[1], data[2]);
				} else {
					continue;
				}
				
				result = (isSuccess) ? "성공" : "실패";
				System.out.println("**" + "판매" + result + "**");
				
				break;
			case 3:
				System.out.println("입력(상품코드 구매수량 구매일)>>");
				str = scn.nextLine();
				data = str.split(" ");

				if (data.length == 2) {
					isSuccess = manager.purchaseProduct(data[0], data[1]);
				} else if (data.length == 3){
					isSuccess = manager.purchaseProduct(data[0], data[1], data[2]);
				} else {
					continue;
				}

				result = (isSuccess) ? "성공" : "실패";
				System.out.println("**" + "구매(입고)" + result + "**");
				
				break;
			case 4:
				List<Product> products = manager.getProductList();
				for (Product p : products) {
					System.out.println(p);
				}
				break;
			case 5:
				System.out.println("입력(상품코드)>>");
				String no = scn.nextLine();

				Product product = manager.getProduct(no);
				if (product == null) {
					System.out.println("상품을 찾을 수 없습니다.");
					continue;
				}

				System.out.println(product);

				System.out.println();
				System.out.println("*판매정보*");
				printDetailInfo(true, product);
				System.out.println();
				System.out.println("*구매정보*");
				printDetailInfo(false, product);

				break;
			case 6:
				manager.save();
				isLoop = false;
				break;
			default:
				System.out.println("올바른 메뉴가 아닙니다.");
			}
		} // end of while
		
		System.out.println("end of prog");
	} // end of main

	public static void printDetailInfo(boolean isSale, Product p) {
		System.out.println("----------------------------------------");
		for (Object o : (isSale) ? p.getSaleInfo() : p.getPurchaseInfo()) {
			System.out.println(o);
		}
		System.out.println("----------------------------------------");
	}
}
