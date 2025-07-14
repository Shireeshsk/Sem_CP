package Unit4;
import java.util.*;
public class ParallelCourse2 {
    public static int helper(int n,int arr[][],int k){
        int indeg[] = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int sk[] : arr){
            res.get(sk[0]).add(sk[1]);
            indeg[sk[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int sem = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            int take = Math.min(k, size);
            for(int i = 0;i<take;i++){
                list.add(q.remove());
            }
            for(int sk : list){
                for(int nei : res.get(sk)){
                    indeg[nei]--;
                    if(indeg[nei]==0){
                        q.add(nei);
                    }
                }
            }
            sem++;
        }
        return sem;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int arr[][] = new int[v][2];
        for(int i = 0;i<v;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(helper(n, arr, k));
        sc.close();
    }
}
