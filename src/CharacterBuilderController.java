import java.awt.Container;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.TransferHandler;


//I might rename this to List listerner (but not now - as I do not know the functionality of this class)

@SuppressWarnings("serial")
public class CharacterBuilderController extends TransferHandler implements ListSelectionListener, ActionListener {

	CharacterBuilderModel model;
	CharBuilderFrame view;
	JList source;
	
	/**
	 * This will be used to create the item on the right list
	 */
	String tempDescription;
	String tempName;
	String tempID;
	String tempCategory;
	
	private String description;
	
	public CharacterBuilderController(CharacterBuilderModel model, CharBuilderFrame view){
		this.model = model;
		this.view = view;
		
		view.getNextButton().addActionListener(this);
		
		view.getItemList().addListSelectionListener(this);
		view.getFemaleList().addListSelectionListener(this);
		view.getMaleList().addListSelectionListener(this);
		view.getGeneralList().addListSelectionListener(this);

		
		view.getGeneralList().setTransferHandler(new ImportTransferHandler( view.getGeneralList(), model.getGeneralList()) );
		view.getFemaleList().setTransferHandler( new ImportTransferHandler( view.getFemaleList(), model.getFemaleList()) );
		view.getMaleList().setTransferHandler( new ImportTransferHandler(view.getMaleList(), model.getMaleList() ));
		
		view.getItemList().setTransferHandler( new ExportTransferHandler( view.getItemList() ) );
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//Object tempList = ((JList)e.getSource()).getSelectedValue();
		
		if( ((JList)e.getSource()).getSelectedValue() instanceof Item){
			
			Item retrievedItem = (Item)((JList) e.getSource()).getSelectedValue();
			tempName = retrievedItem.getName();
			tempID = retrievedItem.getId();
			tempDescription = retrievedItem.getDescription();
			tempCategory = retrievedItem.getCategory();		
			view.getTextArea().setText(retrievedItem.getDescription());
			
		}
		else
			System.out.println("I don't know what this is");
	}
		
    private class ExportTransferHandler extends TransferHandler {
    	
    	private JList<Item> source;
    	
    	
    	public ExportTransferHandler( JList<Item> exportList ){
    		source = exportList;
    	}
    	
        public int getSourceActions(JComponent c){ //Triggered Every Click on a  Export item 
            return TransferHandler.COPY_OR_MOVE;
        }
     
        public Transferable createTransferable(JComponent c) { // Triggered by dragging the mouse on Source
        	return new StringSelection( source.getSelectedValue().getName() );
        }
    }
    
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Skills And Traits"))
			view.setVisible(false);
		if(e.getActionCommand().equalsIgnoreCase("Back to Items"))
			view.setVisible(true);
	}
 
    private class ImportTransferHandler extends TransferHandler {

    	private JList<Item> target;
    	private DefaultListModel<Item> modelTarget;
    	
    	public ImportTransferHandler( JList<Item> importList, DefaultListModel<Item> importModel){
    		target = importList;
    		modelTarget = importModel;
    		
    	}
    	
        public boolean canImport(TransferHandler.TransferSupport supp) { // When dragged over target list
          // if (!supp.isDataFlavorSupported(DataFlavor.stringFlavor)) {
           //     return false;
           // }
            return true;
        }
     
        /**
         * Supp is the item that is currently stored from source (the origin of the drag)
         * TODO Should I just make the right Strings?
         */
        public boolean importData(TransferHandler.TransferSupport supp) { // Mouse released on Target
            // Fetch the Transferable and its data
            Transferable t = supp.getTransferable();
            String data = "";
            try {
                data = (String) t.getTransferData(DataFlavor.stringFlavor); //convert the item into what you want (CASTING NECESSARY)
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }

            // Fetch the drop location
            JList.DropLocation loc = target.getDropLocation();
            int row = loc.getIndex();
            modelTarget.add(row, new Item(tempName, tempID, tempDescription, tempCategory) );
            target.validate();
            return true;
        }
    
    }
    
}
