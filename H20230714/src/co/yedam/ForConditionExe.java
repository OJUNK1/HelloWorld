package co.yedam;

public class ForConditionExe {
	public static void main(String[] args) {
		showCalender(8);
	} // end of main()

	public static void showCalender(int month) {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" }; // 배열 선언

		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println(); // 줄 바꿈.
		// 1일의 위치 지정
		int pos = getFirstDay(month);
		for (int i = 0; i < pos; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = getLastDate(month);
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + pos) % 7 == 0) {
				System.out.println();
			}
		}
	}

	

	// 월 정보를 기입하면 해당월의 1일의 위치(공란을 반환)를 지정
	public static int getFirstDay(int month) {
		int pos = 1;

		switch (month) {
		case 5:
			pos = 1;
			break;
		case 6:
			pos = 4;
			break;
		case 7:
			pos = 6;
		case 8:
			pos = 2;
			break;

		}
		return pos;
	}

	// 월 정보를 기입하면 해당월의 마지막날을 반환.
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		case 2:
			lastDate = 28;
		}
		return lastDate;

	} // end of getlastDate

} // end of class
