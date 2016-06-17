import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JSpinner;

public class CataJsonFile implements ActionListener{
	
	private static CharacterBuilderModel model;
	private static CharBuilderFrame frame;
	private static SkillsAndTraitsModel traitsmodel;
	private static SkillsAndTraitsFrame skillTFrame;
	
	final static int numOfSkills = 26;
	
	public CataJsonFile(CharacterBuilderModel model, CharBuilderFrame frame, 
			SkillsAndTraitsModel traitsmodel, SkillsAndTraitsFrame skillTFrame){
		
		CataJsonFile.model = model ;
		CataJsonFile.frame = frame ;
		CataJsonFile.traitsmodel = traitsmodel;
		CataJsonFile.skillTFrame = skillTFrame ;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equalsIgnoreCase("Save and Export"))
			try {
				makeCharacterFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
	public static void makeCharacterFile() throws IOException{


		File file = new File("../CataCharGenerator/src/mods/CataBMods");
		File modfile = new File("../CataCharGenerator/src/mods/CataBMods/classes.json");

		FileWriter fstream;
		BufferedWriter out;
		BufferedReader bufferedReader;
		


		if( file.mkdir() ){

			System.out.println("Creating a directory");
			modfile.createNewFile();			
			fstream = new FileWriter(modfile); 
			out = new BufferedWriter(fstream);
			
		
			out.write("[\n");
			out.write("    {\n");
			writeCharacter(out);
			out.write("    }\n"); //Only part I need to keep in mind
			out.write("]\n");

			out.close();
			
			return;
		}
		else
			System.out.println("Appending to a file");

		bufferedReader = new BufferedReader(new FileReader(modfile) );
		String stream = "";
		String line = "";
		
		
		//While finding the last character template - 
		while( !(line.equalsIgnoreCase("    }")) ){
			line = bufferedReader.readLine();
			
			/*Debug IO
			if(line.equalsIgnoreCase("    }")) 
				continue;
		
			System.out.println(line);
			stream += line + "\n";
			*/
		}
		
		System.out.println("Stream contents:\n" + stream);
		bufferedReader.close();
		
		fstream = new FileWriter(modfile); //true tells to append data.
		out = new BufferedWriter(fstream);
		
		
		out.write(stream);
		out.write("    },\n");
		out.write("    {\n");
		writeCharacter(out);
		out.write("    }\n");
		out.write("]\n");

		
		out.close();
				
		
		
	}

	private static void writeCharacter(BufferedWriter out) throws IOException {
		
		ArrayList<JSpinner> spinnerList = skillTFrame.getSpinnerList();
		String stringList[] = skillTFrame.getSkillStringList();
		String optionalNames = skillTFrame.getFemaleInGameName().getText();
		
		out.write("        \"type\": \"profession\",\n");
		out.write("        \"ident\": \""+ skillTFrame.getClassName().getText() +"\",\n");
		
		if( optionalNames.equalsIgnoreCase("(This is optional)") || optionalNames.equalsIgnoreCase("")) //if there is an optional name
			out.write("        \"name\": \""+ skillTFrame.getMaleInGameName() +"\",\n");
		else{
			out.write("        \"name\": {\n");
			out.write("            \"male\": \""+skillTFrame.getMaleInGameName()+"\",\n");
			out.write("            \"female\": \""+optionalNames+"\"\n");
			out.write("        },\n");			
		}
		
		out.write("        \"description\": "+ skillTFrame.getDescriptionTextBox().getText() +",\n");
		out.write("        \"points\": "+ ((Integer)skillTFrame.getClassCostSpinner().getValue()) +",");
		
		if( listsContainsBionics() ){
			out.write("        \"CBMs\":[\n");
			//CBMS are automatically implemented to the character upon start-up
			for(int x = 0; x < model.getGeneralList().getSize(); x++){
				if(model.getGeneralList().getElementAt(x).getCategory().equalsIgnoreCase("bionics"))
					out.write("            \"" + model.getGeneralList().getElementAt(x).getId() +"\"\n");
			}
				
			out.write("        \"],\n");
		}
		
		if( classHasSkills() ){ //Some people may only want equipment for the class NOT skills
			
			boolean isFirstSkill = true;
			
			out.write("        \"skills\": [\n");
			
			for(int x = 0; x < numOfSkills; x++){
				
				int skillLevel = (Integer)spinnerList.get(x).getValue();
				String skillName = stringList[x];
				
				if(skillLevel == 0)
					continue;
				
				if(!isFirstSkill) //if this is not the first skill then add a comma
					out.write(",\n");
				
				isFirstSkill = false;
				
				out.write("            {\n");
				out.write("                \"level\": "+skillLevel+",\n");
				out.write("                \"name\": "+skillName+",\n");
				out.write("            }");
			}
			
			out.write("\n");
			out.write("        ],\n");
		}

		
		out.write("        \"Items\": {\n");
		
		if(!model.getGeneralList().isEmpty()){
			DefaultListModel<Item> bothList = model.getGeneralList();
			
			out.write("            \"both\": [");
			
			for(int x = 0; x < bothList.size(); x++)
				out.write("                "+bothList.get(x).getId()+"\n");
			
			out.write("            ]");
		}

		if(!model.getMaleList().isEmpty()){
			
			if(!model.getGeneralList().isEmpty()) // if general list has something
				out.write(",\n");
			
			DefaultListModel<Item> maleList = model.getMaleList();
			
			out.write("            \"male\": [");
			
			for(int x = 0; x < maleList.size(); x++)
				out.write("                "+maleList.get(x).getId()+"\n");
			
			out.write("            ]");
			
		}

		if(!model.getFemaleList().isEmpty()){
			
			if( !model.getGeneralList().isEmpty() || !model.getMaleList().isEmpty()) // if general list has something or male list
				out.write(",\n");

			
			DefaultListModel<Item> femaleList = model.getFemaleList();
			
			out.write("            \"female\": [");
			
			for(int x = 0; x < femaleList.size(); x++)
				out.write("                "+femaleList.get(x).getId()+"\n");
			
			out.write("            ]");
			
		}
		
		out.write("\n");
		out.write("        }\n");
		return;

		
	}

	private static boolean classHasSkills() {
		
		ArrayList<JSpinner> spinners = skillTFrame.getSpinnerList();
		
		for(int x = 0; x < numOfSkills; x++){
			if((Integer)spinners.get(x).getValue() > 0){
				return true;
			}
		}
		
		return false;
	}

	private static boolean listsContainsBionics() {
		
		for(int x = 0; x < model.getGeneralList().getSize(); x++)
			if(model.getGeneralList().get(x).getCategory().equalsIgnoreCase("bionics"))
				return true;
		for(int x = 0; x < model.getFemaleList().getSize(); x++)
			if(model.getFemaleList().get(x).getCategory().equalsIgnoreCase("bionics"))
				return true;
		for(int x = 0; x < model.getMaleList().getSize(); x++)
			if(model.getMaleList().get(x).getCategory().equalsIgnoreCase("bionics"))
				return true;
		
		return false;
	}
}
