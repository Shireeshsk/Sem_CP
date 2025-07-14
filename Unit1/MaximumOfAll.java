import java.util.*;
public class MaximumOfAll {
    public static List<Integer> helper(int arr[],int k){
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>() ;
        for(int i = 0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res.add(arr[dq.peekFirst()]);
            }
        }
        return res;
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
