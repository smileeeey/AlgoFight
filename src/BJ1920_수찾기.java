package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] arrM = new int[M]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		for(int m : arrM) {
			if(find(m,arrN))	System.out.println(1);
			else	System.out.println(0);
		}
	}

	private static boolean find(int m, int[] arrN) {
		
		int l = 0;
		int r = arrN.length-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			
			if(arrN[mid] == m)	return true;
			
			if(arrN[mid]>m)	r = mid-1;
			else	l = mid+1;
		}
		
		return false;
	}

}
