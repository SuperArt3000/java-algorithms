package ru.geekbrains.lesson4;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* Задание 4.1
        На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        Задание 4.2
        На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        Реализуйте вспомогательные методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        Задание 4.3
        На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        Задание 4.4
        Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        Задание 4.5
        На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        Оцените время выполнения операций с помощью базового метода System.nanoTime(). */

        long lastTime;

        System.out.print("Task 4.1.\nPopulating Stack from LinkedList: ");
        Integer[] arr = new Integer[]{92, 38, 24, 15, 65, 76, 48, 93, 210, 57};
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(arr));
        Stack<Integer> stack = new Stack<>();
        lastTime = System.nanoTime();
        stack.addAll(linkedList);
        System.out.println(stack + "\nWe display the last item using the peek method: " + stack.peek());
        stack.pop();
        System.out.println("We remove the last element using the pop method. Displaying the resulting stack: " + stack);
        System.out.println("The execution time of these operations took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.print("Task 4.2.\nFill Queue from LinkedList: ");
        lastTime = System.nanoTime();
        Queue<Integer> queue = new LinkedList<>(linkedList);
        System.out.println(linkedList + "\nDisplaying the first element using the element method: " + queue.element());
        queue.remove();
        System.out.println("We remove the first element using the remove method. We display the resulting Queue: " + queue);
        System.out.println("We check if the Queue is empty using the isEmpty method: " + queue.isEmpty());
        System.out.println("Checking the size of the Queue using the size method: " + queue.size());
        System.out.println("The execution time of these operations took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.print("Task 4.3.\nFill Deque from LinkedList: ");
        lastTime = System.nanoTime();
        Deque<Integer> deque = new ArrayDeque<>(linkedList);
        System.out.print(deque + "\nAdd an element to the beginning of the Deque using the addFirst method.");
        deque.addFirst(100);
        System.out.print("We display the resulting Deque: " + deque);
        System.out.println("Add an element to the end of the Deque using the addLast method.");
        deque.addLast(200);
        System.out.println("Displaying the resulting Deque: " + deque);
        System.out.println("Displaying the first and last Deque elements using the peekFirst methods: " + deque.peekFirst() + " and peekLast: " + deque.peekLast());
        deque.pollFirst();
        deque.pollLast();
        System.out.println("Remove the first and last Deque elements using the pollFirst and pollLast methods. We display the resulting Deque: " + deque);
        System.out.println("The execution time of these operations took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.print("Task 4.4.\nFill PriorityQueue from LinkedList: ");
        lastTime = System.nanoTime();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(linkedList);
        System.out.println(priorityQueue + "\nWe display the priority element using the peek method: " + priorityQueue.peek());
        priorityQueue.poll();
        System.out.println("Removing the priority element using the poll method. We display the resulting PriorityQueue: " + priorityQueue);
        System.out.println("The execution time of these operations took: " + (System.nanoTime() - lastTime) + " nanosecond\n");

        System.out.print("Task 4.5.\nPopulating a Stack based on a linked list (myStack) from a Stack (from task 4.1): ");
        SimpleStackList myStack = new SimpleStackList();
        lastTime = System.nanoTime();
        for (Integer integer : stack) myStack.push(integer);
        myStack.display();
        System.out.println("\nChecking stack fill and removing items one at a time:");
        System.out.print("Element ");
        while (!myStack.isEmpty()) System.out.print(myStack.pop() + " ");
        System.out.print("delete from Stack\nThe execution time of these operations took: " + (System.nanoTime() - lastTime) + " nanosecond");
        System.out.println("\nPopulating a Queue based on a linked list (myQueue) from a Queued (from Activity 4.2): ");
        SimpleQueue myQueue = new SimpleQueue();
        lastTime = System.nanoTime();
        for (int i = 0; i < queue.size(); ) {
            myQueue.insert(queue.peek());
            queue.poll();
        }
        myQueue.display();
        System.out.println("\nCheck if myQueue is full and remove items one by one until the Queue is empty: ");
        System.out.print("Element ");
        while (!myQueue.isEmpty()) System.out.print(myQueue.delete() + " ");
        System.out.println("delete from myQueue\nThe execution time of these operations took: " + (System.nanoTime() - lastTime) + " nanosecond");
    }

    static class Link {
        public int value;

        public Link next;

        public Link(int value) {
            this.value = value;
        }

        public void display() {
            System.out.print(this.value + " ");
        }
    }

    static class SimpleLinkedList {
        public Link first;

        public SimpleLinkedList() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(int value) {
            Link newLink = new Link(value);
            newLink.next = first;
            first = newLink;
        }

        public Link delete() {
            Link temp = first;
            first = first.next;
            return temp;
        }

        public void display() {
            Link current = first;
            while (current != null) {
                current.display();
                current = current.next;
            }
        }
    }

    static class SimpleStackList {
        private SimpleLinkedList list;

        public SimpleStackList() {
            list = new SimpleLinkedList();
        }

        public void push(int value) {
            list.insert(value);
        }

        public int pop() {
            return list.delete().value;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            list.display();
        }
    }

    static class SimpleQueue {
        private SimpleLinkedList myQueue;

        public SimpleQueue() {
            myQueue = new SimpleLinkedList();
        }

        public void insert(int value) {
            myQueue.insert(value);
        }

        public int delete() {
            return myQueue.delete().value;
        }

        public boolean isEmpty() {
            return myQueue.isEmpty();
        }

        public void display() {
            myQueue.display();
        }
    }
}
