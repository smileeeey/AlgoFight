package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class L2_프렌즈4블록 {

	public static void main(String[] args) {
		System.out.println(new L2_프렌즈4블록().solution(6,2,new String[] {"AA", "AA", "CC", "AA", "AA", "DD"}));
	}

	public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][];
        
        
        for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
        
        
        while(true) {
        	
        	//지울 블록 체크
        	List<int[]> list= checkRemoveBlock(map);
        	
        	if(list.size()==0)	break;
        	
        	//블록 지우기
        	for(int[] s : list) {
        		if(map[s[0]][s[1]] == '0')	continue;
        		map[s[0]][s[1]] = '0';
        		++answer;
        	}
        	
        	//블록 내리기
        	for (int i = 0; i < n; i++) {
        		List<Integer> blank = new ArrayList<>();
				for (int j = m-1; j >=0; j--) {
					if(map[j][i]!='0') {
						if(blank.size()==0)	continue;
						
						map[blank.get(0)][i] = map[j][i];
						blank.remove(0);
						map[j][i] = '0';
					}
					else
						blank.add(j);
				}
			}
        	
        }
        
        return answer;
    }

	public List<int[]> checkRemoveBlock(char[][] map) {
		List<int[]> list = new ArrayList<>();
		
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[0].length-1; j++) {
				char cur = map[i][j];
				if(cur=='0')	continue;
				if(map[i][j+1] == cur && map[i+1][j] == cur && map[i+1][j+1] == cur ) {
					list.add(new int[] {i,j});
					list.add(new int[] {i,j+1});
					list.add(new int[] {i+1,j});
					list.add(new int[] {i+1,j+1});
				}
			}
		}
		
		return list;
	}

}
