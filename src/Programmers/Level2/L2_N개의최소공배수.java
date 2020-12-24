package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class L2_N개의최소공배수 {

	public static void main(String[] args) {
		System.out.println(new L2_N개의최소공배수().solution(new int[] {2,6,8,14}));
	}

	private int solution(int[] arr) {
		int answer = arr[0];
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i < arr.length; i++) {
			int big = Math.max(arr[i], answer);
			int small = Math.min(arr[i], answer);
			
			if(big%small==0)	answer = big;
			else {
				//big과 small의 최소공배수 answer에 넣기
				
			}
		}
		
		
		return answer;
	}

}
