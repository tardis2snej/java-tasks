package task12;

import java.util.*;
import Snej.*;

public class Main {
	static int N, M, L;

	public static void main(String[] args) {
		System.out.print("#### ЗАДАЧА №12 ####\n"
				       + "Навколо рахуючого розмыщується N осіб, з яких виділено першого, а решта пронумеровані за годинниковою стрілкою числами від 2 до N.\n"
				       + "Рахуючий, починаючи з кого-то, веде рахунок до M. Людина на якому зупинився рахунок, виходить з кола. Рахунок триває з наступної людини\n"
				       + "і так до тих пір, поки не залишиться одна людина.\n" + 
				       "Визначити:\n" + 
				       "a) номер людини, що залишилась, якщо відомо M і те, що рахунок починався з першого людини;\n" + 
				       "b) номер людини c якої починався рахунок, якщо відомо M і номер людини L, що залишилась.\n"
				       + "--------------------\n");
		boolean flag = true;
		while(flag) { //меню
			System.out.print("Вариант а - 1\n"
							+ "Вариант б - 2\n"
							+ "Выход - 0\n");
			int ans = Easy.giveMeInt();
			switch(ans) {
				case 0: flag = false; break;
				case 1: {
					System.out.print("Введите N - количество человек: ");
					do {
						N = Easy.giveMeInt();
					} while(N <= 0);
					System.out.print("Введите М - до скольки считать: ");
					do {
						M = Easy.giveMeInt();
					} while (M <= 0);
					ArrayList<Integer> list1 = new ArrayList<Integer>(); //список людей в кругу
					for(int i = 0; i < N; i++) {
						list1.add(i+1);
						System.out.println(list1.get(i)); //выводим начальный список
					}
					while (list1.size() > 1){ //считаем до тех пор, пока в списке больше одного человека
						int pos = M;
						while (pos > list1.size()) { //перемещаем указатель позиции, если он вышел за пределы списка
							pos -= list1.size();
						}
						list1.remove(pos - 1); //убираем человека, на котором остановился подсчет
					}
					System.out.println("Оставшийся номер: " + list1.get(0));
					break;
				}
				case 2: {
					System.out.print("Введите N - количество человек: ");
					do {
						N = Easy.giveMeInt();
					} while(N <= 0);
					System.out.print("Введите М - до скольки считать: ");
					do {
						M = Easy.giveMeInt();
					} while (M <= 0);
					System.out.print("Введите L - номер оставшегося человекa: ");
					do {
						L = Easy.giveMeInt();
					} while (!(L >= 0 & L <= N));
					
					int foundPos = -1; //сохраняем позицию, которую найдем
					int lastEl = 0; //для сравнения полученного значения и искомого
					while (lastEl != L) { //перебираем до тех пор, пока не найдем
						foundPos++;
						lastEl = findLastFromPos(foundPos);
					}
					System.out.println("Вы начали с человека под номером " + foundPos);
					break;
				}
			}
		}
	}

	
	static int findLastFromPos(int P) { //функция осуществляет подсчет, начиная с указанной точки, и возвращает значение, которое осталось в списке
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		int num = P; 
		for(int i = 0; i < N; i++) { //создаем список, который начинается с позиции Р
			list0.add(num);
			num++;
			if (num > N)
				num = 1;
		}
		while (list0.size() > 1){ //такой же подсчет, как для первого варианта
			int pos = M;
			while (pos > list0.size()) {
				pos -= list0.size();
			}
			list0.remove(pos - 1);
		}
		return list0.get(0);
	}
}