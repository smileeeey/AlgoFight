package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class L1_수박수박수박 {
	public static void main(String[] args) {
		new L1_수박수박수박().solution(new int[] {4,4,4,3,3});
	}

	private int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		int[] answer = null;
		int prior = -1;
		
		loop:
		for (int num : arr) {
			
			if(num == prior) {
				continue loop;
			}
			else {
				list.add(num);
				prior = num;
			}
		}
		
		answer = new int[list.size()];
		
		for (int i=0 ; i<list.size() ; ++i) {
			answer[i] = list.get(i);
			System.out.print(answer[i]+" ");
		}
		
		return answer;
	}
}
