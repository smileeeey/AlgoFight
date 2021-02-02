package 삼성SW모의역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236_아기상어 {

	public final static int[][] dxdy = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	public static int N,sharkSize=2;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		List<int[]> fishes = new ArrayList<>();

		int[] shark = new int[2];
		int answer = 0;

		N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == 0)
					continue;

				if (tmp == 9) {
					shark[0] = i;
					shark[1] = j;
					continue;
				}

				fishes.add(new int[] { i, j, tmp });
				map[i][j] = tmp;
			}
		}

		int cnt = 0;

		while (true) {

			Collections.sort(fishes, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {

					return o1[2] - o2[2];
				}
			});

			// 더이상 먹을 물고기 없으면 끝!
			if (fishes.size() == 0 || fishes.get(0)[2] >= sharkSize) {
				break;
			}

			// 상어가 닿을 수 있는지에 따라 min~ 값
			// data => {최소거리,fish인덱스}
			int[] data = calDistance(shark[0], shark[1], sharkSize, fishes, map);

			if (data[0] == -1)
				break;

			answer += data[0];
			
			int[] eatenFish = fishes.get(data[1]);
			++cnt;
			// 상어 위치 옮기기
			shark[0] = eatenFish[0];
			shark[1] = eatenFish[1];
			// 먹은 물고기 크기에 따라 상어 크기 변화
			if (cnt == sharkSize) {
				++sharkSize;
				cnt = 0;
			}
			// 먹은 물고기 물고기 리스트에서 삭제
			map[eatenFish[0]][eatenFish[1]] = 0;
			fishes.remove(data[1]);
		}

		System.out.println(answer);
	}

	private static int[] calDistance(int sharkX, int sharkY, int sharkSize, List<int[]> fishes, int[][] map) {
		int dist = 1;
		
		boolean isVisited[][] = new boolean[N][N];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { sharkX, sharkY });
		isVisited[sharkX][sharkY] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();

				for (int j = 0; j < dxdy.length; j++) {
					int nX = cur[0] + dxdy[j][0];
					int nY = cur[1] + dxdy[j][1];
					
					for (int k = 0; k < fishes.size(); k++) {
						int[] fish = fishes.get(k);
						if(fish[2]>=sharkSize)	continue;
						if(fish[0]==nX && fish[1] == nY) {
							return new int[] {dist,k};
						}
					}
					

					if (nX < 0 || nX >= N || nY < 0 || nY >= N || isVisited[nX][nY])
						continue;

					if (map[nX][nY] > sharkSize)
						continue;

					queue.offer(new int[] { nX, nY });
				}
			}
			++dist;
		}
		
		return new int[] {-1,-1};
	}

	private static int calDistance(int sharkX, int sharkY, int sharkSize, int fishX, int fishY, int[][] map) {

		int dist = 1;

		boolean isVisited[][] = new boolean[N][N];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { sharkX, sharkY });
		isVisited[sharkX][sharkY] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();

				for (int j = 0; j < dxdy.length; j++) {
					int nX = cur[0] + dxdy[j][0];
					int nY = cur[1] + dxdy[j][1];

					if (nX == fishX && nY == fishY)
						return dist;

					if (nX < 0 || nX >= N || nY < 0 || nY >= N || isVisited[nX][nY])
						continue;

					if (map[nX][nY] > sharkSize)
						continue;

					queue.offer(new int[] { nX, nY });
				}
			}
			++dist;
		}

		// 상어가 못가면
		return -1;
	}

}
