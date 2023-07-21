package co.yedam.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("홍길동");
		que.offer("최길동");
		que.offer("황길동");

		while (!que.isEmpty()) {
			System.out.println(que.poll()); // 제일 먼저 넣은 요소를 먼저 가져옵니다.
		}
	}
}
