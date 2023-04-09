package HW_4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task_4 {

	public static void main(String[] args) {
		Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
		Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 4, 7));

		Task_4 task = new Task_4();
		Deque<Integer> result = task.sum(d1, d2);
		System.out.println(result);
	}

	public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
		Deque<Integer> result = new ArrayDeque<>();
		int carry = 0;
		while (!d1.isEmpty() || !d2.isEmpty() || carry != 0) {
			int digit1 = !d1.isEmpty() ? d1.pollFirst() : 0;
			int digit2 = !d2.isEmpty() ? d2.pollFirst() : 0;
			int sum = digit1 + digit2 + carry;
			carry = sum / 10;
			result.offerLast(sum % 10);
		}
		return result;
	}
}
