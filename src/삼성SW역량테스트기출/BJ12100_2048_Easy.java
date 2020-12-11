package 삼성SW역량테스트기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12100_2048_Easy {
	
	static int N,answer=0;
	static int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//여기서 뭐 처리~~
		reculsive(0,map);
		
		System.out.println(answer);
	}
	
	private static void reculsive(int cnt, int[][] map) {
		
		if(cnt==5) {
			getMaxBlock(map);
			return;
		}
		
		for (int i = 0; i < dxdy.length; i++) {
			int[][] copyMap = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					copyMap[j][j2] = map[j][j2];
				}
			}
			
			
			//copyMap 옮기기
			for (int j = 0; j < N; j++) {
				for (int j2 = 1; j2 < N; j2++) {
					
					if(i<=1) {
						if(copyMap[j2-1][j] == copyMap[j2][j]) {
							copyMap[j2-1][j]*=2;
							
							for (int k = j2+1; k < N; k++) {
								copyMap[k-1][j] = copyMap[k][j];
							}
							
							--j2;
							
						}
					}
					else {
						if(copyMap[j][j2-1] == copyMap[j][j2]) {
							copyMap[j][j2-1]*=2;
							
							for (int k = j2+1; k < N; k++) {
								copyMap[j][k-1] = copyMap[j][k];
							}
							
							--j2;
							
						}
					}
					
				}
			}
			System.out.println(cnt+":cnt");
			System.out.println("상하좌우 중 "+i+"번째");
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					System.out.print(copyMap[j][j2]+" ");
				}
				System.out.println();
			}
			reculsive(cnt+1,copyMap);
		}
	}
	
	private static void getMaxBlock(int[][] map) {
		int maxBlock=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxBlock = Math.max(maxBlock, map[i][j]);
			}
		}
		answer = Math.max(answer, maxBlock);
	}
	
	

}
