package co.yedam;

public class ForAndForExe {
	public static void main(String[] args) {
		practice3();
		
	}

	public static void practice3() {
		
		boolean run = true;
		while (run) {
			int i = (int) Math.floor((Math.random() * 6) + 1);
			int j = (int) Math.floor((Math.random() * 6) + 1);
			if (i + j == 5) {
				System.out.printf("%d, %d\n", i, j);
				break;
			} else {
				run = false;
				continue;
			}
		}
	}

	public static void practice4() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("x = %d, y = %d \n", x, y);
				}

			}
		}
	}

	public static void forAndFor() {
		for (int i = 1; i < 9; i++) {
			for (int j = 4; j < 7; j++) {
				System.out.printf("%d * %d = %2d ", j, i, j * i);
			}
			System.out.println();
		}
	}
}