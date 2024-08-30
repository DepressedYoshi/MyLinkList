public class MyLinkedList<T> {
    private MyListNode<T> head;

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
    }
}
