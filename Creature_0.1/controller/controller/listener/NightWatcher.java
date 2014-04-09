package controller.listener;


public interface NightWatcher {
	public void receiveEvent(String eventID, String eventType, String event);
}
