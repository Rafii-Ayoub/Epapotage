


import java.time.LocalTime;


public class OffLineEvent {
  protected LocalTime date;

  public OffLineEvent(Object source){
    this.date = LocalTime.now();
  }


  public LocalTime getDate(){
    return date;
  }
}