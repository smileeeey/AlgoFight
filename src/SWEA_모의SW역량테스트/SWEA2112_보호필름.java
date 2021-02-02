package SWEA_모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {

	private static int[][] map;
	private static int[] comb;
	private static int D,W,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			//조합 생성
			for (int j = 0; j < D; j++) {
				if(combination(new boolean[D],0,j)) {
					answer = j;
					break;
				}
			}
			
			System.out.println(answer);
		}
		
	}


	private static boolean combination(boolean[] visited, int start,int r) {
		if(r == 0) {
			
			changeMap(visited);
			
			System.out.println("------------");
			System.out.println(Arrays.toString(visited));
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
			if(checkMap()) {
				System.out.println("여기서 끝!!");
				return true;
			}
			
			changeMap(visited);
			
		} else {
			for(int i = start; i < D; i++) {
				visited[i] = true;
				if(combination(visited, i + 1, r - 1))	return true;
				visited[i] = false;
			}
		}
		
		return false;
	}

	private static void changeMap(boolean[] visited) {
		for (int i = 0; i < D; i++) {
			if(visited[i]) {
				for (int j = 0; j < W; j++) {
					map[i][j] = map[i][j]==0?1:0;
				}
				
			}
		}
	}

	private static boolean checkMap() {
		
		
		
		loop:
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < D-K+1; j++) {
				int sum=0;
				for (int j2 = 0; j2 < K; j2++) {
					sum+=map[j+j2][i];
				}
				if(sum==0 || sum==K)	continue loop;
			}
			return false;
		}
		return true;
	}
}
