package stacksandqueues;
/*
Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack,
but you may not copy the elements into any other data structure (such as an array). The stack supports the following
operations: push, pop, peek, and isEmpty
*/

import java.util.Stack;

class SortedStack{
    private final Stack<Integer> main;
    private final Stack<Integer> helper;

    public SortedStack(){
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val){
        if(!helper.isEmpty() && helper.peek() >= val){
            addToHelper(val);
        }else{
            addToMain(val);
        }
    }

    private void addToMain(int val) {
        while(!main.isEmpty() && main.peek() < val) helper.push(main.pop());
        main.push(val);
    }

    private void addToHelper(int val) {
        while(!helper.isEmpty() && helper.peek() > val) main.push(helper.pop());
        helper.push(val);
    }

    public int pop(){
        moveToMain();
        return main.pop();
    }

    private void moveToMain() {
        while(!helper.isEmpty()) main.push(helper.pop());
    }

}

public class Question5 {
    public static void main(String[] args) {
        SortedStack ss = new SortedStack();

        ss.push(1);
        ss.push(2);
        ss.push(4);
        ss.push(3);

        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());

    }
}
