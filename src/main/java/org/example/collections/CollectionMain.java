package org.example.collections;

import java.util.Map;

public class CollectionMain {
    public static void main(String[] args) {

        String[] strArr = {"a", "b", "b", "c", "d", "e", "f", "g", "h"};

        /**
         * Напишите метод filter, который принимает на вход массив любого типа, вторым арументом метод должен
         * принимать класс, реализующий интерфейс Filter, в котором один метод - T apply(T o) (параметризованный).
         * Метод должен быть реализован так чтобы возвращать новый массив, к каждому элементу которого
         * была применена функция apply
         */
        FilterImpl filter = new FilterImpl();
        Object[] objArr = filter.filter(strArr, new FilterImpl<>());

        /**
         * Напишите метод, который получает на вход массив элементов и возвращает Map ключи в котором - элементы,
         * а значения - сколько раз встретился этот элемент
         */
        ToMap toMap = new ToMap();
        Map<String, Long> rez = toMap.arrToMap(strArr);
        rez.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
