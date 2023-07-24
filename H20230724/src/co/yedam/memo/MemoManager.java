package co.yedam.memo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {

	Scanner scn = new Scanner(System.in);
	List<Memo> memoStorage = new ArrayList<>();

	public MemoManager() {
		readFromFile();
	}

	// 메뉴 출력.
	public void printMenu() {
		System.out.println("1.등록 2.검색 3.삭제 4.종료");
		System.out.println("메뉴 선택> ");
	}

	private int getNextNo() {
		int no = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() > no) {
				no = memoStorage.get(i).getNo();
			}
		}
		return no + 1;
	}

	// 등록.
	public void inputData() {
		int no = getNextNo();
		System.out.println("날짜>> ");
		String date = scn.nextLine();
		System.out.println("내용>> ");
		String content = scn.nextLine();

		Memo memo = null;
		if (date.isEmpty()) {
			memo = new Memo(no, content);
			
		} else {
			memo = new Memo(no, date, content);
		
		}
		if (memoStorage.add(memo)) {
			System.out.println("정상 등록");
		} else {
			System.out.println("등록 오류");
		}
	} // end of inputData();

	public void searchData() {
		System.out.println("날짜>> ");
		String date = scn.nextLine();
		// 입력된 날짜의 메모를 출력.
		for (Memo memo : memoStorage) {
			if (memo.getDate().equals(date)) {
				System.out.println(memo.toString());				
			} else {
				System.out.printf("%s에 등록한 메모가 없습니다 \n", date);
				break;
			}
		}
	}

	public void deleteData() {
		System.out.println("번호>> ");
		int no = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() == no) {
				Object obj = memoStorage.get(i);
				memoStorage.remove(i);
				System.out.println("삭제완료");
			} else {
				System.out.println("삭제에 실패했습니다");
				break;
			}
		}
	}

	public void storeToFile() {
		// 출력스트림. 객체를 담아야함
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/memo.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(memoStorage);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/memo.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			memoStorage = (List<Memo>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
}
