package task17;

import java.util.ArrayList;
import Snej.Easy;

public class Main {
	
	public static void main(String[] args) {
		System.out.print("#### ������ �17 ####\n"
				       + "��������� ����������� � n ����������� �����. ��������� ���������\n"
				       + "�������� ���������� �����, ����� ���� � �����������.\n"
				       + "--------------------\n");
		
		ArrayList<Integer> sequence = new ArrayList<Integer>(); //��� �������� ������������������
		while (true) { //���� �����
			System.out.print("������� ����������� ����� ��� -1, ����� ��������� ����: ");
			Integer num = Easy.giveMeInt();
			if (num == -1)
				break;
			if (num >= 0)
				sequence.add(num);
		}
		sequence.sort(null); //���������� ������������������, ����� ��������� ���������� ������
		if (sequence.size() > 0) { //����� ������������������
			System.out.println("��������������� ������������������: ");
			for(int i = 0; i < sequence.size(); i++) {
				System.out.print(sequence.get(i) + "  ");
			}
			System.out.println();
		}
		if (sequence.size() > 1) { //������� �������, �.�. ��� ��� ������
			for (int i = 1; i < sequence.size(); i++) {
				if (sequence.get(i - 1) == sequence.get(i)) {
					sequence.remove(i);
					i--;
				}
			}
		}
		int currMin = 0; //������������� ������� ������������������
		while (currMin < sequence.size()) {
			if (currMin == sequence.get(currMin))
				currMin++;
			else
				break;
		}
		//����������
		if (sequence.size() == 0) {
			System.out.println("������������������ �� �������");
		}
		else {
			System.out.println("����������� ��������: " + currMin);
		}
		System.out.println("������ ������? 1 - ��, ����� ����� - �����");
		int ans = Easy.giveMeInt();
		if(ans == 1) { //���������� �������
			main(null);
		}
	}

}
