package ICS3USummativeProjectCopy4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PomodoroGUI implements Runnable{

	static JFrame frame;
	private static int seconds;
	
	public PomodoroGUI() {
		
		frame = new JFrame();
        JPanel bigPanel = new JPanel();
        JPanel reviewPanel = new JPanel();

        frame.setLayout(null);
        frame.setSize(1300, 1000);
        // Allow window resizing
        frame.setResizable(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pomodoro Page");

        bigPanel.setLayout(null);
        bigPanel.setBounds(0, 0, 2000, 1200);
        bigPanel.setBackground(Color.white);
        frame.add(bigPanel);
        
        // Labels for displaying current date and time
        JLabel timeLabel = new JLabel();
        timeLabel.setBounds(750, 5, 600, 200);
        timeLabel.setFont(new Font("Serif", Font.BOLD, 150));
        bigPanel.add(timeLabel);
		
        //Set panel and frame visibility
        bigPanel.setVisible(true);
        frame.setVisible(true);
        
		while (true) {
	        try {
	            Date today = new Date();
	            SimpleDateFormat timeFormat= new SimpleDateFormat("HH:mm");

	            // Update labels with current date and time
	            timeLabel.setText(timeFormat.format(today));
	            Thread.sleep(1000); // Sleep for 1 second

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		

	}

	public void CountDownTimer(int seconds) {
			
			this.seconds = seconds;
			
	}
	
	 public static String convertSecondsToTimeString(int seconds) {
         // Calculate minutes and seconds
         int minutes = seconds / 60;
         int remainingSeconds = seconds % 60;

         // Format minutes and seconds to have leading zeros if necessary
         String minutesString = String.format("%02d", minutes);
         String secondsString = String.format("%02d", remainingSeconds);

         // Concatenate minutes and seconds with a colon in between
         String timeString = minutesString + ":" + secondsString;
         return timeString;
        
     
	}
	
	public void run() {
		try {
			for (int i = seconds; i >= 0; i--) {
				//pauses the current thread for 1000 milliseconds (1 second)
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
	
}
