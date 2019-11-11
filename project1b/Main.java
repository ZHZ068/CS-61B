package com.company;

public class Main {

    public static void main(String[] args) {
//        Deque<String> a1 = new ArrayDeque<>();
        Deque<String> a1 = new LinkedListDeque<>("F");
        a1.addFirst("x");
        a1.printDeque();

        a1.addFirst("y");
        a1.printDeque();

        a1.addLast("z");
        a1.printDeque();

        a1.addFirst("w");
        a1.printDeque();

        a1.addFirst("v");
        a1.printDeque();

        a1.removeFirst();
        a1.removeLast();
        a1.printDeque();
        System.out.println(a1.size());
        System.out.println(a1.isEmpty());
    }
}
