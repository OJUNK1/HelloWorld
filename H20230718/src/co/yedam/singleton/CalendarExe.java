package co.yedam.singleton;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	
		
		
		
		System.out.println("원하는 달력의 년도 입력 >");
		int y = Integer.parseInt(scn.nextLine());
		System.out.println("원하는 달력의 월을 입력>> ");
		int m = Integer.parseInt(scn.nextLine());
		showCal(y, m);
	}

	public static void showCal(int year, int month) {
//		System.out.println(Calendar.YEAR);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 2);

//		System.out.println("년도: " + cal.get(Calendar.YEAR));
//		System.out.println("월: " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("날짜: " + cal.get(Calendar.DATE));
//		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("말일: " + cal.getActualMaximum(Calendar.DATE));

		// coding here.. 달력그리기.

		String[] days = { "Sun", "Mon", " Tues", "Wed", "Thr", "Fri", "Sat" };

		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		int pos = firstDay;
		for (int i = 0; i < 7-pos; i++) {
			System.out.printf("%4s", "");
		}
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4s", i);
			if ((i + firstDay - 1) % 7 == 0) {
				System.out.println();
			}
		}
	}
}