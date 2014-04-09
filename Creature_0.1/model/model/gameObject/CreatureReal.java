package model.gameObject;

import java.util.ArrayList;

import mode.customObject.LimitedArray;
import model.main.Entity;

public class CreatureReal extends Entity{
//---------------------------------------------------------------------------
	//VARIABLE
		private int level;
		private int XP;
		private int nextXP;
		private int previousXP;
		
		private int PV;
		private int maxPV;
		private int PE;
		private int maxPE;
		
		private String id_trainer;
		private String id_race;
		
		private int statut;
		
		private LimitedArray my_skill;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public CreatureReal(){ //EMPTY OBJECT CREATURE RACE
			this.XP = 0;
			
			this.PV = 0;
			this.PE=0;
			
			this.id_race = "undefined";
			this.id_race = "undefined";
			
			this.my_skill = new LimitedArray(4);
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		//INT
		public int getLevel(){
			return this.level;
		}
		
		public int getXP(){
			return this.XP;
		}
		
		public int getNextXP(){
			return this.nextXP;
		}
		
		public int getPreviousXP(){
			return this.previousXP;
		}
		
		public int getPV(){
			return this.PV;
		}
		
		public int getMaxPV(){
			return this.maxPV;
		}
		
		public int getPE(){
			return this.PE;
		}
		
		public int getMaxPE(){
			return this.maxPE;
		}
		
		public int getStatut(){
			return this.statut;
		}
		
		//STRING
		public String getTrainer(){
			return this.id_trainer;
		}
		
		public String getRace(){
			return this.id_race;
		}
		
		public String getSkill(int index){
			return this.my_skill.get(index);
		}
		
		//ARRAYLIST
		public ArrayList<String> getMySkill(){
			return this.my_skill;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		//INT
		public void setLevel(int level){
			this.level = level;
		}
		
		public void setXP(int XP){
			this.XP = XP;
		}
		
		public void setNextXP(int nextXP){
			this.nextXP = nextXP;
		}
		
		public void setPreviousXP(int previousXP){
			this.previousXP = previousXP;
		}
		
		public void setPV(int PV){
			this.PV = PV;
		}
		
		public void setMaxPV(int maxPV){
			this.maxPV = maxPV;
		}
		
		public void setPE(int PE){
			this.PE = PE;
		}
		
		public void setMaxPE(int maxPE){
			this.maxPE = maxPE;
		}
		
		public void setStatut(int statut){
			this.statut = statut;
		}
		
		//STRING
		public void setOwner(String id_trainer){
			this.id_trainer = id_trainer;
		}
		
		public void setRace(String id_race){
			this.id_race = id_race;
		}
	//END SETTER
//---------------------------------------------------------------------------	
	//GESTION
		//GESTION XP
			public void addXP(int XP){
				this.XP += XP;
			}
			
			public void removeXP(int XP){
				this.XP -= XP;
			}
		//END GESTION XP
		
		//GESTION PV
			public void addPV(int PV){
				this.PV += PV;
			}
			
			public void removePV(int PV){
				this.PV -= PV;
			}
		//END GESTION PV
		
		//GESTION PE
			public void addPE(int PE){
				this.PE += PE;
			}
			
			public void removePE(int PE){
				this.PE -= PE;
			}
		//END GESTION PE
			
		//GESTION SKILLS
			public void addSkill(String skill){
				this.my_skill.add(skill);
			}
			
			public void removeSkill(String skill){
				this.my_skill.remove(skill);
			}
		//END GESTION SKILLS
	//END GESTION
//---------------------------------------------------------------------------
	//FIGHT FUNCTION
		public boolean isDead(){
			return (this.PV <= 0);
		}
		
		public boolean isExhausted(){
			return (this.PE <= 0);
		}
	//END FIGHT FUNCTION
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
