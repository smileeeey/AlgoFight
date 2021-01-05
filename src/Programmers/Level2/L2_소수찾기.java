package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class L2_소수찾기 {

	public static void main(String[] args) {
		System.out.println(new L2_소수찾기().solution("011"));
	}

	int[] nums;
	int[] number;
	boolean[] visited;
	Set<Integer> set = new HashSet<>();
	
	public int solution(String numbers) {
		
		nums = new int[numbers.length()];
		number = new int[numbers.length()];
		visited = new boolean[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			nums[i] = Integer.parseInt(numbers.substring(i,i+1));
		}
		//System.out.println(Arrays.toString(nums));
		permutation(0);
		
		return set.size();
	}
	
	public void permutation(int cnt) {
		int answer = 0;
		for (int i = 0; i < cnt; i++) {
			answer*=10;
			answer+=number[i];
		}
		//System.out.println(answer);
		
		if(isSosu(answer)) {
			//System.out.println(answer+"은 소수입니당");
			set.add(answer);
		}
		
		if(cnt==nums.length) {
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(visited[i])	continue;
			number[cnt] = nums[i];
			visited[i] = true;
			permutation(cnt+1);
			visited[i]=false;
			number[cnt] = 0;
		}
		
	}
	
	public boolean isSosu(int answer) {
		
		if(answer < 2)	return false;
		if(answer == 2 || answer == 3)	return true;
		if(answer%2==0)	return false;
		
		boolean[] filled = new boolean[answer+1];
		
		for (int i = 2; i <= answer/2; i++) {
			if(filled[i])	continue;
			int j = i;
			while(j<= answer) {
				filled[j] = true;
				j+=i;
			}
		}
		
		if(filled[answer])	return false;
		else	return true;
		
	}

}
