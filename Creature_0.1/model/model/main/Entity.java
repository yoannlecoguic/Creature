package model.main;

public class Entity {
//---------------------------------------------------------------------------
	//VARIABLE
		private String ID;//UNIQUE
		private String name;//NOT UNIQUE
	//END VARIABLE
//---------------------------------------------------------------------------
	//GETTER
		public String getName(){
			return this.name;
		}
		
		public String getID(){
			return this.ID;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setName(String name){
			this.name = name;
		}
		
		public void setID(String ID){
			this.ID = ID;
		}
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
