package co.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello World Nice";
		String[] strAry = str.split(" "); // 스페이스, 즉 공백을 기준으로 문장에서 단어를 구분하겠다는 의미
		int cnt = 0;
		for (String word : strAry) {
			System.out.println(word);
			if (word.indexOf("o") > -1) {
				cnt++;
			}
		}
		System.out.print("o를 포함한 단어수: " + cnt);
	}

}
