package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offByN = new OffByN(3);

    @Test
    public void testoffByN() {
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('g', 'd'));
        assertFalse(offByN.equalChars('c', 'x'));
        assertFalse(offByN.equalChars('z', 'u'));
    }
}
