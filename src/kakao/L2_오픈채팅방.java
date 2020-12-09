package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L2_오픈채팅방 {

	public static void main(String[] args) {
		new L2_오픈채팅방().solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
	}
	public String[] solution(String[] record) {
        String[] answer = null;
        HashMap<String,String> idname = new HashMap<String,String>();
        
        List<String> listAnswer = new ArrayList<>();
        
        List<String> userId = new ArrayList<>();
        List<Integer> status = new ArrayList<>();
        
        for(String rec : record) {
        	String[] r = rec.split(" ");
        	userId.add(r[1]);
        	if(r[0].equals("Enter")) {
        		idname.put(r[1], r[2]);
        		status.add(1);
        	}
        	else if(r[0].equals("Leave"))	status.add(0);
        	else{
        		idname.put(r[1], r[2]);
        		status.add(-1);
        	}
        }
        
        for (int i = 0; i < status.size(); i++) {
			
        	if(status.get(i)==1) {
        		listAnswer.add(idname.get(userId.get(i))+"님이 들어왔습니다.");
        	}
        	else if(status.get(i)==0) {
        		listAnswer.add(idname.get(userId.get(i))+"님이 나갔습니다.");
        	}
		}
        
        answer = new String[listAnswer.size()];
        
        for (int i = 0; i < listAnswer.size(); i++) {
			answer[i] = listAnswer.get(i);
		}
        
        return answer;
    }
}
