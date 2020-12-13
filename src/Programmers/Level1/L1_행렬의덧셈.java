package Programmers.Level1;

public class L1_행렬의덧셈 {

	public static void main(String[] args) {
		new L1_행렬의덧셈().solution(new int[][] {{1,2},{2,3}},new int[][] {{3,4},{5,6}});
	}

	private int[][] solution(int[][] arr1, int[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				arr1[i][j]+=arr2[i][j];
			}
		}
		return arr1;
	}

}
