package quickstart;

/**
 * Created by aryan on 9/8/2016.
 */
public class infix_postfix {
    private static ResizingArrayStack<Character> operator_stack = new ResizingArrayStack<Character>();
    private static String str = "";

    private static int prec(char c){
        switch (c){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean is_operand(char c){
        if(('a'<= c  && c <= 'z' ) || ('A'<=c && c<='Z')){
            return true;
        }
        return false;
    }

    private static String post_fix( String s){

        for(int i =0; i < s.length(); i++){

            Character k = s.charAt(i);
//            System.out.print(k);
            if(is_operand(k)){
                str = str + k;

            }
            else if(k == '('){
                operator_stack.push(k);
            }
            else if(k == ')'){
                while(operator_stack.peek()!='(' ){
//                    System.out.print(operator_stack.peek());
                    str += operator_stack.pop();
                }
                operator_stack.pop();
            }
            else if(!operator_stack.isEmpty() && prec(k) <= prec(operator_stack.peek())){
                while(!operator_stack.isEmpty() && operator_stack.peek()!='(' && prec(operator_stack.peek()) >= prec(k)){
                    str += operator_stack.pop();

                }
                operator_stack.push(k);
            }
            else operator_stack.push(k);
        }
        while (!operator_stack.isEmpty()){
            str+= operator_stack.pop();
        }
        return str;
    }


    public static void main(String[] args){
        System.out.println(post_fix("a+b*c-(d+e+f*g)+h"));
    }
}
