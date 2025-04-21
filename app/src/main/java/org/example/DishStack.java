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
        if (top == null) {
            throw new IllegalStateException("Queue is empty");
        }
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
        if (top == null) {
            throw new IllegalStateException("Queue is empty");
        }
        Dish data = top.data;
        top = top.next;
        size--;
        return data;
    }
}
