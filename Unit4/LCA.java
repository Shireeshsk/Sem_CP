package Unit4;

import java.util.*;
public class LCA {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(int arr[]){
        if(arr.length==0 || arr[0]==-1) return null;
        int idx = 0;
        Node root = new Node(arr[idx++]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(idx<arr.length){
            Node sk = q.remove();
            if(idx<arr.length && arr[idx]!=-1){
                sk.left = new Node(arr[idx]);
                q.add(sk.left);
            }
            idx++;
            if(idx<arr.length && arr[idx]!=-1){
                sk.right = new Node(arr[idx]);
                q.add(sk.right);
            }
            idx++;
        }
        return root;
    }

    public static Node helper(Node root,int p,int q){
        if(root==null) return null;
        if(root.data == p || root.data==q) return root;
        Node left = helper(root.left,p,q);
        Node right = helper(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        Node root = buildTree(arr);
        System.out.println(helper(root, p,q).data);
        sc.close();
    }
}
