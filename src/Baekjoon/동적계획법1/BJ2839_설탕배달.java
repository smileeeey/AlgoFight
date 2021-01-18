package Baekjoon.동적계획법1;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2839_설탕배달 {

	public static void main(String[] args){
		
		int N = new Scanner(System.in).nextInt();
		
		int[] dp = new int[N+1];
		
		Arrays.fill(dp, 9999); //9999는 나올 수 없는 수
		
		dp[3]=dp[5]=1;
		
		for (int i = 6; i <= N; i++) {
			dp[i] = Integer.min(dp[i-3], dp[i-5]);
			if(dp[i]!=9999)	++dp[i];
		}
		
		if(dp[N]==9999)
			dp[N] = -1;
		
		System.out.println(dp[N]);
		return;
	}

}
