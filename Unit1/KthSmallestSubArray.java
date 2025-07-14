import java.util.*;
public class KthSmallestSubArray {
    public static int helper(int arr[],int k){
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int i : arr){
            left = Math.min(left,i);
            right += i;
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(countarr(arr,mid)>=k){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int countarr(int arr[],int mid){
        int csum = 0;
        int j = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            csum += arr[i];
            while(csum>mid){
                csum -= arr[j++];
            }
            count += i-j+1;
        }
        return count;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(helper(arr, k));
        sc.close();
    }
}
