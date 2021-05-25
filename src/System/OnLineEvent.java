import java.time.LocalTime;



public class OnLineEvent extends Bavard{
  protected LocalTime date;

  public OnLineEvent(Object source){
    this.date = LocalTime.now();
  }


  public LocalTime getDate(){
    return date;
  }
}