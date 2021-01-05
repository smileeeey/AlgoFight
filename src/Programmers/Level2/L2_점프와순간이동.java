package Programmers.Level2;

public class L2_점프와순간이동 {

	public static void main(String[] args) {
		System.out.println(new L2_점프와순간이동().solution(5000));
	}
	public int solution(int N) {
		int answer = 0;
		
		while(N>0) {
			if(N%2==0) {
				N/=2;
			}
			else {
				N-=1;
				answer++;
				N/=2;
			}
		}
		
		return answer;
	}

	
}
