package co.yedam.api;

public class CheckGenderExe {
	public static void main(String[] args) {
		String[] numbers = { "9802031234567", "0502033234567", "980203-1234567", "980203-2234567", //
				"020203 3234567", "030203 2234567" };
		// 주민번호 뒷자리의 첫번째 값 (성별: 1,3 남자/ 2,4 여자)
		for (String num : numbers) {
			System.out.println(checkGender(num));
		}
	}

	static String checkGender(String no) {
		char case1 = no.charAt(6);
		char case2 = no.charAt(7);
		switch (case1) {
		case '1':
		case '3':
			return "남자";
		case '2':
		case '4':
			return "여자";
		case '-':
		case ' ':
			switch (case2) {
			case '1':
			case '3':
				return "남자";

			case '2':
			case '4':
				return "여자";
			}
			
		}
		return "에러";
	}
}
