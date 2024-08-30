public class MyListNode<T> {
    private T data;
    private MyListNode<T> next;
    private MyListNode<T> prev;

    public MyListNode(T data){
        this.data = data;
    }
    public MyListNode(T data, MyListNode<T> next, MyListNode<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyListNode<T> getNext() {
        return next;
    }

    public void setNext(MyListNode<T> next) {
        this.next = next;
    }

    public MyListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(MyListNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
