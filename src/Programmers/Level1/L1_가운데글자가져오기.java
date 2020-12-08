package Programmers.Level1;

public class L1_가운데글자가져오기 {

	public static void main(String[] args) {
		System.out.println(new L1_가운데글자가져오기().solution("abcd"));
	}

	private String solution(String s) {
		int len = s.length();
		
		if(len%2==0) {
			return s.substring(len/2-1, len/2+1);
		}
		else {
			return s.substring(len/2,len/2+1);
		}
	}

	
}
