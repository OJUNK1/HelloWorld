package co.yedam;

public class ConditionExe {
	public static void main(String[] args) {
		//Math
		for (int i=0; i < 10; i++){
			int result = (int) (Math.random() * 6) + 1; // 0 ~ 6 사이의 값
			System.out.println(result);
			
			if (result % 2 == 0) {
				System.out.println("2의 배수입니다.");
			}
	}
  }
}	
