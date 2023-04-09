package HW_3;

import java.util.ArrayList;
import java.util.List;

public class Task_2 {
	public static void main(String[] args) {
		// Произвольный список целых чисел
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);

		System.out.println("Исходный список: " + numbers);

		// Удаление четных чисел из списка
		for (int i = numbers.size() - 1; i >= 0; i--) {
			if (numbers.get(i) % 2 == 0) {
				numbers.remove(i);
			}
		}

		System.out.println("Список после удаления четных чисел: " + numbers);
	}
}
