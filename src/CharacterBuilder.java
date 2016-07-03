import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;

public class CharacterBuilder {
	
	public static void main( String args[] ) throws IOException{
		
		CharacterBuilderModel model = new CharacterBuilderModel();
		SkillsAndTraitsModel traitsmodel = new SkillsAndTraitsModel();
		ArrayList<Item> genericList = new ArrayList<Item>();
		ArrayList<Trait> traitList = new ArrayList<Trait>();
		
		model.openJsonFile("../CataCharGenerator/src/json/items/tool_armor.json", genericList);
		traitsmodel.openJsonFile("../CataCharGenerator/src/json/mutations.json");
		
		model.openJsonFile("../CataCharGenerator/src/json/items/generic.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/tools.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/archery.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/ammo.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/armor.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/bionics.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/books.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/chemicals_and_resources.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/comestibles.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/containers.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/handloaded_bullets.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/martial_arts_manuals.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/melee.json", genericList);
		model.openJsonFile("../CataCharGenerator/src/json/items/ranged.json", genericList);

		CharBuilderFrame frame = new CharBuilderFrame(model);
		SkillsAndTraitsFrame skillTFrame = new SkillsAndTraitsFrame(traitsmodel);
		
		
		CharacterBuilderController controller = new CharacterBuilderController(model, frame);
		SkillsAndTraitsController skillTController = new SkillsAndTraitsController( traitsmodel, skillTFrame);
		skillTFrame.getBackButton().addActionListener(controller);
		frame.getNextButton().addActionListener(skillTController);
		frame.getSearchButton().addActionListener(controller);
		//frame.getSearchRequestTextField();
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		skillTFrame.getExportButton().addActionListener( new CataJsonFile(model,frame, traitsmodel, skillTFrame) );
		/*for(int x = 0; x < genericList.size(); x++){
			
			System.out.println("lo:"+genericList.get(x).getId()+"COUNT: "+ x);
		}*/
		//for(int x = 0; x < traitList.size(); x++){
		//	System.out.println("lo:"+traitList.get(x).getGameID()+"COUNT: "+ x);
		//}
		
		
		
	}
	
	
}
