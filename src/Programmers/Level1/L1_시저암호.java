package Programmers.Level1;

public class L1_시저암호 {

	public static void main(String[] args) {
		System.out.println(new L1_시저암호().solution("a B z",4));
	}

	private String solution(String s, int n) {
		
		char[] chs = s.toCharArray();
		
		for (int i = 0; i < chs.length; i++) {
			
			if(chs[i] == ' ')	continue;
			
			char c = (char) (chs[i]+n);
			
			if(chs[i]<='Z' && c >'Z')	c = (char) (c-'Z'-1+'A');
			else if (chs[i]<='z' && c >'z')	c = (char) (c-'z'-1+'a');
		
			chs[i] = c;
		}
		
		return new String(chs);
	}

}
