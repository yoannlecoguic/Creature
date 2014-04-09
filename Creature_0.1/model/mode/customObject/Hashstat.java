package mode.customObject;

import java.util.ArrayList;
import java.util.Hashtable;

public class Hashstat extends Hashtable <Integer, Double>{
//---------------------------------------------------------------------------
	//VARIABLE
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public Hashstat(){
			super();
			
			this.put(1,0.0);
			this.put(2,0.0);
			this.put(3,0.0);
			
			this.put(4,0.0);
			this.put(5,0.0);
			this.put(6,0.0);
			
			this.put(7,0.0);
			this.put(8,0.0);
			this.put(9,0.0);
			
			this.put(10,0.0);
			this.put(11,0.0);
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------	
	//GETTER
		public Double getStat(int index){
			return this.get(index);
		}
		
		public ArrayList<Double> getArray(){
			return new ArrayList<Double>(this.values());
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setStat(int index, double value){
			this.put(index, value);
		}
	//END SETTER
//---------------------------------------------------------------------------
	//SECURITY
	//END SECURITY
//---------------------------------------------------------------------------
	//SHOW INFOS
		public void showInfo(){
			System.out.println("Caractéristiques par level:");
			System.out.println("	PV = "+this.get(10));
			System.out.println("	PE = "+this.get(11));
			System.out.println("----------------------------");
			System.out.println("	Force = "+this.get(1));
			System.out.println("	Endurance = "+this.get(2));
			System.out.println("	Defense = "+this.get(3));
			System.out.println("----------------------------");
			System.out.println("	Agilité = "+this.get(4));
			System.out.println("	Vitesse = "+this.get(5));
			System.out.println("	Chance = "+this.get(6));
			System.out.println("----------------------------");
			System.out.println("	Intelligence = "+this.get(7));
			System.out.println("	Sagesse = "+this.get(8));
			System.out.println("	Volonté = "+this.get(9));
		}
	//END SHOW INFOS
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
