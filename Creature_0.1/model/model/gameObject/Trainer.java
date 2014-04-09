package model.gameObject;

import java.util.ArrayList;

import mode.customObject.LimitedArray;
import model.main.Entity;

public class Trainer extends Entity{
//---------------------------------------------------------------------------
	//VARIABLE
		private LimitedArray my_creature;
		private LimitedArray my_inventory;
		private int money;
		
		private int x;
		private int y;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public Trainer(){ //EMPTY OBJECT TRAINER
			this.setID("undefined");
			this.setName("undefined");
			this.my_creature = new LimitedArray (6);
			this.my_inventory = new LimitedArray (1000);
			this.money = 0;
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------	
	//GETTER
		public int getMoney(){
			return this.money;
		}
		
		public String getCreature(int index){
			return this.my_creature.get(index);
		}
		
		public ArrayList<String> getMyCreature(){
			return this.my_creature;
		}
		
		public int getX(){
			return this.x;
		}
		
		public int getY(){
			return this.y;
		}
	//END GETTER
//---------------------------------------------------------------------------	
	//SETTER
		public void setMoney(int money){
			this.money = money;
		}
		
		public void setX(int x){
			this.x = x;
		}
		
		public void setY(int y){
			this.y = y;
		}
	//END SETTER
//---------------------------------------------------------------------------
	//GESTION
		//MONEY GESTION
			public void addMoney(int money){
				this.money += money;
			}
			
			public void removeMoney(int money){
				this.money -= money;
			}
		//END MONEY GESTION
		
		//CREATURE GESTION
			protected void addEquipe(String id_creature){
				this.my_creature.add(id_creature);
			}
			
			protected void removeEquipe(String id_creature){
				this.my_creature.remove(id_creature);
			}
		//CREATURE GESTION
		
		//INVENTORY GESTION
			protected void addInventory(String id_object){
				this.my_inventory.add(id_object);
			}
			
			protected void removeInventory(String id_object){
				this.my_inventory.remove(id_object);
			}
		//END INVENTORY GESTION
	//END GESTION
}
