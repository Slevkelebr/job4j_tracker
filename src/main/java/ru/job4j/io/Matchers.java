package ru.job4j.io;

import java.util.Scanner;

/**
 * class Matchers - реализация игры в спички.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 03.04.2020
 */
public class Matchers {
    public static void main(String[] args) {
        int matches = 11;
        int player = 1;
        int step = 2;
        boolean run = true;
        while (run) {
            if (player == 1) {
                System.out.println("Ходит " + player + " игрок. Пожалуйста введите число от 1 до 3.");
                player++;
            } else if (player == 2) {
                System.out.println("Ходит " + player + " игрок. Пожалуйста введите число от 1 до 3.");
                player = 1;
            }
            step++;
            int inputPlayer = input();
            if (check(inputPlayer)) {
                matches -= inputPlayer;
                System.out.println("Осталось: " + matches);
                if (matches == 0) {
                    player = step % 2 == 0 ? 2 : 1;
                    System.out.println("У нас есть победитель, это " + player + " игрок.");
                    System.out.println("Конец игры.");
                    run = false;
                }
            }
        }
    }

    private static int input() {
        Scanner input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    private static boolean check(int input) {
        return input <= 3;
    }

}
