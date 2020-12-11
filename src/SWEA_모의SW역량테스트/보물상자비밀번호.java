package SWEA_모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 보물상자비밀번호 {

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;
      
      int T = Integer.parseInt(br.readLine());
      
      for (int t = 1; t <= T; t++) {
         
         Set<Integer> set = new HashSet<Integer>();
         
         st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         int K = Integer.parseInt(st.nextToken());
         
         char[] input = br.readLine().toCharArray();
         char[] chs = new char[input.length*2];
         
         for (int i = 0; i < N; i++) {
            chs[i]=input[i];
            chs[i+N]=input[i];
         }
         
         for (int i = 0; i < N/4; i++) {
            int flag = 0;
            char[] num = new char[N/4];
            for (int j = N-i; j < 2*N-i; j++) {
               num[flag++]=chs[j];
               
               if(flag == N/4) {

                  int setItem = 0;
                  
                  for (int j2 = 0; j2 < N/4; j2++) {
                     setItem*=16;
                     if(num[j2]>='0'&&num[j2]<='9')   setItem+=(num[j2]-'0');
                     else   setItem+= (num[j2]-'A'+10);
                  }
                  set.add(setItem);
                  
                  flag=0;
               }
            }
         }
         
         List<Integer> list = new ArrayList<>();
         for(int n : set) {
            list.add(n);
         }
         
         Collections.sort(list,Collections.reverseOrder());
         
         
         System.out.println("#"+t+" "+list.get(K-1));
         
      }
   
   }

}