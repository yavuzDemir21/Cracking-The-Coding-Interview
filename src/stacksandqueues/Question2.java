package stacksandqueues;

/*
How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
*/

import java.util.Stack;

class ElemWithMin {
    int val;
    int min;

    public ElemWithMin(int val, int min) {
        this.val = val;
        this.min = min;
    }

}

class StackMin {
    Stack<ElemWithMin> st;

    public StackMin() {
        st = new Stack<>();
    }

    public void push(int val) {
        int min = st.isEmpty() ? val : Math.min(val, st.peek().min);
        st.push(new ElemWithMin(val, min));
    }

    public int pop() throws Exception {
        if (st.isEmpty()) throw new Exception("Stack is Empty");
        return st.pop().val;
    }

    public int min() throws Exception {
        if (st.isEmpty()) throw new Exception("Stack is Empty");
        return st.peek().min;
    }


}

/*
This solution is okay, however if there are a lot of elements then there would be inefficiency. Instead of storing
the minimum number in each element, we could have created another stack which consists of only minimum values. When we
come across with the minimum value in the pop then we would pop that thing from the minimum stack too.
 */

public class Question2 {
    public static void main(String[] args) throws Exception {

        StackMin st = new StackMin();

        st.push(5);
        st.push(4);
        st.push(1);
        st.push(3);

        System.out.println(st.min());
        System.out.println(st.pop());
        System.out.println(st.min());
        System.out.println(st.pop());
        System.out.println(st.min());
        System.out.println(st.pop());
        System.out.println(st.min());
        System.out.println(st.pop());


    }
}
