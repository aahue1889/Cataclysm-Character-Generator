import java.io.BufferedReader;
import java.io.IOException;

/**
 * Trait will only have a description, name, and game id - this allows for objects
 * to dynamically give the user information regaurding the trait that they
 * are looking at
 * @author sentinal
 *
 */
public class Trait {

	/**
	 * User friendly readable name
	 */
	private String name;
	
	/**
	 * The Description describing the trait
	 */
	private String description;
	
	/**
	 * The game identifier - NECESSARY FOR REFERENCING
	 */
	private String gameID;
	
	/**
	 * There are some traits that are starting traits and others
	 * that can be gained through playing the game
	 * the mutations file has a difference for the two
	 * right now I ony want to add starting traits to the traits list
	 */
	private boolean isStartingTrait = false;
	
	/**
	 * Contains a string of traits that cannot be allowed to coexist on the same list
	 */
	private String cancelLine;
	
	/**
	 * Incase I want to initialize a blank Trait for a
	 * place holder in a JList
	 */
	public Trait(){}

	public Trait(BufferedReader bufferedReader){}

	/**
	 * Fills out an GENERIC file based on a json file
	 * @param bufferedReader - the file reader
	 * @throws IOException - Handles I/O problems
	 * @returns how the body of the statement was terminated
	 *          -1 is {,} which means we should not be reading the next line
	 *          1 is } which means the body was terminated normally
	 */
	public int buildItem(BufferedReader bufferedReader) throws IOException{
		
		String line = "";
		
		while(true){
			
			line = bufferedReader.readLine();
			
			if(line.contains("\"wet_protection\"")){
				
				/*If use_action attribute contains a body statement
				 *then we need to make a table ELSE it is just a simple
				 *one word definition of a tool: (HOTPLATE, HAMMER .. etc)*/
				if(line.contains("[")){
					while(!line.contains("]") ){ //Loop until end of wet protection statement
						line = bufferedReader.readLine();
						continue;
					}
				}
			}
			
			if(line.contains("\"id\"")){
				line = line.substring(line.indexOf(":") + 1);
				gameID = line;
				continue;
			}
			
			if(line.contains("\"name\"")){
				line = line.substring(line.indexOf(":") + 1);
				name = line;
				continue;
			}
			
			if(line.contains("\"description\"")){
				line = line.substring(line.indexOf(":") + 1);
				description = line;
				continue;
			}
			
			if(line.contains("\"starting_trait\"")){
				setStartingTrait(true);
 				continue;
			}
			
			if(line.contains("\"cancels\"")){
				line = line.substring(line.indexOf(":") + 1);
				setCancelLine(line);
				continue;
			}
			

			
			//-------------The Code below is optional
			
			//this.type.equalsIgnoreCase("GENERIC")
	        //It is the responsibility of a child class find the end of a json body statement (the '}')
			// UNLESS The item is a Generic Type			
			if( (line.contains("},") || line.contains("}"))  ){
	        	System.out.println(this.toString());
	        	
	        	if( line.contains("},{"))
	        		return 0;
	        	else
	        		return 1;
	        }
			
			
	        //Else if this was a constructor called then do not look for the end of the body statement (the '}')
			else if(true){
	        	System.out.println("ERROR: " + line);
	        	continue;
			}


		}	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public String getCancelLine() {
		return cancelLine;
	}

	public void setCancelLine(String cancelLine) {
		this.cancelLine = cancelLine;
	}

	public boolean isStartingTrait() {
		return isStartingTrait;
	}

	public void setStartingTrait(boolean isStartingTrait) {
		this.isStartingTrait = isStartingTrait;
	}
	
	public String toString(){
		return "Name: "+ name + " \n" +
				"Description: " + description +" \n"+
				"GameID: " + gameID + "\n" + 
				"Canceled Traits: " + cancelLine + "\n";
	}
}
