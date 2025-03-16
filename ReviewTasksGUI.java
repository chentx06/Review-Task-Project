package ICS3USummativeProjectCopy4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ReviewTasksGUI implements ActionListener {

    static JFrame frame;

    static JButton homeButton;
    static JButton soundButton;

    public static JLabel[] numberLabels = new JLabel[20];
    public static JTextArea[] textAreas = new JTextArea[20];
    public static JTextArea[] stageAreas = new JTextArea[20];
    static JButton[] editButtons = new JButton[20];

    // This is very important for deciding where to save to.
    // If the edit button is for a certain task, we need to save the info to that
    // task
    public static int taskNumber;

    public ReviewTasksGUI() {

        FileIO.objectCreation();

        //declarations
        frame = new JFrame();
        JPanel bigPanel = new JPanel();
        JPanel taskPanel = new JPanel();

        // Setting frame window popup
        frame.setLayout(null);
        frame.setSize(1300, 1000);
        // this allows the window to be changed and put next to other windows!
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Review Tasks");

        // putting panel on frame with same size
        bigPanel.setLayout(null);
        bigPanel.setBounds(0, 0, 2000, 1200);
        bigPanel.setBackground(new Color(191,219,205));
        frame.add(bigPanel);
        
//        JLabel taskNameLabel = new JLabel("Task Name"); 
//        taskNameLabel.setBounds(500, 20, 200, 30);
//        taskNameLabel.setFont(new Font("Serif", Font.BOLD, 60));
//        bigPanel.add(taskNameLabel);
//        
//        JLabel taskDateLabel = new JLabel("Task Date"); 
//        taskDateLabel.setBounds(750, 10, 200, 30);
//        taskDateLabel.setFont(new Font("Serif", Font.BOLD, 20));
//        bigPanel.add(taskDateLabel);
        
        // putting buttons on the page
        homeButton = new JButton();
        homeButton.setBounds(100, 50, 200, 150);
        homeButton.setFont(new Font("Serif", Font.BOLD, 60));
        homeButton.setBackground(Color.cyan);
        homeButton.setBorder(new RoundedBorder(20));
        homeButton.setContentAreaFilled(false);
        homeButton.setText("Home");
        bigPanel.add(homeButton);
        homeButton.addActionListener(this);
        
//        soundButton = new JButton();
//        soundButton.setBounds(100, 300, 200, 150);
//        soundButton.setFont(new Font("Serif", Font.BOLD, 40));
//        soundButton.setBackground(Color.cyan);
//        soundButton.setBorder(new RoundedBorder(20));
//        soundButton.setContentAreaFilled(false);
//        soundButton.setText("Sound");
//        bigPanel.add(soundButton);
//        soundButton.addActionListener(this);

        // putting task panel with flow layout on fame
        taskPanel.setLayout(null);
        // setting preffered size allows us TO CHANGE SCROLL HEIGHT since we put the panel on the scrolling feature
        taskPanel.setPreferredSize(new Dimension(1000, 2250));
        taskPanel.setBounds(300, 100, 800, 750);
        taskPanel.setBackground(Color.lightGray);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
        taskPanel.setBorder(border);

        // adding scrolling feature by adding taskpanel to the scrollpane then adding
        // this on big panel
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(400, 200, 1200, 800);
        bigPanel.add(scrollPane);

        // Adding task labels, text areas\ and buttons
        for (int i = 0; i < 20; i++) {
            numberLabels[i] = new JLabel(String.valueOf(i + 1));
            numberLabels[i].setBounds(40, 60 + i * 110, 200, 40);
            numberLabels[i].setFont(new Font("Serif", Font.BOLD, 50));
            taskPanel.add(numberLabels[i]);

            textAreas[i] = new JTextArea();
            textAreas[i].setBounds(100, 40 + i * 110, 600, 80);
            textAreas[i].setFont(new Font("Times New Roman", Font.PLAIN, 30));
            textAreas[i].setEditable(false);
            taskPanel.add(textAreas[i]);

            stageAreas[i] = new JTextArea();
            stageAreas[i].setBounds(750, 40 + i * 110, 250, 80);
            stageAreas[i].setFont(new Font("Times New Roman", Font.PLAIN, 30));
            stageAreas[i].setEditable(false);
            taskPanel.add(stageAreas[i]);

            editButtons[i] = new JButton();
            editButtons[i].setBounds(1040, 40 + i * 110, 100, 80);
            editButtons[i].setFont(new Font("Serif", Font.BOLD, 30));
            editButtons[i].setBackground(Color.white);
            editButtons[i].setText("Edit");
            taskPanel.add(editButtons[i]);
            editButtons[i].addActionListener(this);
        }

        // This is to make sure everything on the frame changes as the window changes
        //Need modifications
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Dimension newSize = frame.getSize();
                bigPanel.setSize(newSize);
            }
        });

        taskPanel.setVisible(true);
        bigPanel.setVisible(true);
        frame.setVisible(true);
        
        
    }

    // If one specific button is clicked, the info will be saved to a specific
    // place in the file
    // How do we know which file to save to? if edit button 1, save to the first row
    // in the file
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            HomeGUI.frame.setVisible(true);
            frame.setVisible(false);
        }

        // If the editing button is clicked, then do the pop-up
        for (int i = 0; i < 20; i++) {
            if (e.getSource() == editButtons[i]) {
                taskNumber = i + 1; // Task numbers start from 1
                // create object with switch!
                ReviewTasksPopUpGUI.editPopUp();
                break; // No need to continue looping once found
            }
        }
        
//        if (e.getSource() == soundButton) {
//        	SoundPopup();
//        }
       
    }
    
}
