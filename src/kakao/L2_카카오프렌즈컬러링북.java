package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class L2_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		new L2_카카오프렌즈컬러링북().solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
	}
	
	int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(picture[i][j]!=0 && !visited[i][j]) {
					++numberOfArea;
					//i,j 부터 bfs 돌리기!
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
					
					int fillCnt = 1;
					
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						int curColor = picture[cur[0]][cur[1]];
						
						for (int k = 0; k < dxdy.length; k++) {
							int rx = cur[0]+dxdy[k][0];
							int ry = cur[1]+dxdy[k][1];
							
							if(rx<0 || ry<0 || rx>=m || ry>=n || picture[rx][ry]!=curColor || visited[rx][ry])	continue;
							queue.offer(new int[] {rx,ry});
							visited[rx][ry] = true;
							++fillCnt;
						}
					}
					
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, fillCnt);
				}
			}
		}
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
