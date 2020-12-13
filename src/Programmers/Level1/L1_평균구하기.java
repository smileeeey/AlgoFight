package Programmers.Level1;

public class L1_평균구하기 {

	public static void main(String[] args) {
		System.out.println(new L1_평균구하기().solution(new int[] {1,2,3,4}));
	}

	private double solution(int[] arr) {
		double answer = 0;
		
		for(int a : arr) {
			answer+=a;
		}
		
		return answer/arr.length;
	}

}
