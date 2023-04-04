package HW_2;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Task_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, "UTF-8");
		System.setProperty("file.encoding", "UTF-8");
		// Чтение входных данных2
		int n = scanner.nextInt();
		scanner.nextLine(); // Считываем оставшийся перевод строки после числа n

		List<String> recipes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			recipes.add(scanner.nextLine());
		}

		int m = scanner.nextInt();
		scanner.nextLine(); // Считываем оставшийся перевод строки после числа m

		Map<String, String> substitutions = new HashMap<>();
		for (int i = 0; i < m; i++) {
			String[] line = scanner.nextLine().split(" - ");
			substitutions.put(line[0], line[1]);
		}

		// Замена продуктов в рецептах
		for (int i = 0; i < n; i++) {
			String recipe = recipes.get(i);
			for (Map.Entry<String, String> entry : substitutions.entrySet()) {
				String product = entry.getKey();
				String substitute = entry.getValue();
				recipe = recipe.replaceAll("\\b" + product + "\\b", substitute);
				recipe = recipe.replaceAll("\\b" + capitalize(product) + "\\b", capitalize(substitute));
			}
			System.out.println(recipe);
		}
	}

	// Вспомогательная функция для приведения первой буквы к заглавной
	public static String capitalize(String s) {
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
}
