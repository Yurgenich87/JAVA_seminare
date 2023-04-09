package HW_4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task_5 {
	public static void main(String[] args) {
		Task_5 task = new Task_5();
		System.out.println(task.validate("()[]"));
		System.out.println(task.validate("()"));
		System.out.println(task.validate("{[()]}"));
		System.out.println(task.validate("()()"));
		System.out.println(task.validate(")()("));
	}

	public boolean validate(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
					return false;

				}
			}
		}
		return stack.isEmpty();
	}
}
