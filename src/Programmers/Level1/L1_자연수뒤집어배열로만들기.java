package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class L1_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		new L1_자연수뒤집어배열로만들기().solution(12345);
	}

	private int[] solution(long n) {
		List<Integer> list = new ArrayList<>();
		while(n>0) {
			list.add((int) (n%10));
			n/=10;
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
