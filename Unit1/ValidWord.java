import java.util.*;
public class ValidWord {
    public static boolean helper(String word,String ab){
        int i = 0;
        int j = 0;
        while(i<word.length() && j < ab.length()){
            if(Character.isDigit(ab.charAt(j))){
                if(ab.charAt(j)=='0') return false;
                int num = 0;
                while(j<ab.length() && Character.isDigit(ab.charAt(j))){
                    num = num*10+(ab.charAt(j)-'0');
                    j++;
                }
                i += num;
            }
            else{
                if(word.charAt(i)!=ab.charAt(j))return false;
                i++;
                j++;
            }
        }
        return i == word.length() && j==ab.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(helper(s1, s2));
        sc.close();
    }
}
