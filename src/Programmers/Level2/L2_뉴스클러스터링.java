package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class L2_뉴스클러스터링 {
	public static void main(String[] args) {
		System.out.println(new L2_뉴스클러스터링().solution("FRANCE","french"));
	}

	private int solution(String str1, String str2) {
		int answer = 0;
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		String tmp = "";
		for(char ch : str1.toCharArray()) {
			if(ch<'A' || ch>'z')	continue;
			tmp+=ch;
			if(tmp.length()==2) {
				list1.add(tmp.toUpperCase());
				tmp="";
			}
		}
		if(tmp.length() == 1)	list1.add(tmp.toUpperCase());
		
		tmp = "";
		for(char ch : str2.toCharArray()) {
			if(ch<'A' || ch>'z')	continue;
			tmp+=ch;
			if(tmp.length()==2) {
				list2.add(tmp.toUpperCase());
				tmp="";
			}
		}
		if(tmp.length() == 1)	list2.add(tmp.toUpperCase());
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}
		System.out.println();
		int div=0;
		loop:
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if(list1.get(i).equals(list2.get(j))) {
					++div;
					list2.remove(j);
					continue loop;
				}
			}
		}
		System.out.println("div:"+div);
		int total = list1.size()+list2.size();
		return div/(list1.size()+list2.size())*65536/1;
	}
}
