package com.company.project;

import java.util.*;

/**
 * @author Max
 */

public class OpenHashMapImpl implements OpenHashMap {

    private final int FREE_SPACE = Integer.MIN_VALUE;
    private int[] keys;
    private long[] values;
    private int size;

    public OpenHashMapImpl() {
        keys = new int[1000];
        values = new long[1000];
        size = 0;
        Arrays.fill(keys, FREE_SPACE);
    }

    /**
     * @param size
     */
    public OpenHashMapImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Illegal size: " + size);
        }
        keys = new int[size];
        values = new long[size];
        this.size = 0;
        Arrays.fill(keys, FREE_SPACE);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public boolean put(int key, long value) {
        int hash = hashFunction(key);
        int i = 0;
        if (keys[hash] == FREE_SPACE || keys[hash] == key) {
            keys[hash] = key;
            values[hash] = value;
            size++;
            return true;
        }
        for (i = hash + 1; i != hash; i = (i + 1) % keys.length) {
            if (keys[hash] == FREE_SPACE || keys[hash] == key) {
                keys[i] = key;
                values[i] = value;
                size++;
                return true;
            }
        }
        return false;
    }

    /**
     * @param key
     * @return
     */
    public Long get(int key) {
        int hash = hashFunction(key);
        for (int i = hash; ; i++) {
            //if (i == initSize) i = 0;
            if (keys[i] == FREE_SPACE) {
                throw new NoSuchElementException("No such key in map");
            }
            if (keys[i] == key) {
                return values[i];
            }
        }
    }

    /**
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * @param number
     * @return
     */
    private int hashFunction(int number) {
        return Math.abs(number % keys.length);
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenHashMapImpl that = (OpenHashMapImpl) o;
        return size == that.size && Arrays.equals(keys, that.keys) && Arrays.equals(values, that.values);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(FREE_SPACE, size);
        result = 31 * result + Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "OpenHashMapImpl{" +
                "keys=" + Arrays.toString(keys) +
                ", values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }
}
