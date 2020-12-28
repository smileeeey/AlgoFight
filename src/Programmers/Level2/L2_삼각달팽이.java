package Programmers.Level2;

public class L2_삼각달팽이 {

   public static void main(String[] args) {
      new L2_삼각달팽이().solution(5);
   }

   public int[] solution(int n) {
      
      int[][] map = new int[n][n];
      
      int num = 1;
      int top=0, bottom = n-1, left = 0, right = n-1;
      
      while(true) {
         
         //아래로
         int cur = top; 
         while(cur<=bottom) {
            map[cur++][left] = num++;
         }
         top++;
         left++;
         
         if(top>bottom && left>right)   break;
         
         //오른쪽으로
         cur = left; 
         while(cur<=right) {
            map[bottom][cur++] = num++;
         }
         bottom--;
         right--;
         
         if(top>bottom && left>right)   break;
         
         //대각선 위로
         cur = bottom;
         int cur2 = right;
         while(cur>=top) {
            map[cur--][cur2--] = num++;
         }
         --right;
         ++top;
         if(top>bottom && left>right)   break;
      }
      
      //1+2+3+4+5 = 6*2.5 = 15
      //1+2+3+...+n = (1+n)*(n/2)
      int[] answer = new int[(int)((1+n)*(n/2.0))];
      
      int tmp = 0;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j <= i; j++) {
            answer[tmp++] = map[i][j];
            //System.out.print(map[i][j]+" ");
         }
         //System.out.println();
      }
      
      return answer;
   }

}