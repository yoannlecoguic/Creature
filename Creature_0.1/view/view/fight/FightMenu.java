package view.fight;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import controller.listener.NightWatcher;
import view.customObject.BackgroundPanel;
import view.customObject.CustomButton;


public class FightMenu extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		//VIEW OBJECT
			private CustomButton attaquer;
			private CustomButton creature;
			private CustomButton objet;
			private CustomButton fuir;
		//END VIEW OBJECT
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public FightMenu(Dimension resolution, NightWatcher watcher){
			this.setEventID("fight/menu");
			this.setWatcher(watcher);
			
			//SET SIZE AND POSITION
				this.setSize(290,120);
				this.setImageSize(290,120);
				this.setPosition(resolution.width -this.getPanelSize().width-2, resolution.height-this.getPanelSize().height-28);
			
			//SET GRAPHICS OPTIONS
				this.setImage("bg_menu.png");
				this.setOpaque(false);
			
			//CREATE COMPONENT WITH SIZE AND POSITION
				this.attaquer = new CustomButton(new Dimension(110,25), new Dimension(15,15));
				this.creature = new CustomButton(new Dimension(110,25), new Dimension(130,15));
				this.objet = new CustomButton(new Dimension(110,25), new Dimension(15,45));
				this.fuir = new CustomButton(new Dimension(110,25), new Dimension(130,45));
				
			//SET GRAPHIC COMPONENT
				this.attaquer.setOpaque(false);
				this.creature.setOpaque(false);
				this.objet.setOpaque(false);
				this.fuir.setOpaque(false);
				
				this.attaquer.setImage("button_menu.png");
				this.creature.setImage("button_menu.png");
				this.objet.setImage("button_menu.png");
				this.fuir.setImage("button_menu.png");
		
			//SET VALUE COMPONENT
				this.attaquer.setText("ATTAQUER");
				this.creature.setText("CREATURE");
				this.objet.setText("OBJET");
				this.fuir.setText("FUIR");
			
			//SET NIGHTWATCHER
				this.attaquer.setWatcher(this.getWatcher());
				this.creature.setWatcher(this.getWatcher());
				this.objet.setWatcher(this.getWatcher());
				this.fuir.setWatcher(this.getWatcher());
				
			//SET COMPONENT EVENT ID
				this.attaquer.setEventID("attaquer");
				this.creature.setEventID("creature");
				this.objet.setEventID("objet");
				this.fuir.setEventID("fuir");
			
			//ADD COMPONENTS TO THE PANEL
				this.add(this.attaquer);
				this.add(this.creature);
				this.add(this.objet);
				this.add(this.fuir);
			
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