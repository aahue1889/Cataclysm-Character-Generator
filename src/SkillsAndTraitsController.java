import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SkillsAndTraitsController implements ActionListener, ListSelectionListener{
	
	private SkillsAndTraitsModel model;
	private SkillsAndTraitsFrame view;

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
		if(e.getActionCommand().equalsIgnoreCase("Save and Export"))
			view.setVisible(false);
		else
			System.out.println("I have no idea what this is");
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
