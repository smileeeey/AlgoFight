package Programmers.Level1;

public class L1_2016년 {

	String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
	int[] date = {0,31,29,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		System.out.println(new L1_2016년().solution(5,24));
		
	}
	
	public String solution(int a,int b) {
		int dateSum = 0;
		
		for (int i = 1; i < a; i++) {
			dateSum+=date[i];
		}
		dateSum+=b-1;
		
		
		
		return day[dateSum%7];
	}

}
