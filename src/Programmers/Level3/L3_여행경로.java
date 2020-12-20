package Programmers.Level3;

import java.util.Arrays;
import java.util.Comparator;

public class L3_여행경로 {

	public static void main(String[] args) {
		new L3_여행경로().solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
	}
	
	int ticketsLen = 0;
	String[] answer = null;
	
	public String[] solution(String[][] tickets) {
		ticketsLen = tickets.length;
		
		answer = new String[ticketsLen+1];
		boolean[] visited = new boolean[ticketsLen];
		answer[0] = "ICN";
		
		Comparator<String[]> comparator = new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		};

		Arrays.sort(tickets,comparator);
		
		
		DFS("ICN",visited, 1, tickets);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
	
	public boolean DFS(String arrival, boolean[] visited, int cnt, String[][] tickets) {
		if(cnt==ticketsLen+1) {
			System.out.println("따란 완성!!");
			return true;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i])	continue;
			
			if(tickets[i][0].equals(arrival)) {
				visited[i]=true;
				answer[cnt] = tickets[i][1];
				for (int j = 0; j < visited.length; j++) {
					System.out.print(visited[j]+" ");
				}
				System.out.println("   answer : "+cnt+"까지 찼음");
				if(DFS(tickets[i][1],visited,cnt+1,tickets))	return true;
				visited[i] = false;
			}
		}
		return false;
	}
}
