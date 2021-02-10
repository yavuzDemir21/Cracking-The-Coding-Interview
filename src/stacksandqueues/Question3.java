package stacksandqueues;
/*
Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
exceeds capacity. SetOfStacks.push() and SetOfStacks. pop() should behave identically to a single stack (that is, pop()
should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub­ stack.
*/

import java.util.ArrayList;
import java.util.Stack;

class SetOfStacks<T> {
    ArrayList<Stack<T>> setOfStacks;
    int threshold;

    public SetOfStacks(int threshold) {
        this.setOfStacks = new ArrayList<>();
        this.threshold = threshold;
        addStack();
    }

    public void push(T val){

        Stack<T> st = getStack();

        if(st.size() == threshold){
            addStack();
            st = getStack();
        }

        st.add(val);
    }

    private void addStack() {
        setOfStacks.add(new Stack<>());
    }

    private Stack<T> getStack() {
        return setOfStacks.get(setOfStacks.size()-1);
    }

    public T pop(){
        Stack<T> st = getStack();

        T val = st.pop();
        if(st.isEmpty()) removeStack();

        return val;

    }

    private void removeStack() {
        if(setOfStacks.size() != 1) setOfStacks.remove(setOfStacks.size()-1);
    }

    public T popAt(int stackId){
        Stack<T> st = getStackAt(stackId);

        T val = st.pop();
        if(st.isEmpty()) removeStackAt(stackId);

        return val;
    }

    private void removeStackAt(int stackId) {
        if(setOfStacks.size() != 1) setOfStacks.remove(stackId);
    }

    private Stack<T> getStackAt(int stackId) {
        return setOfStacks.get(stackId);
    }

}

//Assumptions: After popping from a middle stack we need not to rollover from the preceding stacks

public class Question3 {
    public static void main(String[] args) {

    }
}
