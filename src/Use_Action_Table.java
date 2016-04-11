import java.io.BufferedReader;
import java.io.IOException;


public class Use_Action_Table {
	
	/**
	 * What is the use action type
	 * TODO I need a list of action types so programmers can identify what they want 
	 */
	String type;
	
	/**
	 * Message the item will do when it is 'used'
	 */
	String activation_message;
	
	/**
	 * A list of the effects the item will cause 
	 * I just want to store the id
	 */
	String effects[];
	
	/**
	 * What will occur to the player if they use the item
	 */
	String stat_adjustments[];
	
	/**
	 * What kind of fields will be made upon usage of this item
	 */
	String fields_produced;
	
	/**
	 * What is needed to to use this item
	 */
	String charges_needed;
	
	/**
	 * Tools needed to use the item
	 * I didn't think this needed a list - I think the player just needs to know
	 * what is needed to use this item, not necessarily a literla list
	 * I'm open for discussion about this
	 */
	String tools_needed;
	
	/**
	 * How many moves it takes to use this item
	 * TODO A comparison of items for scale in speed
	 */
	String moves;
	
	/**
	 * This is a simple table that stores information about a use_action
	 */
	public Use_Action_Table(){
		effects = new String[10];
		stat_adjustments = new String[10];
	}
	
	public Use_Action_Table(String line) {
		type = line;
	}

	public void buildTable(BufferedReader fileReader) throws IOException{
		
		String line = "";
		
		
		while(true){
			
			line = fileReader.readLine();
			
			if(line.contains("\"type\"")){
				line = line.substring(line.indexOf(":") + 1);
				type = line;
				continue;
			}
			
			if(line.contains("\"activation_message\"")){
				line = line.substring(line.indexOf(":") + 1);
				activation_message = line;
				continue;
			}
			
			
			/**
			 * I only list the effect ids - I don't see  a point of gathering
			 * the duration
			 */
			if(line.contains("\"effects\"")){
				
				int iterator = 0; //iterates the array
				
				
				while(!line.contains("],") ){ //Loop until end of effects statement
					
					line = fileReader.readLine();
					
					if(  line.contains("\"id\"")  ){
						line = line.substring( line.indexOf(":") + 1 );
						effects[iterator] = line;
						
						iterator++;
						
						continue;
					}
					
					//Fixes possible format bugs
					if(!line.contains("]")){
						break; 
					}
				}
				
				continue;
			}// end of effects if statement
			
			
			if(line.contains("\"stat_adjustments\"")){
			
				int iterator = 0; //iterates the array
				
				while(!line.contains("}")){ //Loop until end of effects statement
					
						line = fileReader.readLine();
						
						stat_adjustments[iterator] = line;	
						iterator++;
							
						continue;
						
				}
				
				continue; //Starts from the beginning
			}
			
			if(line.contains("\"fields_produced\"")){
				line = line.substring(line.indexOf(":") + 1);
				fields_produced = line;
				continue;
			}
			
			if(line.contains("\"charges_needed\"")){
				line = line.substring(line.indexOf(":") + 1);
				charges_needed = line;
				continue;
			}
			
			if(line.contains("\"tools_needed\"")){
				line = line.substring(line.indexOf(":") + 1);
				tools_needed = line;
				continue;
			}
			
			if(line.contains("\"moves\"")){
				line = line.substring(line.indexOf(":") + 1);
				moves = line;
				continue;
			}
			
			//This is the end of the use_action table
			return;
		}
		
		//return;
	}
	
}
