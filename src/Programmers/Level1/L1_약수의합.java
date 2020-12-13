package Programmers.Level1;

public class L1_약수의합 {

	public static void main(String[] args) {
		System.out.println(new L1_약수의합().solution(5));
	}

	private int solution(int n) {
		int answer = 0;
		
		int num = n;
		
		while(num>0) {
			if(n%num==0)	answer+=num;
			--num;
		}
		
		return answer;
	}

}
