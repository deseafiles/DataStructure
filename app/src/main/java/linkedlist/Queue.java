import java.util.NoSuchElementException;

class Node {
    private Node next;
    private Node prev;
    private char value;

    public Node(char value){
        this.next = null;
        this.prev = null;
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getPrev(){
        return prev;
    }

    public void setPrev(Node prev){
        this.prev = prev;
    }

    public char getValue(){
        return value;
    }

    public void setValue(char value){
        this.value = value;
    }
}

class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(char value) {
        Node newnode = new Node(value);
        if (rear != null) {
            rear.setNext(newnode);
            newnode.setPrev(rear);
        }
        rear = newnode;
        if (front == null) {
            front = newnode;
        }
        size++;
    }

    public char dequeue() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        char value = front.getValue();
        front = front.getNext();
        if (front != null) {
            front.setPrev(null);
        } else {
            rear = null;
        }
        size--;
        return value;
    }

    public char peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.getValue();
    }

    public char peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return rear.getValue();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
            throw new IndexOutOfBoundsException("Invalid indices for swapping");
        }

        if (index1 == index2) {
            return;
        }

        Node node1 = getNodeAt(index1);
        Node node2 = getNodeAt(index2);

        char tempValue = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(tempValue);
    }

    private Node getNodeAt(int index) {
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = front;
        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}

