package ICS3USummativeProjectCopy4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

//It's 6/3, all code inside this class has been tested.


public class ReviewTask {
	
	//this is for the thread
	private static int seconds;
	
	//the task will have a name, a stage it's on, the stage determines when the next time of the review is
	//the reviewTaskID is for creating a default name for the task & calculating task # we're on
	public static int reviewTaskID = 0;
	private String name;
	private Date reviewDate;
	
	
	//constructor
	public ReviewTask() {
		reviewTaskID++;
		this.name = "Task" + String.valueOf(reviewTaskID);
		Date currentDate = new Date();
		this.reviewDate = currentDate;
		//System.out.println(currentDate);
		//System.out.println("At constructor");
		
	}
	public ReviewTask(String name) {
		reviewTaskID++;
		this.name = name;
		Date currentDate = new Date();
		this.reviewDate = currentDate;
		//System.out.println(currentDate);

	}
	
	//setters
//	public void stageIncrease() { 
//		if (stage < 4){
//			this.stage++;
//		}
//	}
//	public void stageDecrease() {
//		if (stage > 1){
//			this.stage--;
//		}
//	}
//	public void stageIncreaseBy(int increaseBy) {
//		if ((stage + increaseBy) <= 4 && (stage + increaseBy) > 0){
//			stage+= increaseBy;
//			//System.out.println(this.stage);
//		}
//	}
//	public void stageDecreaseBy(int decreaseBy) {
//		if ((stage - decreaseBy) > 0 && (stage - decreaseBy) <= 4){
//			stage -= decreaseBy;
//		}
//	}
	public void setName(String newName) {
		this.name = newName;
	}
	
	//for making string a date
	   public void setDate(String dateStr) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        //strict conversions
	        sdf.setLenient(false);
	        try {
	            this.reviewDate = sdf.parse(dateStr);
	        } catch (ParseException e) {
	            System.err.println("The string couldn't be converted into a date.");
	        }
	    }
	
//	public void setDate(String theDate) {
//		
//		 if (theDate == null || theDate.isEmpty()) {
//	            System.out.println("Empty date");
//	            return;
//	        }
//	        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//	        try {
//	            this.reviewDate = sdf.parse(theDate);
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	            System.out.println("The string couldn't be converted into a date.");
//	        }
//	}
	
	//getters
	public Date getDate() {
		return reviewDate;
	}
	public String getName() {
		return name;
	}
	
	
	
	
	//toString for checking
	public String toString() {
		return this.reviewDate + ", " + this.name;
	}
	
	public void run() {
		
		try {
			for (int i = seconds; i > 0; i++) {
				//pauses the current thread for 1000 milliseconds (1 second)
				Thread.sleep(1000);
				//System.out.println(i);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	
	}

}

