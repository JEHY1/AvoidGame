package Example01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CarGame {
	static boolean die = false;
	static int meLocationIndex;
	
	static Label lane1 = new Label("------------------^-^---------------");
	static Label lane2 = new Label("------------------^-^---------------");
	static Label lane3 = new Label("------------------^-^---------------");
	static Label lane4 = new Label("------------------^-^---------------");
	static Label lane5 = new Label("------------------^-^---------------");
	static Label lane6 = new Label("------------------^-^---------------");
	static Label lane7 = new Label("------------------^-^---------------");
	static Label lane8 = new Label("------------------^-^---------------");
	static Label lane9 = new Label("------------------^-^---------------");
	static Label lane10 = new Label("------------------^-^---------------");
	static Label lane11 = new Label("------------------^-^---------------");
	static Label lane12 = new Label("------------------^-^---------------");
	static Label lane13 = new Label("------------------^-^---------------");
	static Label lane14 = new Label("------------------^-^---------------");
	static Label lane15 = new Label("------------------^-^---------------");
	static Label startLane = new Label("------------------^!^---------------");
	
	
	static StringBuilder newLane = new StringBuilder("------------------------------------");
	
	static StringBuilder strBuild;
	static String lastLain = startLane.getText();
	
	static int score = 0;
	static String scoreStr = "Score : ";
	static Label scoreLabel = new Label(scoreStr + score);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame("hello");
		frame.setSize(180, 300);
		frame.setLocation(900, 500);
		CardLayout cardLayout = new CardLayout();
		frame.setLayout(cardLayout);
		Button start = new Button("start");
		Button moveLeft = new Button("<<");
		Button moveRight = new Button(">>");
		
		Panel mainWindow = new Panel();
		Panel playWindow = new Panel();
		playWindow.setLayout(new BorderLayout());
		
		mainWindow.setLayout(new GridLayout(3,1));
		mainWindow.add(new Label("Car"));
		mainWindow.add(new Label("Game"));
		mainWindow.add(start);
		
		frame.add(mainWindow, "1");
		frame.add(playWindow, "2");
		
	
		
		
		Panel gameWindow = new Panel();
		gameWindow.setLayout(new GridLayout(16, 1));
		gameWindow.add(lane1);
		gameWindow.add(lane2);
		gameWindow.add(lane3);
		gameWindow.add(lane4);
		gameWindow.add(lane5);
		gameWindow.add(lane6);
		gameWindow.add(lane7);
		gameWindow.add(lane8);
		gameWindow.add(lane9);
		gameWindow.add(lane10);
		gameWindow.add(lane11);
		gameWindow.add(lane12);
		gameWindow.add(lane13);
		gameWindow.add(lane14);
		gameWindow.add(lane15);
		gameWindow.add(startLane);
		gameWindow.setBackground(Color.green);
		playWindow.add(gameWindow, "Center");
		
		Panel moveButtons = new Panel();
		moveButtons.setLayout(new GridLayout(1,2));
		moveButtons.add(moveLeft);
		moveButtons.add(moveRight);
		playWindow.add(moveButtons, "South");
		playWindow.add(scoreLabel, "North");
		

		int ranNum; 
		int k = 0;
		
		
		meLocationIndex = lastLain.indexOf("!");
		
		
		frame.setVisible(true);
		
		moveLeft.addActionListener(e -> {
			
			lastLain = startLane.getText();
			strBuild = new StringBuilder(lastLain);
			System.out.println(lastLain);
			if(lastLain.charAt(meLocationIndex - 1) == '^') {
				System.out.println("die");
				die = true;
			}
			else {
				if(meLocationIndex > 0) {
					strBuild.setCharAt(meLocationIndex, '-');
					strBuild.setCharAt(meLocationIndex - 1, '!');
					System.out.println("strBuild : " + strBuild);
					
					meLocationIndex -= 1;
					startLane.setText(new String(strBuild));
				}
			}	
		});
		
		moveRight.addActionListener(e -> {
			lastLain = startLane.getText();
			strBuild = new StringBuilder(lastLain);
			if(lastLain.charAt(meLocationIndex + 1) == '^') {
				System.out.println("die");
				die = true;
			}
			else {
				if(meLocationIndex < lastLain.length()-1) {
					strBuild.setCharAt(meLocationIndex, '-');
					strBuild.setCharAt(meLocationIndex + 1, '!');
					meLocationIndex += 1;
					startLane.setText(new String(strBuild));
				}
			}	
		});
		
		
		start.addActionListener(e -> {
			cardLayout.next(frame);
		});
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		

		
		meLocationIndex = 19;
		while(true) {
			System.out.println("meLocationIndex : " + meLocationIndex);
			 ranNum = (int)(Math.random() * 35);
			 newLane = new StringBuilder("------------------------------------");
			try {
				Thread.sleep(300 - k);
			} catch (InterruptedException e) {}
			
			System.out.println("make lane " + k);
			if(k % 2 == 0) {
				newLane.setCharAt(ranNum, '^');
			}
			
			if(lane15.getText().charAt(meLocationIndex) != '^') {
				StringBuilder strBuilder = new StringBuilder(lane15.getText());
				strBuilder.setCharAt(meLocationIndex, '!');
				startLane.setText(new String(strBuilder));
			}
			else {
				die = true;
				System.out.println("die");
			}
			
			if(die) {
				cardLayout.previous(frame);
				break;
			}
			
			lane15.setText(lane14.getText());
			lane14.setText(lane13.getText());
			lane13.setText(lane12.getText());
			lane12.setText(lane11.getText());
			lane11.setText(lane10.getText());
			lane10.setText(lane9.getText());
			lane9.setText(lane8.getText());
			lane8.setText(lane7.getText());
			lane7.setText(lane6.getText());
			lane6.setText(lane5.getText());
			lane5.setText(lane4.getText());
			lane4.setText(lane3.getText());
			lane3.setText(lane2.getText());
			lane2.setText(lane1.getText());
			lane1.setText(new String(newLane));
	
			scoreLabel.setText(scoreStr + score);
			
			
			
			
			score++;
			if(k < 250) {
				k ++;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
