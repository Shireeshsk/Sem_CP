package Unit5;
import java.util.*;
public class LexicographicallySmallest {
    static class FindUnion{
        int parent[];
        FindUnion(){
            this.parent = new int[26];
            for(int i = 0;i<26;i++){
                parent[i] = i;
            }
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

            if(px==py) return;
            if(px>py){
                parent[px] = py;
            }
            else{
                parent[py] = px;
            }
        }
    }

    public static String helper(String str1,String str2,String word){
        FindUnion dsu = new FindUnion();
        for(int i = 0;i<str1.length();i++){
            dsu.union(str1.charAt(i)-'a', str2.charAt(i)-'a');
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<word.length();i++){
            sb.append((char)(dsu.find(word.charAt(i)-'a')+'a'));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String word = sc.next();
        System.out.println(helper(str1, str2, word));
        sc.close();
    }
}
