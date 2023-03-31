package HW_1;
/*Создайте массив, в котором будут храниться кубы чисел от 1 до 1000. Затем вводятся 2 числа из этого диапазона. 
Используя данные из массива найдите их кубы.
Sample Input:
8
11
Sample Output:
512
1331 */

import java.util.Scanner;

public class Task_1 {
	public static void main(String[] args) {
		int[] cubes = new int[1000];

		for (int i = 1; i <= 1000; i++) {
			cubes[i - 1] = i * i * i;
		}

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Введите первое число: ");
			int first = scanner.nextInt();
			System.out.print("Введите второе число: ");
			int second = scanner.nextInt();

			int index1 = first - 1;
			int index2 = second - 1;

			int cube1 = cubes[index1];
			int cube2 = cubes[index2];

			System.out.println("Куб числа " + first + " равен " + cube1);
			System.out.println("Куб числа " + second + " равен " + cube2);
		}
	}
}