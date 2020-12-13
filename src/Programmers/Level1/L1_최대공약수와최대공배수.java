package Programmers.Level1;

public class L1_최대공약수와최대공배수 {

	public static void main(String[] args) {
		new L1_최대공약수와최대공배수().solution(3,12);
	}

	private int[] solution(int n, int m) {
		int big = Math.max(n, m);
		int small = Math.min(n, m);
		int num = 2;
		int max = 1;
		int min = small*big;
		while(num<=small) {
			if(small%num==0 && big%num==0) {
				max = num;
			}
			++num;
		}
		
		if(max!=1) {
			if(big%small==0)	min = big;
			else {
				min = max*(big/max)*(small/max);
			}
		}
		
		return new int[] {max,min};
	}

}
