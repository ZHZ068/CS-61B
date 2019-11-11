package com.company;

public class ArrayDeque<Genus> implements Deque<Genus> {
    private Genus[] arr;
    private int size;
    private int rfactor;

    public ArrayDeque() {
        arr = (Genus[]) new Object[8];
        rfactor = 2;
        size = 0;
    }

    @Override
    public void addFirst(Genus item) {
        if (size == 0) {
            arr[0] = item;
        }else {
            Genus[] newArr = (Genus[]) new Object[size * rfactor];
            newArr[0] = item;
            System.arraycopy(arr, 0, newArr, 1, size);
            arr = newArr;
        }
        size += 1;

    }

    @Override
    public void addLast(Genus item) {
        if (arr[arr.length - 1] != null) {
            Genus[] newArr = (Genus[]) new Object[size * rfactor];
            System.arraycopy(arr, 0, newArr, 0, size);
            newArr[size] = item;
            arr = newArr;
        }else{
            arr[size] = item;
        }
        size += 1;
    }

//    public boolean isEmpty() {
//        return size == 0;
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            System.out.print(" ");
        }
        // System.out.print('\n');
        System.out.println(" ");
    }

    @Override
    public Genus removeFirst() {
        if (size == 0) {
            return null;
        }else{
            Genus[] newArr = (Genus[]) new Object[size];
            Genus temp = arr[0];
            System.arraycopy(arr, 1, newArr, 0, size - 1);
            size -= 1;
            arr = newArr;
            return temp;
        }
    }

    @Override
    public Genus removeLast() {
        if (size == 0) {
            return null;
        }else{
            Genus temp = arr[size - 1];
            arr[size - 1] = null;
            size -= 1;
            return temp;
        }
    }

    @Override
    public Genus get(int index) {
        if (index >= size) {
            return null;
        }else {
            return arr[index];
        }
    }

}
