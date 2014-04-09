package view.fight;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import controller.listener.NightWatcher;
import model.gameObject.Skill;
import view.customObject.BackgroundPanel;
import view.customObject.CustomButton;

public class FightSkill extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private Skill skill_tl;
		private Skill skill_tr;
		private Skill skill_bl;
		private Skill skill_br;
	
		//VIEW OBJECTS
			private CustomButton top_left;
			private CustomButton top_right;
			private CustomButton bot_left;
			private CustomButton bot_right;
		//END VIEW OBJECTS
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public FightSkill(Dimension resolution, NightWatcher watcher, ArrayList<Skill> skill){
			this.setEventID("fight/skill");
			this.setWatcher(watcher);
			
			//SET SIZE AND POSITION
			this.setSize(350,120);
			this.setPosition(0, resolution.height-this.getPanelSize().height-28);
			this.setImageSize(350,120);
			this.setImagePosition(0,0);
		
			//SET GRAPHICS OPTIONS
				this.setImage("bg_help.png");
				this.setOpaque(false);
				
			//SAVE REFERENCE OF THE OBJECT CORRESPONDING TO THE BUTTON
				this.skill_tl = skill.get(0);
				this.skill_tr = skill.get(1);
				this.skill_bl = skill.get(2);
				this.skill_br = skill.get(3);
			
			//CREATE COMPONENT WITH SIZE AND POSITION
				this.top_left = new CustomButton(new Dimension(110,20), new Dimension(45,40));
				this.top_right = new CustomButton(new Dimension(110,20), new Dimension(160,40));
				this.bot_left = new CustomButton(new Dimension(110,20), new Dimension(45,65));
				this.bot_right = new CustomButton(new Dimension(110,20), new Dimension(160,65));
				
			//SET COMPONENT GRAPHICS
				this.top_left.setOpaque(false);
				this.top_right.setOpaque(false);
				this.bot_left.setOpaque(false);
				this.bot_right.setOpaque(false);
				
				this.top_left.getLabel().setForeground(new Color(17,204,211));
				this.top_right.getLabel().setForeground(new Color(17,204,211));
				this.bot_left.getLabel().setForeground(new Color(17,204,211));
				this.bot_right.getLabel().setForeground(new Color(17,204,211));
			
			//SET VALUES COMPONENT
				this.top_left.setText(this.skill_tl.getName());
				this.top_right.setText(this.skill_tr.getName());
				this.bot_left.setText(this.skill_bl.getName());
				this.bot_right.setText(this.skill_br.getName());
				
			//SET NIGHTWATCHER
				this.top_left.setWatcher(this.getWatcher());
				this.top_right.setWatcher(this.getWatcher());
				this.bot_left.setWatcher(this.getWatcher());
				this.bot_right.setWatcher(this.getWatcher());
				
			//SET COMPONENT EVENT ID
				this.top_left.setEventID("skill_1");
				this.top_right.setEventID("skill_2");
				this.bot_left.setEventID("skill_3");
				this.bot_right.setEventID("skill_4");
			
			//ADD COMPONENTS TO THE PANEL
				this.add(this.top_left);
				this.add(this.top_right);
				this.add(this.bot_left);
				this.add(this.bot_right);
			
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