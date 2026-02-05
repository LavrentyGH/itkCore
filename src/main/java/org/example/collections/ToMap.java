package org.example.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMap<T> {
    public Map<T, Long> arrToMap(T[] t){
        Map<T, Long> map = Arrays.stream(t).collect(Collectors.groupingByConcurrent(x -> x, Collectors.counting()));
        return map;
    }
}
