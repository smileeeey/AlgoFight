package Programmers.Level1;

public class L1_문자열을정수로바꾸기 {
	public static void main(String[] args) {
		System.out.println(new L1_문자열을정수로바꾸기().solution("-1234"));
	}

	private int solution(String s) {
		int answer = 0;
		boolean flag = true;
		
		if(s.charAt(0)=='-') {
			flag = false;
			s = s.substring(1);
		}
		else if(s.charAt(0)=='+') {
			s = s.substring(1);
		}
		char[] chs = s.toCharArray();
		
		for (char c : chs) {
			answer*=10;
			answer+=(c-'0');
		}
		if(!flag) {
			answer-=-1;
		}
		
		return answer;
		
	}
}
