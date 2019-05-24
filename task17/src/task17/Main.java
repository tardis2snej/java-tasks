package task17;

import java.util.ArrayList;
import Snej.Easy;

public class Main {
	
	public static void main(String[] args) {
		System.out.print("#### Задача №17 ####\n"
				       + "Вводиться послідовність з n натуральних чисел. Необхідно визначити\n"
				       + "найменше натуральне число, якого немає у послідовності.\n"
				       + "--------------------\n");
		
		ArrayList<Integer> sequence = new ArrayList<Integer>(); //для хранения последовательности
		while (true) { //ввод чисел
			System.out.print("Введите натуральное число или -1, чтобы закончить ввод: ");
			Integer num = Easy.giveMeInt();
			if (num == -1)
				break;
			if (num >= 0)
				sequence.add(num);
		}
		sequence.sort(null); //сортировка последовательности, чтобы упростить дальнейшую задачу
		if (sequence.size() > 0) { //вывод последовательности
			System.out.println("Отсортированная последовательность: ");
			for(int i = 0; i < sequence.size(); i++) {
				System.out.print(sequence.get(i) + "  ");
			}
			System.out.println();
		}
		if (sequence.size() > 1) { //убираем повторы, т.к. они нам мешают
			for (int i = 1; i < sequence.size(); i++) {
				if (sequence.get(i - 1) == sequence.get(i)) {
					sequence.remove(i);
					i--;
				}
			}
		}
		int currMin = 0; //отсутствующий элемент последовательности
		while (currMin < sequence.size()) {
			if (currMin == sequence.get(currMin))
				currMin++;
			else
				break;
		}
		//результаты
		if (sequence.size() == 0) {
			System.out.println("Последовательность не создана");
		}
		else {
			System.out.println("Отсутствует значение: " + currMin);
		}
		System.out.println("Начать заново? 1 - да, любое число - выход");
		int ans = Easy.giveMeInt();
		if(ans == 1) { //перезапуск функции
			main(null);
		}
	}

}
