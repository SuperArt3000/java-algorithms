package ru.geekbrains.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* Задание 3.1
        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        Оцените время выполнения преобразования.
        Задание 3.2
        На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
        Оценить выполненные методы с помощью базового класса System.nanoTime().
        Задание 3.3
        Реализуйте простой односвязный список и его базовые методы.
        Задание 3.4
        На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        Реализуйте список заполненный объектами из вашего класса из задания 1.3
        Задание 3.5
        Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        Оцените время выполнения операций с помощью базового метода System.nanoTime() */

        long start;

        Integer[] arr = {9, 8, 2, 1, 5, 6, 4, 3, 10, 7};
        System.out.println("Task 3.1.");
        start = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println("ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr)): " + (System.nanoTime() - start) + " nanosecond \n");

        System.out.println("Task 3.2.");
        start = System.nanoTime();
        arrayList.add(10, 100);
        System.out.println("arrayList.add(10, 100): " + (System.nanoTime() - start) + " nanosecond");
        start = System.nanoTime();
        arrayList.remove(10);
        System.out.println("arrayList.remove(10): " + (System.nanoTime() - start) + " nanosecond");
        start = System.nanoTime();
        System.out.println("arrayList.get(8) result " + arrayList.get(8) + " took: " + (System.nanoTime() - start) + " nanosecond\n");

        System.out.println("Task 3.3.");
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) list.insert(i);
        System.out.print("list.display(): ");
        list.display();
        System.out.println("\nlist.find(2): " + list.find(2) + "\n");

        System.out.print("Task 3.4.");
        java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
        linkedList.addAll(0, arrayList);
        System.out.print("\nlinkedList.addAll(0, arrayList): " + linkedList + "\n");
        linkedList.add(100);
        System.out.print("linkedList.add(100): " + linkedList + "\n");
        linkedList.set(4, 500);
        System.out.print("linkedList.set(4, 500): " + linkedList + "\n");
        linkedList.remove(10);
        System.out.print("linkedList.remove(10): " + linkedList + "\n");
        linkedList.addFirst(100);
        linkedList.addLast(200);
        System.out.println("linkedList.addFirst(100) && linkedList.addLast(200): " + linkedList + "\n");

        System.out.println("Task 3.5.");
        System.out.print("hasNext: ");
        ListIterator<Integer> iterator = linkedList.listIterator();
        start = System.nanoTime();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println(": " + (System.nanoTime() - start) + " nanosecond");
        System.out.print("hasPrevious: ");
        start = System.nanoTime();
        while (iterator.hasPrevious()) System.out.print(iterator.previous() + " ");
        System.out.print(": " + (System.nanoTime() - start) + " nanosecond");
        System.out.print("\nRemoving list items: ");
        start = System.nanoTime();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println((System.nanoTime() - start) + " nanosecond");
    }
}
