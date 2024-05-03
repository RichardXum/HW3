package stores;

import interfaces.IStack;

public class MyStack<E> implements IStack<E> {
    private ListElement<E> head;
    private ListElement<E> tail;

    public MyStack(){
        head = null;
        tail = null;
    }

    // INCOMPLETE.
    public void push(E val) {
        //  TODO: implement pushing
        ListElement<E> e = new ListElement<>(val);

        if (!isEmpty()) {
            e.setNext(head);
            head.setPrev(e);
        } else {
            tail = e;
        }

        head = e;
    }

    // INCOMPLETE.
    public E pop() {
        //  TODO: implement popping
        if (isEmpty()) {
            return null;
        }

        ListElement<E> e = head;

        head = head.getNext();

        if (isEmpty()) {
            tail = null;
        } else {
            head.setPrev(null);
        }

        return e.getValue();
    }

    // INCOMPLETE
    public boolean isEmpty() {
        //  TODO: check whether list is empty
 
        return (head == null);
    }

    //INCOMPLETE
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        ListElement<E> ptr = head;
        sb.append('[');
        while(ptr != null && ptr.getNext() != null){
            sb.append(ptr.getValue()).append(", ");
            ptr = ptr.getNext();
        }
        sb.append(ptr.getValue()).append(']');
        // TODO: produces a String of the contents of the queue
        return sb.toString();
    }
}
