package controller.listener;

public interface FreeFolk {
	public NightWatcher getWatcher();
	public void setWatcher(NightWatcher watcher);
	public void updateWatcher(String eventType, String event);
}
