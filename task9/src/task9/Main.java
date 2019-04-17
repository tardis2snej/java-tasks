package task9;

import Snej.Easy;

public class Main {

	public static void main(String[] args) {
		System.out.print("#### ������ �9 ####\n"
						 + "��� ����� X [1..N]. ��������� ������� ������� ���� �� k �������� ������\n"
						 + "(����� ������� X [i] ���� ����� ������� ������ �� ���� X [i + k];\n"
						 + "��� �� ������� �� �� X [N] ��� X [1]). ����������� ������ �������� �� �����!\n"
						 + "-----------------\n");
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //��� ������
		System.out.println("��� ������:"); //����� ������������ �������
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.print("\n");
		System.out.print("������� k - �������� ������� (������ ���� - �����, ������ ���� - ������): "); //��������� ����� k
		int k = Easy.giveMeInt();
		if (k > 0) { //���� k ������ ����, ������� ������
			for (int i = 0; i < k; i++) { //���������� ��������� �������� �� k
				int first = 0;
				for (int j = 0; j < arr.length; j++) { //�������� ������ �� 1
					if (j == 0) //��������� ������ �������
						first = arr[j];
					if (j == arr.length - 1) //��������� ������ ������� � ����� �������
						arr[j] = first;
					else
						arr[j] = arr[j + 1]; //������������ ��� ��������� ��������
				}
			}
		}
		else if (k < 0) { //���� k ������ ����, ������� �����
			for (int i = 0; i > k; i--) { //���������� ��������� �������� �� k
				int last = 0;
				for (int j = arr.length - 1; j >= 0; j--) { //��������� �������� �����
					if (j == arr.length - 1) //��������� ��������� �������
						last = arr[j];
					if (j == 0) //���������� ��������� ������� ������
						arr[j] = last;
					else //������� ��� ��������� ��������
						arr[j] = arr[j - 1];
				}
			}
		}
		System.out.println("������ �� ���������:"); //����� ������������� �������
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.print("\n");
	}

}
