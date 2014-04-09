package view.fight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import controller.listener.NightWatcher;
import model.gameObject.CreatureReal;
import view.customObject.BackgroundPanel;

public class FightFoeBar extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		//VIEW OBJECT
			private JLabel name;
			private JLabel lvl;
			
			private JLabel label_pv;
			private JProgressBar pv;
		//END VIEW OBJECT
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public FightFoeBar(Dimension resolution, NightWatcher watcher){
			this.setEventID("fight/foeBar");
			this.setWatcher(watcher);
			
			//SET SIZE AND POSITION
				this.setSize(280,36);
				this.setImageSize(280,36);
				this.setPosition(5, 15);
				
			//SET GRAPHICS OPTIONS
				this.setBorder(BorderFactory.createLineBorder(Color.black));
	
			//CREATE COMPONENT
				this.name = new JLabel();
				this.lvl = new JLabel();
				
				this.label_pv = new JLabel("PV");
				this.pv = new JProgressBar();
			
			//SET COMPONENT SIZE AND POSITION
				//SET BIG FONT
				Font font = new Font("Arial", Font.TRUETYPE_FONT, 12);
				
				//SET LABEL NAME
				this.name.setBounds(5, 3, 60, 15);
				this.name.setFont(font);
				//SET LABEL LVL
				this.lvl.setBounds(5, 17, 50, 15);
				this.lvl.setFont(font);
				
				//SET SMALL FONT
				font = new Font("Arial", Font.TRUETYPE_FONT, 9);
				
				//SET PV BAR
				this.label_pv.setBounds(253, 4, 70, 15);
				this.label_pv.setFont(font);
				
				this.pv.setMinimum(0);
				this.pv.setStringPainted(true);
				this.pv.setBounds(100, 5, 150, 12);
				this.pv.setFont(font);
				
			//ADD COMPONENTS TO THE PANEL
				this.add(this.name);
				this.add(this.lvl);
				
				this.add(this.label_pv);
				this.add(this.pv);
				
			this.paint();
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------		
	//GETTER
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setValue(CreatureReal creature){
			//SET COMPONENT VALUE
			this.name.setText(creature.getName());
			this.lvl.setText("LVL"+creature.getLevel());
			
			this.pv.setMinimum(0);
			this.pv.setMaximum(creature.getMaxPV());
			this.pv.setValue(creature.getPV());
			this.pv.setString(creature.getPV()+"/"+creature.getMaxPV());
		}
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
