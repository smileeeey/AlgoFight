import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1493_박스채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = 0;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int length = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height  = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> cubes = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			cubes.get(i)[0] = Integer.parseInt(st.nextToken());
			cubes.get(i)[1] = Integer.parseInt(st.nextToken());
		}
		
		
	}

}
