package Programmers.Level1;

public class L1_이상한문자만들기 {

	public static void main(String[] args) {
		System.out.println(new L1_이상한문자만들기().solution2("try hello world"));
	}

	private String solution1(String s) {
		char[] chs = s.toCharArray();
		
		for (int i = 0,idx=0; i < chs.length; i++,++idx) {
			char c = chs[i];
			
			if(c==' ') {	
				idx=-1;
				continue;
			}
			
			if(idx%2==0) {
				if(c>='a' && c<='z')	chs[i] = (char) (c-('a'-'A'));
			}
			else {
				if(c>='A' && c<='Z')	chs[i] = (char) (c+('a'-'A'));
			}
		}
		
		return new String(chs);
	}
	
	//string 클래스의 메소드를 활용하자!
	private String solution2(String s) {
		String answer = "";
		String[] chs = s.split("");
		int idx = 0;
		
		for(String c : chs) {
			
			if(c.equals(" "))	idx=-1;
			answer += (idx++%2==0)? c.toUpperCase():c.toLowerCase();
			
		}
		
		return answer;
	}
}
