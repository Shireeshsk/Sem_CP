package Unit4;
import java.util.*;
public class CourseSchedule2 {
    public static List<Integer> helper(int n,int arr[][]){
        int indeg[] = new int[n];
        List<Integer> res = new ArrayList<>();
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
            res.add(sk);
            num++;
            for(int nei : list.get(sk)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        return num==n?res:new ArrayList<>();
    }
}
