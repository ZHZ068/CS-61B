package com.company;

public interface Deque<Genus> {
    public void addFirst(Genus item);
    public void addLast(Genus item);

    default public boolean isEmpty() {
        int size = this.size();
        return size == 0;
    }

    public int size();
    public void printDeque();
    public Genus removeFirst();
    public Genus removeLast();
    public Genus get(int index);
}
