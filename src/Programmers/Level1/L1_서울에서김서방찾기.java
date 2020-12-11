package Programmers.Level1;

public class L1_서울에서김서방찾기 {

	public static void main(String[] args) {
		System.out.println(new L1_서울에서김서방찾기().solution(new String[] {"Jane","Kim"}));
	}

	private String solution(String[] seoul) {
		StringBuilder sb = new StringBuilder();
		int i=0;
		for (i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim"))	break;
		}
		sb.append("김서방은 ").append(i).append("에 있다");
	
		return sb.toString();
	}

}
