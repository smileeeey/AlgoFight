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

		for (char c : s.toCharArray()) {
			queue.offer(c);
		}

		while (!queue.isEmpty()) {
			char cur = queue.poll();

			if (stack.isEmpty())
				stack.push(cur);

			else {

				if (stack.peek() == cur) {
					stack.pop();
				}

				else {
					stack.push(cur);
				}
			}
		}

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
