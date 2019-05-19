package task16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	//�������� ����
	Label addCoordinates = new Label("���������� X � Y ����� �����: ");
	TextField addCoordinateX = new TextField();
	TextField addCoordinateY = new TextField();
	Button addButton = new Button("�������� �����");
	Label resCoordinates = new Label("���������� X � Y ����� ��� ��������: ");
	TextField resCoordinateX = new TextField();
	TextField resCoordinateY = new TextField();
	Button resultButton = new Button("���������");
	Button clean = new Button("��������");
	Label instructions = new Label("����������:");
	Label figure = new Label("����������� ������ ��� ������� �����.");
	Label numbers = new Label("������� ����� ����� �� ������ ����.");
	Pan panel = new Pan();
	
	Main() {
		super("������ 16");
		this.setBounds(0, 0, 700, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������ � �����������
		JOptionPane.showMessageDialog(null, "�� ������ �������� ������� N-������ �������������� ������������ ����\n"
										  + "������ � ������� ������ �� �����p�. ��������� ���������� ����� (X, Y). \n"
										  + "���������:\n" + 
										    "a) �� � ���� �������� N-�������;\n" + 
									    	"�) �� �������� ���� N-�������.\n", 
									    	"������ 16", JOptionPane.INFORMATION_MESSAGE);
        
		//���������� ���������
		add(addCoordinates);
		addCoordinates.setBounds(20, 20, 200, 20);
        add(addCoordinateX);
        addCoordinateX.setBounds(60, 40, 30, 20);
        add(addCoordinateY);
        addCoordinateY.setBounds(150, 40, 30, 20);
        add(addButton);
        addButton.setBounds(70, 60, 100, 20);
        addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //���������� �����
				try { //��������� ������ �� �����
					int x, y;
					x = Integer.parseInt(addCoordinateX.getText());
					y = Integer.parseInt(addCoordinateY.getText());
					if (x < 0 | y < 0) { //���� ������ ����, ������� ������
						@SuppressWarnings("unused")
						int z = 5/0;
					}
					panel.addPoint(x, panel.getHeight() - y); //���� ��� � �������, �������� ������ ������� �� ������, ������������� ��� Y ���, ��� ��� ������
				}
				catch (Exception exc) { //��������� ������
					JOptionPane.showMessageDialog(null, "����� ������� �������", "������", JOptionPane.ERROR_MESSAGE);
				}
			}
        });
        add(resCoordinates);
        resCoordinates.setBounds(20, 100, 220, 20);
        add(resCoordinateX);
        resCoordinateX.setBounds(60, 120, 30, 20);
        add(resCoordinateY);
        resCoordinateY.setBounds(150, 120, 30, 20);
        add(resultButton);
        resultButton.setBounds(70, 140, 100, 20);
        resultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { //�������� ������������ �����
				try {
					int x, y;
					x = Integer.parseInt(resCoordinateX.getText());
					y = Integer.parseInt(resCoordinateY.getText());
					if (x < 0 | y < 0) { //���� ������ ����, ������� ������
						@SuppressWarnings("unused")
						int z = 5/0;
					}
					panel.checkPoint(x, panel.getHeight() - y); //���� ��� � �������, �������� ������ ��������������� � ������� �������� �����
				}
				catch (Exception exc) { //��������� ������
					JOptionPane.showMessageDialog(null, "����� ������� �������", "������", JOptionPane.ERROR_MESSAGE);
				}
			}
        });
        add(clean);
        clean.setBounds(70, 200, 100, 20);
        clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������� ���� ��� ������
				addCoordinateX.setText("");
				addCoordinateY.setText("");
				resCoordinateX.setText("");
				resCoordinateY.setText("");
				panel.clean(); //������� ������ � ������ � ������� ���������������
			}
        });
        add(instructions);
        instructions.setBounds(20, 240, 220, 20);
        add(figure);
        figure.setBounds(20, 260, 240, 20);
        add(numbers);
        numbers.setBounds(20, 280, 240, 20);
        add(panel);
        panel.setBounds(260, 20, 410, 420);
	}

	public static void main(String[] args) {
		Main window = new Main();
		window.setVisible(true);
	}
}

@SuppressWarnings("serial")
class Pan extends JPanel {
	//��� ���������
	Graphics g;
	Graphics2D g2;
	//��� �������������
	Polygon figure;
	//������ ���� ����� � �� ����������
	int[] pointsX;
	int[] pointsY;
	int numberOfPoints = 0;
	
	Pan() {
		super();
		this.setBackground(Color.WHITE);
	}
	
	public void addPoint(int x, int y) { //���������� �����
		if (numberOfPoints > 0) {
			if (x == pointsX[numberOfPoints - 1] & y == pointsY[numberOfPoints - 1]) { //���� �� �������� �������� ����� ����� �� �����, ������� ���� ��������� ��������� - ���������� ����������
				return;
			}
		}
		//������ ��� ������ ����� �������������
		g = getGraphics();
	    super.paintComponent(g);
	    g2 = (Graphics2D) g.create();
	    if (x < 0 | y < 0) { //���� �������� � � � ������ ����, �� ������, �������� ������ ������ ������
	    	return;
	    }
	    
	    numberOfPoints++; //����������� ���������� �����
	    if (numberOfPoints == 1) { //���� ������� ������ ����� �������������� - ������ ������ ��
	    	//���������� � ������� �����
	    	pointsX = new int[1];
	    	pointsX[0] = x;
	    	pointsY = new int[1];
	    	pointsY[0] = y;
	    	//������ �����
		    g.setColor(Color.black);
		    g.setFont(new Font("�����", Font.BOLD, 30));
		    g.drawString(".", pointsX[0], pointsY[0]);
		    return;
	    }
	    //��� ����������� ������ � ������ � ����� ������ ��������
	    int[] newPointsX = new int[numberOfPoints];
	    int[] newPointsY = new int[numberOfPoints];
	    if (numberOfPoints == 2) { //���� � ��� ���� ������ ��� ����� - ��������� ������ ����� � ��������� ����� � ������
	    	newPointsX[0] = pointsX[0];
	    	newPointsY[0] = pointsY[0];
	    	pointsX = newPointsX;
	    	pointsX[1] = x;
	    	pointsY = newPointsY;
	    	pointsY[1] = y;
	    	g.drawLine(pointsX[0], pointsY[0], pointsX[1], pointsY[1]); //������ ����� ������� �����
	    	return;
	    }
	    //���� ����� ������ ����
	    for (int i = 0; i < numberOfPoints - 1; i++) { //��������� ������
		   	newPointsX[i] = pointsX[i];
		   	newPointsY[i] = pointsY[i];
		}
	    //��������� ����� ����� � ����� �������
		newPointsX[numberOfPoints - 1] = x;
		newPointsY[numberOfPoints - 1] = y;
		//��������� ������
		pointsX = newPointsX;
		pointsY = newPointsY;
	    //������ ������ �� ��������� �����
	    figure = new Polygon(pointsX, pointsY, numberOfPoints);
	    g2.setColor(Color.GRAY);
	    g2.fill(figure);
	    
	}
	
	public void clean() { //������� ������ � ���������� � ������
		//����������� �������� �����
		pointsX = null;
		pointsY = null;
		numberOfPoints = 0; //��������� ���������� �����
		addPoint(-1, -1); //� ������ ����������� ������ ������ ������
	}
	
	public void checkPoint(int x, int y) { //�������� �������������� ����� ������
		if (numberOfPoints < 3) { //���� ����� ������ ����, �� � ��� � ��������������-�� ���
			displayCheckResult(0);
			return;
		}
		paintAgain(); //�������������� �������������, ����� ������� ���������� ����� ��� ��������
		//��������� ���� ����� ��� �������� �� �������
		g.setColor(Color.red);
	    g.setFont(new Font("�����", Font.BOLD, 30));
	    g.drawString(".", x, y);
		int result = 0; //��� ����������
		boolean ray = false; //���, ������������ ������������ �� ���������. ����������� �� ����� ����������� �����. ���� ����� ���������� ����� �� ����� true, ������ �� ���������� �������� ���������� ��� � ����� ��������� � ��������������. ���� false - ������ ���������� ��� ��� 0, � ����� ��������� ��� ��������������
		for (int i = 0; i < numberOfPoints; i++) {
			if (pointsX[i] == x & pointsY[i] == y) { //���� ����� ����� �� �������
				result = 1;
				break;
			}
			double crossingY; //����������� �� ��� X
			boolean crossingX = false; //��������� �� ���������� � ����� ������� ���� �������
			if (i == numberOfPoints - 1) { //���� �� ����� �� ����� ������ ����� - ��������� ����� ������
				if (pointsX[i] == pointsX[0]) { //���� � ��� ������������ ������
					if (pointsX[i] == x & ((y > pointsY[0] & y < pointsY[i]) | (y > pointsY[0] & y < pointsY[i]))) { //���� ����������� ���� ������������ ������
						result = 2;
						break;
					}
					else { //���� ���, ������ ���������� ��
						continue;
					}
				}
				else {
					if (pointsY[i] == pointsY[0]) { //������ � ��� �������������� ������
						if (y == pointsY[i] & (y == pointsY[0] & y == pointsY[i])) { //���� ����� �� ���� �������������� ������
							result = 2;
							break;
						}
					}
					crossingY = (((double) ((x - pointsX[i]) * (pointsY[0] - pointsY[i]))) / (double) (pointsX[0] - pointsX[i])) + pointsY[i]; //��������, ��� ��� ����������� � ������, ������� ����������� ������� ����� ��������������
					if ((x >= pointsX[0] & x <= pointsX[i]) | (x <= pointsX[0] & x >= pointsX[i])) { //��������, ��������� �� ����� ��� ������ �������������� ��� �� ��� ������������ �� Y ���-�� �� ��� ���������
						crossingX = true;
					}
				}
			}
			else { //����� �� �� � ����� ������ �����
				if (pointsX[i] == pointsX[i + 1]) { //���� � ��� ������������ ������
					if (pointsX[i] == x & ((y > pointsY[i + 1] & y < pointsY[i]) | (y > pointsY[i + 1] & y < pointsY[i]))) { //���� ����������� ���� ������������ ������
						result = 2;
						break;
					}
					else { //���� ���, ������ ���������� ��
						continue;
					}
				}
				
				else { //���� �� ������������, ���������� �� ��������� � ���� ����������� � ����� �� �����
					if (pointsY[i] == pointsY[i + 1]) { //������ � ��� �������������� ������
						if (y == pointsY[i] & (y == pointsY[i + 1] & y == pointsY[i])) { //���� ����� �� ���� �������������� ������
							result = 2;
							break;
						}
					}
					crossingY = (((double) ((x - pointsX[i]) * (pointsY[i + 1] - pointsY[i]))) / (double) (pointsX[i + 1] - pointsX[i])) + pointsY[i]; //��������, ��� ��� ����������� � ������, ������� ����������� ������� ����� ��������������
					if ((x >= pointsX[i + 1] & x <= pointsX[i]) | (x <= pointsX[i + 1] & x >= pointsX[i])) { //��������, ��������� �� ����� ��� ������ �������������� ��� �� ��� ������������ �� Y ���-�� �� ��� ���������
						crossingX = true;
					}
				}
			}
			
			if (crossingY < y & crossingX) { //��������� �� ����������� ��� ������ � ������������� ��������� �. ���� �� � ������� (ray == false), �� �� ������ �������������� � ������ true. ���� ��, �� �� ������� (ray == true), �� ����� �� �������������� � ������ false.
				if (ray) {
					ray = false;
				}
				else if (!ray) {
					ray = true;
				}
			}
		}
		//��������� ����������� �����. �����������, ���� ��������� ��� �� ������.
		if (ray && result == 0) {
			result = 2; 
		}
		else if (!ray && result == 0) {
			result = 3;
		}
		displayCheckResult(result);
	}
	
	private void displayCheckResult(int i) { //����� �����������
		String message = "";
		switch(i) {
		case 0: message = "��� ��������������"; break;
		case 1: message = "����� ����� �� �������"; break;
		case 2: message = "����� ����� �� ��������������"; break;
		case 3: message = "����� �� ����� �� ��������������"; break;
		}
		JOptionPane.showMessageDialog(null, message, "���������", JOptionPane.ERROR_MESSAGE);
	}
	
	private void paintAgain() { //������ ������ ��������� �������������
		g = getGraphics();
		super.paintComponent(g);
		g2 = (Graphics2D) g.create();
		figure = new Polygon(pointsX, pointsY, numberOfPoints);
	    g2.setColor(Color.GRAY);
	    g2.fill(figure);
	}
}