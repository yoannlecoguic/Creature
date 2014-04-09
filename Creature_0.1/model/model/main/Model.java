package model.main;

import java.util.ArrayList;

import model.gameObject.CreatureRace;
import model.gameObject.CreatureReal;
import model.gameObject.Object;
import model.gameObject.Skill;
import model.gameObject.Trainer;
import controller.main.FileHandler;

public class Model {
//---------------------------------------------------------------------------
	//VARIABLE
		//DATA GAME
		private ArrayList <CreatureRace> allCreatureRace;
		private ArrayList <Skill> allSkill;
		private ArrayList <Object> allObject;
		//DATA SAVE
		private ArrayList <CreatureReal> allCreatureReal;
		private ArrayList <Trainer> allTrainer;
		//GESTION INGAME
		private ArrayList <CreatureReal> allCreatureRealActive;
		
		//CONSTANT
		private Double constantXP = 2.15;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public Model(){
			//WE INITIALIZE THE ARRAYS
			allCreatureRace = new ArrayList <CreatureRace> (); 
			allSkill = new ArrayList <Skill> ();
			allObject = new ArrayList <Object> ();
			allCreatureReal = new ArrayList <CreatureReal> ();
			allCreatureRealActive = new ArrayList <CreatureReal> ();
			allTrainer = new ArrayList <Trainer> ();
			
			//WE FETCH THE GAME DATA, WE CREATE OBJECTS AND WE INSERT THEM INTO THE LIST
			this.createCreatureRace(this.loadFile("data/creatureRace.txt"));
			this.createSkill(this.loadFile("data/skill.txt"));
			
			//WE FETCH THE SAVE 
			this.createTrainer(this.loadFile("save/trainer.txt"));
			this.createCreatureReal(this.loadFile("save/creatureReal.txt"));
			
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		//MODEL ARRAY
			public ArrayList <CreatureReal> getAllCreature(){
				return this.allCreatureReal;
			}
			
			public ArrayList <CreatureReal> getAllCreatureActive(){
				return this.allCreatureRealActive;
			}
			
			public ArrayList <CreatureRace> getAllRace(){
				return this.allCreatureRace;
			}
			
			public ArrayList <Trainer> getAllTrainer(){
				return this.allTrainer;
			}
			
			public ArrayList <Skill> getAllSkill(){
				return this.allSkill;
			}
		//END MODEL ARRAY
		
		//BY ID
			public CreatureRace getRaceByID(String ID){
				for(CreatureRace race : this.allCreatureRace){
					if(ID.equals(race.getID())){
						return race;
					}
				}
				System.out.println("Erreur, pas de race avec cet ID.");
				return null;
			}
			
			public CreatureReal getCreatureByID(String ID){
				for(CreatureReal creature : this.allCreatureReal){
					if(ID.equals(creature.getID())){
						return creature;
					}
				}
				System.out.println("Erreur, pas de creature avec cet ID.");
				return null;
			}
			
			public Trainer getTrainerByID(String ID){
				for(Trainer trainer : this.allTrainer){
					if(ID.equals(trainer.getID())){
						return trainer;
					}
				}
				System.out.println("Erreur, pas de dresseur avec cet ID.");
				return null;
			}
			
			public Skill getSkillByID(String ID){
				for(Skill skill : this.allSkill){
					if(ID.equals(skill.getID())){
						return skill;
					}
				}
				System.out.println("Erreur, pas de skill avec cet ID.");
				return null;
			}
		//END BY ID
		
		//ARRAYLIST
			public ArrayList<CreatureReal> getTrainerTeam(String id_trainer){
				ArrayList<CreatureReal> team = new ArrayList <CreatureReal>();
				
				for(CreatureReal creature : this.allCreatureRealActive){
					if(creature.getTrainer().equals(id_trainer)){
						team.add(creature);
					}
				}
				
				if(team.size() == 0){
					team.add(this.getCreatureByID("0"));
					team.add(this.getCreatureByID("0"));
					team.add(this.getCreatureByID("0"));
				}
				else if(team.size()==1){
					team.add(this.getCreatureByID("0"));
					team.add(this.getCreatureByID("0"));
				}else if (team.size()==2){
					team.add(this.getCreatureByID("0"));
				}
				
				return team;
			}
			
			public ArrayList<Skill> getCreatureSkill(CreatureReal creature){
				ArrayList<Skill> mySkill = new ArrayList <Skill>();
				
				for(String id_skill : creature.getMySkill()){
					mySkill.add(this.getSkillByID(id_skill));
				}
				
				return mySkill;
			}
		//END ARRAYLIST
			
		//CREATURE STATS
			public int getFOR(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(0));
			}
			
			public int getEND(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(1));
			}
			
			public int getDEF(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(2));
			}
			
			public int getAGI(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(3));
			}
			
			public int getVIT(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(4));
			}
			
			public int getCHA(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(5));
			}
			
			public int getINT(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(6));
			}
			
			public int getSAG(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(7));
			}
			
			public int getVOL(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(8));
			}
			
			public int getMaxPV(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(9));
			}
			
			public int getMaxPE(CreatureReal creature){
				return (int) Math.floor(this.generateStats(creature).get(10));
			}
		//END CREATURE STATS
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		
	//END SETTER
//---------------------------------------------------------------------------
	//CREATION OBJECT
		//CREATURE RACE
			public void createCreatureRace(ArrayList <String[]> array){
				for (String[] data : array){
					CreatureRace creature_race = new CreatureRace();
					//Insertion
						creature_race.setID(data[0]);
						creature_race.setName(data[1]);
						creature_race.setElement(data[2]);
					
						//Insert creature race statistics/levels
						for(int i=1; i<=11; i++){
							creature_race.setStat(i, Double.parseDouble(data[i+2]));
						}
						//End insert statistics
					//End insertion
					allCreatureRace.add(creature_race);
				}
			}
		//END CREATURE RACE
		
		//CREATURE REAL
			public void createCreatureReal(ArrayList <String[]> array){
				for (String[] data : array){
					CreatureReal creature_real = new CreatureReal();
					//Insertion
						creature_real.setID(data[0]);
						creature_real.setName(data[1]);
						creature_real.setRace(data[2]);
						creature_real.setOwner(data[3]);
						creature_real.setStatut(Integer.parseInt(data[4]));
						creature_real.setXP(Integer.parseInt(data[5]));
						creature_real.setPV(Integer.parseInt(data[6]));
						creature_real.setPE(Integer.parseInt(data[7]));
						
						//Insert skills
						for(int i=1; i<=4; i++){
							creature_real.addSkill(data[i+7]);
						}
						//End insert skills
						
						//Stats being calculated
						creature_real.setLevel(this.generateLevel(creature_real.getXP()));
						creature_real.setNextXP(this.generateLevelXP(creature_real.getLevel()));
						creature_real.setPreviousXP(this.generateLevelXP(creature_real.getLevel()-1));
						//creature_real.setMaxPV(this.)
						//this.generateMaxPV(creature_real);
						//this.generateMaxPE(creature_real);
								
					//End insertion
					allCreatureReal.add(creature_real);//We add the creature in the array with all creatures real
					
					if(creature_real.getStatut() == 2){//If the statut is 2, the creature is not in a box but in a player active team
						allCreatureRealActive.add(creature_real);
					}
				}
			}
		//END CREATURE REAL
		
		//TRAINER
			public void createTrainer(ArrayList <String[]> array){
				for (String[] data : array){
					Trainer trainer = new Trainer();
					//Insertion
						trainer.setID(data[0]);
						trainer.setName(data[1]);		
						trainer.setX(Integer.parseInt(data[2]));
						trainer.setY(Integer.parseInt(data[3]));
						trainer.setMoney(Integer.parseInt(data[4]));
					//End insertion
					allTrainer.add(trainer);
				}
			}
		//END TRAINER
			
		//SKILL
			public void createSkill(ArrayList <String[]> array){
				for (String[] data : array){
					Skill skill = new Skill();
					//Insertion
						skill.setID(data[0]);
						skill.setName(data[1]);
						skill.setElement(data[2]);
						skill.setPower(Integer.parseInt(data[3]));
						skill.setPrecision(Integer.parseInt(data[4]));
						skill.setCostPE(Integer.parseInt(data[5]));
					//End insertion
					allSkill.add(skill);
				}
			}
		//END SKILL
	//END CREATION OBJECT
//---------------------------------------------------------------------------
	//UPDATE OBJECT
		//STATS CREATURE REAL
			public void updateStats(String id_creature){
				this.getCreatureByID(id_creature).setLevel(this.generateLevel(this.getCreatureByID(id_creature).getXP()));
				this.getCreatureByID(id_creature).setNextXP(this.generateLevelXP(this.getCreatureByID(id_creature).getLevel()));
				
				this.getCreatureByID(id_creature).setMaxPV(this.getMaxPV(this.getCreatureByID(id_creature)));
				this.getCreatureByID(id_creature).setMaxPE(this.getMaxPE(this.getCreatureByID(id_creature)));
			}
			
			public void updateAllActive(){
				for(CreatureReal creature : this.allCreatureRealActive){
					this.updateStats(creature.getID());
				}
			}
		//END STATS CREATURE REAL
	//END UPDATE OBJECT
//---------------------------------------------------------------------------
	//GENERATION
		//XP AND LEVEL
			public int generateLevelXP(int level){
				return (int) Math.floor(Math.pow((double)level, (double)this.constantXP)*50);
			}
			
			public int generateLevel(int xp_total){
				return (int) Math.floor(Math.pow(((double)xp_total+1.0)/50.0,1.0/(double)this.constantXP)+1.0);
			}
			
			public int generateXP(CreatureReal winner, CreatureReal loser){
				return (int) Math.floor(((double)winner.getLevel()*20.0)*(((double)loser.getLevel()/(double)winner.getLevel())));
			}
		//END XP AND LEVEL
			
		//PV AND PE
			public ArrayList<Double> generateStats(CreatureReal creature){
				ArrayList<Double> stats = new ArrayList<Double> ();
				for(Double stat :this.getRaceByID(creature.getRace()).getMyStatArray()){
					stats.add(stat*creature.getLevel());
				}
				return stats;
			}
		//END PV AND PE
			
		//FIGHT GENERATION
			public int generatePrecision(CreatureReal attacker, CreatureReal defender, Skill skill){
				return (int) Math.floor(((double)skill.getPrecision()*(1+(((double)this.getAGI(attacker)-(double)this.getAGI(defender))/100.0))));
			}
			
			public int generateDamage(CreatureReal attacker, CreatureReal defender, Skill skill){
				return (int)Math.floor(((double)skill.getPower()*(1+(((double)this.getFOR(attacker)-(double)this.getDEF(defender))/100.0))));
			}
			
			public int generatePE(CreatureReal creature){
				return (int)Math.round((double) this.getVIT(creature)/8);
			}
		//END GENERATION
	//END GENERATION
//---------------------------------------------------------------------------
	//READ DATA
		public ArrayList<String[]> loadFile(String path){
			FileHandler handler = new FileHandler(path);
			handler.readFile();
			return handler.getArray();
		}
		
	//END READ DATA
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
