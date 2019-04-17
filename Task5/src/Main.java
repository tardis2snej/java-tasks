import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	static class Sequence { //����� ��� �������� ������ � ������ � ������� ���������������������
		int begin;
		int size;
		
		Sequence() {
			begin = 0;
			size = 0;
		}
	}

	public static void main(String[] args) {
		System.out.print("#### ������ � 5 ####\n" +
						 "� ������ ����������� ����� ����� ������ ����������� ����� ������������� ����� ����, \n�� ������ ��������� ������� ������������� ������ ��� ������� �� ���������.\n" + 
						 "--------------------\n");
		try {
			Scanner in = new Scanner(new File("Input.txt")); //������ �� �����
			while (in.hasNext()) {
				arr.add(in.nextInt());
			}
			int size = arr.size(); //����� ������������������
			Sequence longest = new Sequence(); //������� ���� ������� ���������������������
			Sequence current = new Sequence(); //��������������� ��� ������
			
			for (int i = 1; i < size; i++) { //���������� ������ �������, �.�. ��� �� �� ��� ������
				if (arr.get(i) % arr.get(i - 1) == 0) { //���� ������� ������� ������� �� ���������� ��� �������, ���������� ����� ������������������
					current.size++;
				}
				else if ((current.size > 0) && (current.size > longest.size)) { //���� ����� ������� ������������������ ������ ���� � ������ ����� ����� ������� ���������������������, ��������� ��������� 
					longest.size = current.size + 1;
					longest.begin = i - current.size - 1;
				}
				else if (arr.get(i) % arr.get(i - 1) != 0) {
					if (longest.size >= current.size | current.size < 1) { //�������� ������� �����, ���� ��������������������� ���������� � ���� ������ ����������
						current.size = 0;
					}
				}
			}
			System.out.println("����������� ������������������:"); //����� �����������
			for (int i = 0; i < size; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.print("\n");
			System.out.println("(���� ���� � ����)\n"
					         + "������ ���������������������: " + longest.begin + "\n"
				           	 + "����� �����������������������: " + (longest.begin + longest.size - 1) + "\n"
							 + "������ ���������������������: " + longest.size + "\n" 
							 + "���������������������:");
			for (int i = longest.begin; i < longest.begin + longest.size; i++) {
				System.out.print(arr.get(i) + " ");
			}
		} catch (Exception e) { //��������� ����� ������
			System.out.println("���-�� �� ���! ���������, ��� ���� Input.txt ����������, ����� �������� ������ � � ������������������ ��� ����.");
		}
	}

}
