package HW_2;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Task_3_1 {

	private static final Logger logger = Logger.getLogger(Task_3_1.class.getName());

	public static void main(String[] args) {
		String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
		String name = "Alice";
		String localFilename = "example.txt";

		String fileContent = download(fileUrl);
		if (fileContent == null) {
			logger.warning("Failed to download file from URL: " + fileUrl);
			return;
		}
		logger.info("File content before replacement:\n" + fileContent);

		String replacedContent = change(name, fileContent);
		logger.info("File content after replacement:\n" + replacedContent);

		saveOnLocal(localFilename, replacedContent);
		logger.info("File saved on local as " + localFilename);

		String savedFileContent = read(localFilename);
		logger.info("File content read from local file:\n" + savedFileContent);

		boolean fileRemoved = removeFromLocale(localFilename);
		if (fileRemoved) {
			logger.info("File removed from local: " + localFilename);
		} else {
			logger.warning("Failed to remove file from local: " + localFilename);
		}
	}

	public static String download(String url) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
			StringBuilder content = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
				content.append(System.lineSeparator());
			}
			return content.toString();
		} catch (IOException e) {
			logger.severe("Failed to download file from URL: " + url + ". Error message: " + e.getMessage());
			return null;
		}
	}

	public static String change(String name, String fileContent) {
		return fileContent.replaceAll("%s", name);
	}

	public static void saveOnLocal(String fileName, String fileContent) {
		try {
			Path path = Paths.get(fileName);
			Files.write(path, fileContent.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			logger.severe("Failed to save file on local: " + fileName + ". Error message: " + e.getMessage());
		}
	}

	public static String read(String fileName) {
		try {
			byte[] encodedFileContent = Files.readAllBytes(Paths.get(fileName));
			return new String(encodedFileContent, StandardCharsets.UTF_8);
		} catch (IOException e) {
			logger.severe("Failed to read file: " + fileName + ". Error message: " + e.getMessage());
			return null;
		}
	}

	public static boolean removeFromLocale(String fileName) {
		try {
			Files.delete(Paths.get(fileName));
			return true;
		} catch (IOException e) {
			logger.severe("Failed to remove file from local: " + fileName + ". Error message: " + e.getMessage());
			return false;
		}
	}
}
