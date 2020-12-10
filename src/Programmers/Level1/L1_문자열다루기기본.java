package Programmers.Level1;

public class L1_문자열다루기기본 {

	public static void main(String[] args) {
		System.out.println(new L1_문자열다루기기본().solution("1234"));
	}

	private boolean solution(String s) {
		
		if(s.length()==4 || s.length() == 6) {
			char[] chs = s.toCharArray();
			for(char c: chs) {
				if(c<'0' || c>'9')	return false;
			}
			return true;
		}
		
		return false;
		
	}

}
