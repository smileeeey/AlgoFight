package Programmers.Level1;

public class L1_다트게임 {

	public static void main(String[] args) {
		System.out.println(new L1_다트게임().solution("1S*2T*3S"));
	}

	private int solution(String dartResult) {
		int[] ans = new int[3];
		int idx = -1;
		char[] chs = dartResult.toCharArray();
		for(int i = 0 ; i < chs.length ; ++i) {
			char c = chs[i];
			
			// 점수
			if('0'<=c && '9'>=c) {
				int num = 0;
				++idx;
				while('0'<=c && '9'>=c) {
					if(num>0)	++i;
					num*=10;
					num+=(c-'0');
					c = chs[i+1];
				}
				ans[idx] = num;
			}
			// 보너스
			else if(c=='S'||c=='D'||c=='T') {
				int pow = 1;
				switch(c) {
					case 'D':
						pow=2;
						break;
					case 'T':
						pow=3;
						break;
				}
				ans[idx]=(int) Math.pow(ans[idx], pow);
			}
			//옵션
			else {
				switch(c) {
				case '*':
					ans[idx]*=2;
					if(idx-1>=0)	ans[idx-1]*=2;
					break;
				case '#':
					ans[idx]*=(-1);
					break;
				}
			}
			
		}
		
		return ans[0]+ans[1]+ans[2];
	}

}
