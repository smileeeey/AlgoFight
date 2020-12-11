package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L1_문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(new L1_문자열내림차순으로배치하기().solution2("Zbcdefg"));
	}
	
	//첫번째 풀이
	private String solution1(String s) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		
		Collections.sort(list, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return o2-o1;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (char c : list) {
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	//두번째 풀이
		private String solution2(String s) {
			
			char[] chs = s.toCharArray();
			
			Arrays.sort(chs);
			
			return new StringBuilder(new String(chs)).reverse().toString();
		}
}
