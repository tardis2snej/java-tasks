package task12;

import java.util.*;
import Snej.*;

public class Main {
	static int N, M, L;

	public static void main(String[] args) {
		System.out.print("#### ������ �12 ####\n"
				       + "������� ��������� ����������� N ���, � ���� ������� �������, � ����� ������������ �� ������������ ������� ������� �� 2 �� N.\n"
				       + "��������, ��������� � ����-��, ���� ������� �� M. ������ �� ����� ��������� �������, �������� � ����. ������� ����� � �������� ������\n"
				       + "� ��� �� ��� ��, ���� �� ���������� ���� ������.\n" + 
				       "���������:\n" + 
				       "a) ����� ������, �� ����������, ���� ����� M � ��, �� ������� ��������� � ������� ������;\n" + 
				       "b) ����� ������ c ��� ��������� �������, ���� ����� M � ����� ������ L, �� ����������.\n"
				       + "--------------------\n");
		boolean flag = true;
		while(flag) { //����
			System.out.print("������� � - 1\n"
							+ "������� � - 2\n"
							+ "����� - 0\n");
			int ans = Easy.giveMeInt();
			switch(ans) {
				case 0: flag = false; break;
				case 1: {
					System.out.print("������� N - ���������� �������: ");
					do {
						N = Easy.giveMeInt();
					} while(N <= 0);
					System.out.print("������� � - �� ������� �������: ");
					do {
						M = Easy.giveMeInt();
					} while (M <= 0);
					ArrayList<Integer> list1 = new ArrayList<Integer>(); //������ ����� � �����
					for(int i = 0; i < N; i++) {
						list1.add(i+1);
						System.out.println(list1.get(i)); //������� ��������� ������
					}
					while (list1.size() > 1){ //������� �� ��� ���, ���� � ������ ������ ������ ��������
						int pos = M;
						while (pos > list1.size()) { //���������� ��������� �������, ���� �� ����� �� ������� ������
							pos -= list1.size();
						}
						list1.remove(pos - 1); //������� ��������, �� ������� ����������� �������
					}
					System.out.println("���������� �����: " + list1.get(0));
					break;
				}
				case 2: {
					System.out.print("������� N - ���������� �������: ");
					do {
						N = Easy.giveMeInt();
					} while(N <= 0);
					System.out.print("������� � - �� ������� �������: ");
					do {
						M = Easy.giveMeInt();
					} while (M <= 0);
					System.out.print("������� L - ����� ����������� �������a: ");
					do {
						L = Easy.giveMeInt();
					} while (!(L >= 0 & L <= N));
					
					int foundPos = -1; //��������� �������, ������� ������
					int lastEl = 0; //��� ��������� ����������� �������� � ��������
					while (lastEl != L) { //���������� �� ��� ���, ���� �� ������
						foundPos++;
						lastEl = findLastFromPos(foundPos);
					}
					System.out.println("�� ������ � �������� ��� ������� " + foundPos);
					break;
				}
			}
		}
	}

	
	static int findLastFromPos(int P) { //������� ������������ �������, ������� � ��������� �����, � ���������� ��������, ������� �������� � ������
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		int num = P; 
		for(int i = 0; i < N; i++) { //������� ������, ������� ���������� � ������� �
			list0.add(num);
			num++;
			if (num > N)
				num = 1;
		}
		while (list0.size() > 1){ //����� �� �������, ��� ��� ������� ��������
			int pos = M;
			while (pos > list0.size()) {
				pos -= list0.size();
			}
			list0.remove(pos - 1);
		}
		return list0.get(0);
	}
}