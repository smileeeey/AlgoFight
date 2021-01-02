package Programmers.Level2;

public class L2_단체사진찍기 {

	public static void main(String[] args) {
		System.out.println(new L2_단체사진찍기().solution(2, new String[] {"N~F=0", "R~T>2"}));
	}
	int nn;
	String[] data ; 
	int N = 8;
	String[] names = {"A","C","F","J","M","N","R","T"};
	boolean[] visited = new boolean[N];
	int answer = 0;
	String[] inputs;
	
	public int solution(int n, String[] data) {
		inputs = data;
		
		permutation(0,"");
		
		return answer;
	}
	
	public void permutation(int cnt, String line) {
		if(cnt == N) {
			//줄세우기 완성
			for(String input : inputs) {
				char[] chs = input.toCharArray();
				switch(chs[3]) {
				case '=':
					answer+=(check(line,chs[0],chs[2],chs[4]-'0'))?1:0;
					break;
				case '<':
					break;
				case '>':
					break;
				}
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])	continue;
			
			visited[i] = true;
			permutation(cnt+1,line+names[i]);
			visited[i] = false;
		}
		
	}
	
	public boolean check(String line,char c1, char c2, int distance) {
		
	}

}
