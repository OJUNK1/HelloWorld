package co.yedam.memo;

import java.util.Scanner;

public class MemoApp {
	public static void main(String[] args) {
		MemoManager manager = new MemoManager();
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		int menu = -1;

		while (run) {
			manager.printMenu();
			menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				manager.inputData();
			} else if (menu == 2) {
				manager.searchData();
			} else if (menu == 3) {
				manager.deleteData();
			} else if (menu == 4) {
				System.out.println("종료버튼");
				manager.storeToFile();
				run = false;
			}
		}

		System.out.println("end of prog.");
		scn.close();
	}

}
