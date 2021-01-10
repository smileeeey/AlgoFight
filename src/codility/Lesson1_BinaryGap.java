package codility;

import java.util.ArrayList;
import java.util.List;

public class Lesson1_BinaryGap {

	public static void main(String[] args) {
		System.out.println(new Lesson1_BinaryGap().solution(32));
	}
	public int solution(int N) {
		int answer = 0;
		
		List<Integer> list = new ArrayList<>();
		
		while(N!=0) {
			list.add(N%2);
			N/=2;
		}
		boolean start = false;
		int cnt = 0;
		for(int digit : list) {
			if(digit==1) {
				if(start) {
					answer = Math.max(answer, cnt);
				}
				else {
					start = true;
				}
				cnt=0;
				continue;
			}
			if(start)	++cnt;
			
		}
		
		return answer;
	}
}
