package com.company;

public class OffByN implements CharacterComparator {

    public int diff;

    public  OffByN(int N) {
        diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }

}
