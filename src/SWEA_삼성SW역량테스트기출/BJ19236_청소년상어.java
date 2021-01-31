package SWEA_삼성SW역량테스트기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ19236_청소년상어 {
	
	public static int[][] dxdy = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	public static List<int[]> fishes = new ArrayList<>();
	//값, 방향, x좌표, y좌표
	public static int[] shark = new int[] {0,0,0,0}; 
	public static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				if(i==0 && j==0) {
					st.nextToken();
					shark[1] = Integer.parseInt(st.nextToken());
					continue;
				}
				fishes.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())-1, i, j});
			}
		}
		
		Collections.sort(fishes,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		
		dfs(0);
		
	}

	private static void dfs(int sum) {
		
		int dir = shark[1];
		int x = shark[2];
		int y = shark[3];
		
		//상어 이동
		for (int i = 1;; i++) {
			int nx = x+dxdy[dir][0]*i;
			int ny = y+dxdy[dir][1]*i;
			
			
		}
		while(true) {


			if(x<0 || x>=4 ||y<0 || y>=4) {
				answer = Math.max(answer, sum);
				return;
			}
			
		}
		
		
		
		
		moveFish(fishes,shark);
		dfs(dir,)
	}



	private static void moveFish(List<int[]> fishes, int[] shark) {
		
		loop1:
		for (int i = 0; i < fishes.size(); i++) {
			int[] fish = fishes.get(i);
			
			loop:
			for (int j = 0; j < 8; j++) {
				int d = (fish[1]+j)%8;
				
				int nX = fish[2]+dxdy[d][0];
				int nY = fish[3]+dxdy[d][1];
				
				//이 위치에 상어있거나, 넘어가면 
				if(nX<0 || nX>=4 ||nY<0 || nY>=4 || (shark[2]==nX && shark[3]==nY))
					continue;
				
				//그게 아니면 해당 위치와 swap
				for (int k = 0; k < fishes.size(); k++) {
					if(fishes.get(k)[2]==nX && fishes.get(k)[3] == nY) {
						fishes.get(k)[2] = fishes.get(i)[2];
						fishes.get(k)[3] = fishes.get(i)[3];
						fishes.get(i)[2] = nX;
						fishes.get(i)[3] = nY;
						continue loop1;
					}
				}
				
				//해당하는 자리가 비어있었다면
				fishes.get(i)[2] = nX;
				fishes.get(i)[3] = nY;
				break;
			}
			
		}
	}

	
	
	
}
