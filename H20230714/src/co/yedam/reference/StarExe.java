package co.yedam.reference;

public class StarExe {
	public static void main(String[] args) {
		String stars = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				if (i >= j) {
					stars += "*";
				}
			}
			System.out.println(stars);
			stars = "";
			continue;
		}

		for (int i = 0; i < 4; i++) {
			for (int b = 0; b < 4 - i; b++) {
				stars += " ";
			}
			for (int j = 0; j <= i; j++) {
				stars += "*";
			}
			System.out.println(stars);
			stars = "";
		}
		
		
	}
}
