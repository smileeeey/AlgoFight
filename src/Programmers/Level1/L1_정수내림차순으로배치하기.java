package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1_정수내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(new L1_정수내림차순으로배치하기().solution(118372));
	}

	private long solution(long n) {
		long answer = 0;
		List<Integer> list = new ArrayList<>();
		
		while(n>0) {
			list.add((int) (n%10));
			n/=10;
		}
		
		//list 내림차순 정렬
		Collections.sort(list,Collections.reverseOrder());
		
		for(int i : list) {
			answer*=10;
			answer+=i;
		}
		
		return answer;
	}

}
