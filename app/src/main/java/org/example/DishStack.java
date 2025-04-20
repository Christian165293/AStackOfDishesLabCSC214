package org.example;

public class DishStack {
    private static class Node {
        private final Dish data; // Data stored in the node
        private Node next; // Pointer to the next node

        private Node(Dish data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public Dish peek() {
        return top.data;
    }

    public void push(Dish data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;
    }

    public int size() {
        return size;
    }

    public Dish pop() {
        Dish data = top.data;
        top = top.next;
        size--;
        return data;
    }
}
