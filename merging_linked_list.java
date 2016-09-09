package quickstart;

/**
 * Created by aryan on 9/7/2016.
 */
public class merging_linked_list {

    public static linkedList sort_insert(linkedList m, linkedList l){
        linkedList.Node curr = l.head;
        while(curr!= null){
            m.sorted_insert(curr.data);
            curr = curr.next;
        }
        return m;

    }

//    public static linkedList mergelist(linkedList l1, linkedList l2){
//        linkedList.Node curr1 = l1.head;
//        linkedList.Node curr2 = l2.head;
//
//    }

    public static void main(String [] args){
        linkedList list1 = new linkedList();
        linkedList list2 = new linkedList();
        list1.push(6);
        list1.push(4);
        list1.push(2);
        list2.push(5);
        list2.push(3);
        list2.push(1);
        linkedList list3 = sort_insert(list1,list2);
        list3.printList();
    }
}
