package org.example.stream.order;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        System.out.println("Создайте список заказов с разными продуктами и их стоимостями.");
        List<Order> destinOrder = orders.stream()
                .collect(Collectors.toMap(
                        Order::getProduct,
                        Function.identity(),
                        (o1, o2) -> o1
                ))
                        .values().stream()
                        .toList();
        destinOrder.forEach(o -> System.out.println(o.getProduct() + " " + o.getCost()));

        System.out.println("Группируйте заказы по продуктам.");
        Map<String, List<Order>> groupOrder = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));
        groupOrder.forEach((key, value) -> value.forEach(y -> System.out.println(y.getProduct() + " " + y.getCost())));

        System.out.println("Для каждого продукта найдите общую стоимость всех заказов.");
        Map<String, Double> countProductSumOrders = orders.stream()
                .collect(Collectors
                        .groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(Order::getCost)));
        countProductSumOrders.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("Отсортируйте продукты по убыванию общей стоимости.");
        orders.stream()
                .collect(Collectors
                        .groupingBy(Order::getProduct,
                                Collectors.summingDouble(Order::getCost)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                .reversed()).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        System.out.println("Выберите три самых дорогих продукта.");
        top3Cost(orders)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        System.out.println("Выведите результат: список трех самых дорогих продуктов и их общая стоимость.");
        top3Cost(orders).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        double total = top3Cost(orders).stream().mapToDouble(Map.Entry::getKey).sum();
        System.out.println(total);
    }
    public static List<Map.Entry<Double, String>> top3Cost(List<Order> orders){
        return orders.stream()
                .collect(Collectors
                        .toMap(Order::getCost,
                                Order::getProduct)).entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .limit(3)
                .toList();
    }
}
