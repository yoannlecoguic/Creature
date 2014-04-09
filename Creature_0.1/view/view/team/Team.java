package view.team;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import model.gameObject.CreatureReal;
import view.customObject.BackgroundPanel;
import controller.listener.NightWatcher;

public class Team extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private CreatureReal first_creature;
		private CreatureReal second_creature;
		private CreatureReal third_creature;
	
		//VIEW OBJECTS
			private TeamButton first;
			private TeamButton second;
			private TeamButton third;
		//END VIEW OBJECTS
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public Team(Dimension resolution, NightWatcher watcher, ArrayList<CreatureReal> creature){
			this.setEventID("team");
			this.setWatcher(watcher);
			
			//SET SIZE AND POSITION
				this.setSize(resolution.width, resolution.height);
				this.setPosition(0, 0);
				this.setImageSize(resolution.width,resolution.height);
				this.setImagePosition(0,0);
		
			//SET GRAPHICS OPTIONS
				
			//SAVE REFERENCE OF THE OBJECT CORRESPONDING TO THE BUTTON
				this.first_creature = creature.get(0);
				this.second_creature = creature.get(1);
				this.third_creature = creature.get(2);
				
			//CREATE COMPONENT
				this.first = new TeamButton(resolution, new Dimension(40,20), watcher);
				this.second = new TeamButton(resolution, new Dimension(40,150), watcher);
				this.third = new TeamButton(resolution, new Dimension(40,280), watcher);
				
			//SET COMPONENT POSITION
				this.first.setPosition(0,0);
				this.second.setPosition(170,50);
				this.third.setPosition(280,150);
				
			//SET GRAPHIC COMPONENT
				this.first.setOpaque(false);
				this.second.setOpaque(false);
				this.third.setOpaque(false);
				
			//SET VALUE
				this.first.setValue(this.first_creature);
				this.second.setValue(this.second_creature);
				this.third.setValue(this.third_creature);
			
			//CHANGE IF CREATURE ARE UNDEFINED
				if(this.second_creature.getID().equals("0")){
					this.second.setUndefined();
				}
				if(this.third_creature.getID().equals("0")){
					this.third.setUndefined();
				}
				
			//SET NIGHTWATCHER
				this.first.setWatcher(this.getWatcher());
				this.second.setWatcher(this.getWatcher());
				this.third.setWatcher(this.getWatcher());
				
			//SET COMPONENT EVENT ID
				this.first.setEventID("team_1");
				this.second.setEventID("team_2");
				this.third.setEventID("team_3");
			
			//ADD COMPONENTS TO THE PANEL
				this.add(this.first);
				this.add(this.second);
				this.add(this.third);
			
			this.paint();
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------		
	//GETTER
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}