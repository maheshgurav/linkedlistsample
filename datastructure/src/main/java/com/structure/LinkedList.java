package com.structure;

public interface LinkedList<T> {
    void append(T data);

    boolean remove();

    boolean removeGreaterThan(int value);

    int size();
}
