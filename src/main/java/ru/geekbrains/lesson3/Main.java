package ru.geekbrains.lesson3;

import java.util.*;

/**
 * Java Algorithms. Interactive course. Lesson 3
 *
 * @author Nika Zurbaevi
 * @version dated October 24, 2020
 */
public class Main {
    public static void main(String[] args) {
        long lastTime;

        Integer[] arr = {9, 8, 2, 1, 5, 6, 4, 3, 10, 7};
        System.out.println("Task 3.1.\nStarting array: " + Arrays.toString(arr));
        lastTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Getting the arrayList: " + arrayList);
        System.out.println("The execution time of converting an array to a list took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.println("Task 3.2.\nAdding element:");
        lastTime = System.nanoTime();
        arrayList.add(10, 100);
        System.out.println("The resulting arrayList after adding an element: " + arrayList);
        System.out.println("The execution time of the method for adding an item to the list took: " + (System.nanoTime() - lastTime) + " nanosecond");
        System.out.println("Deleting element:");
        lastTime = System.nanoTime();
        arrayList.remove(10);
        System.out.println("The resulting arrayList after removing the element: " + arrayList);
        System.out.println("The execution time of the method for removing an item from the list took: " + (System.nanoTime() - lastTime) + " nanosecond");
        lastTime = System.nanoTime();
        System.out.println("Received arrayList element: " + arrayList.get(8));
        System.out.println("The execution time of the method to find an item from the list took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.println("Task 3.3.");
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) list.insert(i);
        System.out.print("The resulting singly linked list: ");
        list.display();
        System.out.println("\nAn example of finding the desired element using the find method: " + list.find(2) + "\n");

        System.out.print("Task 3.4.");
        java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
        linkedList.addAll(0, arrayList);
        linkedList.add(100);
        System.out.println("\nAdding an item to a two-sided list: " + linkedList);
        linkedList.set(4, 500);
        System.out.println("Replacing an item in a two-sided list: " + linkedList);
        linkedList.remove(10);
        System.out.println("Remove an item from a two-sided list: " + linkedList);
        linkedList.addFirst(100);
        linkedList.addLast(200);
        System.out.println("Adding the first and last item: " + linkedList + "\n");

        System.out.print("Task 3.5.\nCheck if the linked list contains the next element hasNext method: ");
        ListIterator<Integer> iterator = linkedList.listIterator();
        lastTime = System.nanoTime();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println("\nThe execution time of these methods took: " + (System.nanoTime() - lastTime) + " nanosecond");
        System.out.print("Check if the linked list contains the previous element hasPrevious method: ");
        lastTime = System.nanoTime();
        while (iterator.hasPrevious()) System.out.print(iterator.previous() + " ");
        System.out.println("\nThe execution time of these methods took: " + (System.nanoTime() - lastTime) + " nanosecond");
        lastTime = System.nanoTime();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println("Execution time deleting data took: " + (System.nanoTime() - lastTime) + " nanosecond");
    }
}
