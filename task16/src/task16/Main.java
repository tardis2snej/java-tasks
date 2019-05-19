package task16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	//элементы окна
	Label addCoordinates = new Label("Координаты X и Y новой точки: ");
	TextField addCoordinateX = new TextField();
	TextField addCoordinateY = new TextField();
	Button addButton = new Button("Добавить точку");
	Label resCoordinates = new Label("Координаты X и Y точки для проверки: ");
	TextField resCoordinateX = new TextField();
	TextField resCoordinateY = new TextField();
	Button resultButton = new Button("Проверить");
	Button clean = new Button("Очистить");
	Label instructions = new Label("Инструкция:");
	Label figure = new Label("Выполняется только для опуклых фигур.");
	Label numbers = new Label("Вводите целые числа не меньше нуля.");
	Pan panel = new Pan();
	
	Main() {
		super("Задача 16");
		this.setBounds(0, 0, 700, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//окошко с информацией
		JOptionPane.showMessageDialog(null, "На площині задається опуклий N-кутник цілочисельними координатами своїх\n"
										  + "вершин в порядку обходу по контуpу. Вводяться координати точки (X, Y). \n"
										  + "Визначити:\n" + 
										    "a) чи є вона вершиною N-кутника;\n" + 
									    	"б) чи належить вона N-кутнику.\n", 
									    	"Задача 16", JOptionPane.INFORMATION_MESSAGE);
        
		//размещение элементов
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
			public void actionPerformed(ActionEvent e) { //добавление точки
				try { //считываем данные из полей
					int x, y;
					x = Integer.parseInt(addCoordinateX.getText());
					y = Integer.parseInt(addCoordinateY.getText());
					if (x < 0 | y < 0) { //если меньше нуля, создаем ошибку
						@SuppressWarnings("unused")
						int z = 5/0;
					}
					panel.addPoint(x, panel.getHeight() - y); //если все в порядке, передаем данные функции на панели, переворачивая ось Y так, как нам удобно
				}
				catch (Exception exc) { //обработка ошибки
					JOptionPane.showMessageDialog(null, "Числа введены неверно", "Ошибка", JOptionPane.ERROR_MESSAGE);
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
			public void actionPerformed(ActionEvent arg0) { //проверка расположения точки
				try {
					int x, y;
					x = Integer.parseInt(resCoordinateX.getText());
					y = Integer.parseInt(resCoordinateY.getText());
					if (x < 0 | y < 0) { //если меньше нуля, создаем ошибку
						@SuppressWarnings("unused")
						int z = 5/0;
					}
					panel.checkPoint(x, panel.getHeight() - y); //если все в порядке, передаем данные непосредственно в функцию проверки точки
				}
				catch (Exception exc) { //обработка ошибки
					JOptionPane.showMessageDialog(null, "Числа введены неверно", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
			}
        });
        add(clean);
        clean.setBounds(70, 200, 100, 20);
        clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//очищаем поля для текста
				addCoordinateX.setText("");
				addCoordinateY.setText("");
				resCoordinateX.setText("");
				resCoordinateY.setText("");
				panel.clean(); //очищаем панель и память о прошлых многоугольниках
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
	//для рисования
	Graphics g;
	Graphics2D g2;
	//наш многоугольник
	Polygon figure;
	//списки всех точек и их количество
	int[] pointsX;
	int[] pointsY;
	int numberOfPoints = 0;
	
	Pan() {
		super();
		this.setBackground(Color.WHITE);
	}
	
	public void addPoint(int x, int y) { //добавление точки
		if (numberOfPoints > 0) {
			if (x == pointsX[numberOfPoints - 1] & y == pointsY[numberOfPoints - 1]) { //если мы пытаемся добавить точно такую же точку, которая была добавлена последней - игнорируем добавление
				return;
			}
		}
		//каждый раз рисуем новый многоугольник
		g = getGraphics();
	    super.paintComponent(g);
	    g2 = (Graphics2D) g.create();
	    if (x < 0 | y < 0) { //если переданы х и у меньше нуля, то уходим, оставляя только пустую панель
	    	return;
	    }
	    
	    numberOfPoints++; //увеличиваем количество точек
	    if (numberOfPoints == 1) { //если введена первая точка многоугольника - рисуем только ее
	    	//сохранение в массивы точек
	    	pointsX = new int[1];
	    	pointsX[0] = x;
	    	pointsY = new int[1];
	    	pointsY[0] = y;
	    	//рисуем точку
		    g.setColor(Color.black);
		    g.setFont(new Font("Шрифт", Font.BOLD, 30));
		    g.drawString(".", pointsX[0], pointsY[0]);
		    return;
	    }
	    //для перенесение данных о точках в новый массив побольше
	    int[] newPointsX = new int[numberOfPoints];
	    int[] newPointsY = new int[numberOfPoints];
	    if (numberOfPoints == 2) { //если у нас есть только две точки - переносим старую точку и добавляем новую в список
	    	newPointsX[0] = pointsX[0];
	    	newPointsY[0] = pointsY[0];
	    	pointsX = newPointsX;
	    	pointsX[1] = x;
	    	pointsY = newPointsY;
	    	pointsY[1] = y;
	    	g.drawLine(pointsX[0], pointsY[0], pointsX[1], pointsY[1]); //рисуем между точками линию
	    	return;
	    }
	    //если точек больше двух
	    for (int i = 0; i < numberOfPoints - 1; i++) { //переносим данные
		   	newPointsX[i] = pointsX[i];
		   	newPointsY[i] = pointsY[i];
		}
	    //добавляем новые точки в конец массива
		newPointsX[numberOfPoints - 1] = x;
		newPointsY[numberOfPoints - 1] = y;
		//обновляем массив
		pointsX = newPointsX;
		pointsY = newPointsY;
	    //рисуем фигуру из имеющихся точек
	    figure = new Polygon(pointsX, pointsY, numberOfPoints);
	    g2.setColor(Color.GRAY);
	    g2.fill(figure);
	    
	}
	
	public void clean() { //очищает панель и информацию о точках
		//уничтожение массивов точек
		pointsX = null;
		pointsY = null;
		numberOfPoints = 0; //обнуление количества точек
		addPoint(-1, -1); //с такими параметрами панель станет пустой
	}
	
	public void checkPoint(int x, int y) { //проверка принадлежности точки фигуре
		if (numberOfPoints < 3) { //если точек меньше трех, то у нас и многоугольника-то нет
			displayCheckResult(0);
			return;
		}
		paintAgain(); //перерисовываем многоугольник, чтобы удалить предыдущие точки для проверки
		//добавляем нашу точку для проверки на рисунок
		g.setColor(Color.red);
	    g.setFont(new Font("Шрифт", Font.BOLD, 30));
	    g.drawString(".", x, y);
		int result = 0; //код результата
		boolean ray = false; //луч, определяющий столкновение со сторонами. Выпускается из точки вертикально вверх. Если после выполнения цикла он будет true, значит он столкнулся нечетное количество раз и точка находится в многоугольнике. Если false - четное количество раз или 0, и точка находится вне многоугольника
		for (int i = 0; i < numberOfPoints; i++) {
			if (pointsX[i] == x & pointsY[i] == y) { //если точка лежит на вершине
				result = 1;
				break;
			}
			double crossingY; //пересечение по оси X
			boolean crossingX = false; //находится ли координата Х между концами этой стороны
			if (i == numberOfPoints - 1) { //если мы дошли до конца списка точек - следующая будет первой
				if (pointsX[i] == pointsX[0]) { //если у нас вертикальная прямая
					if (pointsX[i] == x & ((y > pointsY[0] & y < pointsY[i]) | (y > pointsY[0] & y < pointsY[i]))) { //если принадлежит этой вертикальной прямой
						result = 2;
						break;
					}
					else { //если нет, просто пропускаем ее
						continue;
					}
				}
				else {
					if (pointsY[i] == pointsY[0]) { //значит у нас горизонтальная прямая
						if (y == pointsY[i] & (y == pointsY[0] & y == pointsY[i])) { //если лежит на этой горизонтальной прямой
							result = 2;
							break;
						}
					}
					crossingY = (((double) ((x - pointsX[i]) * (pointsY[0] - pointsY[i]))) / (double) (pointsX[0] - pointsX[i])) + pointsY[i]; //выясняем, где луч перечесется с прямой, которой принадлежит текущее ребро многоугольника
					if ((x >= pointsX[0] & x <= pointsX[i]) | (x <= pointsX[0] & x >= pointsX[i])) { //выясняем, находится ли точка под ребром многоугольника или же луч пересекается по Y где-то за его пределами
						crossingX = true;
					}
				}
			}
			else { //когда мы не в конце списка точек
				if (pointsX[i] == pointsX[i + 1]) { //если у нас вертикальная прямая
					if (pointsX[i] == x & ((y > pointsY[i + 1] & y < pointsY[i]) | (y > pointsY[i + 1] & y < pointsY[i]))) { //если принадлежит этой вертикальной прямой
						result = 2;
						break;
					}
					else { //если нет, просто пропускаем ее
						continue;
					}
				}
				
				else { //если не вертикальная, используем ее уравнение и ищем пересечение с лучом из точки
					if (pointsY[i] == pointsY[i + 1]) { //значит у нас горизонтальная прямая
						if (y == pointsY[i] & (y == pointsY[i + 1] & y == pointsY[i])) { //если лежит на этой горизонтальной прямой
							result = 2;
							break;
						}
					}
					crossingY = (((double) ((x - pointsX[i]) * (pointsY[i + 1] - pointsY[i]))) / (double) (pointsX[i + 1] - pointsX[i])) + pointsY[i]; //выясняем, где луч перечесется с прямой, которой принадлежит текущее ребро многоугольника
					if ((x >= pointsX[i + 1] & x <= pointsX[i]) | (x <= pointsX[i + 1] & x >= pointsX[i])) { //выясняем, находится ли точка под ребром многоугольника или же луч пересекается по Y где-то за его пределами
						crossingX = true;
					}
				}
			}
			
			if (crossingY < y & crossingX) { //находится ли пересечение над точкой и соответствует положению Х. Если да и впервые (ray == false), то мы внутри многоугольника и ставим true. Если да, но не впервые (ray == true), мы вышли из многоугольника и ставим false.
				if (ray) {
					ray = false;
				}
				else if (!ray) {
					ray = true;
				}
			}
		}
		//обработка результатов цикла. Выполняется, если результат еще не найден.
		if (ray && result == 0) {
			result = 2; 
		}
		else if (!ray && result == 0) {
			result = 3;
		}
		displayCheckResult(result);
	}
	
	private void displayCheckResult(int i) { //вывод результатов
		String message = "";
		switch(i) {
		case 0: message = "Нет многоугольника"; break;
		case 1: message = "Точка лежит на вершине"; break;
		case 2: message = "Точка лежит на многоугольнике"; break;
		case 3: message = "Точка не лежит на многоугольнике"; break;
		}
		JOptionPane.showMessageDialog(null, message, "Результат", JOptionPane.ERROR_MESSAGE);
	}
	
	private void paintAgain() { //заново рисует имеющийся многоугольник
		g = getGraphics();
		super.paintComponent(g);
		g2 = (Graphics2D) g.create();
		figure = new Polygon(pointsX, pointsY, numberOfPoints);
	    g2.setColor(Color.GRAY);
	    g2.fill(figure);
	}
}