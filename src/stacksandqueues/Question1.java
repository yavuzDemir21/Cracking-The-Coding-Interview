package stacksandqueues;
/*
Describe how you could use a single array to implement three stacks.
*/

class Elem<T>{
    T val;
    public Elem(T val){
        this.val = val;
    }
}

//If stacks have fixed sizes
class FixedStack<T>{
    int stackSize;
    int[] pointers;
    Elem<T>[] array;

    public FixedStack(int size){
        createArray(size);
    }

    private void createArray(int size){
        stackSize = size;
        array = new Elem[3*size];
        pointers = new int[]{0, size, 2 * size};
    }

    public boolean push(int stackId, Elem<T> val) throws Exception {
        if(stackId>2 || stackId<0) throw new Exception("Illegal stack id");

        if(pointers[stackId] == (stackId+1)*stackSize) throw new Exception("Stack is full");

        array[pointers[stackId]] = val;
        pointers[stackId]++;

        return true;
    }

    public Elem<T> pop(int stackId) throws Exception {
        if(stackId>2 || stackId<0) throw new Exception("Illegal stack id");

        if(pointers[stackId] == (stackId)*stackSize) throw new Exception("Stack is empty");

        pointers[stackId]--;
        Elem<T> val = array[pointers[stackId]];
        array[pointers[stackId]] = null;
        return val;
    }

    public Elem<T> peek(int stackId) throws Exception{
        if(stackId>2 || stackId<0) throw new Exception("Illegal stack id");

        if(pointers[stackId] == (stackId)*stackSize) throw new Exception("Stack is empty");

        return array[pointers[stackId]-1];
    }

}


public class Question1 {
    public static void main(String[] args) {

    }
}
