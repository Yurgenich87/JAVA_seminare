package HW_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Notebook {
	private String brand;
	private int ram;
	private int hdd;
	private String os;
	private String color;

	public Notebook(String brand, int ram, int hdd, String os, String color) {
		this.brand = brand;
		this.ram = ram;
		this.hdd = hdd;
		this.os = os;
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public int getRam() {
		return ram;
	}

	public int getHdd() {
		return hdd;
	}

	public String getOs() {
		return os;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Notebook{" +
				"brand='" + brand + '\'' +
				", ram=" + ram +
				", hdd=" + hdd +
				", os='" + os + '\'' +
				", color='" + color + '\'' +
				'}';
	}
}

class NotebookShop {
	private Set<Notebook> notebooks = new HashSet<>();

	public void addNotebook(Notebook notebook) {
		notebooks.add(notebook);
	}

	public void filterNotebooks(Map<String, Object> filterCriteria) {
		Set<Notebook> filteredNotebooks = new HashSet<>();
		for (Notebook notebook : notebooks) {
			boolean passFilter = true;
			for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				switch (key) {
					case "ram":
						if (notebook.getRam() < (int) value) {
							passFilter = false;
						}
						break;
					case "hdd":
						if (notebook.getHdd() < (int) value) {
							passFilter = false;
						}
						break;
					case "os":
						if (!notebook.getOs().equalsIgnoreCase((String) value)) {
							passFilter = false;
						}
						break;
					case "color":
						if (!notebook.getColor().equalsIgnoreCase((String) value)) {
							passFilter = false;
						}
						break;
					default:
						System.out.println("Некорректный выбор критерия фильтрации.");
						break;
				}
				if (!passFilter) {
					break;
				}
			}
			if (passFilter) {
				filteredNotebooks.add(notebook);
			}
		}
		if (filteredNotebooks.isEmpty()) {
			System.out.println("Ноутбуки, отвечающие заданным критериям фильтрации, не найдены.");
		} else {
			System.out.println("Найденные ноутбуки, отвечающие заданным критериям фильтрации:");
			for (Notebook notebook : filteredNotebooks) {
				System.out.println(notebook.toString());
			}
		}
	}
}

public class Task_1 {
	public static void main(String[] args) {
		// Создаем магазин ноутбуков
		NotebookShop notebookShop = new NotebookShop();

		// Добавляем ноутбуки в магазин
		Notebook notebook1 = new Notebook("Lenovo", 8, 256, "Windows", "Black");
		Notebook notebook2 = new Notebook("HP", 16, 512, "Windows", "Silver");
		Notebook notebook3 = new Notebook("Dell", 16, 1024, "Windows", "Blue");
		Notebook notebook4 = new Notebook("Apple", 8, 512, "macOS", "Silver");
		Notebook notebook5 = new Notebook("Asus", 32, 256, "Windows", "Red");
		notebookShop.addNotebook(notebook1);
		notebookShop.addNotebook(notebook2);
		notebookShop.addNotebook(notebook3);
		notebookShop.addNotebook(notebook4);
		notebookShop.addNotebook(notebook5);

		// Запрашиваем у пользователя критерии фильтрации
		Scanner scanner = new Scanner(System.in);
		Map<String, Object> filterCriteria = new HashMap<>();
		System.out.println("Введите цифру, соответствующую необходимому критерию:");
		System.out.println("1 - ОЗУ");
		System.out.println("2 - Объем ЖД");
		System.out.println("3 - Операционная система");
		System.out.println("4 - Цвет");
		System.out.print("Выберите критерий: ");
		int criteria = scanner.nextInt();
		switch (criteria) {
			case 1:
				System.out.print("Введите минимальный объем ОЗУ: ");
				int minRam = scanner.nextInt();
				filterCriteria.put("ram", minRam);
				break;
			case 2:
				System.out.print("Введите минимальный объем ЖД: ");
				int minHdd = scanner.nextInt();
				filterCriteria.put("hdd", minHdd);
				break;
			case 3:
				System.out.print("Введите операционную систему: ");
				String os = scanner.next();
				filterCriteria.put("os", os);
				break;
			case 4:
				System.out.print("Введите цвет: ");
				String color = scanner.next();
				filterCriteria.put("color", color);
				break;
			default:
				System.out.println("Некорректный выбор критерия фильтрации.");
				break;
		}

		// Вызываем метод фильтрации и выводим результат
		notebookShop.filterNotebooks(filterCriteria);
	}
}
