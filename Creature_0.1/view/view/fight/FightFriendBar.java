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
import view.customObject.CustomButton;

public class FightFriendBar extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private String eventID = "friendBar";
	
		//VIEW OBJECT
			private JLabel name;
			private JLabel lvl;
			
			private JLabel label_pv;
			private JProgressBar pv;
			private JLabel label_pe;
			private JProgressBar pe;
			
			//private JProgressBar xp;
		//END VIEW OBJECT
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public FightFriendBar(Dimension resolution, NightWatcher watcher){
			this.setEventID("fight/menu");
			this.setWatcher(watcher);
			
			//SET SIZE AND POSITION
				this.setEventID(this.eventID);
				this.setSize(280,56);
				this.setImageSize(280,56);
				this.setPosition(resolution.width -this.getWidth()-293, resolution.height-this.getHeight()-230);
				
			//SET GRAPHICS OPTIONS
				this.setBorder(BorderFactory.createLineBorder(Color.black));
	
			//CREATE COMPONENT
				this.name = new JLabel();
				this.lvl = new JLabel();
				
				this.label_pv = new JLabel("PV");
				this.pv = new JProgressBar();
				this.label_pe = new JLabel("PE");
				this.pe = new JProgressBar();
				
				//this.xp = new JProgressBar();
			
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
				
				this.pv.setStringPainted(true);
				this.pv.setBounds(100, 5, 150, 12);
				this.pv.setFont(font);
				
				//SET PE BAR
				this.label_pe.setBounds(253, 18, 70, 15);
				this.label_pe.setFont(font);
				
				this.pe.setStringPainted(true);
				this.pe.setBounds(100, 19, 150, 12);
				this.pe.setFont(font);
				
				/*this.xp.setStringPainted(true);	
				this.xp.setBounds(5, 38, 270, 12);
				this.xp.setFont(font);*/
			
			//ADD COMPONENTS TO THE PANEL
				this.add(this.name);
				this.add(this.lvl);
				
				this.add(this.label_pv);
				this.add(this.pv);
				this.add(this.label_pe);
				this.add(this.pe);
				
				//this.add(this.xp);
				
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
			
			this.pe.setMinimum(0);
			this.pe.setMaximum(creature.getMaxPE());
			this.pe.setValue(creature.getPE());
			this.pe.setString(creature.getPE()+"/"+creature.getMaxPE());
			
			/*this.xp.setMinimum(0);
			this.xp.setMaximum(creature.getNextXP()-creature.getPreviousXP());
			this.xp.setValue(creature.getXP()-creature.getPreviousXP());
			this.xp.setString(creature.getXP()+"/"+creature.getNextXP());*/
		}
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
