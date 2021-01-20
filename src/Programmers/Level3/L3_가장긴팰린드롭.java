package Programmers.Level3;

public class L3_가장긴팰린드롭 {

	public static void main(String[] args) {
		System.out.println(new L3_가장긴팰린드롭().solution("a"));
	}

	public int solution(String s) {
		int answer = 1;
		int len = s.length();
		char[] chs = s.toCharArray();
		
		
		for (int i = 0; i < len; i++) {
			int cnt=1;
			
			for (int j = 1; j < len; j++) {
				int left = i-j;
				int right = i+j;
				
				if(left<0 || right>=len) {
					answer = Math.max(answer, cnt);
					break;
				}
				
				if(chs[left]==chs[right])	cnt+=2;
				else {
					answer = Math.max(answer, cnt);
					break;
				}
			}
		}
		
		for (int i = 0; i < len-1; i++) {
			
			
			if(chs[i]!=chs[i+1]) {
				continue;
			}
			int cnt = 2;
			for (int j = 1; j < len; j++) {
				int left = i-j;
				int right = i+1+j;
				
				if(left<0 || right>=len) {
					answer = Math.max(answer, cnt);
					break;
				}
				
				if(chs[left]==chs[right])	cnt+=2;
				else {
					answer = Math.max(answer, cnt);
					break;
				}
			}
		}
		
		return answer;
	}

}
