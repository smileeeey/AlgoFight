package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class L2_가장큰수 {

	public static void main(String[] args) {
		System.out.println(new L2_가장큰수().solution(new int[] {0,0,0,0}));
	}

	public String solution(int[] numbers) {
		
		StringBuilder sb = new StringBuilder();
		
		String[] numbers_str = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers_str[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(numbers_str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o2+o1)-Integer.parseInt(o1+o2);
			}
			
		});
		
		for (int i = 0; i < numbers_str.length; i++) {
			if(numbers_str[0].equals("0")) {
				sb.append("0");
				break;
			}
			sb.append(numbers_str[i]);
		}
		return sb.toString();
	}

}
