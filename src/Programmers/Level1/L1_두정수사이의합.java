package Programmers.Level1;

public class L1_두정수사이의합 {

	public static void main(String[] args) {
		System.out.println(new L1_두정수사이의합().solution(5,3));
	}

	private long solution(int a, int b) {
		
		int big = 0, small = 0;
		long answer=0;
		
		big = Math.max(a, b);
		small = Math.min(a, b);
		
		for (int j2 = small; j2 <= big; j2++) {
			answer+=j2;
		}
		return answer;
	}

}
