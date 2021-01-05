package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class L2_위장 {

	public static void main(String[] args) {
		System.out.println(new L2_위장().solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
	}

	private int solution(String[][] clothes) {
		int answer = 1;
		
		List<String> types = new ArrayList<>();
		int[] counts = new int[30];
		
		loop:
		for(String[] str : clothes) {
			for (int i = 0; i < types.size(); i++) {
				if(types.get(i).equals(str[1])) {
					counts[i]++;
					continue loop;
				}
			}
			counts[types.size()] = 1;
			types.add(str[1]);
		}
		
		for (int i = 0; i < types.size(); i++) {
			answer *= (counts[i]+1);
		}
		
		return answer-1;
	}

}
