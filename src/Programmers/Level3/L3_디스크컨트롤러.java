package Programmers.Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L3_디스크컨트롤러 {

	public static void main(String[] args) {
		System.out.println(new L3_디스크컨트롤러().solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
	}

	public int solution(int[][] jobs) {
        int answer = 0;
        
        boolean[] isVisited = new boolean[jobs.length];
        List<int[]> list = new ArrayList<>();
        
        int cnt = 0;
        int curTime = 0;
        
        
        while(true) {
        	
        	//끝까지 다돌았으면 끝!
        	if(cnt==jobs.length)	break;
        	
        	//1. jobs중 현재 타임보다 전에 시작한 visited false인 것들 리스트에 넣기
        	for (int i = 0; i < jobs.length; i++) {
				if(isVisited[i])	continue;
        		if(jobs[i][0]<=curTime) {
        			list.add(jobs[i]);
        			isVisited[i] = true;
        		}
			}
        	
        	if(list.size()==0) {
        		curTime++;
        		continue;
        	}
        	
        	//현재 리스트에 있는 것 중에서 가장 짧게 끝나는거 꺼내서 작업
        	Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
        	});
        	
        	answer = answer + curTime-list.get(0)[0] + list.get(0)[1];
        	curTime += list.get(0)[1];
        	list.remove(0);
        	cnt++;
        	
        }
        
        
        return answer/jobs.length;
    }

}
