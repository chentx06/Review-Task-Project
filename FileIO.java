package ICS3USummativeProjectCopy4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileIO {

	//for storing based on user input
	static String[] reviewTaskName = new String[20];
	static String[] reviewTaskDate = new String[20];
	
//	//this is for getting stored info
//	static String[] takeName = new String[3];
//	static String[] takeDate = new String[3];

	//these are static to be accessed on other places
	public static ReviewTask Task1;
	public static ReviewTask Task2;
	public static ReviewTask Task3;
	public static ReviewTask Task4;
	public static ReviewTask Task5;
	public static ReviewTask Task6;
	public static ReviewTask Task7;
	public static ReviewTask Task8;
	public static ReviewTask Task9;
	public static ReviewTask Task10;
	public static ReviewTask Task11;
	public static ReviewTask Task12;
	public static ReviewTask Task13;
	public static ReviewTask Task14;
	public static ReviewTask Task15;
	public static ReviewTask Task16;
	public static ReviewTask Task17;
	public static ReviewTask Task18;
	public static ReviewTask Task19;
	public static ReviewTask Task20;
	
	
	//I'm tempoprarily commenting this because I'm creating objects in the ReviewTasksPopupNow
	//every time an object is created, it's doing the saving and reading
	//this keeps our reading updated!
	
	public static void objectCreation() {
		//System.out.println("At object creation");
		Task1 = new ReviewTask();
//		Task1.stageIncreaseBy(2);
		//System.out.println(Task1.getStage());
		//do save to the present object
		SaveAndRead();
		
		Task2 = new ReviewTask("Lala2");
//		Task2.stageIncreaseBy(3);
		//System.out.println(Task2.getStage());
		//more saving
		SaveAndRead();
		
		Task3 = new ReviewTask("Bam3");
//		Task3.stageDecreaseBy(0);
		//System.out.println(Task3.getStage());
		SaveAndRead();
		
		Task4 = new ReviewTask();
		SaveAndRead();
		
		Task5 = new ReviewTask();
		SaveAndRead();
		
		 Task6 = new ReviewTask();
		    SaveAndRead();

	    Task7 = new ReviewTask();
	    SaveAndRead();

	    Task8 = new ReviewTask();
	    SaveAndRead();

	    Task9 = new ReviewTask();
	    SaveAndRead();

	    Task10 = new ReviewTask();
	    SaveAndRead();

	    Task11 = new ReviewTask();
	    SaveAndRead();

	    Task12 = new ReviewTask();
	    SaveAndRead();

	    Task13 = new ReviewTask();
	    SaveAndRead();

	    Task14 = new ReviewTask();
	    SaveAndRead();

	    Task15 = new ReviewTask();
	    SaveAndRead();

	    Task16 = new ReviewTask();
	    SaveAndRead();

	    Task17 = new ReviewTask();
	    SaveAndRead();

	    Task18 = new ReviewTask();
	    SaveAndRead();

	    Task19 = new ReviewTask();
	    SaveAndRead();

	    Task20 = new ReviewTask();
	    SaveAndRead();
		
	}
	
	
	//this is for saving into the file every time
	public static void SaveAndRead() {
		
		//OHH, every time an object is created, this has to be done
		//System.out.println(ReviewTask.reviewTaskID);
		//puts the names of the objects in the array
//		switch (ReviewTask.reviewTaskID) {
//			case 1 -> {reviewTaskName[0] = Task1.getName();reviewTaskStage[0] = Task1.getStage();
//				System.out.println("WE ARE AT SAVE AND READ CASE 1 NOW");}
//			case 2 -> {reviewTaskName[1] = Task2.getName();reviewTaskStage[1] = Task2.getStage();}
//			case 3 -> {reviewTaskName[2] = Task3.getName();reviewTaskStage[2] = Task3.getStage();
//				System.out.println("WE ARE AT SAVE AND READ CASE 3 NOW");}
//		}
		
		//what happened in above code is that i am switching depending on # of objects created, so not right save
		switch (ReviewTasksGUI.taskNumber) {
        case 1 -> {
            reviewTaskName[0] = Task1.getName();
            reviewTaskDate[0] = formatDate(Task1.getDate());
        }
        case 2 -> {
            reviewTaskName[1] = Task2.getName();
            reviewTaskDate[1] = formatDate(Task2.getDate());
        }
        case 3 -> {
            reviewTaskName[2] = Task3.getName();
            reviewTaskDate[2] = formatDate(Task3.getDate());
        }
        case 4 -> {
            reviewTaskName[3] = Task4.getName();
            reviewTaskDate[3] = formatDate(Task4.getDate());
        }
        // And so on for cases 5 to 20
        case 5 -> {
            reviewTaskName[4] = Task5.getName();
            reviewTaskDate[4] = formatDate(Task5.getDate());
        }
        case 6 -> {
            reviewTaskName[5] = Task6.getName();
            reviewTaskDate[5] = formatDate(Task6.getDate());
        }
        case 7 -> {
            reviewTaskName[6] = Task7.getName();
            reviewTaskDate[6] = formatDate(Task7.getDate());
        }
        case 8 -> {
            reviewTaskName[7] = Task8.getName();
            reviewTaskDate[7] = formatDate(Task8.getDate());
        }
        case 9 -> {
            reviewTaskName[8] = Task9.getName();
            reviewTaskDate[8] = formatDate(Task9.getDate());
        }
        case 10 -> {
            reviewTaskName[9] = Task10.getName();
            reviewTaskDate[9] = formatDate(Task10.getDate());
        }
        case 11 -> {
            reviewTaskName[10] = Task11.getName();
            reviewTaskDate[10] = formatDate(Task11.getDate());
        }
        case 12 -> {
            reviewTaskName[11] = Task12.getName();
            reviewTaskDate[11] = formatDate(Task12.getDate());
        }
        case 13 -> {
            reviewTaskName[12] = Task13.getName();
            reviewTaskDate[12] = formatDate(Task13.getDate());
        }
        case 14 -> {
            reviewTaskName[13] = Task14.getName();
            reviewTaskDate[13] = formatDate(Task14.getDate());
        }
        case 15 -> {
            reviewTaskName[14] = Task15.getName();
            reviewTaskDate[14] = formatDate(Task15.getDate());
        }
        case 16 -> {
            reviewTaskName[15] = Task16.getName();
            reviewTaskDate[15] = formatDate(Task16.getDate());
        }
        case 17 -> {
            reviewTaskName[16] = Task17.getName();
            reviewTaskDate[16] = formatDate(Task17.getDate());
        }
        case 18 -> {
            reviewTaskName[17] = Task18.getName();
            reviewTaskDate[17] = formatDate(Task18.getDate());
        }
        case 19 -> {
            reviewTaskName[18] = Task19.getName();
            reviewTaskDate[18] = formatDate(Task19.getDate());
        }
        case 20 -> {
            reviewTaskName[19] = Task20.getName();
            reviewTaskDate[19] = formatDate(Task20.getDate());
        }
	}
		
		//now store write to permanently store the info, and accessing the info
		try {
			//printing the tasks names and Dates one by one
            FileWriter fw = new FileWriter("C:\\Users\\chentx06\\Desktop\\JavaFile\\review_tasks.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0;i<reviewTaskName.length;i++) {
                pw.println(reviewTaskName[i]+","+ reviewTaskDate[i]);
            }

            pw.close();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
        try {
        	//reads the tasks in every line
            FileReader fr = new FileReader("C:\\Users\\chentx06\\Desktop\\JavaFile\\review_tasks.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            for (int index = 0; index < reviewTaskName.length; index ++)
            {
                line = br.readLine();
                String[] output = line.split(",");
                
              //when all the objects have been created and saved
              if (ReviewTask.reviewTaskID==20) {
                System.out.println(reviewTaskName[index] + ", " + reviewTaskDate[index]);
              }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
		
        //now that I can save and read info, I need to create somewhere to use the info and change the info
        //now is the time for me to create the GUI, for getting the question input and Date, and displaying them
		//the GUI must be efficiently created using methods preferably
        
//        System.out.println(Task1.getDate());
	}	
	
	//for making sure it's in correct format
	public static String formatDate(Date aDate) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.format(aDate);
	}
	
	//to read info and put the info saved earlier into the program
	public static void retrieveInfo() {
	    try {
	        // Reads the tasks in every line
	        FileReader fr = new FileReader("C:\\Users\\chentx06\\Desktop\\JavaFile\\review_tasks.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        for (int index = 0; index < reviewTaskName.length; index++) {
	            line = br.readLine();
	            if (line != null) {
	                String[] output = line.split(",");
	                reviewTaskName[index] = output[0];
	                reviewTaskDate[index] = output[1];
	                System.out.println(output[0] + ", " + output[1]);
	                
	            } else {
	                reviewTaskName[index] = null;
	                reviewTaskDate[index] = null;
	            }
	        }
	        br.close();
	    } catch (IOException e) {
	        System.err.println("Error: " + e);
	    }
	}
	
	
	//thrown code
//	public static void retrieveInfo() {
//		
//		 try {
//	        	//reads the tasks in every line
//	            FileReader fr = new FileReader("C:\\Users\\chentx06\\Desktop\\JavaFile\\review_tasks.txt");
//	            BufferedReader br = new BufferedReader(fr);
//	            String line;
//	            for (int index = 0; index < reviewTaskName.length; index ++)
//	            {
//	                line = br.readLine();
//	                String[] output = line.split(",");
//	               
//	                switch (index) {
//	                case 0 ->  {
//	                	reviewTaskName[0] = output[0];
//	                	System.out.println(reviewTaskName[0]);
//	                	System.out.println(reviewTaskDate[0]);
//	                	//ReviewTasksGUI.textArea1.setText(reviewTaskName[0]);
//	                	reviewTaskDate[0] = output[1];}
//	                	//ReviewTasksGUI.stageArea1.setText(reviewTaskDate[0]);}
//	                case 1 -> {
//	                	reviewTaskName[1] = output[0];
//	                	//ReviewTasksGUI.textArea2.setText(reviewTaskName[1]);
//	                	reviewTaskDate[1] = output[1];}
//	                	//ReviewTasksGUI.stageArea2.setText(reviewTaskDate[1]);}
//	                case 2 -> {
//	                	reviewTaskName[2] = output[0];
//	                	//ReviewTasksGUI.textArea3.setText(reviewTaskName[2]);
//	                	reviewTaskDate[2] = output[1];}
//	                	//ReviewTasksGUI.stageArea3.setText(reviewTaskDate[2]);}
//	                }
//	                
//	                System.out.println(output[0]);
//	                System.out.println(output[1]);
//
//	                
//	            }
//	            br.close();
//	        } catch (IOException e) {
//	            System.err.println("Error: " + e);
//	        }
//	}

		
	}
	
