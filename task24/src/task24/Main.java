package task24;
import Snej.Easy;
public class Main {
	
	static int[] daysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //������ ������ �������� ���������� ���� � ������ �� �������
	
	public static void main(String[] args) {
		System.out.print("#### ������ �24 ####\n"
				       + "����� ���� � ����� ����������, � ����� ������ ����, ����� � ��.\n"
				       + "���������, ������ ��� ���������� �� ��� ����������.\n" + 
				         "�������. �������� ���� - �� �, ����� ���� ������� �� 400,\n"
				       + "� ����� �, ����� ���� ������� �� 4, ��� �� ������� �� 100.\n" + 
				         "г� - �� 1920 �� 3000, ����� - �� 1 �� 12, ���� - �� 1 �� ����� ��� � �����.\n" + 
				         "--------------------\n");
		//���� ���� ��� � �������� �� ��, ����� ��� ���� ����������� (����. � ������ �� ��������� 40 ����, � � ������������� ������� - 29)
		System.out.print("������� ����:\n"
				+ "��� (�� 1920 �� 3000): ");
		int year;
		do {
			year = Easy.giveMeInt();
		} while(!(year >= 1920 & year <= 3000));
		System.out.print("����� (������): ");
		int month;
		do {
			month = Easy.giveMeInt();
		} while (!(month > 0 & month < 13));
		System.out.print("����: ");
		int day;
		do { 
			day = Easy.giveMeInt(); 
		} while (!isValidDay(year, month, day));
		System.out.print("���� ��������:\n�����: ");
		int monthBirth;
		do {
			monthBirth = Easy.giveMeInt();
		} while (!(monthBirth > 0 & monthBirth < 13));
		System.out.print("����: ");
		int dayBirth;
		do { 
			dayBirth = Easy.giveMeInt(); 
		} while (!isValidDay(0, monthBirth, dayBirth));
		
		//������� ����
		int daysLeft; //���������� ���� �� ��
		if (monthBirth == month & dayBirth == day) {
			//����� �� �������
			daysLeft = 0;
		}
		else if (monthBirth == month & dayBirth > day) {
			//������ �� ����� ��� � ���� ������
			daysLeft = dayBirth - day;
		}
		else if (monthBirth > month) {
			//������ �� ����� ��� � ���� ����
			daysLeft = dateToDays(year, monthBirth, dayBirth) - dateToDays(year, month, day); //���������� ���� �� 1 ������ �� �� ����� ���������� ���� �� 1 ������ �� �������
		}
		else {
			//�� � ��������� ����
			daysLeft = dateToDays(year + 1, monthBirth, dayBirth); //���������� ���� �� 1 ������ ���������� ���� �� ��
			//���, ������� �������� �� ����� ����� ���� (� ������ ���������� �����)
			if(isLeapYear(year)) {
				daysLeft += 366 - dateToDays(year, month, day);
			}
			else {
				daysLeft += 365 - dateToDays(year, month, day);
			}
		}
		//���������
		System.out.println("���� �� ��� ��������: " + daysLeft);
		
		System.out.print("��� ���? 1 - ��, ����� ����� - �����: ");
		int ans = Easy.giveMeInt();
		if (ans == 1) {
			main(null);
		}
	}

	static boolean isValidDay(int year, int month, int day) { //���������, ������������� �� ���� ���������� ���� � ��������� ������
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
	
	static boolean isLeapYear(int year) { //��������, �������� �� ��� ����������
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
	
	static int dateToDays(int year, int month, int day) { //������������ ���������� ���� � ������ ���� �� ��������� � ���������� ����
		int answer = 0;
		for (int i = 0; i < month - 1; i++) {
			answer += daysInMonth[i];
		}
		answer += day;
		if (month > 2 & isLeapYear(year)) //���� ��� ��� ���������� � ������� ��� ������, ����� ��������� ��� 29-� �����
			answer++;
		return answer;
	}
}
