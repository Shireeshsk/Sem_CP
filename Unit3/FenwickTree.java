package Unit3;
import java.util.*;
public class FenwickTree {
    static class Fenwick{
        int BIT[];
        int size;
        Fenwick(int n){
            this.size = n;
            this.BIT = new int[n+1];
        }
        public void update(int idx,int val){
            while(idx<=size){
                BIT[idx]+=val;
                idx +=(idx&-idx);
            }
        }

        public int query(int i){
            int sum = 0;
            while(i>0){
                sum += BIT[i];
                i -= (i & -i);
            }
            return sum;
        }
        public int rangeQuery(int l,int r){
            return query(r)-query(l-1);
        }
        public void build(int arr[]){
            for(int i = 0;i<arr.length;i++){
                update(i+1,arr[i]);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Fenwick tree = new Fenwick(n);
        tree.build(arr);
        System.out.println(tree.rangeQuery(1,3));
        sc.close();
    }
}
