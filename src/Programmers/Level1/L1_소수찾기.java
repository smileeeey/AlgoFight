package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class L1_소수찾기 {

	public static void main(String[] args) {
		System.out.println(new L1_소수찾기().solution(5));
	}
/*
	private int solution(int n) {
		List<Integer> list = new ArrayList<>();
        
        //2는 짝수이지만 소수이므로 미리 체크
		list.add(2);
		
		loop:
		for (int i = 3; i <= n; i++) {
			
			if(i%2==0)	continue loop;	
			
			for(int num : list) {
				if(i%num == 0)	continue loop;
			}
            //소수이면!
			list.add(i);
		}
		return list.size();
	}
*/
	//에라토스테네스의 체
	private int solution(int n) {
		int answer = 0;
		
		//n까지의 배열 생성
		//모두 false로 초기화 => false : 소수이다.
		boolean[] a = new boolean[n+1];
		
		for (int i = 2; i <= n; i++) {
			
			//true : 소수가 아니다.
			if(a[i])	continue;
			
			//false : 소수이다.
			//소수의 배수들은 소수가 아니므로 true로 갱신
			for (int j = 2*i; j <= n; j+=i) {
				a[j]=true;
			}
		}
		
		//소수의 개수 카운트
		for (int i = 2; i <= n; i++) {
			if(!a[i])	++answer;
		}
		
		return answer;
	}
}
