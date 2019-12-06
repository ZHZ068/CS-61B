package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        int getFirst = arb.peek();
        assertEquals(2, getFirst);
        assertEquals(3, arb.fillCount());
        arb.dequeue();
        assertEquals(3, (int) arb.peek());
        assertEquals(2, arb.fillCount());
    }
} 
