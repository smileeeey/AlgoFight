package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class L2_캐시 {

	public static void main(String[] args) {
		System.out.println(new L2_캐시().solution(5,new String[] {"Seoul", "Seoul", "Seoul"}));
	}

	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> cache = new ArrayList<>();
        
        for(String city : cities) {
        	if(cache.contains(city.toUpperCase())) {
        		cache.remove(city.toUpperCase());
        		cache.add(city.toUpperCase());
        		answer+=1;
        	}
        	else {
        		answer+=5;
        		cache.add(city.toUpperCase());
        		if(cache.size() > cacheSize)	cache.remove(0);
        	}
        }
        
        return answer;
    }

}
