package Programmers.Level1;

import java.util.Arrays;

public class L1_예산 {

	public static void main(String[] args) {
		System.out.println(new L1_예산().solution(new int[] {1,3,2,5,4},9));
	}

	private int solution(int[] d, int budget) {
		int answer = 0;
		
		Arrays.sort(d);
		
		int i = 0;
		while(budget>0 && i<d.length) {
			budget-=d[i++];
			if(budget<0)	break;
			++answer;
		}
		
		return answer;
	}

}
