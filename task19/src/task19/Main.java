package task19;

import java.util.ArrayList;
import Snej.Easy;

public class Main {

	static class EachSum { //элемент класса содержит список всех комбинаций чисел, сумма которых равняется sum
		int sum;
		ArrayList<Integer[]> numbers;
		
		EachSum(int sum) {
			this.sum = sum;
			numbers = new ArrayList<Integer[]>();
		}
	}
	
	static ArrayList<EachSum> comb = new ArrayList<EachSum>(); 
	
	public static void main(String[] args) {
		System.out.print("#### ЗАДАЧА № 19 ####\n"
				       + "Написати програму визначення кількості шестизначних 'щасливих' квитків, \n"
				       + "у яких сума перших 3 десяткових цифр дорівнює сумі 3 останніх десяткових цифр.\n"
				       + "---------------------");
				
		for(int i = 0; i < 28; i++) { //27 - максимальная сумма трех одноцифровых чисел
			comb.add(new EachSum(i));
		}
		
		//следующие три цикла перебирают все возможные комбинации трех цифр, подсчитывают сумму в каждой комбинации и запоминают результат
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k ++) {
					int sum = i + j + k;
					Integer[] numb = new Integer[3];
					numb[0] = i;
					numb[1] = j;
					numb[2] = k;
					comb.get(sum).numbers.add(numb);
				}
			}
		}
		
		int numberOfCombs = 0; //общее количество комбинаций счастливых билетиков
		for (int i = 0; i < 28; i++) {
			int number = comb.get(i).numbers.size();
			numberOfCombs += number * number; //счастливый билетик получается каждый раз, когда в одном билете встречаются элементы одного и того же списка numbers, следовательно, нужно перебирать все их комбинации
		}
		//вывод информации
		System.out.println("Количество счастливых билетиков: " + numberOfCombs);
		System.out.println("Для просмотра подробной информации нажмите 1, для выхода - любое другое число");
		int ans = Easy.giveMeInt();
		while (ans == 1) {
			System.out.println("Число от 0 до 28, которое является суммой трех первых/последних чисел билета:" );
			int i;
			do {
				i = Easy.giveMeInt();
			} while(!(i >= 0 && i <= 28));
			System.out.print("--------------------------------\n" + i + ":\n");
			for (int j = 0; j < comb.get(i).numbers.size(); j++) {
				for (int k = 0; k < comb.get(i).numbers.size(); k++) {
					System.out.print(comb.get(i).numbers.get(j)[0].toString() + comb.get(i).numbers.get(j)[1].toString() + comb.get(i).numbers.get(j)[2].toString() + "-" +
									 comb.get(i).numbers.get(k)[0].toString() + comb.get(i).numbers.get(k)[1].toString() + comb.get(i).numbers.get(k)[2].toString() + "   ");
				}
			}
			System.out.println("\n--------------------------------");
			System.out.println("Выбрать другое число - 1, выход - любое другое число");
			ans = Easy.giveMeInt();
		}
	}
}
