package com.company.project;

import java.util.Objects;

public class Pair {
    private int key;
    private long value;

    public Pair(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return getKey() == pair.getKey() &&
                getValue() == pair.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key is: " + key +
                ", value is: " + value +
                '}';
    }
}
