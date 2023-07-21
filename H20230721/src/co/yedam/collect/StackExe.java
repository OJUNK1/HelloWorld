package co.yedam.collect;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("홍길동");
		stack.push("김길동");
		stack.push("박길동");

		while (!stack.isEmpty()) {
			System.out.println(stack.pop()); // 박길동이 호출
//			System.out.println(stack.peek()); // 김길동
//			System.out.println(stack.peek()); // 홍길동 pop : stack 중에 마지막에 들어온 요소부터 하나씩 끄집어내는거. peek: 안없어지면서 마지막꺼
		}
	}
}
