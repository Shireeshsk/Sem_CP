package Unit4;
import java.util.*;
public class CourseSchedule1 {
    public static boolean helper(int n,int arr[][]){
        int indeg[] = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int sk[] : arr){
            list.get(sk[0]).add(sk[1]);
            indeg[sk[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int num = 0;
        while(!q.isEmpty()){
            int sk = q.remove();
            num++;
            for(int nei : list.get(sk)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        return num==n;
    }
}
