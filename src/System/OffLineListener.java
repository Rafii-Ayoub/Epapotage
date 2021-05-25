
public interface OffLineListener{

  public void turnCapteurOff();

  public OffLineEvent getLogOutEvent();

  public void setLogOutEvent();

  public void logOutNotification(Bavard b);
}