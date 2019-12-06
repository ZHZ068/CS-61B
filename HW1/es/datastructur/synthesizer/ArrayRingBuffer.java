package es.datastructur.synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    private int capacity;
    private int fillCount;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). 
     */
    @Override
    public void enqueue(T x) {
        if (fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }

        rb[last] = x;
        fillCount++;
        last++;

        if (last == capacity) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). 
     */
    @Override
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }

        T oldest = rb[first];
        rb[first] = null;
        first++;
        fillCount--;

        if (first == capacity) {
            first = 0;
        }

        return oldest;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        return rb[first];
    }

    /**
     * Iteration
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int position;
        private int count;

        public ArrayRingBufferIterator() {
            position = first;
            count = 0;
        }

        public boolean hasNext(){
            return count < fillCount;
        }

        public T next(){
            T returnItem = rb[position];
            position++;
            count++;
            if (position == capacity) {
                position = 0;
            }
            return returnItem;
        }
    }

    /**
     * Rewrite an equals method
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {return false;}
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) obj;
        if (other.fillCount() != this.fillCount() || other.capacity() != this.capacity()) {
            return false;
        }

        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = other.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (thisIterator.next() != otherIterator.next()) {
                return false;
            }
        }

        return true;
    }
}