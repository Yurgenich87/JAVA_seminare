package HW_1;

import java.util.Scanner;

public class Task_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите уравнение с вопросами в формате 'q + w = e': ");
		String equation = scanner.nextLine();

		boolean foundSolution = false;
		for (int q = 0; q < 10; q++) {
			for (int w = 0; w < 10; w++) {
				for (int e = 0; e < 10; e++) {
					String testEquation = equation.replace("?", String.valueOf(q))
							.replace("?", String.valueOf(w))
							.replace("?", String.valueOf(e));

					if (isValidEquation(testEquation)) {
						System.out.println("Решение: " + testEquation);
						foundSolution = true;
						break;
					}
					break;
				}
				break;
			}
		}

		if (!foundSolution) {
			System.out.println("Решений нет");
		}

		scanner.close();
	}

	private static boolean isValidEquation(String equation) {
		String[] parts = equation.split(" = ");
		int sum = 0;
		for (String part : parts[0].split(" \\+ ")) {
			sum += Integer.parseInt(part);
		}
		return sum == Integer.parseInt(parts[1]);
	}
}
