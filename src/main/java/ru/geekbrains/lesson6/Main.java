package ru.geekbrains.lesson6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /* Задание 6.2
        Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
        Задание 6.3
        Реализуйте методы поиска и вставки узла в дерево.
        Задание 6.4
        Реализуйте базовые методы обхода дерева и метода дисплей.
        Реализуйте поиск максимума и минимума.
        Задание 6.5
        Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
        Задание 6.6
        Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки. */

        long lastTime;

        Tree tree = new Tree();
        tree.insert(new Person(1, "Lex", 23));
        tree.insert(new Person(2, "Ivan", 52));
        tree.insert(new Person(3, "Nikolai", 20));
        tree.insert(new Person(4, "Sergey", 65));
        tree.insert(new Person(5, "John", 40));

        System.out.println("Task 6.5. We estimate the time of the basic tree methods.");
        lastTime = System.nanoTime();
        System.out.println("Method displayTree");
        tree.displayTree();
        System.out.println("Method max and min");
        tree.max().display();
        tree.min().display();
        System.out.println("Method find(3)");
        tree.find(3).display();
        System.out.println("Method delete(4)");
        tree.delete(4);
        System.out.println("Method displayTree after method delete(4)");
        tree.displayTree();
        System.out.println("Method execution time max, min, display, find, delete и displayTree took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.println("Task 6.6. We estimate the time of the heapsort algorithm. ");
        int[] arr = new int[]{95, 58, 32, 11, 25, 65, 44, 33, 510, 67};
        System.out.println("Current array:" + Arrays.toString(arr));
        lastTime = System.nanoTime();
        HeapSort.sort(arr);
        System.out.println("Sorted array arr:" + Arrays.toString(arr));
        System.out.println("The heapsort took: " + (System.nanoTime() - lastTime) + " nanosecond");
    }
}
