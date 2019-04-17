import java.util.*;

public class Main {

	public static void main(String[] args) {
		//время работы - с 8 утра до 8 вечера; 720 минут;
		int workTime = 720;
		//максимальное число посетителей в день - 500;
		int numberOfVisiters = (int) (Math.random() * (501 - 1) + 1);
		Integer[][] visiter = new Integer[numberOfVisiters][2]; //массив со всеми посетителями за весь день и его наполнение
		for(int i = 0; i < numberOfVisiters; i++) {
			visiter[i] = visiterTime();
		}
		
		ArrayList<ArrayList<Integer[]>> minutes = new ArrayList<ArrayList<Integer[]>>(); //список, каждое поле в котором соответсвует одной из минут работы музея, и является списком посетителей, которые были в ту минуту
		for (int i = 0; i < workTime; i++) { //создание списка из 720 минут
			minutes.add(new ArrayList<Integer[]>());
		}
		for (int i = 0; i < numberOfVisiters; i++) { //добавляем каждого из посетителей в те минуты в списке, когда он находился в музее
			for (int j = visiter[i][0]; j < visiter[i][1]; j++) {
				minutes.get(j).add(visiter[i]);
			}
		}
		
		int maxVisiters = 0;
		int maxMinute = 0;
		for (int i = 0; i < workTime; i++) { //ищем самый длинный список посетителей среди списков минут
			if (maxVisiters < minutes.get(i).size()) {
				maxVisiters = minutes.get(i).size();
				maxMinute = i;
			}
		}
		//вывод результатов и информации
		System.out.println("#### ЗАДАЧА № 8 ####\n" 
				         + "У музеї реєструється протягом дня час приходу і відходу кожного відвідувача.\n"
				         + "Таким чином за день отримані N пар значень, де перше значення у парі показує\n"
				         + "час приходу відвідувача і друге значення - час його відходу. Знайти проміжок\n"
				         + "часу, протягом якого в музеї одночасно перебувало максимальне число відвідувачів.\n"
				         + "--------------------\n"
				         + "Время работы музея: с 8:00 до 20:00.\n"
				         + "Максимальное возможное количество посетителей за день: 500.\n"
		                 + "Максимальное число людей, которые одновременно находились в музее: " + maxVisiters
		                 + "\nСоответсвующее время: " + (8 + maxMinute/60) + " час. " + maxMinute % 60 + " мин.");
	}
	
	static Integer[] visiterTime() {
		Integer[] time = new Integer[2];
		time[0] = (int) (Math.random() * 720); //время прихода - от 0 до 720-й минуты
		time[1] = (int) (Math.random() * (721 - (time[0] + 1)) + time[0] + 1); //время ухода - от следующей после прихода минуты до 720-й минуты включительно
		return time;
	}
}
