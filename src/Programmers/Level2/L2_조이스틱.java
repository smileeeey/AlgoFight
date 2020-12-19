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
			//prev와 c 사이에 최소 이동 횟수 구하기
			int min = Math.abs(prev - c);
			
			if(min == 0)	continue;
			
			int cnt = 1;
			int disA = prev-'A';
			int disZ = 'Z'-prev;
			
			// disZ
			min = Math.min(min, )
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
