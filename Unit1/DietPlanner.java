import java.util.*;
public class DietPlanner {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int low = sc.nextInt();
        int up = sc.nextInt();
        System.out.println(helper(arr,k,low,up));
        sc.close();
    }

    public static int helper(int arr[],int k ,int low ,int up){
        int res = 0;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += arr[i];
        }
        if(sum<low) res--;
        else if(sum>up) res++;
        int idx = 0;
        for(int i = k;i<arr.length;i++){
            sum-=arr[idx++];
            sum += arr[i];
            if(sum<low) res--;
            else if(sum>up) res++;
        }
        return res;
    }
}
