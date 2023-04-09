package HW_3;

import java.util.Arrays;

public class Task_1 {
	// Алгоритм сортировки слиянием
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int middle = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, middle);
		int[] right = Arrays.copyOfRange(arr, middle, arr.length);
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}

	private static void merge(int[] arr, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}

	// Алгоритм сортировки выборкой
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 1, 5, 6 };
		System.out.println("Исходный массив: " + Arrays.toString(arr));

		// Сортировка слиянием
		mergeSort(arr);
		System.out.println("Отсортированный массив слиянием: " + Arrays.toString(arr));

		// Сортировка выборкой
		int[] arr2 = { 5, 2, 9, 1, 5, 6 };
		selectionSort(arr2);
		System.out.println("Отсортированный массив выборкой: " + Arrays.toString(arr2));
	}
}
