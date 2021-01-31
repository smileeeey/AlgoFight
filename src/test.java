import java.util.HashMap;

public class test {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put("A", 10);
		
		aa(map);
		
		System.out.println(map.get("A"));
	}

	private static void aa(HashMap map) {
		map.put("A", 20);
	}
}
