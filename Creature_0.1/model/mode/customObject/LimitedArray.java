package mode.customObject;

import java.util.ArrayList;

public class LimitedArray extends ArrayList <String>{
//---------------------------------------------------------------------------
	//VARIABLE
		private int size;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public LimitedArray(int size){
			super();
			
			this.size = size;
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------	
	//GETTER
		public ArrayList<String> getArrayList(){
			ArrayList<String> array = new ArrayList<String>();
			for(String skill : this){
				array.add(skill);
			}
			return array;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
	//END SETTER
//---------------------------------------------------------------------------
	//SECURITY
		public void add(int index, String value){
			if(this.size() < this.size){
				if(!this.contains(value)){
					this.add(value);
				}else{
					System.out.println("Cette creature connait deja cette attaque.");
				}
			}
		}
	//END SECURITY
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
