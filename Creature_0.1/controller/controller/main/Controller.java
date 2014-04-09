package controller.main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.gameObject.CreatureRace;
import model.gameObject.CreatureReal;
import model.gameObject.Skill;
import model.gameObject.Trainer;
import model.main.Model;
import view.main.View;
import controller.listener.NightWatcher;
import controller.state.FightState;
import controller.state.State;

public class Controller implements NightWatcher, KeyListener{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		//MVC OBJECT
			private View view;
			private Model model;
		//END MVC OBJECT
		
		//VARIABLE
			private Dimension resolution = new Dimension(640,480);
			private State state;
			
			private Trainer player;
		//END VARIABLE
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public Controller(Model model, View view){
			this.model = model;
			this.view = view;
			
			this.view.setName("Creature");
			this.view.setResolution(this.resolution);
			this.view.setController(this);
			this.view.addKeyListener(this);
			
			//this.model.showCreatureRace();
			//this.model.showTrainer();
			//this.showProgressionXP();
			
			//LE JOUEUR SE CO LA
			this.player = this.model.getTrainerByID("2");
			
			this.state = new FightState(this.model.getTrainerByID("1"), this);	
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		public Model getModel(){
			return this.model;
		}
		
		public View getView(){
			return this.view;
		}
		
		public Dimension getResolution(){
			return this.resolution;
		}
		
		public State getState(){
			return this.state;
		}
		
		public Trainer getPlayer(){
			return this.player;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//LISTENER TRANSMIT IT TO THE STATE
		//MOUSE LISTENER
			@Override
			public void receiveEvent(String eventID, String eventType, String event) {
				this.state.receiveEvent(eventID, eventType, event);	
			}
		//END MOUSE LISTENER
			
		//KEYBOARD LISTENER
			@Override
			public void keyPressed(KeyEvent event) {
				this.state.receiveEvent(String.valueOf(event.getKeyCode()), "keyboard", "pressed");	
				
			}
			@Override
			public void keyReleased(KeyEvent event) {
				this.state.receiveEvent(String.valueOf(event.getKeyCode()), "keyboard", "released");	
				
			}
			@Override
			public void keyTyped(KeyEvent event) {
				this.state.receiveEvent(String.valueOf(event.getKeyCode()), "keyboard", "typed");	
			}
		//END KEYBOARD  LISTENER
	//END LISTENER
//---------------------------------------------------------------------------	
	//TEST FUNCTIONS
		public void showProgressionXP(){
			this.model.getCreatureByID("1").setXP(0);
			this.model.getCreatureByID("1").setLevel(1);
			this.model.getCreatureByID("1").setNextXP(this.model.generateLevelXP(this.model.getCreatureByID("1").getLevel()));
			
			for(int i=1;i<=100;i++){
				System.out.println("");
				System.out.println("#######################################################################");
				System.out.println("Level : "+this.model.getCreatureByID("1").getLevel());
				System.out.println("XP total : "+this.model.getCreatureByID("1").getXP());
				System.out.println("XP requis pour le niveau suivant : "+this.model.getCreatureByID("1").getNextXP());
				System.out.println("XP entre les deux niveaux : "+" xp");
				System.out.println("#######################################################################");
				System.out.println("");

				this.model.getCreatureByID("1").setXP(this.model.generateLevelXP(this.model.getCreatureByID("1").getLevel()));
				this.model.getCreatureByID("1").setLevel(this.model.generateLevel(this.model.getCreatureByID("1").getXP()));
				this.model.getCreatureByID("1").setNextXP(this.model.generateLevelXP(this.model.getCreatureByID("1").getLevel()));
			}
		}
		
		public boolean testSkill(Skill skill){
			return (!skill.getID().equals("0"));
		}
	//END TEST FUNCTIONS
//---------------------------------------------------------------------------
//SHOW INFOS
	//CREATURE RACE
		public void showCreatureRace(){
			System.out.println("###################################################");
			System.out.println("LISTE DES RACES DE CREATURES :");
			for(CreatureRace creature_race : this.model.getAllRace()){
				System.out.println("");
				System.out.println("ID = "+creature_race.getID());
				System.out.println("Name = "+creature_race.getName());
				System.out.println("Element = "+creature_race.getElement());
				creature_race.getMyStat().showInfo();
			}
			System.out.println("###################################################");
		}
	//END CREATURE RACE
	
	//CREATURE REAL
		public void showCreatureReal(){
			System.out.println("###################################################");
			System.out.println("LISTE DES CREATURES EXISTANTES DANS LE JEU :");
			for(CreatureReal creature : this.model.getAllCreature()){
				System.out.println("");
				System.out.println("ID = "+creature.getID());
				System.out.println("Name = "+creature.getName());
				System.out.println("Race = "+this.model.getRaceByID(creature.getRace()).getName());
				System.out.println("Level "+creature.getLevel());
				System.out.println("Trainer = "+this.model.getTrainerByID(creature.getTrainer()).getName());
				System.out.println("XP = "+creature.getXP()+"/"+creature.getNextXP());
				System.out.println("PV = "+creature.getPV()+"/"+creature.getMaxPV());
				System.out.println("PE = "+creature.getPE()+"/"+creature.getMaxPE());
				System.out.println("Force = "+this.model.getFOR(creature));
				System.out.println("Endurance = "+this.model.getEND(creature));
				System.out.println("Defense = "+this.model.getDEF(creature));
				System.out.println("Agilité = "+this.model.getAGI(creature));
				System.out.println("Vitesse = "+this.model.getVIT(creature));
				System.out.println("Chance = "+this.model.getCHA(creature));
				System.out.println("Intelligence = "+this.model.getINT(creature));
				System.out.println("Sagesse = "+this.model.getSAG(creature));
				System.out.println("Volonté = "+this.model.getVOL(creature));
				
				System.out.println("Ses skills :");
				for(String skill : creature.getMySkill()){	
					System.out.println("	- "+this.model.getSkillByID(skill).getName());
				}
			}
			System.out.println("###################################################");
		}
	//END CREATURE REAL
	
	//TRAINER
		public void showTrainer(){
			System.out.println("###################################################");
			System.out.println("LISTE DES DRESSEURS EXISTANTS DANS LE JEU :");
			for(Trainer trainer : this.model.getAllTrainer()){
				System.out.println("");
				System.out.println("ID = "+trainer.getID());
				System.out.println("Name = "+trainer.getName());
				System.out.println("Position(x,y) = ("+trainer.getX()+","+trainer.getY()+")");
				System.out.println("Money = "+trainer.getMoney()+" gils");
				
				System.out.println("Son équipe :");
				for(CreatureReal creature : this.model.getTrainerTeam(trainer.getID())){
					System.out.println("    -"+creature.getName());
				}
			}
			System.out.println("###################################################");
		}
	//END TRAINER
		
	//SKILL
		public void showSkill(){
			System.out.println("###################################################");
			System.out.println("LISTE DES SKILLS EXISTANTS DANS LE JEU :");
			for(Skill skill : this.model.getAllSkill()){
				System.out.println("");
				System.out.println("ID = "+skill.getID());
				System.out.println("Name = "+skill.getName());
				System.out.println("Element = "+skill.getElement());
				System.out.println("Puissance = "+skill.getPower());
				System.out.println("Precision = "+skill.getPrecision());
				System.out.println("Cout en PE = "+skill.getCostPE());
			}
			System.out.println("###################################################");
		}
	//END SKILL
//END SHOW INFOS
//---------------------------------------------------------------------------	
//---------------------------------------------------------------------------		
}
