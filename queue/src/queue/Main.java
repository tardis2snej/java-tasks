package queue;

import java.util.ArrayList;
import Snej.Easy;

public class Main {

	static ArrayList<Integer> fed = new ArrayList<Integer>(); //каждое число в списке соответсвует количеству сытых студентов за одну перемену
	
	public static void main(String[] args) {
		System.out.println("Введите количество экспериментов: ");
		int num = Easy.giveMeInt(); //функция обрабатывает ошибки при вводе символов и не целых чисел
		if (num == 0) { //проверки на неверный ввод
			System.out.println("Если провести 0 экспериментов, то мы ничего не узнаем.");
			main(null);
		}
		else if (num < 0) {
			System.out.println("Мы не можем провести меньше нуля экспериментов.");
			main(null);
		}
		else {
			for (int i = 0; i < num; i++) { //повторяем столько раз, сколько экспериментов хотим видеть
				breakTime();
			}
			float result = 0;
			for (int i = 0; i < fed.size(); i++) //считаем суму всех студентов за перемену
				result += fed.get(i);
			result /= fed.size(); //считаем среднее количество накормленных студентов
			System.out.println("В среднем буфет обслуживает за перемену студентов: " + (int) Math.floor(result)); //округляем в меньшую сторону, т.к. не целое количество студентов накормить нельзя, а в большую сторону мы еще не "докормили"
		}
	}

	static void breakTime() {
		System.out.println("Открываем столовку (зачеркнуто) буфет...");
		for (int i = 0; i < 3; i++) {
			System.out.print(". ");
			try {
				Thread.sleep(400); //просто для красоты
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		
		System.out.println("Сытые студенты и преподы:");
		int breakTime = 600; //время перемены в секундах
		//для подсчета студентов и преподов
		int countStudents = 0; 
		int countPrepods = 0;
		ArrayList<Integer> prepods = new ArrayList<Integer>(); //для подсчета ограничения по преподам
		while (breakTime > 0) {
			int service = (int) (Math.random()*(121 - 10)) + 10; //время обслуживания - от 10 до 120 секунд
			breakTime -= service; //отнимаем время обслуживания одного человека от времени перемены
			int isPrepod = (int) Math.round(Math.random()); //получаем значение в диапазоне [0, 1), если оно округляется до нуля, то препода нет, если до единицы - он есть
			if (prepods.size() > 8) { //если преподов уже слишком много, то просто обнуляем последующих
				isPrepod = 0;
			}
			try {
				Thread.sleep(service*10); //просто для красоты вывода и с учетом времени обслуживания
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			if (breakTime >= 0 & isPrepod == 0) { //если пришел студент
				countStudents++;
				System.out.print(" (^_^)" + service + "с "); //выводим довольного студента и время обслуживания
			}
			else if (breakTime >= 0 & isPrepod == 1) { //если пришел препод
				prepods.add(isPrepod);
				countPrepods++;
				System.out.print(" (^_^)*" + service + "с "); //выводим довольного препода и время обслуживания
			}
			else { //если студент/препод пришел, но его не успели обслужить - выводим грусного студента/препода и время обслуживания, которое ему требовалось
				if (isPrepod == 1)
					System.out.print(" (-_-)*" + service + "с ");
				else
					System.out.print(" (-_-)" + service + "с ");
			}
		}
		System.out.println("\nВсего студентов: " + countStudents + "; преподов: " + countPrepods + ".\n"); //вывод результатов за одну перемену
		fed.add(countStudents); //добавляем статистику в список
	}
}
