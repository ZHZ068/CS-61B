package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offbyone = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("hannah"));
        assertFalse(palindrome.isPalindrome("grunt"));
    }

    @Test
    public void testisPalindromeNew() {
        assertTrue(palindrome.isPalindrome("flake", offbyone));
        assertTrue(palindrome.isPalindrome("ab", offbyone));
        assertFalse(palindrome.isPalindrome("xxx", offbyone));
    }
}