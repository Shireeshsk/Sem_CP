package Unit4;
import java.util.*;
public class Bridges {
    public static int timer = 1;
    public static List<List<Integer>> helper(int n,int arr[][]){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int sk[] : arr){
            list.get(sk[0]).add(sk[1]);
            list.get(sk[1]).add(sk[0]);
        }
        boolean vis[] = new boolean[n];
        int low[] = new int[n];
        int tin[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,low,tin,list,bridges);
        return bridges;
    }

    public static void dfs(int node,int parent,boolean vis[],int low[],int tin[],List<List<Integer>> adj,List<List<Integer>> bridges){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int nei : adj.get(node)){
            if(nei==parent) continue;
            if(!vis[nei]){
                dfs(nei,node,vis,low,tin,adj,bridges);
                low[node] = Math.min(low[node],low[nei]);
                if(low[nei]>tin[node]){
                    bridges.add(Arrays.asList(nei,node));
                }
            }
            else{
                low[node] = Math.min(low[node],low[nei]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] arr = {
            {0, 1},
            {1, 2},
            {2, 0},
            {1, 3},
            {3, 4}
        };
        List<List<Integer>> bridges = helper(n, arr);
        System.out.println("Bridges in the graph:");
        for (List<Integer> bridge : bridges) {
            System.out.println(bridge);
        }
    }
}
