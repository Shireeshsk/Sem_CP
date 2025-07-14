import java.util.*;
public class DistinctNumbers {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(helper(arr,k)));
        sc.close();
    }

    public static int[] helper(int arr[],int k){
        int res[] = new int[arr.length-k+1];
        int idx = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<k;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        int sk = 0;
        res[sk] = map.size();
        sk++;
        for(int i = k;i<arr.length;i++){
            if(map.get(arr[idx])==1){
                map.remove(arr[idx]);
            }
            else{
                map.put(arr[idx],map.get(arr[idx])-1);
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);
            }
            res[sk] = map.size();
            sk++;
            idx++;
        }
        return res;
    }
}
