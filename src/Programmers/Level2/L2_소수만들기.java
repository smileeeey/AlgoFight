package Programmers.Level2;

public class L2_소수만들기 {

	public static void main(String[] args) {
		System.out.println("답은:"+new L2_소수만들기().solution(new int[] {1,2,4}));
	}

	private int solution(int[] nums) {
		int answer = 0;
		
		int totalCnt = nums.length;
		
		for (int i = 1; i < 1<<totalCnt; i++) {
			int cnt=0;
			int sum=0;
			for (int j = 0; j < totalCnt; j++) {
				if((i&(1<<j)) == (1<<j)) {
					System.out.print(nums[j]+" ");
					++cnt;
					sum+=nums[j];
				}
			}
			if(cnt==3) {
				//sum이 소수인지 체크
				boolean check = true;
				for (int j = 2; j < sum ; j++) {
					if(sum%j==0) {
						check = false;
						break;
					}
				}
				
				if(check) {
					++answer;
					System.out.print("   "+sum);
				}
			}
			System.out.println();
		}
		
		return answer;
	}
}
