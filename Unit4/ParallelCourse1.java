package Unit4;
import java.util.*;
public class ParallelCourse1 {
    public static int helper(int n,int arr[][]){
        int indeg[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int sk[]:arr){
            adj.get(sk[0]).add(sk[1]);
            indeg[sk[1]]++;
        }
        int sem = 0;
        int courses = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            sem++;
            for(int i = 0;i<size;i++){
                int rem = q.remove();
                courses++;
                for(int sk : adj.get(rem)){
                    indeg[sk]--;
                    if(indeg[sk]==0){
                        q.add(sk);
                    }
                }
            }
        }
        return courses==n?sem:-1;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {
            {1,0},
            {2,1},
            {3,2}
        };
        System.out.println(ParallelCourse1.helper(n, prerequisites)); // Output: 4
    }

}
