package HW_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task_3 {

	public static void main(String[] args) {1
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите число в формате byte:");
		byte number = scanner.nextByte();

		try {
			File file = new File("result.txt");
			FileWriter writer = new FileWriter(file);
			writer.write(Byte.toString(number));
			writer.close();
			System.out.println("Число успешно записано в файл.");
		} catch (IOException e) {
			Logger logger = Logger.getLogger(Task_3.class.getName());
			logger.log(Level.SEVERE, "Ошибка при записи числа в файл.", e);
		}
	}

}
