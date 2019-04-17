import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	static class Sequence { //класс для хранения данных о начале и размере подпоследовательности
		int begin;
		int size;
		
		Sequence() {
			begin = 0;
			size = 0;
		}
	}

	public static void main(String[] args) {
		System.out.print("#### ЗАДАЧА № 5 ####\n" +
						 "У заданій послідовності цілих чисел знайти максимально довгу підпослідовність чисел таку, \nщо кожний наступний елемент підпослідовності ділився без остатку на попередній.\n" + 
						 "--------------------\n");
		try {
			Scanner in = new Scanner(new File("Input.txt")); //чтение из файла
			while (in.hasNext()) {
				arr.add(in.nextInt());
			}
			int size = arr.size(); //длина последовательности
			Sequence longest = new Sequence(); //искомая сама длинная подпоследовательность
			Sequence current = new Sequence(); //вспомогательное для поиска
			
			for (int i = 1; i < size; i++) { //пропускаем первый элемент, т.к. его не на что делить
				if (arr.get(i) % arr.get(i - 1) == 0) { //если текущий элемент делится на предыдущий без остатка, прибавляем длину последовательности
					current.size++;
				}
				else if ((current.size > 0) && (current.size > longest.size)) { //если длина текущей последовательности больше нуля и больше длины самой длинной подпоследовательности, обновляем последнюю 
					longest.size = current.size + 1;
					longest.begin = i - current.size - 1;
				}
				else if (arr.get(i) % arr.get(i - 1) != 0) {
					if (longest.size >= current.size | current.size < 1) { //обнуляем текущую длину, если подпоследовательность прервалась и была меньше длиннейшей
						current.size = 0;
					}
				}
			}
			System.out.println("Изначальная последовательность:"); //вывод результатов
			for (int i = 0; i < size; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.print("\n");
			System.out.println("(счет идет с нуля)\n"
					         + "Начало подпоследовательности: " + longest.begin + "\n"
				           	 + "Конец подпоследовательстности: " + (longest.begin + longest.size - 1) + "\n"
							 + "Размер подпоследовательности: " + longest.size + "\n" 
							 + "Подпоследовательность:");
			for (int i = longest.begin; i < longest.begin + longest.size; i++) {
				System.out.print(arr.get(i) + " ");
			}
		} catch (Exception e) { //обработка любых ошибок
			System.out.println("Что-то не так! Убедитесь, что файл Input.txt существует, числа являются целыми и в последовательности нет нуля.");
		}
	}

}
