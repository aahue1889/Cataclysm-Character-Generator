import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class Item {
	/**
	 * This will be used to define the ITEM
	 * - User will not be responsible for coming up with this name
	 */
	private String type;
	
	/**
	 * This is used request the item and store it into the user's inventory
	 * - REMEMBER Unique ID. Must be one continuous word, use underscores if necessary
	 */
	private String id;
	
	/**
	 * The ASCII Character that will represent the Item in the game
	 * - REMEMBER Even though it is a single character, it is read in as a String
	 */
	private String symbol;
	
	/**
	 * The color of the symbol and how it will be represented in the game
	 * TODO A list of possible colors the user can choose would be handy here
	 */
	private String color;
	
	/**
	 * The name of the item is a user friendly representation of the name
	 * ex. id = "pizza_cutter" name = "pizza cutter"
	 */
	private String name;
	
	/**
	 * The description of this item
	 *  TODO What are the limits of the description?
	 */
	private String description;
	
	/**
	 * Used to barder with NPCs
	 * TODO A Guide for pricing an item
	 */
	private String price;
	
	/**
	 * The Weight of an object measured in grams
	 * REMEMBER 1000 is 3lb (The weight of a rubber mallet)
	 */
	private String weight;
	
	/**
	 * How much space the object takes measured in 1/4 liters
	 * REMEMBER 1/4 a liter is a bottle of water and 1 liter is a family sized bottle
	 */
	private String volume;
	
	//---------------------------------------------------------------
	
	/**
	 * OPTIONAL: The bashing damage of a weapon
	 * TODO A guide for bashing scale
	 */
	private String bashing;
	
	/**
	 * OPTIONAL: The slash damage of a weapon
	 * TODO A guide for slash scale
	 */
	private String cutting;
	
	/**
	 * OPTIONAL: To-hit bonus if using it as a melee weapon (whatever for?)
	 * TODO A guide for accuracy
	 */
	private String to_hit;
	
	/**
	 * OPTIONAL: Category - I don't think we will be using this in this program
	 * but it indicates what crafting category this item belongs in
	 */
	private String category;

	/**
	 * OPTIONAL: name_plural - How the item will be read if there are more than two of them
	 */
	private String name_plural;
	
	
	/**
	 * Optional: I don't know what this means -
	 * TODO A proper explanation on what this is
	 */
	private String price_postapoc;
	
	
	/**
	 * OPTIONAL: qualities - What kind of 'tool' qualities does this object have?
	 * A Rock has the tool quality of a hammber
	 * TODO: Examples of qaulities for balance
	 */
	private String qualities;
	


	/**
	 * OPTIONAL: materials add additional effects to your item
	 * TODO What different materials do should be listed here 
	 */
	private String material;


	/**
	 * OPTIONAL: Flags - There are a bunch of flags 
	 * TODO: Define the kind of flags out there for the user
	 * TODO: Tokenize the flags to be read and printed to the user
	 */
	private String flags;

	/**
	 * This table lists all of the attributes of an item if it is a 
	 * USABLE type (cigarettes, pizza.. etc)
	 */
	private Use_Action_Table use_action_attr;
	
	private String initial_charges;

	private String max_charges;

	private String charges_per_use;

	private String turns_per_charge;

	private String ammo;

	private String revert_to;
	
	/**
	 * The Constructor is blank because it is going to be instantiated with its setters
	 */
	public Item(){}
	
	
	/**
	 * This constructor is reserved for moving items over to the left drop list
	 * String name - a user friendly read name it is displayed on the lists
	 * String id - This is a major string needed for building json files
	 * String Description - Will contain information regaurding the item (incase they want ammo)
	 */
	public Item( String name, String category, String id, String Description){
		this.name = name;
		this.id = id;
		this.description = Description;
		this.category = category;
	}

	
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
			
			if(line.contains("\"id\"")){
				line = line.substring(line.indexOf(":") + 1);
				id = line;
				continue;
			}

			if(line.contains("\"type\"")){
				line = line.substring(line.indexOf(":") + 1);
				type = line;
				continue;
			}
			
			if(line.contains("\"symbol\"")){
				line = line.substring(line.indexOf(":") + 1);
				symbol = line;
				continue;
			}

			if(line.contains("\"color\"")){
				line = line.substring(line.indexOf(":") + 1);
				color = line;
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
			
			if(line.contains("\"price\"")){
				line = line.substring(line.indexOf(":") + 1);
				price = line;
				continue;
			}
			
			if(line.contains("\"weight\"")){
				line = line.substring(line.indexOf(":") + 1);
				weight = line;
				continue;
			}

			if(line.contains("\"volume\"")){
				line = line.substring(line.indexOf(":") + 1);
				volume = line;
				continue;
			}

			if(line.contains("\"max_charges\"")){
				line = line.substring(line.indexOf(":") + 1);
				max_charges = line;
				continue;
			}

			if(line.contains("\"initial_charges\"")){
				line = line.substring(line.indexOf(":") + 1);
				initial_charges = line;
				continue;
			}
			
			if(line.contains("\"charges_per_use\"")){
				line = line.substring(line.indexOf(":") + 1);
				charges_per_use = line;
				continue;
			}

			if(line.contains("\"turns_per_charge\"")){
				line = line.substring(line.indexOf(":") + 1);
				turns_per_charge = line;
				continue;
			}

			if(line.contains("\"ammo\"")){
				line = line.substring(line.indexOf(":") + 1);
				ammo = line;
				continue;
			}

			if(line.contains("\"revert_to\"")){
				line = line.substring(line.indexOf(":") + 1);
				revert_to = line;
				continue;
			}
			

			
			//-------------The Code below is optional

			//Use actions of an item are stored inside of a Table object
			if(line.contains("\"use_action\"")){
				
				/*If use_action attribute contains a body statement
				 *then we need to make a table ELSE it is just a simple
				 *one word definition of a tool: (HOTPLATE, HAMMER .. etc)*/
				if(line.contains("{")){
					use_action_attr = new Use_Action_Table();
					use_action_attr.buildTable(bufferedReader); // Will search for the '}' while building  the use_action description
					continue;
				}
				else{					
					line = line.substring(line.indexOf(":") + 1);
					use_action_attr = new Use_Action_Table(line); 
					continue;
				}
			}
			
			if(line.contains("\"bashing\"")){
				line = line.substring(line.indexOf(":") + 1);
				bashing = line;
				continue;
			}
			
			if(line.contains("\"cutting\"")){
				line = line.substring(line.indexOf(":") + 1);
				cutting = line;
				continue;
			}
			
			if(line.contains("\"to_hit\"")){
				line = line.substring(line.indexOf(":") + 1);
				to_hit = line;
				continue;
			}

			
			if(line.contains("\"flags\"")){
				line = line.substring(line.indexOf("[") + 1);
				flags = line;
				continue;
			}
			
			if(line.contains("\"qualities\"")){
				line = line.substring(line.indexOf("[") + 1);
				qualities = line;
				continue;
			}
			
			if(line.contains("\"price_postapoc\"")){
				line = line.substring(line.indexOf(":") + 1);
				category = line;
				continue;
			}
			
			if(line.contains("\"category\"")){
				line = line.substring(line.indexOf(":") + 1);
				category = line;
				continue;
			}
			
			if(line.contains("\"material\"")){
				line = line.substring(line.indexOf("[") + 1);
				material = line;
				continue;
			}
			
			if(line.contains("\"name_plural\"")){
				line = line.substring(line.indexOf(":") + 1);
				name_plural = line;
				continue;
			}
			
			if(line.contains("\"ammo_type\"")){
				line = line.substring(line.indexOf(":") + 1);
				name_plural = line;
				continue;
			}
			
			//Ignore comments - they are not an attribute 
			if(line.contains("\"//\""))
				continue;
			
				
			//TODO Techniques are special things that your item can do I will add this later
			if(line.contains("\"techniques\""))
				continue;

			//TODO This is a subcategory of the "USE_ACTION" - which I will be implementing later
			if(line.contains("\"type\""))
				continue;
			
			//TODO Another subcategory of USE_ACTION
			if(line.contains("\"need_sunlight\""))
				continue;
			
			//this.type.equalsIgnoreCase("GENERIC")
	        //It is the responsibility of a child class find the end of a json body statement (the '}')
			// UNLESS The item is a Generic Type			
			if( (line.contains("},") || line.contains("}"))  ){
	        	//System.out.println(this.toString());
	        	
	        	if( line.contains("},{"))
	        		return 0;
	        	else
	        		return 1;
	        }
			
			
	        //Else if this was a constructor called then do not look for the end of the body statemt (the '}')
			else if(true){
	        	//System.out.println("ERROR: " + line);
	        	continue;
			}
	        
		}//End of while loop
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
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


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getVolume() {
		return volume;
	}


	public void setVolume(String volume) {
		this.volume = volume;
	}


	public String getBashing() {
		return bashing;
	}


	public void setBashing(String bashing) {
		this.bashing = bashing;
	}


	public String getCutting() {
		return cutting;
	}


	public void setCutting(String cutting) {
		this.cutting = cutting;
	}


	public String getTo_hit() {
		return to_hit;
	}


	public void setTo_hit(String to_hit) {
		this.to_hit = to_hit;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName_plural() {
		return name_plural;
	}

	public void setName_plural(String name_plural) {
		this.name_plural = name_plural;
	}
	
	public String getPrice_postapoc() {
		return price_postapoc;
	}

	public void setPrice_postapoc(String price_postapoc) {
		this.price_postapoc = price_postapoc;
	}
	
	public String getQualities() {
		return qualities;
	}

	public void setQualities(String qualities) {
		this.qualities = qualities;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getFlags() {
		return flags;
	}


	public void setFlags(String flags) {
		this.flags = flags;
	}

	
	public String printAllAttrbibutes() {
		return "\nItem [type=" + type + "\n, id=" + id + "\n, symbol=" + symbol
				+ "\n, color=" + color + "\n, name=" + name + "\n, description="
				+ description + "\n, price=" + price + "\n, weight=" + weight
				+ "\n, volume=" + volume + "\n, bashing=" + bashing + "\n, cutting="
				+ cutting + "\n, to_hit=" + to_hit + "\n, category=" + category
				+ "\n, flags=" + flags + "\n, plural=" + name_plural + "]"
				+ "\n, materal=" + material + "\n, plural=" + qualities
				+ "\n, price_postapoc=" + price_postapoc;
	}
	
	@Override
	public String toString(){
		return name ;
	}


	
}
