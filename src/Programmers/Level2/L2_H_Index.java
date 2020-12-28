package Programmers.Level2;

public class L2_H_Index {

	public static void main(String[] args) {
		System.out.println(new L2_H_Index().solution(new int[] {3,0,6,1,5}));
	}

	public int solution(int[] citations) {
		int answer = citations.length; 
		
		while(answer>0) {
			int over = 0;
			int under = 0;
			for(int citation : citations) {
				if(citation>=answer)	++over;
				else	++under;
			}
			if(over>=answer && under<=answer)	break;
			--answer;
		}
		
		return answer;
	}

}
