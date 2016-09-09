package quickstart;

/**
 * Created by aryan on 9/9/2016.
 */
public class postfix_evaluation {

    private static ResizingArrayStack<Integer> operand_stack = new ResizingArrayStack<Integer>();


    public static boolean is_operator(Character c){
        if(c == '+' || c == '-' || c== '*' || c== '/' || c=='^') return true;
        else return false;
    }

    public static void do_operation(Character c){
        int a= operand_stack.pop();
        int b = operand_stack.pop();
        if(c=='+'){
            operand_stack.push(b + a);
        }
        else if( c == '-'){
            operand_stack.push(b - a);
        }
        else if( c == '*'){
            operand_stack.push(b * a);
        }
        else if( c == '/'){
            operand_stack.push( b /a );
        }
        else if( c == '^'){
            operand_stack.push( b ^ a);
        }
        return;
    }

    public static int evaluate(String s){
        for(int i =0; i< s.length(); i++){
            if(!is_operator(s.charAt(i))){
                operand_stack.push(Character.getNumericValue(s.charAt(i)));
            }
            else if (is_operator(s.charAt(i))){
                do_operation(s.charAt(i));
            }
        }
        return operand_stack.pop();
    }

    public static void main(String [] args){
        System.out.print(evaluate("123*+45+67*+-8+"));
    }
}

