package Programmers.Level2;

public class L2_피보나치수 {

	public static void main(String[] args) {
		System.out.println(new L2_피보나치수().solution(7));
	}

	private int solution(int n) {
		
		int pprev = 0;
		int prev = 1;
		
		for (int i = 2; i <= n; i++) {
			int cur = pprev%1234567 + prev%1234567;
			pprev = prev%1234567;
			prev = cur%1234567;
		}
		
		return prev;
	}

}
