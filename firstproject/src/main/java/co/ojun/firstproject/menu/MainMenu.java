package co.ojun.firstproject.menu;

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
		System.out.println("==== Main Menu ====");
		System.out.println("1. 전체제품조회");
		System.out.println("2. 제품코드검색");
		System.out.println("3. 제품이름검색");
		System.out.println("4. 제품등록");
		System.out.println("5. 제품정보변경 메뉴");
		System.out.println("6. 제품삭제");
		System.out.println("7. 제품재고관리 메뉴");
		System.out.println("9. 프로그램 종료");
		System.out.println("===================");
		System.out.println("원하는 메뉴 선택>> ");

	}

	private void productEditTitle() {
		System.out.println("==== 제품정보변경메뉴 ====");
		System.out.println("1. 가격 변경");
		System.out.println("2. 제품명 변경");
		System.out.println("3. 제품 설명 변경");
		System.out.println("9. 메인메뉴로 돌아가기");
		System.out.println("=====================");
		System.out.println("원하는 메뉴 선택>> ");
	}

	private void productEditManage() {
		boolean run = false;
		do {
			productEditTitle();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				productEditPrice();
				break;
			case 2:
				productEditName();
				break;
			case 3:
				productEditDescription();
				break;
			case 9:
				run = true;
				System.out.println("제품정보변경 종료");
				break;
			}

		} while (!run);
	}

	private void stockTitle() {
		System.out.println("==== 제품재고관리메뉴 ====");
		System.out.println("1. 전체 거래내역조회 ");
		System.out.println("2. 제품별 거래내역조회 ");
		System.out.println("3. 기간별 거래내역조회 ");
		System.out.println("4. 입출고 거래입력 ");
		System.out.println("9. 메인메뉴로 돌아가기 ");
		System.out.println("=====================");
		System.out.println("원하는 메뉴 선택>> ");
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
				inAndOutProduct();
				break;
			case 9:
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

	private void productSelectByCode() { // 단일 제품 조회
		ProductVO product = new ProductVO();
		System.out.println("== 조회할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		product = ps.productSelectByCode(product);
		if (product.getProductName() != null) {
			product.toString();
		} else {
			System.out.println("잘못된 제품코드입니다. ");
		}
	}

	private void productSelectByName() { // 단일 제품 조회
		ProductVO product = new ProductVO();
		System.out.println("== 조회할 제품의 제품이름을 입력하세요. == ");
		sc.nextLine();
		String name = sc.nextLine();
		product.setProductName(name);
		product = ps.productSelectByName(product);
		if (product.getProductCode() != null) {
			product.toString();
		} else {
			System.out.println("잘못된 제품이름입니다.");
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
			System.out.println("제품삭제 실패. 제품코드를 정확히 입력하세요 ");
		}

	}

	private void productEditPrice() {
		ProductVO product = new ProductVO();
		System.out.println("== 수정할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		System.out.println("== 변경된 금액을 입력하세요. ==");
		int price = sc.nextInt();
		product.setProductPrice(price);
		int products = ps.productEditPrice(product);
		if (products != 0) {
			System.out.println("제품금액 수정 완료");
		} else {
			System.out.println("제품금액 수정 실패. 제품코드를 정확히 입력하세요");
		}
	}

	private void productEditName() {
		ProductVO product = new ProductVO();
		System.out.println("== 수정할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		System.out.println("== 변경된 제품명을 입력하세요. ==");
		String name = sc.nextLine();
		product.setProductName(name);
		int products = ps.productEditName(product);
		if (products != 0) {
			System.out.println("제품명 수정 완료");
		} else {
			System.out.println("제품명 수정 실패. 제품코드를 정확히 입력하세요");
		}
	}

	private void productEditDescription() {
		ProductVO product = new ProductVO();
		System.out.println("== 수정할 제품의 제품코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		product.setProductCode(code);
		System.out.println("== 변경된 제품 설명을 입력하세요. ==");
		String des = sc.nextLine();
		product.setProductDescription(des);
		int products = ps.productEditDescription(product);
		if (products != 0) {
			System.out.println("제품 설명 수정 완료");
		} else {
			System.out.println("제품 설명 수정 실패. 제품코드를 정확히 입력하세요");
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
			System.out.println("입출고내역이 존재하지 않습니다.");
		}
	}

	private void transactionSelect() {
		List<StockVO> stocks = new ArrayList<StockVO>();
		System.out.println("== 거래내역을 조회할 제품의 제품 코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();

		stocks = ss.transactionSelect(code);
		if (!stocks.isEmpty()) {
			stocks.toString();
		} else {
			System.out.println("잘못된 제품코드입니다.");
		}
	}

	private void transactionSelectByDate() {
		List<StockVO> stocks = new ArrayList<StockVO>();
		System.out.println("== 조회할 날짜 시작일을 입력하세요.\n형식: yyyy-mm-dd ==");
		String startDate = sc.next(); // nextLine으로 입력 시 엔터때문에 형식변환
		sc.nextLine();
		System.out.println("== 조회할 날짜 말일을 입력하세요. \n형식: yyyy-mm-dd ==");
		String endDate = sc.next();
		sc.nextLine();
		java.sql.Date sDate = java.sql.Date.valueOf(startDate);
		java.sql.Date eDate = java.sql.Date.valueOf(endDate);
		stocks = ss.transactionSelectByDate(sDate, eDate);
		if (!stocks.isEmpty()) {
			for (StockVO stockList : stocks) {
				stockList.toString();
			}
		} else {
			System.out.println("기간 내 입고, 출고 기록이 존재하지 않습니다.");
		}
	}

	private void inAndOutProduct() {
		System.out.println("== 입출고 내역을 입력할 제품의 코드를 입력하세요. ==");
		sc.nextLine();
		String code = sc.nextLine();
		System.out.println("== 입고이면 '+', 출고이면 '-'를 입력하세요. ==");
		String pm = sc.nextLine();

		if (pm.equals("+") || pm.equals("-")) {
			System.out.println("== 입출고량을 입력하세요. ==");
			int amount = sc.nextInt();
			System.out.println("== 거래날짜를 입력하세요. \n형식: yyyy-MM-dd ==");
			String tDate = sc.next();
			java.sql.Date transactionDate = java.sql.Date.valueOf(tDate);

			if (pm.equals("+")) {
				StockVO stock = new StockVO();
				stock.setProductCode(code);
				stock.setStockDate(transactionDate);
				stock.setStockIn(amount);
				stock.setStockOut(0);
				int currentStock = ss.getExistingStock(stock).getStock() + stock.getStockIn();
				stock.setStock(currentStock);
				int stocks = ss.inAndOutProduct(stock);
				if (stocks != 0) {
					System.out.println("등록 완료");
				} else {
					System.out.println("등록 실패");
				}
			}
			if (pm.equals("-")) {
				StockVO stock = new StockVO();
				stock.setProductCode(code);
				stock.setStockDate(transactionDate);
				stock.setStockOut(amount);
				stock.setStockIn(0);
				int currentStock = ss.getExistingStock(stock).getStock() - stock.getStockOut();
				stock.setStock(currentStock);

				if (ss.getExistingStock(stock).getStock() < amount) {
					System.out.println("상품의 재고가 부족합니다. (현재 재고 수량 : " + ss.getExistingStock(stock).getStock() + ")");
				} else {
					int stocks = ss.inAndOutProduct(stock);
					if (stocks != 0) {
						System.out.println("등록 완료");
					} else {
						System.out.println("등록 실패");
					}
				}
			}
		} else {
			System.out.println("형식이 틀렸습니다. 입고면 '+', 출고면 '-'를 입력하세요.");
		}
	}

	public void run() {
		boolean run = false;
		do {
			mainTitle();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				productListAll();
				break;
			case 2:
				productSelectByCode();
				break;
			case 3:
				productSelectByName();
				break;
			case 4:
				productInsert();
				break;
			case 5:
				productEditManage();
				break;
			case 6:
				productDelete();
				break;
			case 7:
				stockManage();
				break;
			case 9:
				System.out.println("Product Management 종료");
				run = true;
				break;
			}
		} while (!run);

		sc.close();
	}
}
