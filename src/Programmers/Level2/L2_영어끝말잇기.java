package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class L2_영어끝말잇기 {

	public static void main(String[] args) {
		new L2_영어끝말잇기().solution(3,new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
	}

	public int[] solution(int n, String[] words) {
		
		Set<String> set = new HashSet<>();
		
		int failNum = 0;
		int failCnt = 0;
		
		char last='Z';
		for (int i = 0; i < words.length; i++) {
			if(i == 0) {
				if(words[0].length() == 1) {
					failNum = 1;
					failCnt = 1;
					break;
				}
				last = words[0].charAt(words[0].length()-1);
				set.add(words[0]);
				continue;
			}
			
			int before = set.size();
			set.add(words[i]);
			int after = set.size();
			System.out.println(words[i].length()+" "+before+","+after+" "+last+","+words[i].charAt(0));
			if(words[i].length() == 1 || before == after || last!=words[i].charAt(0))
			{
				//걸리면
				failNum = i%n +1;
				failCnt = i/n +1;
				break;
			}
			last = words[i].charAt(words[i].length()-1);
		}
		
		System.out.println(failNum+" "+ failCnt);
		return new int[] {failNum, failCnt};
	}

}
