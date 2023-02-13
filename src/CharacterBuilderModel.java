
import java.io.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class CharacterBuilderModel {

	private ArrayList<String> categoryList = new ArrayList<String>();
	private ArrayList<Item> itemList;
	DefaultListModel<Item> generalList, femaleList, maleList, tempList;
	
	public CharacterBuilderModel(  ){
    	categoryList.add("All"); // We need an empty cell in the categoryDropList
		
		femaleList = new DefaultListModel<Item>();
		femaleList.addElement(new Item());
		
		maleList = new DefaultListModel<Item>();
		maleList.addElement(new Item());
		
		generalList = new DefaultListModel<Item>();
		generalList.addElement(new Item());
		
		tempList = new DefaultListModel<Item>();
		
		itemList = new ArrayList<Item>();
	}

	public void openJsonFile( String fileName, ArrayList<Item> genericList){

		String line = "";
		//itemList = genericList; //TODO This should be in the constructor
								// but i'm brainstorming on how I can divide the list size to other areas

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int character; // TODO put this somewhere more appropriate
            int isCorrect;
            
            while( (character = bufferedReader.read()) != -1) {
                //System.out.println(line);
            	char ch = (char)character;
            	
                if( ch == '{' ){
                	while(true){
                	
	                	Item newitem = new Item();
	                	isCorrect = newitem.buildItem(bufferedReader);
	                	System.out.println(newitem.toString());
	                	
	                	//This catches false 'items' to keep the itemlist short
	                	// instead of filled with null elements.
	                	if(newitem.getId() == null)
	                		continue;
	                	
	                	itemList.add(newitem);
	                	
	                	String category = newitem.getType();
	                	System.out.println(category);
	                	if(category != null){
	                		//if(categoryList.size() == 0)
	                		//	categoryList.add(category);
	                			
		                	for(int x = 0; x < categoryList.size(); x++)
		                	{
		                		if(categoryList.get(x).equalsIgnoreCase(category) || categoryList.get(x).contains(category))
		                			break;
		                		//if(categoryList.get(x).equalsIgnoreCase(category))	
		                		else if(x == (categoryList.size()-1))
		                			categoryList.add(category);
		                	}
		                }
	                	if(isCorrect == 1) break;
	                	else continue;
                	}
                }
                
                //bufferedReader.mark(0);
                /*if( line.contains("\"TOOL\"")){ // This will be next
                	Item newtool = new Tool();
                	genericList.add(newtool);
                	continue;
                }*/

                /*case "        \"type\":\"COMESTIBLE\",":
                	isGeneric = true;
                	//Item newitem = new Item();
                	storeItem(newitem);
                case "        \"type\":\"GENERIC\",":
                	isGeneric = true;
                	//Item newitem = new Item();
                	storeItem(newitem);
                 */
                
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}




	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public DefaultListModel<Item> getMaleList() {
		return maleList;
	}

	public void setMaleList(DefaultListModel<Item> maleListModel) {
		this.maleList = maleListModel;
	}

	public DefaultListModel<Item> getFemaleList() {
		return femaleList;
	}

	public void setFemaleList(DefaultListModel<Item> femaleList) {
		this.femaleList = femaleList;
	}

	public DefaultListModel<Item> getGeneralList() {
		return generalList;
	}

	public void setGeneralList(DefaultListModel<Item> generalList) {
		this.generalList = generalList;
	}
	
	public DefaultListModel<Item> getSearchList() {
		return tempList;
	}

	public void setSearchList(DefaultListModel<Item> searchList) {
		this.tempList = searchList;
	}
}