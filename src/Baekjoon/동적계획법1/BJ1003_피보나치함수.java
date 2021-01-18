package Baekjoon.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003_피보나치함수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N+1][2];
			
			map[0][0] = 1;
			
			if(N==0) {
				System.out.println("1 0");
				continue;
			}
			
			map[1][1] = 1;
			
			
			for (int j = 2; j <= N; j++) {
				map[j][0] = map[j-1][0] + map[j-2][0];
				map[j][1] = map[j-1][1] + map[j-2][1];
			}
			System.out.println(map[N][0]+" "+map[N][1]);
		}
	}
	
}
