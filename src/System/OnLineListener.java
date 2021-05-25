
public interface OnLineListener {
  public void turnCapteurOn();

  public void iAmConnected();

  public OnLineEvent getConnectionEvent();

  public void notificateConnection(Bavard bavard);

  public void notifyMe();
}
