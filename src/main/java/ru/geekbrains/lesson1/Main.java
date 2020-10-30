package ru.geekbrains.lesson1;

/**
 * Java Algorithms. Interactive course. Lesson 1
 *
 * @author Nika Zurbaevi
 * @version dated October 20, 2020
 */
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

    public static boolean isEquals(int... ints) {
        lastTime = System.nanoTime();
        for (int i : ints) {
            if (i == 11)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main(7);

        System.out.println(main.getI());
        System.out.println(primitive);
        System.out.println(reference);

        System.out.println(isEquals(main.getI(), primitive, reference));
        System.out.println((System.nanoTime() - lastTime));
    }
}
