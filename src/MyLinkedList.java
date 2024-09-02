import java.lang.reflect.Array;

public class MyLinkedList<T> {
    private MyListNode<T> head;
    private int size = 0;
    public int size() {
        return size;
    }

    public void addToFront(T data){
        //if there is nothing in the list
        if (head == null){
            head = new MyListNode<>(data);
            head.setNext(head);
            head.setPrev(head);
        }
        else {//DO NOT CHANGE THE ORDER OF THE STEPS _ DO NOT TOUCH BLACK MAGIC
            //step 1
            MyListNode<T> nodeToAdd = new MyListNode<>(data);
            //step 2
            nodeToAdd.setPrev(head.getPrev());
            nodeToAdd.setNext(head);
            //step 3
            head.getPrev().setNext(nodeToAdd);
            //step 4
            head.setPrev(nodeToAdd);
            //step5
            head = nodeToAdd;
        }
        size++;
    }

    public void addToEnd(T data){
        //if there is nothing in the list
        if (head == null){
            head = new MyListNode<>(data);
            head.setNext(head);
            head.setPrev(head);
        }
        else {//DO NOT CHANGE THE ORDER OF THE STEPS _ DO NOT TOUCH BLACK MAGIC
            //step 1
            MyListNode<T> nodeToAdd = new MyListNode<>(data);
            //step 2
            nodeToAdd.setPrev(head.getPrev());
            nodeToAdd.setNext(head);
            //step 3
            head.getPrev().setNext(nodeToAdd);
            //step 4
            head.setPrev(nodeToAdd);
        }
        size++;
    }

    public T removeFromFront() {
        if (head == null) {
            throw new NullPointerException("CircularLinkedList is empty");
        }

        T data = head.getData();

        if (head.getNext() == head) { // Only one element in the list
            head = null;
        } else {
            head.getPrev().setNext(head.getNext());
            head.getNext().setPrev(head.getPrev());
            head = head.getNext();
        }
        size--;
        return data;
    }

    public T removeFromEnd() {
            if (head == null) {
                throw new NullPointerException("CircularLinkedList is empty");
            }
            T data = head.getPrev().getData();
            if (head.getNext() == head) { // Only one element in the list
                head = null;
            } else {
                // Update the second last node's next to point to the head
                head.getPrev().getPrev().setNext(head);
                // Update the head's previous to point to the second last node
                head.setPrev(head.getPrev().getPrev());
            }
            size--;
            return data;
    }

    public boolean contains(T data) {
        MyListNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData() == data){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T[] toArray() {
        if (size == 0) {
            return (T[]) new Object[0]; // Return an empty array if the list is empty
        }

        // Create an array of the same type as the first element's class
        T[] array = (T[]) Array.newInstance(head.getData().getClass(), size);
        MyListNode<T> current = head;

        // Populate the array with elements from the list
        for (int i = 0; i < size; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }

        return array;
    }



    @Override
    public String toString() {
        if(head == null) {
            return "null";
        }

        String out = head.toString();
        MyListNode<T> current = head.getNext();
        while(current != head) {
            out += ", " + current.toString();
            current = current.getNext();
        }
        return out;
    }
}
