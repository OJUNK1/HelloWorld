package co.ojun.firstproject.menu;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.ojun.firstproject.product.service.ProductService;
import co.ojun.firstproject.product.service.ProductVO;
import co.ojun.firstproject.product.serviceImpl.ProductServiceImpl;
import co.ojun.firstproject.stock.service.StockService;
import co.ojun.firstproject.stock.service.StockVO;
import co.ojun.firstproject.stock.serviceImpl.StockServiceImpl;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	private ProductService ps = new ProductServiceImpl();
	private StockService ss = new StockServiceImpl();

	private void mainTitle() {
		System.out.println("===Product Management===");
		System.out.println("==1. Product Info==");
		System.out.println("==2. Receive & Shipping==");
		System.out.println("==3. Quit==");
		System.out.println("= 원하는 메뉴 선택 =");

	}

	private void productTitle() {
		System.out.println("==== 제품정보관리 ====");
		System.out.println("= 1. 제품 전체 조회 =");
		System.out.println("= 2. 단일 제품 조회 =");
		System.out.println("= 3. 제품 등록 =");
		System.out.println("= 4. 제품 삭제 =");
		System.out.println("= 5. 제품 수정 =");
		System.out.println("= 6. 제품 관리 종료");
		System.out.println("=================");
		System.out.println("= 원하는 메뉴 선택 =");
	}

	private void productManage() {
		boolean run = false;
		do {
			productTitle();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				productListAll();
				break;
			case 2:
				productSelect();
				break;
			case 3:
				productInsert();
				break;

			case 4:
				productDelete();
				break;

			case 5:
				productEdit();
				break;

			case 6:
				run = true;
				System.out.println("제품관리 종료");
				break;
			}

		} while (!run);
	}

	private void stockTitle() {
		System.out.println("==== 제품재고관리 ====");
		System.out.println("= 1. 전체 거래 내역 조회 =");
		System.out.println("= 2. 단일 상품 거래 내역 조회 =");
		System.out.println("= 3. 제품 입출고 내역 등록 =");
		System.out.println("==================");
		System.out.println("= 원하는 메뉴 선택 =");
	}

	private void stockManage() {
		boolean run = false;
		do {
			stockTitle();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				transactionListAll();
				break;
			case 2:
				transactionSelect();
				break;

			case 3:
				transactionSelectByDate();
				break;

			case 4:

				break;
			case 5:
				run = true;
				System.out.println("재고관리 종료");
				break;
			}
		} while (!run);
	}

	private void productListAll() { // 제품 전체 조회
		List<ProductVO> products = new ArrayList<ProductVO>();
		products = ps.productListAll();

		if (!products.isEmpty()) {
			for (ProductVO product : products) {
				product.toString();
			}
		} else {
			System.out.println("제품이 하나도 존재하지 않습니다."); // 제품 없을때 확인
		}
	}

	private void productSelect() { // 단일 제품 조회
		ProductVO product = new ProductVO();
		System.out.println("== 조회할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		product = ps.productSelect(product);
		if (product.getProductCode() != null) {
			product.toString();
		} else {
			System.out.println("존재하지 않는 제품입니다. ==");
		}
	}

	private void productInsert() { // 상품 등록
		System.out.println("== 등록할 제품의 코드를 입력 ==");
		sc.nextLine();
		String code = sc.nextLine();
		System.out.println("== 등록할 제품의 제품명을 입력 ==");
		String name = sc.nextLine();
		System.out.println("== 등록할 제품의 가격을 입력 ==");
		int price = sc.nextInt();
		System.out.println("== 등록할 제품에 대한 정보를 입력 ==");
		sc.nextLine();
		String details = sc.nextLine();

		ProductVO product = new ProductVO(code, name, price, details);
		int products = ps.productInsert(product);

		if (products != 0) {
			System.out.println("제품등록 완료");
		} else {
			System.out.println("제품등록 실패");
		}
	}

	private void productDelete() {
		ProductVO product = new ProductVO();
		System.out.println("== 삭제할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		int products = ps.productDelete(product);

		if (products != 0) {
			System.out.println("제품삭제 완료");
		} else {
			System.out.println("제품삭제 실패");
		}

	}

	private void productEdit() {
		ProductVO product = new ProductVO();
		System.out.println("== 수정할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		System.out.println("== 변경된 금액을 입력하세요. ==");
		int price = sc.nextInt();
		product.setProductPrice(price);

		int products = ps.productEdit(product);
		if (products != 0) {
			System.out.println("제품수정 완료");
		} else {
			System.out.println("제품수정 실패");
		}
	}

	private void transactionListAll() {
		List<StockVO> stocks = new ArrayList<StockVO>();
		stocks = ss.transactionListAll();

		if (!stocks.isEmpty()) {
			for (StockVO stock : stocks) {
				stock.toString();
			}
		} else {
			System.out.println("재고 항목에 등록된 정보가 존재하지 않습니다");
		}
	}

	private void transactionSelect() {
		StockVO stock = new StockVO();
		System.out.println("== 거래내역을 조회할 제품의 제품 코드를 입력하세요. ==");
		String code = sc.nextLine();
		stock.setProductCode(code);
		stock = ss.transactionSelect(stock);
		if (stock.getProductCode() != null) {
			stock.toString();
		} else {
			System.out.println("존재하지 않는 제품입니다. ==");
		}
	}

	private void transactionSelectByDate() {
		StockVO stock = new StockVO();

		System.out.println("조회할 날짜 시작일을 입력하세요.(yyyy-MM-dd) ==");
		String startDate = sc.nextLine();
		sc.nextLine();
		System.out.println("조회할 날짜 말일을 입력하세요. (yyyy-MM-dd) ==");
		String endDate = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sdf.format(startDate);
		String edate = sdf.format(endDate);
		java.sql.Date sqlDateS = java.sql.Date.valueOf(sdate);
		java.sql.Date sqlDateE = java.sql.Date.valueOf(edate);
		stock.setStockDate(sqlDateS);
		stock.setStockDate(sqlDateE);
		stock = ss.transactionSelectByDate(stock);
		if (stock.getProductCode() != null) {
			stock.toString();
		} else {
			System.out.println("에러");
		}

	}

	private void inAndOutProduct() {
		System.out.println("입출고 내역을 등록할 제품의 코드를 입력 . ==");
		String code = sc.nextLine();

	}

	public void run() {
		boolean run = false;
		do {
			mainTitle();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				productManage();
				break;
			case 2:
				stockManage();
				break;

			case 3:
				System.out.println("Product Management 종료");
				run = true;
				break;
			}
		} while (!run);

		sc.close();
	}
}
