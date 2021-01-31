package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L3_가장긴팰린드롭 {

	public static void main(String[] args) {
		System.out.println(new L3_가장긴팰린드롭().solution("abcded"));
	}

	public int solution(String s) {
		
		int answer = 1;
		Map<Character,List<Integer>> map = new HashMap<>();
		
		int idx=0;
		
		loop:
		for (char ch : s.toCharArray()) {

			for (char c : map.keySet()) {
				if(ch == c) {
					map.get(ch).add(idx);
					++idx;
					continue loop;
				}
			}
			
			List<Integer> tmp = new ArrayList<>();
			tmp.add(idx);
			map.put(ch, tmp);
			
			++idx;
		}
		
		
		
		return answer;
	}

}
