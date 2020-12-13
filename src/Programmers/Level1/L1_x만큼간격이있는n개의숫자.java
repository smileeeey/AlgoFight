package Programmers.Level1;


public class L1_x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		new L1_x만큼간격이있는n개의숫자().solution(2,5);
	}

	
	private long[] solution(int x, int n) {
		
		long[] answer= new long[n];
		//주의! int면 오류 : 표현범위 넘어감!
		long num = x;
		
		for(int i = 0 ; i < n ; ++i) {
			answer[i] = num;
			num+=x;
		}
		
		return answer;
	}

}
