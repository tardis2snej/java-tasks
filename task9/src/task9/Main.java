package task9;

import Snej.Easy;

public class Main {

	public static void main(String[] args) {
		System.out.print("#### ЗАДАЧА №9 ####\n"
						 + "Дан масив X [1..N]. Необхідно циклічно зрушити його на k елементів вправо\n"
						 + "(тобто елемент X [i] після зсуву повинен стояти на місці X [i + k];\n"
						 + "тут ми вважаємо що за X [N] слід X [1]). Додаткового масиву заводити не можна!\n"
						 + "-----------------\n");
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //наш массив
		System.out.println("Ваш массив:"); //вывод изначального массива
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.print("\n");
		System.out.print("Введите k - смещение массива (больше нуля - влево, меньше нуля - вправо): "); //получение числа k
		int k = Easy.giveMeInt();
		if (k > 0) { //если k больше нуля, смещаем вправо
			for (int i = 0; i < k; i++) { //количество единичных смещений до k
				int first = 0;
				for (int j = 0; j < arr.length; j++) { //смещение вправо на 1
					if (j == 0) //сохраняем первый элемент
						first = arr[j];
					if (j == arr.length - 1) //записваем первый элемент в конец массива
						arr[j] = first;
					else
						arr[j] = arr[j + 1]; //переписываем все остальные элементы
				}
			}
		}
		else if (k < 0) { //если k меньше нуля, смещаем влево
			for (int i = 0; i > k; i--) { //количество единичных смещений до k
				int last = 0;
				for (int j = arr.length - 1; j >= 0; j--) { //единичное смещение влево
					if (j == arr.length - 1) //сохраняем последний элемент
						last = arr[j];
					if (j == 0) //записываем последний элемент первым
						arr[j] = last;
					else //смещаем все остальные элементы
						arr[j] = arr[j - 1];
				}
			}
		}
		System.out.println("Массив со смещением:"); //вывод получившегося массива
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.print("\n");
	}

}
