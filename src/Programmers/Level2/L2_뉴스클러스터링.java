package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class L2_뉴스클러스터링 {
	public static void main(String[] args) {
		System.out.println(new L2_뉴스클러스터링().solution("aab","abb"));
	}

	public int solution(String str1, String str2) {
		
		int sameCnt = 0;
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		for (int i = 0; i < str1.length()-1; i++) {
			if(str1.charAt(i)>='A' && str1.charAt(i)<='Z' && str1.charAt(i+1)>='A' && str1.charAt(i+1)<='Z')
					list1.add(str1.substring(i,i+2).toUpperCase());
		}
		for (int i = 0; i < str2.length()-1; i++) {
			if(str2.charAt(i)>='A' && str2.charAt(i)<='Z' && str2.charAt(i+1)>='A' && str2.charAt(i+1)<='Z')
				list2.add(str2.substring(i,i+2).toUpperCase());
		}
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}
		System.out.println();
		loop:
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if(list1.get(i).equals(list2.get(j))) {
					list2.remove(j);
					sameCnt++;
					continue loop;
				}
			}
		}
		System.out.println();
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}
		System.out.println();
		int answer = (list1.size() ==0 && list2.size() ==0)?0:(int) (sameCnt*1.0/(list1.size()+list2.size())*65536/1);
		return answer;
	}
}
