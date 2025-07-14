import java.util.*;
public class PalindromeLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(){
            this.next=null;
            this.data = Integer.MIN_VALUE;
        }
    }

    public static Node buildList(int arr[]){
        Node root = new Node();
        Node temp = root;
        for(int i : arr){
            temp.next = new Node(i);
            temp = temp.next;
        }
        return root.next;
    }

    public static Node midNode(Node head){
        Node fast = head;
        Node slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head){
        Node s1 = head;
        Node s2 = reverse(midNode(head).next);
        while(s2.next!=null){
            if(s1.data!=s2.data) return false;
            s1 = s1.next;
            s2 = s2.next;
        }
        return true;
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Node head = buildList(arr);
        System.out.println(isPalindrome(head));
        sc.close();
    }
}
