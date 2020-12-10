package Programmers.Level1;

public class L1_문자열내p와y의개수 {

	public static void main(String[] args) {
		System.out.println(new L1_문자열내p와y의개수().solution("PoooyY"));
	}

	private Boolean solution(String string) {
		
		int pCnt=0,yCnt=0;
		
		for( char c : string.toCharArray()) {
			if(c=='p' || c=='P')	++pCnt;
			else if(c=='y' || c=='Y')	++yCnt;
		}
		
		if(pCnt==yCnt)	return true;
		else	return false;
	}

}
