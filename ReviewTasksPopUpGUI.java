package ICS3USummativeProjectCopy4;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//popped up when clicked on edit in reviewtasksGUI
public class ReviewTasksPopUpGUI {

    static JTextField editName;
    static JTextField editStage;
    static JLabel nameLabel;
    static JLabel timeLabel;

    public static void editPopUp() {

        JFrame questionFrame = new JFrame();
        questionFrame.setTitle("Edit The Review Task");
        questionFrame.setLayout(null);
        questionFrame.setLocation(450, 250);
        questionFrame.setSize(new Dimension(400, 400));
        questionFrame.setResizable(false);
        questionFrame.setVisible(true);

        nameLabel = new JLabel("Task Name");
        nameLabel.setBounds(30, -20, 325, 100);
        
        editName = new JTextField();
        editName.setBounds(30, 50, 325, 100);
        
        timeLabel = new JLabel("Review date (yyyy-MM-dd): "
        		+ "Example: 2024-08-21");
        timeLabel.setBounds(30, 130, 325, 100);
        
        editStage = new JTextField();
        editStage.setBounds(30, 200, 325, 60);

        //when this button is clicked, we'll save everything in it and change some things as well
        //to do this we also need lots of error checking
        JButton doneButton = new JButton("✔");
        doneButton.setBounds(150, 300, 100, 50);
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	//we get the text and check if it's valid until the right input is got
                String inputDate = editStage.getText();
                if (!isValidDate(inputDate)) {
                    JOptionPane.showMessageDialog(questionFrame, "Invalid date format. Please use yyyy-MM-dd.\n"
                    		+ "You must incorporate the '-' as well.", "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //we save everything and at the same time make sure the displays are right
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date theInput = sdf.parse(inputDate);

                    //we basically based on which edit button is clicked save and display to different locations
                    //switch makes things much shorter
                    switch (ReviewTasksGUI.taskNumber) {
                    case 1 -> {
                        FileIO.Task1.setName(editName.getText());
                        FileIO.Task1.setDate(inputDate);
                        ReviewTasksGUI.textAreas[0].setText(FileIO.Task1.getName());
                        ReviewTasksGUI.stageAreas[0].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 2 -> {
                        FileIO.Task2.setName(editName.getText());
                        FileIO.Task2.setDate(inputDate);
                        ReviewTasksGUI.textAreas[1].setText(FileIO.Task2.getName());
                        ReviewTasksGUI.stageAreas[1].setText(sdf.format(theInput));
                        FileIO.SaveAndRead();
                    }
                    case 3 -> {
                        FileIO.Task3.setName(editName.getText());
                        FileIO.Task3.setDate(inputDate);
                        ReviewTasksGUI.textAreas[2].setText(FileIO.Task3.getName());
                        ReviewTasksGUI.stageAreas[2].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 4 -> {
                        FileIO.Task4.setName(editName.getText());
                        FileIO.Task4.setDate(inputDate);
                        ReviewTasksGUI.textAreas[3].setText(FileIO.Task4.getName());
                        ReviewTasksGUI.stageAreas[3].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 5 -> {
                        FileIO.Task5.setName(editName.getText());
                        FileIO.Task5.setDate(inputDate);
                        ReviewTasksGUI.textAreas[4].setText(FileIO.Task5.getName());
                        ReviewTasksGUI.stageAreas[4].setText(sdf.format(theInput));
                        FileIO.SaveAndRead();
                    }
                    case 6 -> {
                        FileIO.Task6.setName(editName.getText());
                        FileIO.Task6.setDate(inputDate);
                        ReviewTasksGUI.textAreas[5].setText(FileIO.Task6.getName());
                        ReviewTasksGUI.stageAreas[5].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 7 -> {
                        FileIO.Task7.setName(editName.getText());
                        FileIO.Task7.setDate(inputDate);
                        ReviewTasksGUI.textAreas[6].setText(FileIO.Task7.getName());
                        ReviewTasksGUI.stageAreas[6].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 8 -> {
                        FileIO.Task8.setName(editName.getText());
                        FileIO.Task8.setDate(inputDate);
                        ReviewTasksGUI.textAreas[7].setText(FileIO.Task8.getName());
                        ReviewTasksGUI.stageAreas[7].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 9 -> {
                        FileIO.Task9.setName(editName.getText());
                        FileIO.Task9.setDate(inputDate);
                        ReviewTasksGUI.textAreas[8].setText(FileIO.Task9.getName());
                        ReviewTasksGUI.stageAreas[8].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 10 -> {
                        FileIO.Task10.setName(editName.getText());
                        FileIO.Task10.setDate(inputDate);
                        ReviewTasksGUI.textAreas[9].setText(FileIO.Task10.getName());
                        ReviewTasksGUI.stageAreas[9].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 11 -> {
                        FileIO.Task11.setName(editName.getText());
                        FileIO.Task11.setDate(inputDate);
                        ReviewTasksGUI.textAreas[10].setText(FileIO.Task11.getName());
                        ReviewTasksGUI.stageAreas[10].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 12 -> {
                        FileIO.Task12.setName(editName.getText());
                        FileIO.Task12.setDate(inputDate);
                        ReviewTasksGUI.textAreas[11].setText(FileIO.Task12.getName());
                        ReviewTasksGUI.stageAreas[11].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 13 -> {
                        FileIO.Task13.setName(editName.getText());
                        FileIO.Task13.setDate(inputDate);
                        ReviewTasksGUI.textAreas[12].setText(FileIO.Task13.getName());
                        ReviewTasksGUI.stageAreas[12].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 14 -> {
                        FileIO.Task14.setName(editName.getText());
                        FileIO.Task14.setDate(inputDate);
                        ReviewTasksGUI.textAreas[13].setText(FileIO.Task14.getName());
                        ReviewTasksGUI.stageAreas[13].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 15 -> {
                        FileIO.Task15.setName(editName.getText());
                        FileIO.Task15.setDate(inputDate);
                        ReviewTasksGUI.textAreas[14].setText(FileIO.Task15.getName());
                        ReviewTasksGUI.stageAreas[14].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 16 -> {
                        FileIO.Task16.setName(editName.getText());
                        FileIO.Task16.setDate(inputDate);
                        ReviewTasksGUI.textAreas[15].setText(FileIO.Task16.getName());
                        ReviewTasksGUI.stageAreas[15].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 17 -> {
                        FileIO.Task17.setName(editName.getText());
                        FileIO.Task17.setDate(inputDate);
                        ReviewTasksGUI.textAreas[16].setText(FileIO.Task17.getName());
                        ReviewTasksGUI.stageAreas[16].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 18 -> {
                        FileIO.Task18.setName(editName.getText());
                        FileIO.Task18.setDate(inputDate);
                        ReviewTasksGUI.textAreas[17].setText(FileIO.Task18.getName());
                        ReviewTasksGUI.stageAreas[17].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 19 -> {
                        FileIO.Task19.setName(editName.getText());
                        FileIO.Task19.setDate(inputDate);
                        ReviewTasksGUI.textAreas[18].setText(FileIO.Task19.getName());
                        ReviewTasksGUI.stageAreas[18].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                    case 20 -> {
                        FileIO.Task20.setName(editName.getText());
                        FileIO.Task20.setDate(inputDate);
                        ReviewTasksGUI.textAreas[19].setText(FileIO.Task20.getName());
                        ReviewTasksGUI.stageAreas[19].setText(sdf.format(theInput)); 
                        FileIO.SaveAndRead();
                    }
                }
                    //this is also VERY IMPORTANT because this updates the NAMES and the STATE of the task
                    HomeGUI.updateReviewTaskButtons();
                    
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                //get out of this popup
                questionFrame.setVisible(false);
            }

        });

        questionFrame.add(timeLabel);
        questionFrame.add(nameLabel);
        questionFrame.add(editStage);
        questionFrame.add(editName);
        questionFrame.add(doneButton);
    }

    //this is basically to check if the date can be used called above
    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // This ensures strict date format checking
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
