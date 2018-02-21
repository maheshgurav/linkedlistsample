package com.structure.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SinglyLinkedListTest {

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
        list.append(1);
        assertEquals(1, list.size(), "Expected and actual values are matching");
    }

    @Test
    public void testRemoveGreaterThanPass() {
        list.append(1);
        list.removeGreaterThan(2);
        assertEquals(list.size(), 1);
        list.removeGreaterThan(0);
        assertEquals(list.size(), 0);
    }

    @Test
    public void testRemovePass() {
        list.append(1);
        list.remove();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testAppendFail() {
        list.append(1);
        assertNotEquals(list.size(), 4);
    }

    @Test
    public void testRemoveGreaterThanFail() {
        list.append(1);
        list.removeGreaterThan(2);
        assertNotEquals(list.size(), 6);
        list.removeGreaterThan(0);
        assertNotEquals(list.size(), 1);
    }

    @Test
    public void testRemoveFail() {
        list.append(1);
        list.remove();
        assertNotEquals(list.size(), 2);
    }
}