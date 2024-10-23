package structures;

public class Queue<T> implements IQueue<T> {

    private Stack<T> front;
    private Stack<T> rear;

    public Queue() {
        front = new Stack<>();
        rear = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        if(rear.isEmpty() && front.isEmpty()){
            return true;
        }

        return false;
    }

    @Override
    public void enqueue(T item) {
        rear.push(item);
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            return null;
        }
        int rSize = rear.size();
        for(int i = 0; i < rSize; i++) {
            front.push(rear.pop());
        }
        T t = front.pop();
        int fSize = rear.size();
        for(int i = 0; i < fSize; i++) {
            rear.push(front.pop());
        }
        return t;
    }

    @Override
    public T front() {
        if(isEmpty()){
            return null;
        }
        int rSize = rear.size();
        for(int i = 0; i < rSize; i++) {
            front.push(rear.pop());
        }
        T t = front.top();
        int fSize = rear.size();
        for(int i = 0; i < fSize; i++) {
            rear.push(front.pop());
        }
        return t;
    }

}