package com.company;

public class ArrayDeque<Genus> {
    private Genus[] arr;
    private int size;
    private int rfactor;
    private int front;
    private int end;


    public ArrayDeque() {
        arr = (Genus[]) new Object[8];
        rfactor = 2;
        size = 0;
    }

    public ArrayDeque(ArrayDeque<Genus> other) {
        arr = (Genus[]) new Object[8];
        rfactor = 2;
        size = 0;
        front = 0;
        end = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }


    /**
     * front: points to the location that just added a number
     * end: points to the location for next insertion
     * */

    private void resizing(int capacity) {
        Genus[] narr = (Genus[]) new Object[capacity];
        int s = size;
        int i = 0;

        while (s > 0) {
            narr[i] = arr[front];
            s -= 1;
            i += 1;
            front += 1;
            if (front == arr.length) {
                front = 0;
            }
        }
        front = 0;
        end = i;
        arr = narr;

    }


    public void addFirst(Genus item) {
        if (size == arr.length) {
            resizing(size*rfactor);
        }
        if (isEmpty()) {
            front = 0;
            end = 1;
        } else if (front == 0) {
            front = arr.length - 1;
        } else {
            front -= 1;
        }

        arr[front] = item;
        size += 1;
    }

    public void addLast(Genus item) {
        if (size == arr.length) {
            resizing(size*rfactor);
        }

        arr[end] = item;
        end += 1;
        if (end == arr.length) {
            end = 0;
        }

        size += 1;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public double usageRatio(){
        return (double) size/ (double) arr.length;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.print('\n');
    }

    public Genus removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Genus temp = arr[front];
        arr[front] = null;

        if (front == arr.length-1) {
            front = 0;
        } else {
            front += 1;
        }
        size -= 1;
        if (arr.length >= 16 && usageRatio() < 0.25) {
            resizing(size/rfactor);
        }
        return temp;
    }

    public Genus removeLast() {
        if (isEmpty()) {
            return null;
        }

        Genus temp;
        if (end == 0) {
            temp = arr[arr.length-1];
            arr[arr.length-1] = null;
            end = arr.length-1;
        } else {
            temp = arr[end-1];
            arr[end-1] = null;
            end -= 1;
        }
        size -= 1;
        if (arr.length >= 16 && usageRatio() < 0.25) {
            resizing(size/rfactor);
        }
        return temp;

    }

    public Genus get(int index) {
        if (index >= arr.length) {
            return null;
        } else {
            return arr[(index+front)%(arr.length)];
        }
    }
}
