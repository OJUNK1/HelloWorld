package co.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {

		SimpleDateFormat sdf = //
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date today = new Date();

		// Date 객체 -> String 출력시 format 메소드 사용
		System.out.println(sdf.format(today));

		Date tday = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			tday = sdf.parse("2023-01-10 10:10:20");
			System.out.println(tday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String result = DateUtil.dateToStr(today);
		System.out.println(result);
		
		String result2 = DateUtil.dateToStr(today, "yyyy-MM-dd");
		System.out.println(result2);
		
		// 문자열(2023-03-05) -> Tue Mar 05 00:00:00 KST 2023
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date dday = DateUtil.strToDate("2023-03-05");
		System.out.println(dday);
		
	} // end main.

}
