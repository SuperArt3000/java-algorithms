package ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static long start;
    private static long finish;

    public static void main(String[] args) {

        /* Задание 2.1
        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
        Выполните обращение к массиву и базовые операции класса Arrays.
        Оценить выполненные методы с помощью базового класса System.nanoTime().
        Задание 2.2
        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(),
        при необходимости расширьте уже существующий массив данных.
        Задание 2.3

        Создайте массив размером 400 элементов.
        Выполните сортировку с помощью метода sort().
        Оцените сортировку с помощью базового класса System.nanoTime().
        Задание 2.4
        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
        Задание 2.5
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
        Задание 2.6
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5. */

        int[] firstArray = {11, 22, 41, 154, 3, 8, 9, 30};

        findTimes(firstArray);

        linearSearch(firstArray, 154);
        binarySearch(firstArray, 11);

        int[] secondArray = getArray(400);

        float methodSortTime = methodSort(secondArray);
        float bubbleSortTime = bubbleSort(secondArray);
        float selectionSortTime = selectionSort(secondArray);
        float insertSortTime = insertSort(secondArray);

        System.out.println("\nmethodSort() " + (methodSortTime > bubbleSortTime ? "slower" : "faster") + " bubbleSort()");
        System.out.println("selectionSort() " + (selectionSortTime > bubbleSortTime ? "slower" : "faster") + " bubbleSort()");
        System.out.println("selectionSort() " + (selectionSortTime > methodSortTime ? "slower" : "faster") + " methodSort()");
        System.out.println("insertSort() " + (insertSortTime > bubbleSortTime ? "slower" : "faster") + " bubbleSort()");
        System.out.println("insertSort() " + (insertSortTime > methodSortTime ? "slower" : "faster") + " methodSort()");
        System.out.println("insertSort() " + (insertSortTime > selectionSortTime ? "slower" : "faster") + " selectionSort()");
    }

    public static void findTimes(int[] array) {
        start = System.nanoTime();
        int[] newInts = Arrays.copyOf(array, array.length);
        System.out.println("\nnewInts = Arrays.copyOf(array, array.length) = " + (System.nanoTime() - start) + "\n");

        start = System.nanoTime();
        System.out.print(Arrays.toString(array));
        System.out.println(" - Arrays.toString(array) = " + (System.nanoTime() - start) + "\n");

        start = System.nanoTime();
        Arrays.sort(array);
        finish = (System.nanoTime() - start);
        System.out.print(Arrays.toString(array));
        System.out.println(" - Arrays.sort(array) = " + (System.nanoTime() - start) + "\n");

        start = System.nanoTime();
        System.out.print(Arrays.binarySearch(array, 154) >= 0 ? "true" : "false");
        System.out.println(" - Arrays.binarySearch(array, 3) = " + (System.nanoTime() - start) + "\n");

        start = System.nanoTime();
        System.out.print(Arrays.equals(array, newInts) ? "true" : "false");
        System.out.println(" - Arrays.equals(array, newInts) = " + (System.nanoTime() - start) + "\n");
    }

    public static boolean linearSearch(int[] array, int a) {
        start = System.nanoTime();
        for (int j : array) {
            if (j == a) {
                System.out.println("linearSearch(int[] array, int a) = " + (System.nanoTime() - start) * 0.000000001F + "\n");
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int[] array, int a) {
        start = System.nanoTime();
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == a) {
                System.out.println("binarySearch(int[] array, int a) = " + (System.nanoTime() - start) * 0.000000001F);
                return middleIndex;
            } else if (array[middleIndex] < a) {
                firstIndex = middleIndex + 1;
            } else if (array[middleIndex] > a) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    private static float methodSort(int[] array) {
        int[] integers = array.clone();
        start = System.nanoTime();
        Arrays.sort(integers);
        finish = (System.nanoTime() - start);
        System.out.println("\nmethodSort result: " + Arrays.toString(integers));
        System.out.println("methodSort = " + (System.nanoTime() - finish) * 0.000000001F);
        return finish;
    }

    public static float bubbleSort(int[] array) {
        int[] cloneArray = array.clone();
        start = System.nanoTime();
        for (int i = 0; i < cloneArray.length - 1; i++) {
            for (int j = 0; j < cloneArray.length - i - 1; j++) {
                if (cloneArray[j] > cloneArray[j + 1]) {
                    swap(cloneArray, j, j + 1);
                }
            }
        }
        finish = (System.nanoTime() - start);
        System.out.println("\nbubbleSort result: " + Arrays.toString(cloneArray));
        System.out.println("bubbleSort = " + finish * 0.000000001F);
        return finish;
    }

    private static void swap(int[] a, int first, int last) {
        int buff = a[first];
        a[first] = a[last];
        a[last] = buff;
    }

    public static float selectionSort(int[] array) {
        int[] integers = array.clone();
        start = System.nanoTime();
        for (int i = 0; i < integers.length; i++) {
            int min = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[min]) {
                    min = j;
                }
            }
            swap(integers, i, min);
        }
        finish = (System.nanoTime() - start);
        System.out.println("\nselectionSort result: " + Arrays.toString(integers));
        System.out.println("selectionSort = " + finish);
        return finish;
    }

    public static float insertSort(int[] array) {
        int[] integers = array.clone();
        int buff;
        int in;
        start = System.nanoTime();
        for (int i = 1; i < integers.length; i++) {
            buff = integers[i];
            in = i;
            while (in > 0 && integers[in - 1] >= buff) {
                integers[in] = integers[in - 1];
                --in;
            }
            integers[in] = buff;
        }
        finish = (System.nanoTime() - start);
        System.out.println("\ninsertSort result: " + Arrays.toString(integers));
        System.out.println("insertSort = " + finish);
        return finish;
    }

    private static int[] getArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }
}
