package task19;

import java.util.ArrayList;
import Snej.Easy;

public class Main {

	static class EachSum { //������� ������ �������� ������ ���� ���������� �����, ����� ������� ��������� sum
		int sum;
		ArrayList<Integer[]> numbers;
		
		EachSum(int sum) {
			this.sum = sum;
			numbers = new ArrayList<Integer[]>();
		}
	}
	
	static ArrayList<EachSum> comb = new ArrayList<EachSum>(); 
	
	public static void main(String[] args) {
		System.out.print("#### ������ � 19 ####\n"
				       + "�������� �������� ���������� ������� ������������ '��������' ������, \n"
				       + "� ���� ���� ������ 3 ���������� ���� ������� ��� 3 ������� ���������� ����.\n"
				       + "---------------------");
				
		for(int i = 0; i < 28; i++) { //27 - ������������ ����� ���� ������������ �����
			comb.add(new EachSum(i));
		}
		
		//��������� ��� ����� ���������� ��� ��������� ���������� ���� ����, ������������ ����� � ������ ���������� � ���������� ���������
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
		
		int numberOfCombs = 0; //����� ���������� ���������� ���������� ���������
		for (int i = 0; i < 28; i++) {
			int number = comb.get(i).numbers.size();
			numberOfCombs += number * number; //���������� ������� ���������� ������ ���, ����� � ����� ������ ����������� �������� ������ � ���� �� ������ numbers, �������������, ����� ���������� ��� �� ����������
		}
		//����� ����������
		System.out.println("���������� ���������� ���������: " + numberOfCombs);
		System.out.println("��� ��������� ��������� ���������� ������� 1, ��� ������ - ����� ������ �����");
		int ans = Easy.giveMeInt();
		while (ans == 1) {
			System.out.println("����� �� 0 �� 28, ������� �������� ������ ���� ������/��������� ����� ������:" );
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
			System.out.println("������� ������ ����� - 1, ����� - ����� ������ �����");
			ans = Easy.giveMeInt();
		}
	}
}
