package HW_4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task_3 {

	// Дан Deque состоящий из последовательности цифр.
	// Необходимо проверить, что последовательность цифр является палиндромом
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		System.out.println(checkOn(deque)); // false
	}

	public static boolean checkOn(Deque<Integer> deque) {
		// Создаем копию исходной очереди, чтобы не изменять ее содержимое
		Deque<Integer> copyDeque = new ArrayDeque<>(deque);

		while (copyDeque.size() > 1) {
			// Извлекаем первый и последний элементы из очереди
			Integer first = copyDeque.pollFirst();
			Integer last = copyDeque.pollLast();

			// Если первый и последний элементы не равны, это не палиндром
			if (!first.equals(last)) {
				return false;
			}
		}

		// Если очередь содержит нечетное количество элементов,
		// то центральный элемент не влияет на проверку палиндрома
		// и мы можем его пропустить

		// Остался только один элемент или очередь пуста, значит это палиндром
		return true;
	}
}
