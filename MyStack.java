
import java.util.NoSuchElementException;

public class MyStack<T> implements StackADT<T>{
    private T[] data;
    private int size;

    public MyStack(){
        data = (T[]) new Object[MAX_CAPACITY];
        size = 0;
    }

    public void push(T item){
        if (item == null){
            throw new IllegalArgumentException();
        }
        if (size >= MAX_CAPACITY){
            throw new IllegalStateException();
        }
        data[size] = item;
    }

    public T pop(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        T topItem = data[size - 1];   
    }

    public T peek(){
        
    }

    public boolean isEmpty(){

    }

    public int size(){

    }

    public Object[] toArray(){

    }
}
