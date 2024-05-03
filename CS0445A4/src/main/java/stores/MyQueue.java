package stores;

import interfaces.IQueue;

public class MyQueue<E> implements IQueue<E> {

    private ListElement<E> head;
    private ListElement<E> tail;

    public MyQueue() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        ListElement<E> tmp = head;
        head = tmp.getNext();

        if (head == null) {
            tail = null;
        }

        return tmp.getValue();
    }

    public void enqueue(E value) {
        ListElement<E> tmp = new ListElement<>(value);

        if (isEmpty()) {
            tail = head = tmp;
        } else {
            tail.setNext(tmp);
            tail = tmp;
        }
    }

    //INCOMPLETE
    public E modifyHead(E value) {
        //TODO: modifies the head of the queue, and returns the previous value
        ListElement<E> tmp = new ListElement<>(value);

        if (isEmpty()) {
            tail = head = tmp;
            return null;
        } else {
            ListElement<E> last_head = new ListElement<>(head.getValue());
            tmp.setNext(head.getNext());
            head = tmp;
            return last_head.getValue();
        }

    }

    //INCOMPLETE
    public String toString() {
        //TODO: produces a String of the contents of the queue
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder queue = new StringBuilder();
        ListElement<E> ptr = head;
        
        queue.append('[');
        while (ptr != null && ptr.getNext() != null) {
            queue.append(ptr.getValue()).append(", ");
            ptr = ptr.getNext();
        }

        queue.append(ptr.getValue()).append(']');
        return queue.toString();
    }
}
