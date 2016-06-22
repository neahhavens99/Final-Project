/*
Calendar.java
Assignment: Final Project
@version: 06/21/16
@author: Neah Havens

*/

import java.util.*;
import java.io.*;
import java.awt.*;
import java.time.*;

public class Calendar {



   public static void main(String[] args)throws FileNotFoundException {
  	Scanner console = new Scanner (System.in);
  	ArrayList<Event> events = new ArrayList<Event>();
  	events.add(createEvent(console));
  	String userInput = console.next();
  	File input = new File (userInput);
 	 
 	 
  	DrawingPanel panel = new DrawingPanel (630, 450); 	 
  	Graphics g = panel.getGraphics();
  	g.setColor(Color.PINK);  	 
  	graphics(console, g, panel, events);
  	output(console, g, panel, events);
   }	 

   //prints text necessary for product
   public static Event createEvent(Scanner console) {
  	System.out.println("Hello! Welcome to Calendar for Students!");
  	System.out.println("Would you like to add an event or item? (yes or no)");
  	String response = console.nextLine();
  	boolean reply = false;
  	String eventTitle = "";
  	LocalTime eventStart = LocalTime.of(0,00);
  	LocalTime eventEnd = LocalTime.of(0,00);
  	LocalDate eventDate = LocalDate.of(1,1,1);
 	 
  	String eventCategory = "";
 	 
 	 
  	if(response.equals("yes")) {
     	reply = true;
    	 
  	}   
  	else if(!response.equals("yes")) {
     	reply = false;
  	}
  	if(reply == true) {
     	System.out.println("Please type the title of the event you would like to add.");
     	eventTitle = console.nextLine();
     	System.out.println("What time will you start " + eventTitle + "?");
     	System.out.println("The hour?");
     	int hour = console.nextInt();
     	System.out.println("The minute?");
     	int minute = console.nextInt();
     	eventStart = LocalTime.of(hour, minute);
     	System.out.println("What time will you end " + eventTitle + "?");
     	System.out.println("The hour?");
     	int endHour = console.nextInt();
     	System.out.println("The minute?");
     	int endMinute = console.nextInt();
     	eventEnd = LocalTime.of(endHour, endMinute);
     	System.out.println("What is the date of " + eventTitle + "?");
     	System.out.println("The day?");
     	int eventDay = console.nextInt();
     	System.out.println("The month?");
     	int eventMonth = console.nextInt();
     	System.out.println("The year?");
     	int eventYear = console.nextInt();  
     	eventDate = LocalDate.of(eventYear, eventMonth, eventDay);
     	System.out.println("Please type the category of " + eventTitle);
     	eventCategory = console.next();
 	 
 	 
 	 
 	 
  	}
  	System.out.println("What day in May 2016 would you like to add an event to? (1 - 31)");
  	String dayOfMonth = "";
  	int day = console.nextInt();
  	if((day == 1) || (day == 8) || (day == 15) || (day == 22) || (day == 29)) {
     	dayOfMonth = "Sunday";
  	}
  	else if((day == 2) || (day == 9) || (day == 16) || (day == 23) || (day == 30)) {
     	dayOfMonth = "Monday";
  	}
  	else if((day == 3) || (day == 10) || (day == 17) || (day == 24) || (day == 31)) {
     	dayOfMonth = "Tuesday";
  	}
  	else if((day == 4) || (day == 11) || (day == 18) || (day == 25)) {
     	dayOfMonth = "Wednesday";
  	}
  	else if((day == 5) || (day == 12) || (day == 19) || (day == 26)) {
     	dayOfMonth = "Thursday";
  	}
  	else if((day == 6) || (day == 13) || (day == 20) || (day == 27)) {
     	dayOfMonth = "Friday";
  	}
  	else if((day == 7) || (day == 14) || (day == 21) || (day == 28)) {
     	dayOfMonth = "Saturday";
  	}
  	else if((day > 31)) {
     	dayOfMonth = "That day is not available in May 2016.";
  	}
 	 
   
  	Event event = new Event(eventTitle, eventStart, eventEnd, eventDate, eventCategory);
   
 	 
 	 
  	return event;
 	 
   }
   //sets up the graphical output (the calendar)
   public static void graphics (Scanner console, Graphics g, DrawingPanel panel, ArrayList events) {
  	g.setColor(Color.BLACK);
  	g.drawLine(0, 20, 700, 20);
  	for(int i = 0; i <= 700; i+=90) {
     	g.drawLine(0, i + 90 , 700 , i + 90);
     	g.drawLine(i + 90, 0, i + 90, 700);
 	 
 	 
  	}
   
  	int date = 1;
  	int startingY = 20;
  	int height = 90;
  	int rows = 5;
  	int startingX = 10;
  	int width = 90;
  	int columns = 7;
	 
  	for (int y = startingY; y <= height * rows - 1 + startingY  ; y+=height) {
     	for(int x = startingX; x <= width * columns - 1 + startingX; x+=width) {
       	 
        	String num = date + ""; 
        	if(date < 32) {
           	g.drawString(num, x, y);
           	date += 1;
        	}
     	}
   	 
  	}
   
	 
  	g.drawString("Sunday", 0, 10);
  	g.drawString("Monday", 100, 10);
  	g.drawString("Tuesday", 200, 10);
  	g.drawString("Wednesday", 300, 10);
  	g.drawString("Thursday", 400, 10);
  	g.drawString("Friday", 480, 10);
  	g.drawString("Saturday", 580, 10);
   
   }
   //takes the user and input and prints it into a separate file. 
   public static void output (Scanner console,Graphics g, DrawingPanel panel, ArrayList events) throws FileNotFoundException{
  	Event z = (Event) events.get(0);
  	Event b = (Event) events.get(1);
  	String x = z.getTitle();
  	String a = b.startTime().toString();    
  	while(console.hasNext()) {
     	FileWriter fw = null;
     	BufferedWriter bw = null;
     	PrintWriter out = null;
     	try{
      	fw = new FileWriter("outfilename", true);
      	bw = new BufferedWriter(fw);
      	out = new PrintWriter(bw);
        	out.print(a);
         out.print(x);
        	out.close();
     	}
     	catch (IOException e) {
     	}
     	finally {

             	if(out != null)
                 	out.close();

         	try {
             	if(bw != null)
                 	bw.close();
         	} catch (IOException e) {
         	}
         	try {
             	if(fw != null)
                 	fw.close();
         	} catch (IOException e) {
         	}
     	}
     	System.out.println(LocalTime.parse(a));  	
       
     	g.drawString(x, 20, 50);
                	 
     	for(int i = 0; i <= events.size(); i++) {
    	 
    	 
     	}
  	}
   }
}


 
   
  	 




