package SWEA_삼성SW역량테스트기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA14499_주사위굴리기 {
	static int[][] dxdy = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	
	static class Dice{
		int one,two,three,four,five,six;

		public Dice() {
			super();
		}

		public Dice(int one, int two, int three, int four, int five, int six) {
			super();
			this.one = one;
			this.two = two;
			this.three = three;
			this.four = four;
			this.five = five;
			this.six = six;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Dice dice = new Dice();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		loop:
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			
			if(x+dxdy[dir][0]<0 || x+dxdy[dir][0]>=N || y+dxdy[dir][1]<0 || y+dxdy[dir][1]>=M) {
				continue loop;
			}	
			
			x+=dxdy[dir][0];
			y+=dxdy[dir][1];
			
			switch(dir) {
				case 1:
					dice=moveDir1(dice);
					break;
				case 2:
					dice=moveDir2(dice);
					break;
				case 3:
					dice=moveDir3(dice);
					break;
				case 4:
					dice=moveDir4(dice);
					break;
			}
			if(map[x][y] == 0)	map[x][y] = dice.six;
			else {
				dice.six = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice.one);
			
		}
		
		
		
		
	}

	
	//3차원 배열로 만들고 하나의 함수로 처리 가능
	public static Dice moveDir1(Dice dice) {
		
		Dice D = new Dice();
		
		D.six = dice.three;
		D.four = dice.six;
		D.one = dice.four;
		D.three = dice.one;
		D.two = dice.two;
		D.five = dice.five;
		
		return D;
	}
	
	public static Dice moveDir2(Dice dice) {
		
		Dice D = new Dice();
		
		D.four = dice.one;
		D.six = dice.four;
		D.three = dice.six;
		D.one = dice.three;
		D.two = dice.two;
		D.five = dice.five;
		
		return D;
	}
public static Dice moveDir3(Dice dice) {
		
		Dice D = new Dice();
		
		D.two = dice.one;
		D.six = dice.two;
		D.five = dice.six;
		D.one = dice.five;
		D.three = dice.three;
		D.four = dice.four;
		
		return D;
	}
	
	public static Dice moveDir4(Dice dice) {
		
		Dice D = new Dice();
		
		D.five = dice.one;
		D.six = dice.five;
		D.two = dice.six;
		D.one = dice.two;
		D.three = dice.three;
		D.four = dice.four;
		
		return D;
	}
	
}
