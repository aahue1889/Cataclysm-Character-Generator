import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SkillsAndTraitsController implements ActionListener, ListSelectionListener{
	
	private SkillsAndTraitsModel model;
	private SkillsAndTraitsFrame view;
	private CataJsonFile outputFile;

	public SkillsAndTraitsController( SkillsAndTraitsModel model , SkillsAndTraitsFrame view){
		this.model = model;
		this.view = view;
		view.getAddButton().addActionListener(this);
		view.getRemoveButton().addActionListener(this);
		view.getTraitsList().addListSelectionListener(this);
		view.getChosentraitsList().addListSelectionListener(this);
		view.getBackButton().addActionListener(this);
		view.getExportButton().addActionListener(this);
	}
	
	public CataJsonFile getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(CataJsonFile outputFile) {
		this.outputFile = outputFile;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equalsIgnoreCase("add")){
			Trait selectedTrait = view.getTraitsList().getSelectedValue();
			model.getExportedTraitList().addElement(selectedTrait);
			view.getChosentraitsList().validate();
		}
		
		if(e.getActionCommand().equalsIgnoreCase("remove")){
			int index = view.getChosentraitsList().getSelectedIndex();
			model.getExportedTraitList().removeElementAt(index);
			view.getDescriptionTextBox().setText("");
			view.getChosentraitsList().validate();
		}
		if(e.getActionCommand().equalsIgnoreCase("Back to Items")){
			view.setVisible(false);
		}		
		if(e.getActionCommand().equalsIgnoreCase("Skills And Traits"))
			view.setVisible(true);
		if(e.getActionCommand().equalsIgnoreCase("Save and Export")){
			if(view.getClassName().getText().equalsIgnoreCase("")){
				
				for(int x = 0; x < view.getClassName().getText().length(); x++){
					char ch = view.getClassName().getText().charAt(x);
					if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z' ) || (ch == '_') ){
						continue;
					}
					else{
						//custom title, error icon
						JOptionPane.showMessageDialog(view,
						    "Please use only alphabetic lowercase characters as the Class Name",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
						return;

					}
				}
				
				//custom title, error icon
				JOptionPane.showMessageDialog(view,
				    "A class needs a variable name with no spaces \n ex: wrestler or sumo_wrestler BUT NOT sumo wrestler",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);

				return; // error
			}
			if(view.getDescriptionTextBox().getText().equalsIgnoreCase("You are Dovakiin, a mighty warrior and slayer of dragons!")){
				
				//custom title, error icon
				JOptionPane.showMessageDialog(view,
				    "Please enter a customized Description - it helps people understand what your class does/is" +
				    "\nExample: \"You are a Storm Trooper - a mighty warrior of the fallen empire\"",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);

				return; // error
			}
			if( view.getMaleInGameName().getText().equalsIgnoreCase("")) {
				
				//custom title, error icon
				JOptionPane.showMessageDialog(view,
				    "This is the \"IN GAME name\" of your class - the male text box is the default name",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);

				return; // error
			}
			
			
				try {
					outputFile.makeCharacterFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				view.setVisible(false);
				
		}
		else
			System.out.println("CONTROLLER MISFIRE");
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if( ((JList<Trait>)e.getSource()).getSelectedValue() instanceof Trait){
		
		Trait retrievedItem = (Trait)((JList<Trait>) e.getSource()).getSelectedValue();
		view.getDescriptionTextBox().setText(retrievedItem.getDescription());
		
		}
		else
			System.out.println("I don't know what this is");
		
	}



	
	
	
}
