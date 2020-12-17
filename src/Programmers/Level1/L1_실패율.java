package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1_실패율 {

	public static void main(String[] args) {
		new L1_실패율().solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
	}

	private int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] values = new int[N];
		double[] num = new double[N+2];
		Map<Integer,Double> map = new HashMap<>();
		for(int stage : stages) {
			++num[stage];
		}
		
		int playerNum = stages.length;
		
		for (int i = 1; i <= N; i++) {
			double cur = num[i];
			map.put(i, (playerNum!=0 && cur!=0)? cur/playerNum:0);
			playerNum-=cur;
			if(playerNum<=0)	break;
		}
		
		
		
		int idx=0;
		for(int key : map.keySet()) {
			answer[idx++] = key;
		}
		return answer;
	}

	
	
}
