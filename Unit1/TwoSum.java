import java.util.*;
public class TwoSum {
    public static int[] helper(int arr[],int tar){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int s = arr[left]+arr[right];
            if(s==tar) return new int[]{left+1,right+1};
            if(s>tar){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(helper(arr, target)));
        sc.close();
    }
}
