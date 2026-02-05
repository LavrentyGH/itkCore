package org.example.collections;

@FunctionalInterface
public interface Filter <T> {
    T apply(T o);

}
