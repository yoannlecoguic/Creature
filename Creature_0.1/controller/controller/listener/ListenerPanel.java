package controller.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ListenerPanel extends JPanel implements FreeFolk, MouseListener{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private String eventID;
		private NightWatcher nightWatcher;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public ListenerPanel(){
			//Initialization
			this.eventID = "undefined";
			
			//Add listener
			this.addMouseListener(this);
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		public String getEventID(){
			return this.eventID;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setEventID(String eventID){
			this.eventID = eventID;
		}
	//END SETTER
//---------------------------------------------------------------------------
	//OBSERVATOR GESTION
		public NightWatcher getWatcher() {
			return this.nightWatcher;
		}
		
		public void setWatcher(NightWatcher watcher){
			this.nightWatcher = watcher;
		}
		
		public void updateWatcher(String eventType, String event){
			this.nightWatcher.receiveEvent(this.eventID, eventType, event);
		}
	//END OBSERVATOR GESTION
//---------------------------------------------------------------------------
	//EVENT LISTENER
		//MOUSE LISTENER
			@Override
			public void mouseClicked(MouseEvent arg0) {
				this.updateWatcher("mouse", "click");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//this.updateWatcher("mouse", "enter");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				//this.updateWatcher("mouse", "exit");
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				//this.updateWatcher("mouse", "press");
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//this.updateWatcher("mouse", "release");
			}
		//END MOUSE LISTENER
	//END EVENT LISTENER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------		
}
