package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class L2_최솟값만들기 {

	public static void main(String[] args) {
		System.out.println(new L2_최솟값만들기().solution(new int[] {1,2}, new int[] {3,4}));
	}

	private int solution(int[] A, int[] B) {
		int answer = 0;
		
		int len = A.length;
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < len; i++) {
			answer+=(A[i]*B[len-i-1]);
		}
		
		return answer;
	}

}
