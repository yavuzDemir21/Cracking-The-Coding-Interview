package stacksandqueues;

/*
 Implement a MyQueue class which implements a queue using two stacks.
*/


import java.util.Stack;

class MyQueue<T>{
    Stack<T> main;
    Stack<T> helper;

    public MyQueue(){
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void add(T val){
        moveToHelper();
        main.add(val);
        moveToMain();
    }

    private void moveToMain() {
        while(!helper.isEmpty()) main.push(helper.pop());
    }

    private void moveToHelper() {
        while(!main.isEmpty()) helper.push(main.pop());
    }

    public T remove(){
        return main.pop();
    }


}

class MyQueue2<T>{
    Stack<T> main;
    Stack<T> helper;

    public MyQueue2(){
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void add(T val){
        main.add(val);
    }

    public T remove(){
        shiftElements();
        return helper.pop();
    }

    private void shiftElements() {
        if(helper.isEmpty()){
            while (!main.isEmpty()) helper.push(main.pop());
        }
    }


}

public class Question4 {
    public static void main(String[] args) {

    }
}
