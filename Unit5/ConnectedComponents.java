package Unit5;
import java.util.*;
public class ConnectedComponents {
    static class FindUnion{
        int parent[];
        int size[];
        int components;
        FindUnion(int n){
           this.components=n;
           this.parent = new int[n];
           this.size = new int[n];
           for(int i = 0;i<n;i++){
            parent[i] = i;
           }
           Arrays.fill(size,1);
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px==py) return ;
            if(size[px]>size[py]){
                parent[py] = px;
                size[px] += size[py];
            }
            else{
                parent[px] = py;
                size[py] += size[px];
            }
            components--;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        FindUnion dsu = new FindUnion(n);

        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);

        System.out.println(dsu.find(0) == dsu.find(2)); // true
        System.out.println(dsu.find(0) == dsu.find(3)); // false
        System.out.println(dsu.components); // 2
    }

}
