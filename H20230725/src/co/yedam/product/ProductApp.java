package co.yedam.product;

import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {
		Product product = new Product();
		ProductManage productm = new ProductManage();
		String productNum = "";
		String name = "";
		String saleDate = "";
		String purchaseDate = "";
		int price = 0;
		int saleQuantity = 0;
		int purchaseQuantity = 0;
		int stock = 0;
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.상품등록, 2.판매관리, 3.구매관리, 4.현재재고 5.종료");
			System.out.println("메뉴를 입력> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("상품등록을 진행하겠습니다");
				System.out.println("상품코드를 입력> ");
				productNum = scn.nextLine();
				System.out.println("상품명을 입력> ");
				name = scn.nextLine();
				System.out.println("상품가격을 입력> ");
				price = Integer.parseInt(scn.nextLine());
				Product products = new Product(productNum, name, price);
				boolean result = productm.productR(products);
				if (result) {
					System.out.println("상품등록에 성공.");
				} else {
					System.out.println("상품등록에 실패.");
				}
			} else if (menu == 2) {
				System.out.println("판매관리를 진행하겠습니다");
				System.out.println("상품코드를 입력> ");
				productNum = scn.nextLine();
				System.out.println("해당 상품의 판매수량을 입력> ");
				saleQuantity = Integer.parseInt(scn.nextLine());
				System.out.println("해당 상품의 판매일을 입력> ");
				saleDate = scn.nextLine();
				boolean result = productm.salesManage(productNum, saleQuantity, saleDate);
				if (result) {
					System.out.println("등록완료");
				} else {
					System.out.println("상품코드를 정확히 입력하세요");
				}

			} else if (menu == 3) {
				System.out.println("구매관리를 진행하겠습니다");
				System.out.println("상품코드를 입력> ");
				productNum = scn.nextLine();
				System.out.println("해당 상품의 구매수량을 입력> ");
				purchaseQuantity = Integer.parseInt(scn.nextLine());
				System.out.println("해당 상품의 구매일을 입력> ");
				purchaseDate = scn.nextLine();
				boolean result = productm.purchaseManage(productNum, purchaseQuantity, purchaseDate);
				if (result) {
					System.out.println("등록완료");
				} else {
					System.out.println("등록실패");
				}
			} else if (menu == 4) {
				System.out.println("현재재고를 확인하겠습니다");
				System.out.println("상품코드를 입력> ");
				productNum = scn.nextLine();
				boolean result = productm.stockManage(productNum);
				if (result) {

				} else {
					System.out.println("등록되지 않은 상품코드입니다.");
				}
			} else if (menu == 5) {
				System.out.println("종료버튼입니다");
				productm.storeToFile();
				run = false;
			} else if (menu == 9) {
				productm.searchProduct();
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
