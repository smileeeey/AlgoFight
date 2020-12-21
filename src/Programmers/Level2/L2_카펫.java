package Programmers.Level2;

public class L2_카펫 {

	public static void main(String[] args) {
		new L2_카펫().solution(24,24);
	}

	private int[] solution(int brown, int yellow) {
		
		//brown + yellow 가 나눠지는 때
		int sum = brown + yellow;
		for (int W = 3; W <= sum; W++) {
			if(sum%W==0) {
				int H = sum/W;
				if(W<H)	continue;
				// W와 H로 brown, yellow를 만족시키는지
				int calBrown = (W+H)*2-4;
				int calYellow = (W-2)*(H-2);
				if(calBrown == brown && calYellow == yellow) {
					return new int[] {W,H};
				}
			}
		}
		return new int[] {0,0};
	}
}
