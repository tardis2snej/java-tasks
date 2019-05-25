package task21;
import Snej.Easy;

public class Main {

	public static void main(String[] args) {
		System.out.print("#### ������ � 23 ####\n" + 
						 "���� 5 ����� �����. ����� ���:\n" + 
				         "* ���� ������� 5, �� ������� \"Impossible\", ������\n" + 
				         "* ���� ������� 4, �� ������� \"Four of a Kind\", ������\n" + 
				         "* ���� ������� 3 � 2, �� ������� \"Full House\", ������\n" + 
				         "* ���� � 5 ����������, �� ������� \"Straight\", ������\n" + 
				         "* ���� ������� 3, �� ������� \"Three of a Kind\", ������\n" + 
				         "* ���� ������� 2 � 2, �� ������� \"Two Pairs\", ������\n" + 
				         "* ���� ������� 2, �� ������� \"One Pair\", ������\n" + 
				         "* ������� \"Nothing\".\n"
				         + "-------------------\n");
		int[] numbers = new int[5]; //������ ��� ��������� �����
		//����-�����
		System.out.println("������� 5 ����� �� 1 �� 13:");
		for (int i = 0; i < 5; i++) {
			numbers[i] = Easy.giveMeInt();
			if (!(numbers[i] >= 1 && numbers[i] <= 13))
				i--;
		}
		System.out.println("��������� �����:");
		for (int i = 0; i < 5; i++) {
			System.out.print(numbers[i] + "  ");
		}
		System.out.println();
		
		int[] resArr = new int[5]; //������ ��� ������ �������� � �������� �����
		for (int i = 0; i < 5; i++) {
			resArr[i] = 0;
			boolean isRepeating = false; //���������� "����������", ������� �� ����� ����� ��� ��� ���
			for (int j = 0; j < i; j++) {
				if (numbers[j] == numbers[i]) { //���� � ���������� ����� ������� ���� ����� �����, �� �� ������ ����� ���
					isRepeating = true;
				}
			}
			if(isRepeating) //���� � ���������� ����� ������� ���� ����� �����, �� �� �� ������������ ��� ������� ������
				continue;
			for (int j = i; j < 5; j++) { //������������ ������� � ���������� ����� �������
				if (numbers[j] == numbers[i])
					resArr[i]++;
			}
		}
		
		boolean[] found2 = new boolean[2]; //�������� �� ��������� ���� �����
		found2[0] = false;
		found2[1] = false;
		boolean found3 = false; //�������� �� ��������� ������
		int answer = 0; //���������� ��� �������� ��������� ������
		
		//��� ������ ������ ������� � �������� � �������� ���������, ���������� �� �������� ��� ������������ ������-�� �� ������� 1 ��� 2 � ��������, ������� ����� � ����� �������� �������
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
		//�� ��������� ������� � ������� �������� ��������� ������������ �������� 3, 6, 5, 7
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
		//���������, �������� �� ��������� ����� �������������������
		boolean sequence = true;
		for(int i = 1; i < 5; i++) {
			if (numbers[i - 1] + 1 != numbers[i]) {
				sequence = false;
				break;
			}
		}
		if (!sequence) { //���� ������ ���� �������, ��� ��� �� ������������ ������������������ - ��������, ��� ��������� ������������������
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
		//����� ������
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
		
		System.out.println("��� ���? 1 - ��, ����� ����� - �����");
		int ans = Easy.giveMeInt();
		if(ans == 1) { //���������� �������
			main(null);
		}
	}

}
