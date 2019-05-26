package task14;
import Snej.Easy;
public class Main {

	public static void main(String[] args) {
		System.out.print("#### ������ �14 ####\n"
					   + "� ������� � ������ N �� ���� �������� ��������� ����� ������� �������\n"
					   + "�� ���������� ��������� �� ��� �������, ���� ����� ����. ���� ������\n"
					   + "�������� ����, �� ������� ���� �� ����\n"
					   + "--------------------\n");
		//����
		System.out.print("���������� ����� � ������������������: ");
		int size;
		do {
			size = Easy.giveMeInt();
		} while (size <= 0);
		int[] arr = new int[size];
		System.out.println("������� ����� ������������������: ");
		for (int i = 0; i < size; i++) {
			arr[i] = Easy.giveMeInt();
		}
		System.out.println("��� ������:");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();

		for (int i = 0; i < size; i++) { //���� �� ������� ����� � �������
			int j = i + 1;
			boolean isFound = false; //����������, ����� �� ������� ����� ��� ���
			while(j < size) { //��������� ��� �����, ������� ���� ����� �������
				if (arr[j] > arr[i]) { //��� ������ ������� �����, ������� ������� - ���������� �����
					arr[i] = arr[j];
					isFound = true;
					break;
				}
				else {
					j++;
				}
			}
			if (!isFound) //���� ������� ����� ��� � �� �������, ������ ����
				arr[i] = 0;
		}
		//����� �����������
		System.out.println("������ � ����������:");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
		System.out.println("������ ������? 1 - ��, ������ ����� - �����");
		int ans = Easy.giveMeInt();
		if(ans == 1) 
			main(null);
	}

}
