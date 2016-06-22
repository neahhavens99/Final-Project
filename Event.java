import java.time.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Event {
   // instance fields
   private String category;
   private LocalTime startTime;
   private LocalTime endTime;
   private LocalDate date;
   private String title;
   
   // constructors
   public Event() {
      this("To Be Determined");
   }
   public Event(String title) {
      this(title, LocalTime.of(7,00), LocalTime.of(8,00),  LocalDate.now(), "");
   }
   public Event(String title, LocalTime startTime, LocalTime endTime, LocalDate date, String category) {
      this.title = title;
      this.startTime = startTime;
      this.endTime = endTime;
      this.date = date;
      this.category = category;
   }
   
   // instance methods
   public String getTitle() {
      return title;
   }
   public LocalTime startTime() {
      return startTime;
   }
   public LocalTime endTime() {
      return endTime;
   }
   public LocalDate date() {
      return date;
   }
   public String category() {
      return category;
   }
}