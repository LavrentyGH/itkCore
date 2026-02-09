package org.example.collections;

import java.util.Arrays;

public class FilterImpl<T> implements Filter<T> {

    @Override
    public T apply(T o) {
        System.out.println(o.hashCode());
        return o;
    }

    public Object[] filter(T[] arr, FilterImpl filter){
        return Arrays.stream(arr).map(x -> filter.apply(x)).toArray();
    }
}
