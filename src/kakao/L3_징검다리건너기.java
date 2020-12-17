package kakao;

import java.util.Arrays;

public class L3_징검다리건너기 {

	public static void main(String[] args) {
		System.out.println(new L3_징검다리건너기().solution2(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
	}

	private int solution(int[] stones, int k) {
		int answer = 0;
		int zeroLen = 0;
		int min = Integer.MAX_VALUE;
		while(zeroLen < k && zeroLen!=stones.length) {
			
			//배열에서 min값 찾기
			for(int n : stones) {
				if(n==0)	continue;
				if(min>n)	min=n;
			}
			
			//모든 배열 원소 -min 해주고, 0이 제일 많이 붙어있는 개수 구하기
			int cnt=0;
			for (int i = 0; i < stones.length; i++) {
				stones[i]-=min;
				if(stones[i]<0) {
					stones[i] = 0;
				}
				if(stones[i]==0)	++cnt;
				else {
					zeroLen = Math.max(zeroLen, cnt);
					cnt=0;
				}
			}
			zeroLen = Math.max(zeroLen, cnt);
			System.out.println("min:"+min+", zeroLen:"+zeroLen);
			answer+=min;
		}
		return answer;
	}
	
	private int solution2(int[] stones, int k) {
		int answer = 0;
		
		int[] sortedStones = new int[stones.length];
		int tmp = 0 ;
		for(int n : stones)
			sortedStones[tmp++] = n;
		
		Arrays.sort(sortedStones);
		
		int minIdx = 0,zeroLen = 0;
		int prevmin = 0;
		int min = 0;
		while(zeroLen < k && zeroLen!=stones.length) {
			
			while(minIdx<sortedStones.length &&sortedStones[minIdx]==prevmin) {
				++minIdx;
			}
			if(minIdx==sortedStones.length)	break;
			min = sortedStones[minIdx]-prevmin;
			prevmin=sortedStones[minIdx++];
			
			//모든 배열 원소 -min 해주고, 0이 제일 많이 붙어있는 개수 구하기
			int cnt=0;
			for (int i = 0; i < stones.length; i++) {
				stones[i]-=min;
				if(stones[i]<0) {
					stones[i] = 0;
				}
				if(stones[i]==0)	++cnt;
				else {
					zeroLen = Math.max(zeroLen, cnt);
					cnt=0;
				}
			}
			zeroLen = Math.max(zeroLen, cnt);
			System.out.println("min:"+min+", zeroLen:"+zeroLen);
			answer+=min;
		}
		
		
		return answer;
	}
}
