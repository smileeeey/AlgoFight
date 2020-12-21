package Programmers.Level2;

public class L2_숫자의표현 {

	public static void main(String[] args) {
		System.out.println(new L2_숫자의표현().solution(15));
	}

	private int solution(int n) {
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			int sum=0;
			int j=i;
			while(sum<n) {
				sum+=j;
				++j;
			}
			if(sum==n)	++answer;
		}
		
		return answer;
	}

}
