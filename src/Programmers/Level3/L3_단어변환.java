package Programmers.Level3;

import java.util.LinkedList;
import java.util.Queue;

public class L3_단어변환 {

	public static void main(String[] args) {
		System.out.println(new L3_단어변환().solution("hit","cog",new String[] {"hot", "dot", "dog", "lot", "log"}));
	}

	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //BFS를 써야 될듯...
        answer = BFS(begin,target,words);
        
        return answer;
    }
	
	public int BFS(String begin, String target, String[] words) {
		
		Queue<String> queue= new LinkedList<>();
		
		queue.offer(begin);

		int cnt = 0;
		while(!queue.isEmpty()) {
			
			++cnt;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				
				for(int j = 0 ; j < words.length ; ++j) {
					if(words[j].equals(cur)) {
						words[j] = "";
						continue;
					}
					
					if(checkWord(cur,words[j])) {
						if(words[j].equals(target))	return cnt;
						queue.offer(words[j]);
					}
				}
			}
		}
	
		return 0;
	}

	private boolean checkWord(String cur, String word) {
		
		if(cur.length()!=word.length())	return false;
		
		char[] ch1 = cur.toCharArray();
		char[] ch2 = word.toCharArray();
		
		boolean difficult = false;
		
		for (int i = 0; i < ch2.length; i++) {
			if(ch1[i]!=ch2[i]) {
				if(difficult)	return false;
				difficult = true;
			}
		}
		
		return true;
	}

}
