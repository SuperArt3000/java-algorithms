package ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
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

        long lastTime;
        long bubbleSortTime;
        long insertionSortTime;
        long selectionSortTime;
        long methodSortTime;
        long linearSearchTime;
        long binarySearchTime;

        Random random = new Random();
        int[] array = new int[]{22, 18, 52, 15, 56, 68, 44, 31, 120, 47};
        int key = array[random.nextInt(array.length)];
        System.out.println("Task 2.1.\nBasic operations of the Arrays class.");
        lastTime = System.nanoTime();
        System.out.println("The resulting array: " + Arrays.toString(array));
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("Copied array: " + Arrays.toString(arrayCopy));
        System.out.println("The result of the binarySearch method: " + Arrays.binarySearch(array, key));
        System.out.println("Outputting the result of the Arrays.equals method between the array and arrayCopy arrays: " + Arrays.equals(array, arrayCopy));
        System.out.println("The execution time of the specified basic operations of the Arrays class took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        lastTime = System.nanoTime();
        System.out.println("Task 2.2.");
        System.out.println("The result of the linearSearch method: " + linearSearch(array, key));
        linearSearchTime = System.nanoTime() - lastTime;
        System.out.println("The execution time of a linear search for a value (key) in an unsorted array took: " + linearSearchTime + " nanosecond");
        lastTime = System.nanoTime();
        System.out.println("The result of the binarySearch method: " + Arrays.binarySearch(array, key));
        binarySearchTime = System.nanoTime() - lastTime;
        System.out.println("Execution time of binary search for value (key) in unsorted array took: " + binarySearchTime + " nanosecond\n");

        int[] firstBigArray = new int[400];
        for (int i = 0; i < firstBigArray.length; i++) {
            firstBigArray[i] = random.nextInt(400);
        }
        int[] secondBigArray = firstBigArray.clone();
        int[] thirdBigArray = firstBigArray.clone();
        int[] fourthBigArray = firstBigArray.clone();
        System.out.println("Task 2.3. \nCurrent array: " + Arrays.toString(firstBigArray));
        lastTime = System.nanoTime();
        Arrays.sort(firstBigArray);
        methodSortTime = System.nanoTime() - lastTime;
        System.out.println("Sorted array: " + Arrays.toString(firstBigArray));
        System.out.println("The execution time of sorting the array using the sort() method took: " + methodSortTime + " nanosecond\n");

        System.out.println("Task 2.4.\nCurrent array: " + Arrays.toString(secondBigArray));
        lastTime = System.nanoTime();
        bubbleSort(secondBigArray);
        bubbleSortTime = System.nanoTime() - lastTime;
        System.out.println("Sorted array: " + Arrays.toString(secondBigArray));
        System.out.println("The bubble sort on secondBigArray took time: " + bubbleSortTime + " nanosecond");
        System.out.println("Method sort " + (methodSortTime > bubbleSortTime ? "slower" : "faster") + " than bubble sort\n");

        System.out.println("Задание 2.5. \nCurrent array: " + Arrays.toString(thirdBigArray));
        lastTime = System.nanoTime();
        selectionSort(thirdBigArray);
        selectionSortTime = System.nanoTime() - lastTime;
        System.out.println("Sorted array: " + Arrays.toString(thirdBigArray));
        System.out.println("The selection sort on thirdBigArray took time: " + selectionSortTime + " nanosecond");
        System.out.println("Selection sort " + (selectionSortTime > methodSortTime ? "slower" : "faster") + " than method sort");
        System.out.println("Selection sort " + (selectionSortTime > bubbleSortTime ? "slower" : "faster") + " than bubble sort\n");

        System.out.println("Задание 2.6. \nCurrent array: " + Arrays.toString(fourthBigArray));
        lastTime = System.nanoTime();
        insertionSort(fourthBigArray);
        insertionSortTime = System.nanoTime() - lastTime;
        System.out.println("Sorted array: " + Arrays.toString(fourthBigArray));
        System.out.println("Insertion sort " + (insertionSortTime > bubbleSortTime ? "slower" : "faster") + " than bubble sort");
        System.out.println("Insertion sort " + (insertionSortTime > methodSortTime ? "slower" : "faster") + " than method sort");
        System.out.println("Insertion sort " + (insertionSortTime > selectionSortTime ? "slower" : "faster") + " than selection sort\n");

        System.out.println("Nanosecond to second for bubble sort: " + ((double) bubbleSortTime / 1000000000.0));
        System.out.println("Nanosecond to second for method sort: " + ((double) methodSortTime / 1000000000.0));
        System.out.println("Nanosecond to second for selection sort: " + ((double) selectionSortTime / 1000000000.0));
        System.out.println("Nanosecond to second for insertion sort: " + ((double) insertionSortTime / 1000000000.0));
        System.out.println("Nanosecond to second for linear search: " + ((double) linearSearchTime / 1000000000.0));
        System.out.println("Nanosecond to second for binary search: " + ((double) binarySearchTime / 1000000000.0));
    }

    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                    int buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
        }
    }

    public static boolean linearSearch(int[] array, int key) {
        for (int value : array) {
            if (value == key) {
                return true;
            }
        }
        return false;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int buff = array[i];
            array[i] = array[min];
            array[min] = buff;
        }
    }

    public static void insertionSort(int[] array) {
        int buff;
        int in;
        for (int i = 1; i < array.length; i++) {
            buff = array[i];
            in = i;
            while (in > 0 && array[in - 1] >= buff) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = buff;
        }
    }
}
