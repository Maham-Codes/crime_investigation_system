package com.crimeinvestigation.system.interfaces;

@FunctionalInterface
public interface DataProcessor<T> {
    T process(T data);
}
