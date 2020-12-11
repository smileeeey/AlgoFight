package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L1_나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		new L1_나누어떨어지는숫자배열().solution2(new int[] {3,2,6}, 7);
	}

	//멍청한 풀이...
	private int[] solution1(int[] arr, int divisor) {
		
		
		List<Integer> list = new ArrayList<>();
		int[] answer;
		
		//divisor로 나누어떨어지는 수 list에 넣기
		for(int a : arr) {
			if(a%divisor == 0) {
				list.add(a);
			}
		}
		
		//list 정렬
		Collections.sort(list);
		
		int size = list.size();
		//list가 비었으면 -1 넣기
		if(size==0) {
			answer = new int[1];
			answer[0] = -1;
		}
		
		//list의 값 넣기
		else {
			answer = new int[size];
			for (int i = 0; i < size; i++) {
				answer[i] = list.get(i);
				System.out.println(list.get(i));
			}
		}
		
		return answer;
	}
	
	//똑똑한 풀이
	public int[] solution2(int[] array, int divisor) {
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
}
