package Unit4;

import java.util.*;
public class ArticulationPoint {
    public static int timer = 1;
    public static List<Integer> helper(int n,int arr[][]){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int sk[] : arr){
            list.get(sk[0]).add(sk[1]);
            list.get(sk[1]).add(sk[0]);
        }
        int low[] = new int[n];
        int tin[] = new int[n];
        boolean vis[] = new boolean[n];
        boolean isArticulation[] = new boolean[n];
        List<Integer> art = new ArrayList<>();
        dfs(0,-1,list,vis,low,tin,isArticulation);
        for(int i = 0;i<n;i++){
            if(isArticulation[i]) art.add(i);
        }
        return art;
    }

    public static void dfs(int node,int parent,List<List<Integer>> list,boolean vis[],int low[],int tin[],boolean isArticulation[]){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int ch = 0;
        for(int nei: list.get(node)){
            if(nei==parent) continue;
            if(!vis[nei]){
                dfs(nei,node,list,vis,low,tin,isArticulation);
                low[node] = Math.min(low[node],low[nei]);
                if(parent!=-1 && low[nei]>=tin[node]){
                    isArticulation[node] = true;
                }
                ch++;
            }
            else{
                low[node] = Math.min(low[node],tin[nei]);
            }
        }
        if(parent==-1 && ch>1){
            isArticulation[node] = true;
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
        List<Integer> articulationPoints = helper(n, arr);
        System.out.println("Articulation Points: " + articulationPoints); // Output: [1, 3]
    }
}
