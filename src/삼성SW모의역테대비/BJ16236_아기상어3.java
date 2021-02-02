package 삼성SW모의역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236_아기상어3 {

	static class Fish {
		int x;
		int y;
		int size;
		int dist;
		int idx;
		
		public Fish(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}

		public void setDist(int dist) {
			this.dist = dist;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public Fish() {
			super();
		}
	}

	private static int N, dxdy[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, distMap[][],originMap[][];
	private static PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {

		@Override
		public int compare(Fish o1, Fish o2) {
			if (o1.dist == o2.dist) {
				if (o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
			return o1.dist - o2.dist;
		}

	});

	public static void main(String[] args) throws NumberFormatException, IOException {

		Fish shark = new Fish();
		List<Fish> fishes = new ArrayList<>();
		int answer = 0, eatenCnt=0;

		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		originMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == 0)
					continue;

				if (tmp == 9) {
					shark = new Fish(i, j, 2);
					continue;
				}
				originMap[i][j] = tmp;
				fishes.add(new Fish(i, j, tmp));
			}
		}

		// 2. bfs
		while (true) {
			distMap = new int[N][N];
			pq.clear();
			bfs(shark,fishes);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(distMap[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------------");
			
			for (int i = 0; i < fishes.size(); i++) {
				Fish fish = fishes.get(i);
				if (fish.size < shark.size) {
					fish.setDist(distMap[fish.x][fish.y]);
					fish.setIdx(i);
					pq.offer(fish);
					
				}
			}
			
			if(pq.size()==0)	break;
			
			Fish eatenFish = pq.poll();
			originMap[eatenFish.x][eatenFish.y] = 0;
			answer += eatenFish.dist;
			++eatenCnt;
			if(eatenCnt == shark.size) {
				shark.size++;
				eatenCnt = 0;
			}
			
			fishes.remove(eatenFish.idx);
			shark.x = eatenFish.x;
			shark.y = eatenFish.y;
			System.out.println(eatenFish.dist);
			System.out.println("먹은 물고기 개수:"+eatenCnt+" "+"상어 크기:"+shark.size);
			System.out.println("누적 거리:"+answer);
			
		}
		
		System.out.println(answer);

	}

	private static void bfs(Fish shark,List<Fish> fishes) {
		boolean[][] visited = new boolean[N][N];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { shark.x, shark.y });

		visited[shark.x][shark.y] = true;
		int dist = 1;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();

				for (int j = 0; j < dxdy.length; j++) {
					int nX = cur[0] + dxdy[j][0];
					int nY = cur[1] + dxdy[j][1];

					if (nX < 0 || nX >= N || nY < 0 || nY >= N || visited[nX][nY])
						continue;
					
					if(originMap[nX][nY] > shark.size)	continue;
					
					queue.offer(new int[] {nX,nY});
					distMap[nX][nY] = dist;
					visited[nX][nY] = true;
					
				}

			}
			++dist;
		}

	}

}
