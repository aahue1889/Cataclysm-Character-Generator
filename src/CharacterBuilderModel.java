
import java.io.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class CharacterBuilderModel {

	private ArrayList<Item> itemList;
	private DefaultListModel<String> femaleList, maleList, generalList;
	
	public CharacterBuilderModel(){
		femaleList = new DefaultListModel<String>();
		femaleList.addElement(new String());
		
		maleList = new DefaultListModel<String>();
		maleList.addElement(new String());
		
		generalList = new DefaultListModel<String>();
		generalList.addElement(new String());

	}

	public void openJsonFile( String fileName, ArrayList<Item> genericList){

		String line = "";
		itemList = genericList; //TODO This should be in the constructor
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
	                	genericList.add(newitem);
	                	
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



	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public DefaultListModel<String> getMaleList() {
		return maleList;
	}

	public void setMaleList(DefaultListModel<String> maleListModel) {
		this.maleList = maleListModel;
	}

	public DefaultListModel<String> getFemaleList() {
		return femaleList;
	}

	public void setFemaleList(DefaultListModel<String> femaleList) {
		this.femaleList = femaleList;
	}

	public DefaultListModel<String> getGeneralList() {
		return generalList;
	}

	public void setGeneralList(DefaultListModel<String> generalList) {
		this.generalList = generalList;
	}
}