/**
* @file Clock.java
* @author Patrick Schlumberger Socha
* @date 26 Nov 2014
* @see
*
* @Brief Keeps track of time during game play
* *
*/
package A3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {

	private long time; //These make no sense as static
	private long gameTime;
	private static final long HOUR = 3600000;

	/**
	* Sets the starting time of the program
	* @see getStartTime()
	* @see getCurrentTime()
	* @return null
	*/
	public void setStartTime(){
		time = System.currentTimeMillis();
	}

	/**
	* Gets the starting time of the program
	* @see setStartTime()
	* @return time
	*/
	public long getStartTime(){
		return time;
	}



	/**
	* Sets the starting time of the program
	* @return null
	*/
	public void setGameStartTime(){
		// Calendar calendar = Calendar.getInstance();
		// SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		gameTime = System.currentTimeMillis();
	}

	/**
	* Sets the starting time of the program
	* @return gameTime
	*/
	public long getGameStartTime(){

		return gameTime;
	}

	/**
	* Gets the current time
	* @return currentTimeMillis
	*/
	public long getCurrentTime(){
		return System.currentTimeMillis();
	}

	/**
	* Computes the programs run time
	* @return getProgramRunTime
	*/
	public String getProgramRunTime(){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		// To investigate: For some odd reason, an hour is added when subtracting the ms time. Fixed by added HOUR constant.
		return timeFormat.format(getCurrentTime() - HOUR - getStartTime()); //TODO: Find out why there is a 1 hour offset - check timezones ect.
	}

	/**
	* Computes the time since the game started
	* @return getGameTime
	*/
	public String getGameTime(){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.format(getCurrentTime() - HOUR - getGameStartTime());
	}


	 // public static void main(String[] args) {
		// Clock testObject = new Clock(); //Making everything static to refrence it from main is a terriable idea	
	 // 	// testObject.setStartTime();
	 // 	testObject.setGameStartTime();
	 // 	System.out.println("Start time " + testObject.getStartTime());
 	// 	try {
 	// 		Thread.sleep(3000);                 //1000 milliseconds is one second.
 	// 	} catch(InterruptedException ex) {
 	// 		Thread.currentThread().interrupt();
 	// 	}
	 // 	System.out.println("Current time " + testObject.getCurrentTime());
	 // 	System.out.println("Current game run time " + testObject.getGameTime());

	 // }

}

