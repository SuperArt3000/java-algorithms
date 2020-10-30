package ru.geekbrains.lesson7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Для заданий 7.2, 7.3 и 7.4
 */
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

/**
 * Для заданий 7.2, 7.3 и 7.4
 */
class Graph {
    private final int MAX_VERTICES = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;

    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMat = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs(int f) {
        vertexList[f].wasVisited = true;
        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1) {
                fullDisplayVertex(f, v);
                dfs(i);
            }
        }
    }

    public void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Tops " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        queue.add(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
