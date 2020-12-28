package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L2_짝지어제거하기 {

	public static void main(String[] args) {
		System.out.println(new L2_짝지어제거하기().solution("cdcd"));
	}

	public int solution(String s) {

		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();

		//큐에 전부 넣기
		for (char c : s.toCharArray()) {
			queue.offer(c);
		}

		//큐의 모든 것 체크
		while (!queue.isEmpty()) {
			
			char cur = queue.poll();

			//스택이 비어있으면 비교 대상 없음.
			if (stack.isEmpty())
				stack.push(cur);

			else {

				//스택 맨 위에꺼와 같으면 버리기
				if (stack.peek() == cur) {
					stack.pop();
				}

				// 다르면 스택에 쌓기
				else {
					stack.push(cur);
				}
			}
		}

		//스택이 비어있으면 모두 제거됐다는 뜻!
		return (stack.isEmpty()) ? 1 : 0;
	}

	public int solution2(String s) {

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (stack.isEmpty())
				stack.push(c);

			else {

				if (stack.peek() == c) {
					stack.pop();
				}

				else {
					stack.push(c);
				}
			}
		}

		return (stack.isEmpty()) ? 1 : 0;
	}
}
