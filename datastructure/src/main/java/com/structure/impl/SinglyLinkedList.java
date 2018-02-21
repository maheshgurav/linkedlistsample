package com.structure.impl;

import com.structure.LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private static int counter;
    private Node head;

    public SinglyLinkedList() {
    }

    /**
     * This method is used to append data at end of the linked list
     * @param data
     */
    public void append(T data) {
        if (head == null) {
            head = new Node(data);
        }

        Node temporaryNode = new Node(data);
        Node currentNode = head;

        if (currentNode != null) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(temporaryNode);
        }
        incrementCounter();
    }

    /**
     * Remove last element from linked list
     * @return
     */
    public boolean remove() {
        Node currentNode = head;
        if (head != null) {
            int count = size();
            for (int i = 1; i <= count; i++) {
                if (currentNode.getNext() == null)
                    return false;
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            decrementCounter();
            return true;
        }
        return false;
    }

    /**
     * Remove all values greater than provided values
     * @param value
     * @return
     */
    public boolean removeGreaterThan(int value) {
        boolean result = false;
        int count = size();
        //If list has only one element
        if(count == 1 && head.getData() != null && (Integer) head.getData() > value) {
            head = null;
            decrementCounter();
            return true;
        }

        //If list has more than one element
        Node previousNode = head;
        Node currentNode = head;
        Node nextNode =null;
        if(head.getNext() != null) {
            nextNode = head.getNext().getNext();
        }
        for (int i = 0; i < count; i++) {
            if (currentNode.getData() != null && (Integer) currentNode.getData() > value) {
                if (currentNode.getNext() != null) {
                    nextNode = currentNode.getNext().getNext();
                    currentNode = previousNode.getNext().getNext();
                    if (previousNode != null) {
                        previousNode.setNext(currentNode.getNext());
                    }
                    if (currentNode.getNext() != null) {
                        currentNode = currentNode.getNext();
                    }
                } else {
                    if (previousNode != null) {
                        previousNode.setNext(null);
                    }
                }
                decrementCounter();
                result = true;
            } else {
                previousNode = currentNode;
                currentNode = nextNode;
                if (nextNode != null) {
                    nextNode = nextNode.getNext();
                }
            }
        }
        return result;
    }

    /**
     * Get size of linked list
     * @return
     */
    public int size() {
        return counter;
    }

    /**
     * Increment size when element added to list
     */
    private static void incrementCounter() {
        counter++;
    }

    /**
     * Decrement size when element added to list
     */
    private void decrementCounter() {
        counter--;
    }

    /**
     * String representation of linked list
     * @return
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (head != null) {
            Node currentNode = head.getNext();
            while (currentNode != null) {
                output.append("[");
                output.append(currentNode.getData());
                output.append("]");
                currentNode = currentNode.getNext();
            }
        }
        return output.toString();
    }

    /**
     * Node class for linked list
     */
    private class Node {
        Node next;
        Object data;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}