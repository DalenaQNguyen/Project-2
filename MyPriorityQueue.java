
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> {
    private T[] data;
    private int size;
    private Comparator<T> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(Comparator<T> comparator){
        this.comparator = comparator;
        data = (T[]) new Object(DEFAULT_CAPACITY);
        size = 0;
    }

    public void enqueue(T item){
        if (item == null){
            throw new IllegalArgumentException();
        }

        if (size == data.length){
            resize();
        }

        int i = size - 1;

        while (i >= 0 && comparator.compare(item, data[i]) < 0){
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = item;
        size++;
    }

    public void dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
    }

    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return data[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public Object[] toArray(){
        Object[] result = new Object[size];

        for (int i = 0; i < size; i++){
            result[i] = data[i];
        }
        return result;
    }
}
