package quickstart;

/**
 * Created by aryan on 9/9/2016.
 */
public class reverse_string_using_stack {
    private static ResizingArrayStack<Character> operand_stack = new ResizingArrayStack<Character>();

    private static String  reverse(String operand){
        for(int i=0;i<operand.length();i++){
            operand_stack.push(operand.charAt(i));
        }
        String copy = "";
        while (!operand_stack.isEmpty()){
            copy += operand_stack.pop();
        }
        return  copy;
    }

    public static void main( String [] args){
        System.out.print(reverse("abcdefghij"));
    }
}
