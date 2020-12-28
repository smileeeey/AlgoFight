package Programmers.Level2;

public class L2_JadenCase문자열만들기 {

	public static void main(String[] args) {
		System.out.println(new L2_JadenCase문자열만들기().solution("for the last week"));
	}

	public String solution(String s) {
		StringBuilder sb= new StringBuilder();
		boolean flag = true;
		for(char ch : s.toCharArray()) {
			if(flag) {
				if(ch>='a' && ch<='z')
					sb.append((char)(ch-('a'-'A')));
				else
					sb.append(ch);
				
				if(ch!=' ')
					flag = false;
			}
			else {
				if(ch>='A' && ch<='Z')
					sb.append((char)(ch+('a'-'A')));
				else
					sb.append(ch);
				
				if(ch==' ')	flag = true;
			}
		}
		
		return sb.toString();
	}

}
