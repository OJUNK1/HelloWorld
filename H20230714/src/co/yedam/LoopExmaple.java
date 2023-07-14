package co.yedam;

public class LoopExmaple {
	public static void main(String[] args) {
		// 76800원 > 5만원 1장, 1만원 2장, 5천원 1장, 천원 1장, 500원 1개, 100원 3개
		int value = ((int) (Math.random() * 50000 / 100)) * 100 + 50000; // 5만 이상
		
		int oman = 50000;
		int man = 10000;
		int ocheon = 5000;
		int cheon = 1000;
		int obaek = 500;
		int baek = 100;
		String result = "";

		int div50 = Math.round(value / oman);
		int div10 = Math.round((value - div50 * oman) / man);
		int div5 = Math.round((value - div50 * oman - div10 * man) / ocheon);
		int div1 = Math.round((value - div50 * oman - div10 * man - div5 * ocheon) / cheon);
		int div05 = Math.round((value - div50 * oman - div10 * man - div5 * ocheon - div1 * cheon) / obaek);
		int div01 = Math
				.round((value - div50 * oman - div10 * man - div5 * ocheon - div1 * cheon - div05 * obaek) / baek);

		result = value + "값은 50000원 " + div50 + "장 " + "10000원 " + div10 + "장 " + "5000원 " + div5 + "장" + " 1000원 "
				+ div1 + "장" + " 500원 " + div05 + "개" + " 100원 " + div01 + "개입니다";
		System.out.println(result);
	}

}

// int value = ((int) (Math.random() * 50000 / 100)) * 100 + 50000;
// int won = 50000;
// String result = value + "원은";
//int paperCnt =0, remainAmt = 0;
//for (int i =0; value > 0; i++) {
//	paperCnt = value /won;                                      
//	remainAmt = value - (won * paperCnt);                      
//	result += won + "원" + paperCnt + "장";
//	value = remainAmt;
// 50000 -> 10000 -> 5000 -> 1000 -> 500 -> 100  	//i가 0일 때, won은 50000이므로 won / 5를 통해 10000으로 변경됩니다.
													//i가 1일 때, won은 10000이므로 won / 2를 통해 5000으로 변경됩니다.
													//i가 2일 때, won은 5000이므로 won / 5를 통해 1000으로 변경됩니다.
													//i가 3일 때, won은 1000이므로 won / 2를 통해 500으로 변경됩니다.
													//i가 4일 때, won은 500이므로 won / 5를 통해 100으로 변경됩니다.
													//i가 5일 때, won은 100이므로 won / 2를 통해 50으로 변경됩니다.
//	if (i % 2 == 0 ) {
//		won = won /5;		
//	} else {
//		won = won /2;
//	}
//}
//System.out.println(result);