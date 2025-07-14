import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void rotate(int arr[],int k){
        k = k%arr.length;
        helper(0,k-1,arr);
        helper(k,arr.length-1,arr);
        helper(0,arr.length-1,arr);
    }

    public static void helper(int start,int end,int arr[]){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
