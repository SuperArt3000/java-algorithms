package ru.geekbrains.lesson7;

public class Main {
    public static void main(String[] args) {

        /* Задание 7.1
        Приведите пример графа.
        Задание 7.2
        Реализуйте базовые методы графа.
        Задание 7.3
        В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
        Выполните оценку времени с помощью System.nanoTime().
        Задание 7.4
        В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
        Выполните оценку времени с помощью System.nanoTime(). */

        long lastTime;

        // Задание 7.1: Приведите пример графа.
        // Ответ: используются в логистики в проложении наиболее выгодного маршрута маршрута

        System.out.println("Task 7.2. Implementation of basic graph methods: ");
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        System.out.print("The output of the vertex at index 3: ");
        graph.displayVertex(3);

        System.out.println("\nTask 7.3. Depth-first traversal implementation: ");
        lastTime = System.nanoTime();
        graph.dfs(0);
        System.out.println("The execution time of the depth-first traversal took: " + (System.nanoTime() - lastTime) + " nanosecond");

        System.out.println("\nTask 7.4. Breadth-first traversal implementation:");
        lastTime = System.nanoTime();
        graph.bfs();
        System.out.println("The execution time of the breadth-first traversal took: " + (System.nanoTime() - lastTime) + " nanosecond");
    }
}
