package task24;
import Snej.Easy;
public class Main {
	
	static int[] daysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //массив хранит значения количества дней в каждом из месяцев
	
	public static void main(String[] args) {
		System.out.print("#### ЗАДАЧА №24 ####\n"
				       + "Задані день і місяць народження, а також поточні день, місяць і рік.\n"
				       + "Визначити, скільки днів залишилося до дня народження.\n" + 
				         "Примітка. Високосні роки - це ті, номер яких ділиться на 400,\n"
				       + "а також ті, номер яких ділиться на 4, але не ділиться на 100.\n" + 
				         "Рік - від 1920 до 3000, місяць - від 1 до 12, день - від 1 до числа днів у місяці.\n" + 
				         "--------------------\n");
		//ввод всех дат и проверка на то, чтобы они были правильными (напр. в месяце не оказалось 40 дней, а в невысокостном феврале - 29)
		System.out.print("Текущая дата:\n"
				+ "Год (от 1920 до 3000): ");
		int year;
		do {
			year = Easy.giveMeInt();
		} while(!(year >= 1920 & year <= 3000));
		System.out.print("Месяц (числом): ");
		int month;
		do {
			month = Easy.giveMeInt();
		} while (!(month > 0 & month < 13));
		System.out.print("День: ");
		int day;
		do { 
			day = Easy.giveMeInt(); 
		} while (!isValidDay(year, month, day));
		System.out.print("День рождения:\nМесяц: ");
		int monthBirth;
		do {
			monthBirth = Easy.giveMeInt();
		} while (!(monthBirth > 0 & monthBirth < 13));
		System.out.print("День: ");
		int dayBirth;
		do { 
			dayBirth = Easy.giveMeInt(); 
		} while (!isValidDay(0, monthBirth, dayBirth));
		
		//подсчет дней
		int daysLeft; //количество дней до ДР
		if (monthBirth == month & dayBirth == day) {
			//значи ДР сегодня
			daysLeft = 0;
		}
		else if (monthBirth == month & dayBirth > day) {
			//значит ДР будет уже в этом месяце
			daysLeft = dayBirth - day;
		}
		else if (monthBirth > month) {
			//значит ДР будет уже в этом году
			daysLeft = dateToDays(year, monthBirth, dayBirth) - dateToDays(year, month, day); //количество дней от 1 января до ДР минус количество дней от 1 января до сегодня
		}
		else {
			//ДР в следующем году
			daysLeft = dateToDays(year + 1, monthBirth, dayBirth); //количество дней от 1 января следующего года до ДР
			//дни, которые остались до конца этого года (с учетом высокосных годов)
			if(isLeapYear(year)) {
				daysLeft += 366 - dateToDays(year, month, day);
			}
			else {
				daysLeft += 365 - dateToDays(year, month, day);
			}
		}
		//результат
		System.out.println("Дней до дня рождения: " + daysLeft);
		
		System.out.print("Еще раз? 1 - да, любое число - выход: ");
		int ans = Easy.giveMeInt();
		if (ans == 1) {
			main(null);
		}
	}

	static boolean isValidDay(int year, int month, int day) { //проверяет, соответствует ли день количеству дней в выбранном месяце
		if (!(day > 0 & day < 32))
			return false;
		if (month == 2) {
			if(isLeapYear(year)) {
				if (day > 29)
					return false;
			}
			else {
				if (day > 28)
					return false;
			}
		}
		else if (day > daysInMonth[month - 1])
			return false;
		return true;
	}
	
	static boolean isLeapYear(int year) { //выясняет, является ли год высокосным
		if ((double)year % 400 == 0)
			return true;
		if ((double)year % 4 == 0) {
			if ((double) year % 100 != 0)
				return true;
			else
				return false;
		}
		return false;
	}
	
	static int dateToDays(int year, int month, int day) { //подсчитывает количество дней с начала года до указанной в параметрах даты
		int answer = 0;
		for (int i = 0; i < month - 1; i++) {
			answer += daysInMonth[i];
		}
		answer += day;
		if (month > 2 & isLeapYear(year)) //если год был высокосным и февраль уже прошел, нужно посчитать еще 29-е число
			answer++;
		return answer;
	}
}
