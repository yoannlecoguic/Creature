package model.gameObject;

import java.util.ArrayList;

import mode.customObject.Hashstat;
import model.main.Entity;

public class CreatureRace extends Entity{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private Hashstat stat;
		private String id_element;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public CreatureRace(){ //EMPTY OBJECT CREATURE RACE
			this.stat = new Hashstat();
			this.id_element = "undefined";
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------	
	//GETTER
		public String getElement(){
			return this.id_element;
		}
		
		public Hashstat getMyStat(){
			return this.stat;
		}
		
		public ArrayList<Double> getMyStatArray(){
			return this.stat.getArray();
		}
	//END GETTER
//---------------------------------------------------------------------------		
	//SETTER
		public void setElement(String id_element){
			this.id_element = id_element;
		}
		
		public void setStat(int index, double value){
			this.stat.setStat(index, value);
		}
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
