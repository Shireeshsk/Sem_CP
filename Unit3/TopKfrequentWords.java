package Unit3;

import java.util.*;
public class TopKfrequentWords {
    static class Node{
        Node links[];
        boolean flag;
        int count;
        String word;

        Node(){
            this.links = new Node[26];
            this.flag =false;
            this.count = 0;
            this.word = null;
        }

        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        public Node get(char ch){
            return links[ch-'a'];
        }

        public void put(char ch,Node node){
            links[ch-'a']=node;
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
            temp.count++;
            temp.word = str;
        }

        public void collectWord(Node node,PriorityQueue<Stringfreq> pq,int k){
            if(node==null) return ;
            if(node.isEnd()){
                pq.offer(new Stringfreq(node.word,node.count));
                if(pq.size()>k) pq.poll();
            }

            for(char ch ='a';ch <='z';ch++){
                if(node.containsKey(ch)){
                    collectWord(node.get(ch), pq, k);
                }
            }
        }
    }

    static class Stringfreq{
        int freq;
        String word;

        Stringfreq(String word,int freq){
            this.freq = freq;
            this.word = word;
        }
    }

    public static List<String> helper(String str[],int k){
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String sk : str){
            trie.insert(sk);
        }
        PriorityQueue<Stringfreq> pq = new PriorityQueue<>((a,b)->{
            if(a.freq != b.freq) return a.freq-b.freq;
            return b.word.compareTo(a.word);
        });

        trie.collectWord(trie.root,pq,k);
        while(!pq.isEmpty()){
            res.add(pq.poll().word);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String args[]){
        String str[] = {"ball","are","case","doll","egg","case","doll","egg","are","are","egg","case","are","egg","are","case"};
        System.out.println(helper(str,3));
    }
}

