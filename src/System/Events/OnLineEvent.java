import java.time.LocalTime;



public class OnLineEvent {
  protected LocalTime date;

  public OnLineEvent(Object source){
    this.date = LocalTime.now();
  }


  public LocalTime getDate(){
    return date;
  }
}
