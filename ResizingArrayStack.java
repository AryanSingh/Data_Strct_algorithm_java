package quickstart;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int n;

    public ResizingArrayStack(){
        a = (Item[]) new Object[2];
        n=0;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }
    private void resize(int capacity){
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for(int i=0; i<n ;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        if(n==a.length){
            resize(2*a.length);
        }
        a[n++] = item;
    }

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = a[--n];
        a[n] = null;
        if(n>0 && n==a.length/4) resize(a.length/2);
        return item;
    }

    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        return a[n-1];
    }
    public Iterator<Item> iterator()  { return new ReverseArrayIterator(); }


    public class ReverseArrayIterator implements Iterator<Item> {
        private int i = n-1;

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        stack.push("aran");
        stack.push("good");
        stack.push("boy");
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.pop());
    }

}
