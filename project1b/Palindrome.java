package com.company;

public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> pl = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            pl.addLast(word.charAt(i));
        }
        return pl;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> pl = wordToDeque(word);
        return isPalindromeHelper(pl);
    }

    public boolean isPalindromeHelper(Deque d) {
        if (d.size() < 2) {
            return true;
        }

        if (d.removeFirst() == d.removeLast()) {
            return isPalindromeHelper(d);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> pl = wordToDeque(word);
        if (pl.size() < 2) {
            return true;
        } else {
            while (pl.size() > 1) {
                if (!cc.equalChars(pl.removeFirst(), pl.removeLast())) {
                    return false;
                }
            }
            return true;
        }

    }


    /* Non-recursive version */
//    public boolean isPalindrome(String word) {
//        Deque<Character> pl = wordToDeque(word);
//
//        if (pl.size() < 2) {
//            return true;
//        } else {
//            while (pl.size() > 1) {
//                if (pl.removeFirst() != pl.removeLast()) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//    }

}
