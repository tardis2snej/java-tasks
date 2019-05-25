package task21;
import Snej.Easy;

public class Main {

	public static void main(String[] args) {
		System.out.print("#### «јƒј„ј є 23 ####\n" + 
						 "ƒано 5 ц≥лих чисел. —еред них:\n" + 
				         "* якщо однаков≥ 5, то вивести \"Impossible\", ≥накше\n" + 
				         "* якщо однаков≥ 4, то вивести \"Four of a Kind\", ≥накше\n" + 
				         "* якщо однаков≥ 3 ≥ 2, то вивести \"Full House\", ≥накше\n" + 
				         "* якщо Ї 5 посл≥довних, то вивести \"Straight\", ≥накше\n" + 
				         "* якщо однаков≥ 3, то вивести \"Three of a Kind\", ≥накше\n" + 
				         "* якщо однаков≥ 2 ≥ 2, то вивести \"Two Pairs\", ≥накше\n" + 
				         "* якщо однаков≥ 2, то вивести \"One Pair\", ≥накше\n" + 
				         "* ¬ивести \"Nothing\".\n"
				         + "-------------------\n");
		int[] numbers = new int[5]; //массив дл€ введенных чисел
		//ввод-вывод
		System.out.println("¬ведите 5 чисел от 1 до 13:");
		for (int i = 0; i < 5; i++) {
			numbers[i] = Easy.giveMeInt();
			if (!(numbers[i] >= 1 && numbers[i] <= 13))
				i--;
		}
		System.out.println("¬веденные числа:");
		for (int i = 0; i < 5; i++) {
			System.out.print(numbers[i] + "  ");
		}
		System.out.println();
		
		int[] resArr = new int[5]; //массив дл€ записи сведений о повторах чисел
		for (int i = 0; i < 5; i++) {
			resArr[i] = 0;
			boolean isRepeating = false; //переменна€ "запоминает", считали мы такое число или еще нет
			for (int j = 0; j < i; j++) {
				if (numbers[j] == numbers[i]) { //если в пройденной части массива было такое число, то мы теперь знаем это
					isRepeating = true;
				}
			}
			if(isRepeating) //если в пройденной части массива было такое число, то мы не подсчитываем его повторы заново
				continue;
			for (int j = i; j < 5; j++) { //подсчитываем повторы в оставшейс€ части массива
				if (numbers[j] == numbers[i])
					resArr[i]++;
			}
		}
		
		boolean[] found2 = new boolean[2]; //отвечает за найденные пары чисел
		found2[0] = false;
		found2[1] = false;
		boolean found3 = false; //отвечает за найденную тройку
		int answer = 0; //переменна€ дл€ хранени€ итогового ответа
		
		//дл€ каждой €чейки массива с запис€ми о повторах провер€ет, достаточно ли повторов дл€ соответстви€ какому-то из условий 1 или 2 и замечает, сколько троек и двоек повторов найдено
		for (int i = 0; i < 5; i++) {
			if (resArr[i] == 5) {
				answer = 1;
				break;
			}
			if (resArr[i] == 4) {
				answer = 2;
				break;
			}
			
			if (resArr[i] == 3 & !found3) {
				found3 = true;
			}
			if (resArr[i] == 2 & !found2[0]) {
				found2[0] = true;
			}
			else if(resArr[i] == 2 & !found2[1]) {
				found2[1] = true;
			}
		}
		//по найденным тройкам и двойкам повторов провер€ет соответствие услови€м 3, 6, 5, 7
		if (found3 & found2[0]) {
			answer = 3;
		}
		else if(found2[0] & found2[1]) {
			answer = 6;
		}
		else if(found3) {
			answer = 5;
		}
		else if (found2[0]) {
			answer = 7;
		}
		//провер€ет, €вл€етс€ ли введенные числа последовательностью
		boolean sequence = true;
		for(int i = 1; i < 5; i++) {
			if (numbers[i - 1] + 1 != numbers[i]) {
				sequence = false;
				break;
			}
		}
		if (!sequence) { //если первый цикл показал, что это не возрастающа€ последовательность - возможно, это убывающа€ последовательность
			sequence = true;
			for(int i = 1; i < 5; i++) {
				if (numbers[i - 1] - 1 != numbers[i]) {
					sequence = false;
					break;
				}
			}
		}
		if(sequence) {
			answer = 4;
		}
		//вывод ответа
		switch(answer) {
		case 1: System.out.println("Impossible"); break;
		case 2: System.out.println("Four of a Kind"); break;
		case 3: System.out.println("Full House"); break;
		case 4: System.out.println("Staright"); break;
		case 5: System.out.println("Three of a Kind"); break;
		case 6: System.out.println("Two pairs"); break;
		case 7: System.out.println("One Pair"); break;
		default: System.out.println("Nothing"); break;
		}
		
		System.out.println("≈ще раз? 1 - да, любое число - выход");
		int ans = Easy.giveMeInt();
		if(ans == 1) { //перезапуск функции
			main(null);
		}
	}

}
