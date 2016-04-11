import java.util.ArrayList;

import javax.swing.JFrame;

public class CharacterBuilder {
	
	public static void main( String args[] ){
		
		CharacterBuilderModel model = new CharacterBuilderModel();
		ArrayList<Item> genericList = new ArrayList<Item>();
		
		model.openJsonFile("../CataCharGenerator/src/json/items/tool_armor.json", genericList);

		//openJsonFile("../CataCharGenerator/src/json/items/generic.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/tools.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/archery.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/ammo.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/armor.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/bionics.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/books.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/chemicals_and_resources.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/comestibles.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/containers.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/handloaded_bullets.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/martial_arts_manuals.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/melee.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/ranged.json", genericList);
		//openJsonFile("../CataCharGenerator/src/json/items/software.json", genericList);

		CharBuilderFrame frame = new CharBuilderFrame(model);
		CharacterBuilderController controller = new CharacterBuilderController(model, frame);
		
		frame.getItemList().addListSelectionListener(controller);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int x = 0; x < genericList.size(); x++){
			
			System.out.println("lo:"+genericList.get(x).getId()+"COUNT: "+ x);
		}
	}
}
