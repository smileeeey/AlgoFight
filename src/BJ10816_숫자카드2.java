
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10816_숫자카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[20000001]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			++arrN[Integer.parseInt(st.nextToken())+10000000];
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(arrN[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
