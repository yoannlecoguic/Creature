package controller.state;

import controller.listener.NightWatcher;
import controller.main.Controller;

public class State implements NightWatcher{
//---------------------------------------------------------------------------
	//VARIABLE
		private Controller controller;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public State(Controller controller){
			this.controller = controller;
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		public Controller getController(){
			return this.controller;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setController(Controller controller){
			this.controller = controller;
		}
	//END SETTER
//---------------------------------------------------------------------------
	//LISTENER
		@Override
		public void receiveEvent(String eventID, String eventType, String event) {
			System.out.println(eventID+"/"+eventType+"/"+event);
		}
	//END LISTENER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------	
}
