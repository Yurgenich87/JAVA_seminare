package HW_3;

import java.util.ArrayList;
import java.util.List;

public class Task_3 {
	public static void main(String[] args) {
		// Задан целочисленный список
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(5);
		numbers.add(15);
		numbers.add(7);
		numbers.add(20);

		System.out.println("Список чисел: " + numbers);

		// Нахождение минимального значения
		int min = Integer.MAX_VALUE;
		for (int num : numbers) {
			if (num < min) {
				min = num;
			}
		}
		System.out.println("Минимальное значение: " + min);

		// Нахождение максимального значения
		int max = Integer.MIN_VALUE;
		for (int num : numbers) {
			if (num > max) {
				max = num;
			}
		}
		System.out.println("Максимальное значение: " + max);

		// Нахождение среднего значения
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		double average = (double) sum / numbers.size();
		System.out.println("Среднее значение: " + average);
	}
}
