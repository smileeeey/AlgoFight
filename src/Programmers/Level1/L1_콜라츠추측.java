package Programmers.Level1;

public class L1_콜라츠추측 {

	public static void main(String[] args) {
		System.out.println(new L1_콜라츠추측().solution(626331));
	}

	private int solution(int num) {
		int answer = 0;
		
		//n이 int형이면 답이 달라짐...주의!
		long n = num;
		
		while(n!=1) {
			if(answer==501) {	
				answer = -1;
				break;
			}
			n = (n%2==0)? n/2 : n*3+1;
			++answer;
		}
		return answer;
	}

}
