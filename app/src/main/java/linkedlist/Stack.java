package main.java.com.example.Stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

class Node<T> {
    private Node<T> next;
    private T value;

    public Node(T value){
        this.next = null;
        this.value = value;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}

class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void push(T value) {
        Node<T> newnode = new Node(value);
        newnode.setNext(this.top);
        this.top = newnode;
        this.size++;
    }

    public T pop(){
        if(this.top == null){
            throw new NoSuchElementException("Stack is empty");
        }
        T value = this.top.getValue();
        this.top = this.top.getNext();
        this.size--;
        return value;
    }

    public T peek(){
        if(this.isEmpty() || top == null){
            throw new NoSuchElementException("null");
        }
        return this.top.getValue();
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
            throw new IndexOutOfBoundsException("Invalid indices for swapping");
        }

        if (index1 == index2) {
            return;
        }

        Node<T> node1 = getNodeAt(index1);
        Node<T> node2 = getNodeAt(index2);

        T tempValue = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(tempValue);
    }

    private Node<T> getNodeAt(int index) {
        Node<T> current = top;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            str.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return str.toString().trim();
    }
}
