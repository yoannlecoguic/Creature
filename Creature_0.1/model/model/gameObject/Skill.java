package model.gameObject;

import model.main.Entity;

public class Skill extends Entity{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private int power;
		private int precision;
		private int cost_PE;
		private String id_element;
	//END VARIABLE
//---------------------------------------------------------------------------
	//GETTER
		//INT
			public int getPower(){
				return this.power;
			}
			
			public int getPrecision(){
				return this.precision;
			}
			
			public int getCostPE(){
				return this.cost_PE;
			}
		//END INT
		
		//STRING
			public String getElement(){
				return this.id_element;
			}
		//END STRING
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		//INT
			public void setPower(int power){
				this.power = power;
			}
			
			public void setPrecision(int precision){
				this.precision = precision;
			}
			
			public void setCostPE(int cost_PE){
				this.cost_PE = cost_PE;
			}
		//END INT
		
		//STRING
			public void setElement(String id_element){
				this.id_element = id_element;
			}
		//END STRING
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
