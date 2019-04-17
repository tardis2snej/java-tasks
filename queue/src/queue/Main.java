package queue;

import java.util.ArrayList;
import Snej.Easy;

public class Main {

	static ArrayList<Integer> fed = new ArrayList<Integer>(); //������ ����� � ������ ������������ ���������� ����� ��������� �� ���� ��������
	
	public static void main(String[] args) {
		System.out.println("������� ���������� �������������: ");
		int num = Easy.giveMeInt(); //������� ������������ ������ ��� ����� �������� � �� ����� �����
		if (num == 0) { //�������� �� �������� ����
			System.out.println("���� �������� 0 �������������, �� �� ������ �� ������.");
			main(null);
		}
		else if (num < 0) {
			System.out.println("�� �� ����� �������� ������ ���� �������������.");
			main(null);
		}
		else {
			for (int i = 0; i < num; i++) { //��������� ������� ���, ������� ������������� ����� ������
				breakTime();
			}
			float result = 0;
			for (int i = 0; i < fed.size(); i++) //������� ���� ���� ��������� �� ��������
				result += fed.get(i);
			result /= fed.size(); //������� ������� ���������� ������������ ���������
			System.out.println("� ������� ����� ����������� �� �������� ���������: " + (int) Math.floor(result)); //��������� � ������� �������, �.�. �� ����� ���������� ��������� ��������� ������, � � ������� ������� �� ��� �� "���������"
		}
	}

	static void breakTime() {
		System.out.println("��������� �������� (����������) �����...");
		for (int i = 0; i < 3; i++) {
			System.out.print(". ");
			try {
				Thread.sleep(400); //������ ��� �������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		
		System.out.println("����� �������� � �������:");
		int breakTime = 600; //����� �������� � ��������
		//��� �������� ��������� � ��������
		int countStudents = 0; 
		int countPrepods = 0;
		ArrayList<Integer> prepods = new ArrayList<Integer>(); //��� �������� ����������� �� ��������
		while (breakTime > 0) {
			int service = (int) (Math.random()*(121 - 10)) + 10; //����� ������������ - �� 10 �� 120 ������
			breakTime -= service; //�������� ����� ������������ ������ �������� �� ������� ��������
			int isPrepod = (int) Math.round(Math.random()); //�������� �������� � ��������� [0, 1), ���� ��� ����������� �� ����, �� ������� ���, ���� �� ������� - �� ����
			if (prepods.size() > 8) { //���� �������� ��� ������� �����, �� ������ �������� �����������
				isPrepod = 0;
			}
			try {
				Thread.sleep(service*10); //������ ��� ������� ������ � � ������ ������� ������������
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			if (breakTime >= 0 & isPrepod == 0) { //���� ������ �������
				countStudents++;
				System.out.print(" (^_^)" + service + "� "); //������� ���������� �������� � ����� ������������
			}
			else if (breakTime >= 0 & isPrepod == 1) { //���� ������ ������
				prepods.add(isPrepod);
				countPrepods++;
				System.out.print(" (^_^)*" + service + "� "); //������� ���������� ������� � ����� ������������
			}
			else { //���� �������/������ ������, �� ��� �� ������ ��������� - ������� �������� ��������/������� � ����� ������������, ������� ��� �����������
				if (isPrepod == 1)
					System.out.print(" (-_-)*" + service + "� ");
				else
					System.out.print(" (-_-)" + service + "� ");
			}
		}
		System.out.println("\n����� ���������: " + countStudents + "; ��������: " + countPrepods + ".\n"); //����� ����������� �� ���� ��������
		fed.add(countStudents); //��������� ���������� � ������
	}
}
