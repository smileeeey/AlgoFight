package Programmers.Level1;

public class L1_정수제곱근판별 {

	public static void main(String[] args) {
		System.out.println(new L1_정수제곱근판별().solution(144));
	}

	private long solution(long n) {
		if(Math.pow((int)Math.sqrt(n), 2) == n)	return (long) Math.pow(Math.sqrt(n)+1, 2);
		return -1;
	}

}
