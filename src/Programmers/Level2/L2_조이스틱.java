package Programmers.Level2;

public class L2_조이스틱 {

	public static void main(String[] args) {
		System.out.println(new L2_조이스틱().solution("JEROEN"));
	}

	private int solution(String name) {
		
		int answer = 0;
		char prev = 'A';
		
		for(char c : name.toCharArray()) {
			
			System.out.println("prev:"+prev+" / c:"+c);
			
			// 1. 한 알파벳씩 이동했을 때의 최소값
			int min = Math.abs(prev - c);
			
			if(min == 0)	continue;
			
			int cnt = 1;
			int disA = prev-'A';
			int disZ = 'Z'-prev;
			
			// 2. 
			
			min = Math.min(min,);
			if(disA > disZ) {
				cnt+=disZ;
				cnt+=Math.min(c-'A', 'Z'-c);
			}
			else {
				cnt+=disA;
				cnt+=Math.min(c-'A', 'Z'-c);
			}
			
			answer += min;
			prev = c;
		}
		
		return answer;
	}

}
