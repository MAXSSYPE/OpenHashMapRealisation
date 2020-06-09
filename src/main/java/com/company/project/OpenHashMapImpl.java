package com.company.project;

import java.util.Arrays;

/**
 * @author Max
 */

public class OpenHashMapImpl implements OpenHashMap {

    private Pair[] map;

    public OpenHashMapImpl() {
        map = new Pair[1000];
    }

    /**
     * @param size
     */
    public OpenHashMapImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Illegal size: " + size);
        }
        map = new Pair[size];
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public boolean put(int key, long value) {
        int hash = hashFunction(key);
        int i = 0;
        if (map[hash] == null || map[hash].getKey() == key) {
            map[hash] = new Pair(key, value);
            return true;
        }
        for (i = hash + 1; i != hash; i = (i + 1) % map.length) {
            if (map[i] == null || map[i].getKey() == key) {
                map[i] = new Pair(key, value);
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
        if (map[hash] == null) {
            return null;
        }
        if (map[hash].getKey() == key) {
            return map[hash].getValue();
        }

        for (int i = hash + 1; i != hash; i = (i + 1) % map.length) {
            if (map[i] != null && map[i].getValue() == key) {
                return map[hash].getValue();
            }
        }
        return null;
    }

    /**
     * @return
     */
    public int size() {
        return map.length;
    }

    /**
     * @param number
     * @return
     */
    private int hashFunction(int number) {
        return Math.abs(number % map.length);
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
        return Arrays.equals(map, that.map);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(map);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "OpenHashMapImpl{" +
                "map=" + Arrays.toString(map) +
                '}';
    }
}
