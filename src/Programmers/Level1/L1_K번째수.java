package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1_K번째수 {
	public static void main(String[] args) {
		new L1_K번째수().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
	}
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
			List<Integer> list = new ArrayList<>();
			
			for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {
				list.add(array[j]);
			}
			
			Collections.sort(list);
			
			answer[i] = list.get(commands[i][2]-1);
			System.out.println(answer[i]);
		}
        
        return answer;
    }
}
