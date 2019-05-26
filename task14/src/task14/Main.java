package task14;
import Snej.Easy;
public class Main {

	public static void main(String[] args) {
		System.out.print("#### ЗАДАЧА №14 ####\n"
					   + "У таблиці А розміру N за один перегляд необхідно кожен елемент замінити\n"
					   + "на найближчий наступний за ним елемент, який більше його. Якщо такого\n"
					   + "елемента немає, то замінити його на нуль\n"
					   + "--------------------\n");
		//ввод
		System.out.print("Количество чисел в последовательности: ");
		int size;
		do {
			size = Easy.giveMeInt();
		} while (size <= 0);
		int[] arr = new int[size];
		System.out.println("Вводите числа последовательности: ");
		for (int i = 0; i < size; i++) {
			arr[i] = Easy.giveMeInt();
		}
		System.out.println("Ваш массив:");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();

		for (int i = 0; i < size; i++) { //идем по каждому числу в массиве
			int j = i + 1;
			boolean isFound = false; //показывает, нашли мы бОльшее число или нет
			while(j < size) { //проверяем все числа, которые есть после данного
				if (arr[j] > arr[i]) { //как только находим число, большее данного - прекращаем поиск
					arr[i] = arr[j];
					isFound = true;
					break;
				}
				else {
					j++;
				}
			}
			if (!isFound) //если бОльшее число так и не нашлось, ставим ноль
				arr[i] = 0;
		}
		//вывод результатов
		System.out.println("Массив с замещением:");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
		System.out.println("Начать заново? 1 - да, другое число - выход");
		int ans = Easy.giveMeInt();
		if(ans == 1) 
			main(null);
	}

}
