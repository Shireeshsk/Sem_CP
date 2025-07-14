package Unit4;
import java.util.*;
public class ConnectedComponents {
    public static void helper(int n,int edges[][]){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int sk[] : edges){
            adj.get(sk[0]).add(sk[1]);
            adj.get(sk[1]).add(sk[0]);
        }
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                System.out.println();
            }
        }
    }

    public static void dfs(int node,List<List<Integer>> adj,boolean vis[]){
        vis[node] = true;
        System.out.print(node + " ");
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[e][2];
        for(int i = 0;i<e;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        helper(n, arr);
        sc.close();
    }
}
