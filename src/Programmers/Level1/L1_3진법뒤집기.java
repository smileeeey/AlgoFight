package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class L1_3진법뒤집기 {

	public static void main(String[] args) {
		System.out.println(new L1_3진법뒤집기().solution(125));
	}

	public int solution(int n) {
		
		int answer=0;
		
		//3진법으로 바꾼 수를 담을 list
		List<Integer> list = new ArrayList<>();
		
		//3보다 작아질때까지 반복 : 나머지 list에 넣기
		while(n>=3) {
			list.add(n%3);
			n/=3;
		}
		
		//3보다 작아진 몫 list에 넣기
		list.add(n);
		
		//최대 차수
		int pow = (int) Math.pow(3, list.size()-1);
		
		//3진법->10진법
		for (int num : list) {
			answer+=(pow*num);
			pow/=3;
		}
		
		return answer;
	}

}
