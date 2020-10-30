package ru.geekbrains.lesson7;

/**
 * Java Algorithms. Interactive course. Lesson 5
 *
 * @author Nika Zurbaevi
 * @version dated October 30, 2020
 */
public class Main {
    public static void main(String[] args) {
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
