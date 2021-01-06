package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class L2_파일명정렬 {

	public static void main(String[] args) {
		new L2_파일명정렬().solution(new String[] {"muzi01a10.png","MUZI01.zip","a ","foo010bar020.zip"});
	}

	public String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				//head, number, tail 구분하기
				String head1="",head2="";
				int number1=0, number2=0;
				
				boolean isCheck1 = false;
				int numberCnt = 0;
				for(char ch : o1.toCharArray()) {
					if(ch>='0' && ch<='9') {
						isCheck1 = true;
						number1*=10;
						number1+=(ch-'0');
						++numberCnt;
						if(numberCnt==5)	break;
					}
					else if(ch=='.'){
						break;
					}
					else {
						if(isCheck1)	break;
						head1+=ch;
					}
					
				}
				isCheck1 = false;
				numberCnt = 0;
				for(char ch : o2.toCharArray()) {
					if(ch>='0' && ch<='9') {
						isCheck1 = true;
						number2*=10;
						number2+=(ch-'0');
						++numberCnt;
						if(numberCnt==5)	break;
					}
					else if(ch=='.'){
						break;
					}
					else {
						if(isCheck1)	break;
						head2+=ch;
					}
					
				}
				
				head1 = head1.toUpperCase();
				head2 = head2.toUpperCase();
				
				//System.out.println(o1+": "+head1+" "+number1);
				//System.out.println(o2+": "+head2+" "+number2);
				
				//1. head는 대소문자 구분없이 사전순
				if(!head1.equals(head2))
					return head1.compareTo(head2);
				//2. number도 오름차순
				if(number1!=number2)
					return number1-number2;
				//3. 여기까지 같다면 들어온 순서대로
				return 1;
			}
			
		});
		
		System.out.println(Arrays.toString(files));
        return files;
	}

}
