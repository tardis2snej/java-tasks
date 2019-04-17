import java.util.*;

public class Main {

	public static void main(String[] args) {
		//����� ������ - � 8 ���� �� 8 ������; 720 �����;
		int workTime = 720;
		//������������ ����� ����������� � ���� - 500;
		int numberOfVisiters = (int) (Math.random() * (501 - 1) + 1);
		Integer[][] visiter = new Integer[numberOfVisiters][2]; //������ �� ����� ������������ �� ���� ���� � ��� ����������
		for(int i = 0; i < numberOfVisiters; i++) {
			visiter[i] = visiterTime();
		}
		
		ArrayList<ArrayList<Integer[]>> minutes = new ArrayList<ArrayList<Integer[]>>(); //������, ������ ���� � ������� ������������ ����� �� ����� ������ �����, � �������� ������� �����������, ������� ���� � �� ������
		for (int i = 0; i < workTime; i++) { //�������� ������ �� 720 �����
			minutes.add(new ArrayList<Integer[]>());
		}
		for (int i = 0; i < numberOfVisiters; i++) { //��������� ������� �� ����������� � �� ������ � ������, ����� �� ��������� � �����
			for (int j = visiter[i][0]; j < visiter[i][1]; j++) {
				minutes.get(j).add(visiter[i]);
			}
		}
		
		int maxVisiters = 0;
		int maxMinute = 0;
		for (int i = 0; i < workTime; i++) { //���� ����� ������� ������ ����������� ����� ������� �����
			if (maxVisiters < minutes.get(i).size()) {
				maxVisiters = minutes.get(i).size();
				maxMinute = i;
			}
		}
		//����� ����������� � ����������
		System.out.println("#### ������ � 8 ####\n" 
				         + "� ���� ���������� �������� ��� ��� ������� � ������ ������� ���������.\n"
				         + "����� ����� �� ���� ������� N ��� �������, �� ����� �������� � ��� ������\n"
				         + "��� ������� ��������� � ����� �������� - ��� ���� ������. ������ �������\n"
				         + "����, �������� ����� � ���� ��������� ���������� ����������� ����� ����������.\n"
				         + "--------------------\n"
				         + "����� ������ �����: � 8:00 �� 20:00.\n"
				         + "������������ ��������� ���������� ����������� �� ����: 500.\n"
		                 + "������������ ����� �����, ������� ������������ ���������� � �����: " + maxVisiters
		                 + "\n�������������� �����: " + (8 + maxMinute/60) + " ���. " + maxMinute % 60 + " ���.");
	}
	
	static Integer[] visiterTime() {
		Integer[] time = new Integer[2];
		time[0] = (int) (Math.random() * 720); //����� ������� - �� 0 �� 720-� ������
		time[1] = (int) (Math.random() * (721 - (time[0] + 1)) + time[0] + 1); //����� ����� - �� ��������� ����� ������� ������ �� 720-� ������ ������������
		return time;
	}
}
