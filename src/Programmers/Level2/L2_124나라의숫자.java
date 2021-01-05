package Programmers.Level2;

public class L2_124나라의숫자 {

	public static void main(String[] args) {
		System.out.println(new L2_124나라의숫자().solution(6));
	}
	
	public String solution(int n) {
		StringBuilder answer = new StringBuilder();
		
		int na = 0;
		
		while(n!=0) {
			na = n%3;
			n/=3;
			
			if(na == 0) {
				n-=1;
				na = 4;
			}
			
			answer.insert(0,na);
		}
		
		return answer.toString();
	}
	

	
}
