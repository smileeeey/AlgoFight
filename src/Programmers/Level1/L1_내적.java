package Programmers.Level1;

public class L1_내적 {

	public static void main(String[] args) {
		System.out.println(new L1_내적().solution(new int[] {1,2,3,4},new int[] {-3,-1,0,2}));
	}

	private int solution(int[] a, int[] b) {
		int answer = 0;
		
		for (int i = 0; i < b.length; i++) {
			answer+=(a[i]*b[i]);
		}
		
		return answer;
	}

}
