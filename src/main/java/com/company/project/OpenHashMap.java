package com.company.project;

/**
 * @author Max
 */

public interface OpenHashMap {
    /**
     * @param key
     * @param value
     * @return
     */
    boolean put(int key, long value);

    /**
     * @param key
     * @return
     */
    Long get(int key);

    /**
     * @return
     */
    int size();
}
