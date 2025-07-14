import java.util.*;
public class MaximumSubArraySum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(helper(arr,k));
        sc.close();
    }

    public static int helper(int arr[],int k){
        int res = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        for(int j = 0;j<k;j++){
            sum += arr[j];
        }
        for(int j = k;j<arr.length;j++){
            res = Math.max(res,sum);
            sum-=arr[i++];
            sum+=arr[j];
        }
        res = Math.max(res,sum);
        return res;
    }
}