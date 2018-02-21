package com.structure.impl;

import com.structure.LinkedList;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestSinglyLinkedList extends TestCase{

    private SinglyLinkedList<Integer> list = null;

    @BeforeEach
    public void beforeTest(){
        list = new SinglyLinkedList<Integer>();
    }

    @AfterEach
    public void afterTest(){
        list = null;
    }

    @Test
    public void testAppendPass() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.append(1);
        assertEquals(1, list.size());
        list = null;
    }

    @Test
    public void testRemoveGreaterThanPass() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.removeGreaterThan(2);
        assertEquals(list.size(), 1);
        list.removeGreaterThan(0);
        assertEquals(list.size(), 0);
        list = null;
    }

    @Test
    public void testRemovePass() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.remove();
        assertEquals(list.size(), 0);
        list = null;
    }

    @Test
    public void testAppendFail() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.append(1);
        assertNotEquals(list.size(), 4);
        list = null;
    }

    @Test
    public void testRemoveGreaterThanFail() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.removeGreaterThan(2);
        assertNotEquals(list.size(), 6);
        list.removeGreaterThan(0);
        assertNotEquals(list.size(), 1);
        list = null;
    }

    @Test
    public void testRemoveFail() {
        LinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.remove();
        assertNotEquals(list.size(), 2);
        list = null;
    }
}