package ru.geekbrains.lesson5;

import java.util.Arrays;

/**
 * Java Algorithms. Interactive course. Lesson 5
 *
 * @author Nika Zurbaevi
 * @version dated October 26, 2020
 */
public class Main {
    private static final int[] simpleRecursionArray = new int[10];
    private static final int[] simpleCycleArray = new int[10];
    private static int counter = 0;

    public static void main(String[] args) {
        long lastTime;

        // Задание 5.1: Приведите пример использования рекурсии.
        // Два зеркала направиенные друг на друга

        // Задание 5.3: Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        // Стек вызова в жизни как пример выполнение человеком четко заданого распорядка дня по пунктам
        // Стек вызова с рекурсией как пример игра в шахматы с часами, сделал ход нажал на кнопку передал ход и так до конца игры

        System.out.print("Task 5.2.\nMethod for regular recursion: ");
        recursionMethodWithExit(5);
        // recursionMethod(5);

        System.out.println("\n\nTask 5.4.");
        lastTime = System.nanoTime();
        simpleRecursion(1);
        System.out.println("The execution time of the recursive method took: " + (System.nanoTime() - lastTime));
        lastTime = System.nanoTime();
        simpleCycle();
        System.out.println("The execution time of the cycle method took: " + (System.nanoTime() - lastTime));

        System.out.println("\nTask 5.5.\nBinary recursive search algorithm implementation:");
        int[] firstArray = new int[]{69, 48, 32, 13, 53, 62, 54, 37, 160, 76};
        int[] secondArray = Arrays.copyOf(firstArray, firstArray.length);
        int[] thirdArray = Arrays.copyOf(firstArray, firstArray.length);
        int[] fourthArray = Arrays.copyOf(firstArray, firstArray.length);
        System.out.println("Current array:" + Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        System.out.println("Sorted array:" + Arrays.toString(firstArray));
        lastTime = System.nanoTime();
        System.out.println("The result of the usual binarySearch method: " + Arrays.binarySearch(firstArray, 13));
        System.out.println("The execution time of the usual binarySearch method took: " + (System.nanoTime() - lastTime) + " nanosecond");
        System.out.println("Result of binary recursive search method: " + recursionBinarySearch(13, 0, secondArray.length, secondArray));
        System.out.println("The execution time of the binary recursive search method took:" + (System.nanoTime() - lastTime) + " nanosecond");

        System.out.println("\nTask 5.6.\nMerge sort algorithm implementation:");
        System.out.println("Current array: " + Arrays.toString(thirdArray));
        lastTime = System.nanoTime();
        Arrays.sort(thirdArray);
        System.out.println("Result method sort: " + Arrays.toString(thirdArray));
        System.out.println("The sort method took execution time: " + (System.nanoTime() - lastTime) + " nanosecond");
        lastTime = System.nanoTime();
        System.out.println("Merge sort result: " + Arrays.toString(sortMerge(fourthArray)));
        System.out.println("The merge sort took time to complete: " + (System.nanoTime() - lastTime) + " nanosecond");
    }

    private static int recursionMethod(int i) {
        System.out.println(i++);
        return recursionMethod(i);
    }

    private static int recursionMethodWithExit(int i) {
        System.out.print(i++ + " ");
        if (i >= 20)
            return i;
        return recursionMethodWithExit(i);
    }

    private static void simpleRecursion(int i) {
        simpleRecursionArray[counter++] = i;
        if (counter == 10)
            return;
        simpleRecursion(++i);
    }

    private static void simpleCycle() {
        for (int i = 0; i < 10; i++) {
            simpleCycleArray[i] = i + 5;
        }
    }

    public static int recursionBinarySearch(int searchKey, int low, int high, int[] arr) {
        if (low > high) {
            return arr.length;
        }
        int middle = (low + high) / 2;
        if (arr[middle] == searchKey) {
            return middle;
        } else if (arr[middle] < searchKey) {
            return recursionBinarySearch(searchKey, low + 1, high, arr);
        } else {
            return recursionBinarySearch(searchKey, low, high - 1, arr);
        }
    }

    public static int[] sortMerge(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return arr;
        }
        int middle = length / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, length)));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
