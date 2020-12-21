package Programmers.Level2;

public class L2_행렬의곱셈 {

	public static void main(String[] args) {
		new L2_행렬의곱셈().solution(new int[][] {{1, 4}, {3, 2}, {4, 1}}, new int[][] {{3, 3}, {3, 3}});
	}

	private int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
	
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				int mul = 0;
				
				for (int k = 0; k < arr1[0].length; k++) {
					mul += (arr1[i][k]*arr2[k][j]);
				}
				
				answer[i][j] = mul;
			}
			
		}
		
		return answer;
	}

}
