package Programmers.Level1;

public class L1_비밀지도 {

	public static void main(String[] args) {
		new L1_비밀지도().solution(5,new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
	}

	private String[] solution(int n, int[] arr1, int[] arr2) {
		
		String[] str = new String[n];
		
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			
			int tmp = arr1[i] | arr2[i];
			int j = (int) Math.pow(2, n-1);
		
			for (int j2 = 0; j2 < n; j2++) {
				if(tmp>=j) {
					tmp-=j;	
					sb.append("#");
				}
				else	sb.append(" ");
				j/=2;
			}
			
			str[i] = sb.toString();
		}
		return str;
	}

}
