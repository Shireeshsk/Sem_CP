package Unit3;

public class ContainsAllPrefix {
    static class Node{
        Node links[] = new Node[26];
        boolean flag;

        public boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }

        public Node get(char ch){
            return links[ch-'a'];
        }

        public void put(char ch,Node node){
            links[ch-'a'] = node;
        }

        public void setEnd(){
            this.flag = true;
        }

        public boolean isEnd(){
            return this.flag;
        }
    }

    static class Trie{
        Node root;
        
        Trie(){
            this.root = new Node();
        }

        public void insert(String str){
            Node temp = root;
            for(char ch : str.toCharArray()){
                if(!temp.containsKey(ch)){
                    temp.put(ch,new Node());
                }
                temp = temp.get(ch);
            }
            temp.setEnd();
        }

        public boolean search(String str){
            Node temp = root;
            for(char ch : str.toCharArray()){
                if(!temp.containsKey(ch)){
                    return false;
                }
                temp = temp.get(ch);
                if(!temp.isEnd()){
                    return false;
                }
            }
            return true;
        }
    }

    public static String helper(String str[]){
        Trie sk = new Trie();
        for(String temp : str){
            sk.insert(temp);
        }
        String res="";
        for(String temp: str){
            if(sk.search(temp)){
                if(res.length()<temp.length()){
                    res = temp;
                }
                else if(res.length()==temp.length() && res.compareTo(temp)<0){
                    res = temp;
                }
            }
        }
        return res;
    }

    public static void main(String args[]){
        String nums[] = {"k","ki","kir","kira","kiran","shireesh"};
        System.out.println(helper(nums));
    }
}

