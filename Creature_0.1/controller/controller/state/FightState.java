package controller.state;

import java.util.ArrayList;
import java.util.Random;

import model.gameObject.CreatureReal;
import model.gameObject.Skill;
import model.gameObject.Trainer;
import controller.listener.NightWatcher;
import controller.main.Controller;

public class FightState extends State implements NightWatcher{
//---------------------------------------------------------------------------
	//VARIABLE
		private String state;
		private ArrayList <String> text_to_show = new ArrayList<String>();
		
		private Trainer active_trainer;
		private Trainer passive_trainer;
		private CreatureReal active_creature;
		private CreatureReal passive_creature;
		
		private Trainer foe_trainer;
		private CreatureReal friend_creature;
		private CreatureReal foe_creature;
		
		//FLAGS
			boolean begin_fight=false;
		//END FLAGS
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public FightState(Trainer foe_trainer, Controller controller){
			super(controller);
			
			//SET TRAINERS
			this.foe_trainer = foe_trainer;
			this.state = "";
			
			//UPDATE MODEL
			this.getController().getModel().updateAllActive();
			
			//GET FIRST CREATURE TODO THE PLAYER CAN CHOOSE ANY CREATURE
			this.foe_creature = this.getController().getModel().getTrainerTeam(this.foe_trainer.getID()).get(0);
			this.friend_creature = this.getController().getModel().getTrainerTeam(this.getController().getPlayer().getID()).get(0);
			
			//START FIGHT VIEW
			this.getController().getView().fight();

			this.getController().getView().getFight().addTeam(this.getController().getModel().getTrainerTeam(this.getController().getPlayer().getID()));
			this.getController().getView().getFight().addSkill(this.getController().getModel().getCreatureSkill(friend_creature));
			this.getController().getView().getFight().addHelp();
			this.getController().getView().getFight().addFightMenu();
			this.getController().getView().getFight().addFriendBar();
			this.getController().getView().getFight().addFoeBar();
			
			this.getController().getView().getFight().getHelp().setVisible(true);
			this.getController().getView().getFight().getMenu().setVisible(true);
			this.getController().getView().getFight().getFriendBar().setVisible(true);
			this.getController().getView().getFight().getFoeBar().setVisible(true);
			
			//SET FIGHT VIEW VALUE
			this.getController().getView().getFight().getFriendBar().setValue(this.friend_creature);
			this.getController().getView().getFight().getFoeBar().setValue(this.foe_creature);
			
			//SET ACTIVE
			this.addText("DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!DEBUT DU MATCH!");
			this.initiative();
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
	//END GETTER
//---------------------------------------------------------------------------
	//RUN
		public void initiative(){//CALCULATE WHO MUST PLAY
			if(active_trainer == null){
				this.active_trainer = this.getController().getPlayer();
				this.passive_trainer = this.foe_trainer;
				
			}else{
				this.begin_fight = true;
				Trainer buffer = this.active_trainer;
				this.active_trainer = this.passive_trainer;
				this.passive_trainer = buffer;
			}
			
			this.play();
		}
		
		public void play(){
			this.addText("A "+this.active_trainer.getName()+" DE JOUER !");
			if(this.active_trainer == this.getController().getPlayer()){
				//PLAYER TURN
					this.state = "active";
					this.active_creature = this.friend_creature;
					this.passive_creature = this.foe_creature;
					
					if(this.begin_fight == true){
						this.addText(this.active_creature.getName()+" RECUPERE "+this.getController().getModel().generatePE(this.active_creature)+" PE !");
						this.friend_creature.addPE(this.getController().getModel().generatePE(this.friend_creature));
						this.updateUI();
					}
					this.addText("CHOISISSEZ UNE ATTAQUE!");
				
					//UPDATE UI
					this.getController().getView().getFight().getMenu().setVisible(true);
					this.showText();
					
					//WAIT FOR PLAYER ACTION
					this.state = "active";
			}
			else{
				//ENNEMI TURN
					this.state = "inactive";
					this.active_creature = this.foe_creature;
					this.passive_creature = this.friend_creature;
					
					if(this.begin_fight == true){
						this.foe_creature.addPE(this.getController().getModel().generatePE(this.foe_creature));
						this.updateUI();
					}
					
					//GENERATE ENNEMI ACTION
					this.attack(this.getController().getModel().getSkillByID(this.active_creature.getSkill(0)));
					this.showText();
					
					//WAIT FOR PLAYER ACTION
					this.state = "show_attack";
			}
		}
		
		public void updateUI(){
			this.getController().getView().getFight().getFoeBar().setValue(this.foe_creature);
			this.getController().getView().getFight().getFriendBar().setValue(this.friend_creature);
		}
		
		public void isDead(){
			//ADD TEXT
			if(this.friend_creature.isDead()){
				this.addText(this.friend_creature.getName()+" EST MORT");
			}
			else if(this.foe_creature.isDead()){
				this.addText(this.foe_creature.getName()+" EST MORT");
			}
			
			//WAIT PLAYER ACTION
			this.state = "show_death";
		}
	//END RUN
//---------------------------------------------------------------------------
	//FIGHT ACTIONS
		public boolean attack(Skill skill){
			if(this.enoughPE(this.active_creature, skill) == true){//CHECK IF ENOUGH PE 
				if(this.isTouched(this.active_creature, this.passive_creature, skill) == true){//CHECK IF TOUCHED
					//CALCULATE DAMAGE
					int damage = this.getController().getModel().generateDamage(this.active_creature, this.passive_creature, skill);
					this.addText(this.active_creature.getName()+" UTILISE "+skill.getName());
					
					//UPDATE MODEL OBJECT
					this.passive_creature.removePV(damage);
					if(this.passive_creature.isDead()){
						this.passive_creature.setPV(0);
					}
					this.active_creature.removePE(skill.getCostPE());
					
					this.addText(this.active_creature.getName()+" INFLIGE "+damage+" DE DEGAT.");	
					return true;
				}
				else{
					this.active_creature.removePE(skill.getCostPE());
					this.addText(active_creature.getName()+" A RATE SON ATTAQUE");
					return true;
				}
			}
			else{
				this.addText("PAS ASSEZ DE PEEEE!");
				return false;
			}
		}
	//END FIGHT ACTION
//---------------------------------------------------------------------------
	//IA
		public Skill randomSkill(CreatureReal creature){
			ArrayList <Skill> array_skill = new ArrayList <Skill> ();
			
			for(String id_skill : creature.getMySkill()){
				Skill skill = this.getController().getModel().getSkillByID(id_skill);
				
				if(this.notUndefined(skill)
				&& this.enoughPE(creature, skill)){
					array_skill.add(skill);
				}
			}
			
			if(array_skill.size() != 0){
				Random random = new Random();
				System.out.println(array_skill.size());
				return (array_skill.get(random.nextInt(array_skill.size())));
			}else{
				return this.getController().getModel().getSkillByID("0");
			}
		}
	//END IA
//---------------------------------------------------------------------------
	//VERIFICATION
		public boolean notUndefined(Skill skill){
			if(skill.getName().equals("undefined")){
				return false;
			}else{
				return true;
			}
		}
		
		public boolean notUndefined(CreatureReal creature){
			if(creature.getName().equals("undefined")){
				return false;
			}else{
				return true;
			}
		}
		
		public boolean enoughPE(CreatureReal creature, Skill skill){
			if(creature.getPE() - skill.getCostPE() >=0){
				return true;
			}else{
				return false;
			}
		}
		
		public boolean isTouched(CreatureReal attacker, CreatureReal defender, Skill skill){
			if((Math.random()*100)>this.getController().getModel().generatePrecision(attacker, defender, skill)){
				return false;
			}else{
				return true;
			}
		}
		
		public boolean emptyTeam(Trainer trainer){
			int i = 0;
			int y = 0;
			for(String creature : trainer.getMyCreature()){
				y++;
				if(this.getController().getModel().getCreatureByID(creature).getPV() == 0){
					i++;
				}
			}
			if(i == y){
				return true;
			}else{
				return false;
			}		
		}
	//END VERIF
//---------------------------------------------------------------------------
	//ARRAYLIST HELP
		public void addText(String text){
			this.text_to_show.add(text);
		}
		
		public void showText(){
			if(!this.text_to_show.isEmpty()){
				this.getController().getView().getFight().getHelp().setText(this.text_to_show.get(0));
				this.text_to_show.remove(0);
			}
		}
	//END ARRAYLIST HELP
//---------------------------------------------------------------------------	
	//EVENT FUNCTION
		public void eventSkill(int num_skill){
			Skill skill = this.getController().getModel().getSkillByID(this.active_creature.getSkill(num_skill));
			
			if(this.notUndefined(skill)){
				if(this.attack(skill)){				
					this.state = "show_attack";
					this.getController().getView().getFight().getSkill().setVisible(false);
				}
				this.getController().getView().getFight().getSkill().setVisible(false);
				this.showText();
			}
		}
		
		public void changeCreature(Trainer trainer, int num_creature){
			CreatureReal creature = this.getController().getModel().getTrainerTeam(trainer.getID()).get(num_creature);
		
			if(this.notUndefined(creature) && this.active_creature != creature){
				if(!creature.isDead()){
					if(trainer == this.getController().getPlayer()){
						this.friend_creature = creature;
					}
					else{
						this.foe_creature = creature;
					}
					this.getController().getView().getFight().getTeam().setVisible(false);
					this.addText(trainer.getName()+" A CHANGE DE CREATURE.");
					this.addText(trainer.getName()+" ENVOIE "+creature.getName()+" !");
					this.showText();
					this.state="show_attack";
				}
			}
		}
	//END EVENT FUNCTION
//---------------------------------------------------------------------------
	//LISTENER
		@Override
		public void receiveEvent(String eventID, String eventType, String event) {
			System.out.println(eventID+"/"+eventType+"/"+event);
			if(this.text_to_show.isEmpty()){
				if(this.state.equals("active")){
					switch(eventID) {
						case "attaquer":
							this.getController().getView().getFight().showSkill();
					    break;
					    
						case "creature":
							this.getController().getView().getFight().getTeam().setVisible(true);
							this.state="team";
					    break;
					    
						case "skill_1":
							this.eventSkill(0);
						break;
					    
						case "skill_2":
							this.eventSkill(1);
					    break;
					    
						case "skill_3":
							this.eventSkill(2);
					    break;
					    
						case "skill_4":
							this.eventSkill(3);
					    break;
				    }	
				}
				
				else if(this.state.equals("show_attack")){
					if(eventID.equals("help") || (eventID.equals("10") && event.equals("pressed"))){
						if(this.friend_creature.isDead() || this.foe_creature.isDead()){
							this.isDead();
							this.showText();
						}
						else{
							this.updateUI();
							this.initiative();
						}
					}
				}
				
				else if(this.state.equals("show_death")){
					if(eventID.equals("help") || (eventID.equals("10") && event.equals("pressed"))){
						if(this.friend_creature.isDead()){
							this.getController().getView().getFight().getFriendBar().setVisible(false);
							//GENERE XP ET AFFICHE
							this.foe_creature.addXP(this.getController().getModel().generateXP(this.foe_creature, this.friend_creature));
							this.updateUI();
							//CHOISIR NOUVELLE CREATURE OU FIN DU COMBAT
						}
						if(this.foe_creature.isDead()){
							this.getController().getView().getFight().getFoeBar().setVisible(false);
							//GENERE XP
							this.friend_creature.addXP(this.getController().getModel().generateXP(this.friend_creature, this.foe_creature));
							this.updateUI();
							//GENERE UNE NOUVELLE CREATURE OU FIN DU COMBAT
						}
					}
				}
				
				else if(this.state.equals("team")){
					switch(eventID) {
						case "team":
							this.getController().getView().getFight().getTeam().setVisible(false);
							this.state="active";
						break;
						
						case "team_1":
							this.changeCreature(this.getController().getPlayer(), 0);
						break;
						
						case "team_2":
							this.changeCreature(this.getController().getPlayer(), 1);
						break;
						
						case "team_3":
							this.changeCreature(this.getController().getPlayer(), 2);
						break;
					}
				}
			}
			else{
				if(eventID.equals("help") || (eventID.equals("10") && event.equals("pressed"))) {
					this.updateUI();
					this.showText();
				}
			}
		}
	//END LISTENER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
