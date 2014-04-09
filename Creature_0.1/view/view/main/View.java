package view.main;
import java.awt.Dimension;

import javax.swing.JFrame;

import view.fight.Fight;
import controller.listener.NightWatcher;
import controller.main.Controller;


public class View extends JFrame{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private Dimension resolution;
		private NightWatcher controller;
		//VIEW OBJECTS
			private Fight fight;
		//END VIEW OBJECTS
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public View(){
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setResizable(false);
			this.setVisible(true);
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		public Fight getFight(){
			return this.fight;
		}
		
		public NightWatcher getController(){
			return this.controller;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setName(String name){
			this.setTitle(name);
		}
		
		public void setResolution(Dimension resolution){
			this.resolution = resolution;
			this.setSize(this.resolution.width, this.resolution.height);
			this.setLocationRelativeTo(null);
		}
		
		public void setController(NightWatcher watcher){
			this.controller = watcher;
		}
	//END SETTER
//---------------------------------------------------------------------------
	//SHOW FIGHT
		public void fight(){
			this.fight = new Fight(this.resolution);
			this.fight.setWatcher(this.controller);
			this.getContentPane().add(fight);
			this.repaint();
		}
	//END SHOW FIGHT
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}