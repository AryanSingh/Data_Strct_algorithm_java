package quickstart;

/**
 * Created by aryan on 9/7/2016.
 */
public class linkedList {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
        }
    }

    public void printList(){
        Node n = head;
        while (n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public void push(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void insert_after(Node prev_node, int data){
        if (prev_node == null){
            System.out.print("previous node cannot be null");
            return;
        }
        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insert_at_end(int data){
        if (head == null){
            head = new Node(data);
            return;
        }
        Node iterate = head;
        while(iterate.next != null){
            iterate = iterate.next;
        }
        insert_after(iterate,data);
    }

    public void sorted_insert(int i){
        Node curr = head;
        Node to_be_inserted = new Node(i);
        if (head.data >i){
            to_be_inserted.next = head;
            head = to_be_inserted;
            return;
        }
        while( curr.next != null && curr.next.data <= i ){
            curr = curr.next;
        }
        to_be_inserted.next = curr.next;
        curr.next = to_be_inserted;
        return;
    }
    public void delete_node(int key){
        if(head.data ==  key){
            head.next = head;
            return;
        }
        Node prev = head;
        Node temp = head.next;
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            return;
        }
        prev.next = temp.next;

    }

    public void delete_node_at_position(int position){
        if(position == 0){
            head.next = head;
        }
        Node prev = head;
        Node curr = head.next;
        for(int i = 1; i <= position -1 ; i++){
            prev = prev.next;

        }
        if(prev == null && prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }

//

    public int length_iterative(){
        int length = 1;
        if(head == null){
            return 0;
        }
        Node iterator = head;
        while(iterator.next != null){
            iterator = iterator.next;
            length++;
        }
        return length;

    }

    public int length_recursive(Node node){
      if(node == null){
          return 0;
      }
      return 1 + length_recursive(node.next);
    }

    public void length(){
        System.out.println(length_recursive(head));
        return;
    }

    public int last_node(){
        Node curr = head;
        if(head.next == null){
            int v = head.data;
            head = null;
            return  v;
        }

        while (curr.next!=null){
            curr = curr.next;
        }
        return curr.data;


    }

    public void delete_last_node(){
        Node curr = head;
        if(head==null ){
            return;
        }
        if(head.next == null){
            head = null;
        }
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
    }

    public void reverse_list(){
        Node curr = head.next;
        Node prev = head ;
        Node ahead = head.next.next;
//        System.out.print(head.data);
        while (ahead != null){

            curr.next = prev;
            prev = curr;
            System.out.print(curr.data);
            curr =ahead;
            ahead = ahead.next;
        }
        return;

    }

    public int detect_loop(){
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String [] args){
        linkedList llist = new linkedList();

        llist.head = new Node(10);
        Node Second = new Node(12);
        Node Third = new Node(14);

        llist.head.next = Second;
        Second.next = Third;
        llist.push(10);
        llist.push(8);
        llist.push(6);
        llist.push(4);
        llist.sorted_insert(5);
        llist.sorted_insert(0);
        llist.sorted_insert(12);
        llist.sorted_insert(3);
        llist.sorted_insert(9);
        llist.reverse_list();
        llist.printList();
    }
}
