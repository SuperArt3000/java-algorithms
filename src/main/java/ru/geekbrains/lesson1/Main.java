package ru.geekbrains.lesson1;

public class Main {
    private int i;
    private static int primitive = 11;
    private static Integer reference = 5;
    static long lastTime;

    Main(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static boolean isEqualsFive(int... ints) {
        lastTime = System.nanoTime();
        for (int i : ints) {
            if (i == 5)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        /* Задание 1.1
        Приведите пример алгоритмов и структур данных из жизни.
        Задание 1.2
        Приведите пример алгоритмов и структур данных в программировании.
        Задание 1.3
        Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
        Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
        Выведите написанные данные.
        Задание 1.4
        Дополните предыдущий код сравнением ваших данных с другой переменной,
        данный код должен имитировать простейший поиск перебором.
        Оцените время выполнения алгоритма с помощью базового метода System.nanoTime(). */

        Main main = new Main(7);

        System.out.println(main.getI());
        System.out.println(primitive);
        System.out.println(reference);

        System.out.println(isEqualsFive(main.getI(), primitive, reference));
        System.out.println((System.nanoTime() - lastTime) * 0.000000001F);
    }
}
