import java.util.Comparator;

public class WarehouseSimulation {
    private Order[] orders;
    private int nextOrderIndex;
    private int currentMin;
    private int totalArrived;
    private int totalShipped;
    private int totalLate;
    private MyStack<Order> returnsStack;
    private MyPriorityQueue<Order> queue;

    public WarehouseSimulation(Order[] orders, Comparator<order> comparator){
        this.orders = orders;
        this.queue = new MyPriorityQueue<>(comparator);
        this.returnsStack = new MyStack<>();
        this.nextOrderIndex = 0;
        this.currentMin = 0;
        this.totalArrived = 0;
        this.totalShipped = 0;
        this.totalLate = 0;
    }

    @Override
    public void tick(){
        if (nextOrderIndex < orders.length){
            Order order = order[nextOrderIndex];
            order.setArrivalMinute(currentMin);

            queue.enqueue(order);
            nextOrderIndex++;
            totalArrived++;
        }

        if (!queue.isEmpty()){
            Order shipped = queue.dequeue();
            totalShipped++;

            if (currentMin > shipped.getDeadlineMin()){
                returnsStack.push(shipped);
                totalLate--;
            }
        }
        currentMin++;
    }

    public boolean isFinished(){
        return nextOrderIndex >= orders.length && queue.isEmpty();
    }

    public int getCurrentMinute(){
        return currentMin;
    }

    public int getTotalArrived(){
        return totalArrived;
    }

    public int getTotalShipped(){
        return totalShipped;
    }

    public int getTotalLate(){
        return totalLate;
    }
}
