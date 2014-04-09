package view.fight;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import model.gameObject.CreatureReal;
import model.gameObject.Skill;
import view.customObject.BackgroundPanel;
import view.team.Team;

public class Fight extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
	private Dimension resolution;
	private String bg_image;
	private Color bg_color;
		//VIEW OBJECTS
			private FightSkill skill;
			private FightHelp help;
			private FightFriendBar friendBar;
			private FightFoeBar foeBar;
			private FightMenu menu;
			private Team team;
		//END VIEW OBJECTS
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public Fight(Dimension resolution){
			this.resolution = resolution;
			this.setEventID("fight");
			
			//SET POSITION AND SIZE
				this.setSize(this.resolution.width,this.resolution.height);
				this.setPosition(0,0);
			
			this.paint();
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------		
	//GETTER
		public FightHelp getHelp(){
			return this.help;
		}
		
		public FightFriendBar getFriendBar(){
			return this.friendBar;
		}
		
		public FightFoeBar getFoeBar(){
			return this.foeBar;
		}
		
		public FightMenu getMenu(){
			return this.menu;
		}
		
		public FightSkill getSkill(){
			return this.skill;
		}
		
		public Team getTeam(){
			return this.team;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
	//END SETTER
		
	//OBJECT SETTER
		public void addHelp(){
			this.help = new FightHelp(this.resolution, this.getWatcher());
			this.help.setVisible(false);
			this.add(this.help);
			this.repaint();
		}
		
		public void addFightMenu(){
			this.menu= new FightMenu(this.resolution, this.getWatcher());
			this.menu.setVisible(false);
			this.add(menu);
			this.repaint();
		}
		
		public void addFoeBar(){
			this.foeBar = new FightFoeBar(this.resolution, this.getWatcher());
			this.foeBar.setVisible(false);
			this.add(this.foeBar);
			this.repaint();
		}
		
		public void addFriendBar(){
			this.friendBar = new FightFriendBar(this.resolution, this.getWatcher());
			this.friendBar.setVisible(false);
			this.add(this.friendBar);
			this.repaint();
		}
		
		public void addSkill(ArrayList<Skill> skill){
			this.skill = new FightSkill(this.resolution, this.getWatcher(), skill);
			this.skill.setVisible(false);
			this.add(this.skill);
			this.repaint();
		}
		
		public void addTeam(ArrayList<CreatureReal> creature){
			this.team = new Team(this.resolution, this.getWatcher(), creature);
			this.team.setVisible(false);
			this.add(this.team);
			this.repaint();
		}
	//END OBJECT SETTER
//---------------------------------------------------------------------------
	//SHOW AND HIDE
		public void showSkill(){
			if(this.skill.isVisible()){
				this.skill.setVisible(false);
			}else{
				this.skill.setVisible(true);
			}
		}
	//END SHOW AND HIDE
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
