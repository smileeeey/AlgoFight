package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

public class L2_구명보트 {

	public static void main(String[] args) {
		System.out.println(new L2_구명보트().solution2(new int[] {70, 80, 50},100));
	}

	private int solution(int[] people, int limit) {
		int answer = 0;
		
		Integer[] peoples = Arrays.stream( people ).boxed().toArray( Integer[]::new );
		
		Arrays.sort(peoples, Collections.reverseOrder());
		
		for (int i = 0,j=peoples.length-1; i < peoples.length; i++) {
			
			if(i>=j) {
				if(i==j)	++answer;
				break;
			}
			if(peoples[i]+peoples[j]<=limit) {
				--j;
			}
			++answer;
		}
		
		return answer;
	}
	private int solution2(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		int s=0,e=people.length-1;
		
		while(true) {
			if(s>=e) {
				if(s==e)	++answer;
				break;
			}
			if(people[s]+people[e]<=limit) {
				--e;
			}
			++answer;
			++s;
		}
		
		return answer;
	}
}
