package view.team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import model.gameObject.CreatureReal;
import view.customObject.BackgroundPanel;
import view.customObject.CustomButton;
import controller.listener.NightWatcher;

public class TeamButton extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private String eventID = "friendBar";
	
		//VIEW OBJECT
			private CustomButton image;
		
			private JLabel name;
			private JLabel lvl;
			
			private JLabel label_pv;
			private JProgressBar pv;
			private JLabel label_pe;
			private JProgressBar pe;
			
			private JProgressBar xp;
		//END VIEW OBJECT
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public TeamButton(Dimension resolution, Dimension position, NightWatcher watcher){
			this.setEventID("fight/menu");
			this.setWatcher(watcher);
			
			//SET SIZE AND POSITION
				this.setEventID(this.eventID);
				this.setSize(320,120);
				this.setImageSize(320,120);
				this.setPosition(position.width, position.height);
				
			//SET GRAPHICS OPTIONS
				this.setBorder(BorderFactory.createLineBorder(Color.black));
	
			//CREATE COMPONENT
				this.image = new CustomButton(new Dimension(80,80), new Dimension(5,5));
				this.name = new JLabel();
				this.lvl = new JLabel();
				
				this.label_pv = new JLabel("PV");
				this.pv = new JProgressBar();
				this.label_pe = new JLabel("PE");
				this.pe = new JProgressBar();
				
				this.xp = new JProgressBar();
			
			//SET COMPONENT SIZE AND POSITION
				//SET IMAGE
					this.image.setBackground(Color.blue);
				
				//SET BIG FONT
					Font font = new Font("Arial", Font.TRUETYPE_FONT, 12);
				
				//SET LABEL NAME
					this.name.setBounds(95, 3, 60, 15);
					this.name.setFont(font);
					
				//SET LABEL LVL
					this.lvl.setBounds(260, 3, 50, 15);
					this.lvl.setFont(font);
				
				//SET SMALL FONT
					font = new Font("Arial", Font.TRUETYPE_FONT, 9);
				
				//SET PV BAR
					this.label_pv.setBounds(95, 25, 70, 15);
					this.label_pv.setFont(font);
				
					this.pv.setStringPainted(true);
					this.pv.setBounds(120, 25, 180, 15);
					this.pv.setFont(font);
				
				//SET PE BAR
					this.label_pe.setBounds(95, 45, 70, 15);
					this.label_pe.setFont(font);
				
					this.pe.setStringPainted(true);
					this.pe.setBounds(120, 45, 180, 14);
					this.pe.setFont(font);
				
					this.xp.setStringPainted(true);	
					this.xp.setBounds(5, 92, 310, 18);
					this.xp.setFont(font);
					
			//ADD NIGHTWATCHER
				this.image.setWatcher(this.getWatcher());
				//this.name.setWatcher(this.getWatcher());
				//this.lvl.setWatcher(this.getWatcher());
				//this.label_pv.setWatcher(this.getWatcher());
				//this.pv.setWatcher(this.getWatcher());
				//this.label_pe.setWatcher(this.getWatcher());
				//this.pe.setWatcher(this.getWatcher());
				//this.xp.setWatcher(this.getWatcher());
			
			//SET EVENT ID 
				this.image.setEventID("image_team");
			
			//ADD COMPONENTS TO THE PANEL
				this.add(this.image);
				this.add(this.name);
				this.add(this.lvl);
				
				this.add(this.label_pv);
				this.add(this.pv);
				this.add(this.label_pe);
				this.add(this.pe);
				
				this.add(this.xp);
				
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
			
			this.xp.setMinimum(0);
			this.xp.setMaximum(creature.getNextXP()-creature.getPreviousXP());
			this.xp.setValue(creature.getXP()-creature.getPreviousXP());
			this.xp.setString(creature.getXP()+"/"+creature.getNextXP());
		}
		
		public void setUndefined(){
			this.image.setVisible(false);
			this.name.setVisible(false);
			this.lvl.setVisible(false);
			this.label_pv.setVisible(false);
			this.pv.setVisible(false);
			this.label_pe.setVisible(false);
			this.pe.setVisible(false);
			this.xp.setVisible(false);
		}
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
