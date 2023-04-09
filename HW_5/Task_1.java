package HW_5;

import java.util.*;

public class Task_1 {

	public static void main(String[] args) {
		// Создаем список сотрудников
		List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова",
				"Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
				"Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
				"Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
				"Петр Петин", "Иван Ежов");

		// Создаем HashMap для хранения телефонной книги
		Map<String, List<String>> phoneBook = new HashMap<>();

		// Заполняем телефонную книгу случайными телефонными номерами
		for (String employee : employees) {
			List<String> phones = generatePhoneNumbers();
			phoneBook.put(employee, phones);
		}

		// Находим повторяющиеся имена и их количество повторений
		Map<String, Integer> nameFrequency = new HashMap<>();
		for (String employee : employees) {
			String name = employee.split(" ")[0]; // Получаем имя сотрудника
			if (nameFrequency.containsKey(name)) {
				int frequency = nameFrequency.get(name);
				nameFrequency.put(name, frequency + 1);
			} else {
				nameFrequency.put(name, 1);
			}
		}

		// Сортируем по убыванию популярности
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(nameFrequency.entrySet());
		sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		// Выводим результаты
		System.out.println("Повторяющиеся имена с количеством повторений:");
		for (Map.Entry<String, Integer> entry : sortedList) {
			String name = entry.getKey();
			int frequency = entry.getValue();
			System.out.println(name + ": " + frequency);
		}
	}

	// Генерация случайных телефонных номеров
	private static List<String> generatePhoneNumbers() {
		List<String> phones = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				sb.append(random.nextInt(10));
			}
			phones.add(sb.toString());
		}
		return phones;
	}
}
