package controller.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
//---------------------------------------------------------------------------
	//VARIABLE
		private String file_name;
		private String line;
		private String[] array_line;
		private ArrayList <String[]> array;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public FileHandler(String file_name){
			this.file_name = file_name;
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		public ArrayList <String[]> getArray(){
			return this.array;
		}
	//END GETTER
//---------------------------------------------------------------------------	
	//FILE GESTION
		//READ
			public void readFile(){
				try{
					line ="";
					array = new ArrayList<String[]>();
					
					FileReader fileReader = new FileReader(this.file_name);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		            while((line = bufferedReader.readLine()) != null) {
		            	if(!line.matches("#(.?)*") && !line.trim().isEmpty()){
			                this.array_line = line.split(" ");
			                this.array.add(this.array_line);
		            	}
		            }	
		            
		            bufferedReader.close();			
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println("Unable to open file '" + this.file_name + "'");				
		        }
		        catch(IOException ex) {
		            System.out.println("Error reading file '"+ this.file_name + "'");
		        }
			}
		//END READ
			
		//WRITE
			public void writeFile(ArrayList<String> toWrite){
		        try {
		            FileWriter fileWriter = new FileWriter(this.file_name);
		            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		            
		            for(String data : toWrite){
		            	bufferedWriter.write(data);
		            	bufferedWriter.newLine();
		            }
		            
		            bufferedWriter.close();
		        }
		        catch(IOException ex) {
		            System.out.println( "Error writing to file '"+ this.file_name + "'");
		        }
			}
		//END WRITE
	//END FILE GESTION
//---------------------------------------------------------------------------
}
