package Programmers.Level1;

public class L1_자릿수더하기 {

	public static void main(String[] args) {
		System.out.println(new L1_자릿수더하기().solution(987));
	}

	private int solution(int N) {
		int answer = 0;
		
		while(N>0) {
			answer+=(N%10);
			N/=10;
		}
		
		return answer;
	}

}
