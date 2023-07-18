package co.yedam.memo;

import java.util.Scanner;

public class MemoAppExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("input(번호 이름 성적) >> ");
		String str;
		// 홍길동
		String no = scn.next();
		String name = scn.next();
		String score = scn.next();
		System.out.println("번호: " + no + "이름: " + name);
//	메모 app.
//	Memo.java
//	번호  내용   날짜     Enter.
//
//	MemoApp.java
//	-메모등록(addMemo)
//	-메모수정(editMemo) (번호, 내용)
//	-메모삭제(delMemo)
//	-메모목록(memoList)
//	-메모조회(fineMemo) (번호)
//	1   장보기 230719
//	2  운동하기 230718
	}
}