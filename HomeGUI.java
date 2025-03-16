package ICS3USummativeProjectCopy4;

import java.awt.Color;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HomeGUI implements ActionListener {

	//declaring elements of page
    static JFrame frame;
    static JButton reviewPageButton;
    static JButton infoButton;
//    static JButton pomodoroPageButton;
    static ReviewTasksGUI reviewTasks;

    //for the labels avoiding repetitive code
    public static JLabel[] tasks = new JLabel[20];
    static JButton[] postponeButton = new JButton[20];
    
    //for the review picture
    private static JLabel pictureShown;

    HomeGUI() {

    	//This makes sure that everytime we FIRST get ALL the date from the file WITHOUT changes
        FileIO.retrieveInfo();

        //creating, not setting visible
        reviewTasks = new ReviewTasksGUI(); 
        ReviewTasksGUI.frame.setVisible(false);

        // Set text after ReviewTasksGUI instantiation, this is SO important
        for (int i = 0; i < 20; i++) {
            ReviewTasksGUI.textAreas[i].setText(FileIO.reviewTaskName[i]);
            ReviewTasksGUI.stageAreas[i].setText(FileIO.reviewTaskDate[i]);
        }
        
        frame = new JFrame();
        JPanel bigPanel = new JPanel();
        JPanel reviewPanel = new JPanel();

        frame.setLayout(null);
        frame.setSize(1300, 1000);
        //allow window resizing
        frame.setResizable(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Home Page");
        
//        //setting background
//        ImageIcon background = new ImageIcon("C:\\Users\\chentx06\\IdeaProjects\\FileIO\\src\\ForestRiver.jpg");
//        Image image = background.getImage();
//        Image newimg = image.getScaledInstance(2000, 1200, java.awt.Image.SCALE_SMOOTH);
//        background = new ImageIcon(newimg); 
//        backgroundPic = new JLabel(background);
//        backgroundPic.setBounds(0, 0, 2000, 1200);
//        frame.add(backgroundPic);

        bigPanel.setLayout(null);
        bigPanel.setBounds(0, 0, 2000, 1200);
        bigPanel.setBackground(new Color(181,218,229));
        frame.add(bigPanel);

        ImageIcon forgettingCurve = new ImageIcon("C:\\Users\\chentx06\\IdeaProjects\\FileIO\\src\\curve 3.png");
        Image image = forgettingCurve.getImage();
        //rescaling
        Image newimg = image.getScaledInstance(920, 620, java.awt.Image.SCALE_SMOOTH);
        forgettingCurve = new ImageIcon(newimg); 
        pictureShown = new JLabel(forgettingCurve);
        pictureShown.setBounds(30, 120, 920, 620);
        bigPanel.add(pictureShown);
        
        // labels for displaying exact current date and time
        JLabel dayTimeLabel = new JLabel();
        dayTimeLabel.setBounds(40, 30, 600, 60);
        dayTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 60));
        bigPanel.add(dayTimeLabel);

        JLabel hourTimeLabel = new JLabel();
        hourTimeLabel.setBounds(400, 30, 600, 60);
        hourTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 60));
        bigPanel.add(hourTimeLabel);
        
        JLabel reviewLabel = new JLabel("Review Tasks");
        reviewLabel.setBounds(1200, 30, 600, 60);
        reviewLabel.setFont(new Font("Helvetica", Font.BOLD, 60));
        bigPanel.add(reviewLabel);

        //Going to review page
        reviewPageButton = new JButton();
        reviewPageButton.setBounds(100, 800, 300, 120);
        reviewPageButton.setFont(new Font("Rock Salt", Font.BOLD, 30));
//        reviewPageButton.setBackground(Color.cyan);
        //makes the border round
        reviewPageButton.setBorder(new RoundedBorder(20));
        reviewPageButton.setText("Review Tasks");
        bigPanel.add(reviewPageButton);
//        reviewPageButton.setOpaque(false);
        reviewPageButton.setContentAreaFilled(false);
//        startButton.setBorderPainted(false);
        reviewPageButton.addActionListener(this);
        
        infoButton = new JButton();
        infoButton.setBounds(700, 800, 100, 120);
        infoButton.setFont(new Font("Rock Salt", Font.BOLD, 40));
        infoButton.setBackground(Color.white);
        infoButton.setText("i");
        bigPanel.add(infoButton);
        infoButton.addActionListener(this);

//        pomodoroPageButton = new JButton();
//        pomodoroPageButton.setBounds(300, 800, 180, 120);
//        pomodoroPageButton.setFont(new Font("Serif", Font.BOLD, 30));
//        pomodoroPageButton.setBackground(Color.cyan);
//        pomodoroPageButton.setText("Pomodoro");
//        bigPanel.add(pomodoroPageButton);
//        pomodoroPageButton.addActionListener(this);


        //panel displaying review tasks
        reviewPanel.setLayout(null);
        // Set preferred size to enable scrolling
        reviewPanel.setPreferredSize(new Dimension(300, 2250)); 
        reviewPanel.setBounds(1300, 130, 800, 800);
        reviewPanel.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
        reviewPanel.setBorder(border);

        //scrolling feature for this as well
        JScrollPane scrollPane = new JScrollPane(reviewPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(1000, 130, 800, 800);
        bigPanel.add(scrollPane);

        // in a for loop create the repeating elements! avoids repetitive code
        for (int i = 0; i < 20; i++) {
            postponeButton[i] = new JButton();
            postponeButton[i].setText(FileIO.reviewTaskName[i]);
            postponeButton[i].setBounds(40, 40 + i * 110, 700, 80);
            postponeButton[i].setFont(new Font("Serif", Font.BOLD, 30));
            reviewPanel.add(postponeButton[i]);
            //it took time to figure out i would do the actionlistener to the buton based on i as well
            postponeButton[i].addActionListener(new PostponeActionListener(i));

            //notifies that it's review time by becoming red
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                Date reviewDate = sdf.parse(FileIO.reviewTaskDate[i]);

                if (currentDate.compareTo(reviewDate) >= 0) {
                    //if iit is the right day or afterwards, set colour of button to red
                    postponeButton[i].setBackground(Color.yellow);
                } else {
                    // Set colour of button to white
                    postponeButton[i].setBackground(Color.white);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        
        
        //visible elements
        reviewPanel.setVisible(true);
        bigPanel.setVisible(true);
        frame.setVisible(true);

        //update time label all the time
        while (true) {
            try {
                Date currentDate = new Date();
                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                //updated with current date and time, using this sleep thread allowing slowed for 1 second
                dayTimeLabel.setText(dayFormat.format(currentDate));
                hourTimeLabel.setText(hourFormat.format(currentDate));
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //when a task is changed this updates the button colour
    public static void updateButtonColor(int taskIndex) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            //change stored string into date object 
            Date reviewDate = sdf.parse(FileIO.reviewTaskDate[taskIndex]);

            if (currentDate.compareTo(reviewDate) >= 0) {
                // If it is the right day or afterwards, set colour of button to yellow
                postponeButton[taskIndex].setBackground(Color.yellow);
            } else {
                // Set colour of button to white
                postponeButton[taskIndex].setBackground(Color.white);
            }
            
            //makes it update
            postponeButton[taskIndex].revalidate();
            postponeButton[taskIndex].repaint();
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //makes sure they are the right colour and with right text on
    public static void updateReviewTaskButtons() {
        for (int i = 0; i < 20; i++) {
            postponeButton[i].setText(ReviewTasksGUI.textAreas[i].getText());
            // Update button color based on date
            updateButtonColor(i);
        }
    }
    
    //this class is put inside the HomeGUI class because it's an extension
    class PostponeActionListener implements ActionListener {
    	
        int taskIndex;
        
        PostponeActionListener(int taskIndex) {
            this.taskIndex = taskIndex;
        }

        //when the postpone button is clicked do this
        public void actionPerformed(ActionEvent e) {
            JTextField dateField = new JTextField();
            Object[] message = {"Please update the review date of the task in format (yyyy-MM-dd):", dateField};

            //opens Joptionpane with error checking
            int option = JOptionPane.showConfirmDialog(null, message, "Postpone Task", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newDateStr = dateField.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);
                
                try {
                    Date newDate = sdf.parse(newDateStr);
                    FileIO.reviewTaskDate[taskIndex] = sdf.format(newDate);
                    ReviewTasksGUI.stageAreas[taskIndex].setText(sdf.format(newDate));
                    FileIO.SaveAndRead();
                    //when update colour method is called, the colour of the task will change
                    updateButtonColor(taskIndex); 
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Please use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    //when this is clicked go to review page
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reviewPageButton) {
            //change page
            ReviewTasksGUI.frame.setVisible(true);
            frame.setVisible(false); 
        }
        if (e.getSource() == infoButton) {
            
        	//This program makes 
        	String infoMessage = "Welcome to the Review Tasks Program!\n\n"
                    + "1. Home Page:\n"
                    + "   - Click on any task buttons to the right to edit or postpone the date you want to review your tasks.\n"
                    + "   - When a tasks is to be reviewed according to your plan, it will appear as yellow.\n"
                    + "   - When the task is not to be reviewd yet, it appears at white.\n"
                    + "   - If you want to edit the tasks further, click on the Review Tasks Button, it'll take you to the review tasks editing page.\n"
                    + "   - This graph features the forgetting curve, for reminding you of the next time you should do an effective review.\n\n"
                    + "2. Review Tasks Page:\n"
                    + "   - Clicking on the Review Tasks Button takes you to this page.\n"
                    + "   - If you want to create or modify a new task, simply click the edit button and enter the name and date you want to review the task.\n"
                    + "   - The date must be entered in the (yyyy-MM-dd) format.\n\n"
                    + "Enjoy organizing your tasks!";
        	
        	 JOptionPane.showMessageDialog(null, infoMessage, "Information", JOptionPane.INFORMATION_MESSAGE);
        	
        }
    }
}
