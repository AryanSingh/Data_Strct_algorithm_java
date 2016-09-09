package quickstart;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class two_stacks_using_array<Item> implements Iterable<Item> {

    private Item[] a;
    private int n;
    private int m;

    public two_stacks_using_array(){
        a = (Item[]) new Object[6];
        n=0;
        m=1;
    }

    public int larger(int n, int m){
        if(n>m) return n;
        else return m;
    }

    public boolean isEmpty(){
        return n==0 && m==1;
    }

    public int size(){
        return larger(n,m);
    }
    private void resize(int capacity){
        assert capacity >= larger(n,m);
        Item[] temp = (Item[]) new Object[capacity];
        for(int i=0; i<larger(n,m) ;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push1(Item item){
        if(n>=a.length ){
            resize(4*a.length);
        }
        a[n] = item;
        n += 2;
    }
    public void push2(Item item){
        if(m>=a.length ){
            resize(4*a.length);
        }
        a[m] = item;
        m += 2;
    }

    public Item pop1(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = a[n-2];
        n = n-2;

        a[n] = null;
        if(n>0 && (larger(n,m)==a.length/4 || larger(n,m) == a.length/4 +1)) resize(a.length/2);
        return item;
    }
    public Item pop2(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = a[m-2];
        m = m-2;

        a[m] = null;
        if(m>0 && (larger(n,m)==a.length/4 || larger(n,m) == a.length/4 +1)) resize(a.length/2);
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
        two_stacks_using_array<String> stack = new two_stacks_using_array<String>();
        stack.push1("aran");
        stack.push2("good");
        stack.push1("boy3");
        stack.push1("boy4");
        stack.push1("boy5");
        stack.push1("boy6");
        stack.push1("boy7");
        stack.push1("boy8");
        stack.push1("boy9");
        stack.push2("good2");
        stack.push2("good3");
        stack.push2("good4");
        stack.push2("good5");
        stack.push2("good6");
        stack.push2("good7");
        stack.push2("good8");
        stack.push2("good9");

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());

    }

}
