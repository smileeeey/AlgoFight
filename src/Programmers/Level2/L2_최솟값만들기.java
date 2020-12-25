package Programmers.Level2;

import java.util.Arrays;

public class L2_최솟값만들기 {

	public static void main(String[] args) {
		System.out.println(new L2_최솟값만들기().solution(new int[] {1,2}, new int[] {3,4}));
	}

	private int solution(int[] A, int[] B) {
		int answer = 0;
		
		int len = A.length;
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < len; i++) {
			answer+=(A[i]*B[len-i-1]);
		}
		
		return answer;
	}
	
	private int solution2(int[] A, int[] B) {
		int answer = 0;
		
		int len = A.length;
		
		quickSort(A,0,len-1);
		quickSort(B,0,len-1);
		
		for (int i = 0; i < len; i++) {
			answer+=(A[i]*B[len-i-1]);
		}
		
		return answer;
	}
	
	public static void quickSort(int[] arr, int left, int right)
    {
        int i, j, pivot, tmp;

        if (left < right) {
            i = left;
            j = right;
            pivot = arr[left];
            //분할 과정
            while (i < j) {
                while (arr[j] > pivot) j--;
                while (i < j && arr[i] <= pivot) i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            arr[left] = arr[i];
            arr[i] = pivot;
            //정렬 과정
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

}
