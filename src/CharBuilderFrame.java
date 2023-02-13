import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JInternalFrame;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CharBuilderFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CataJsonFile outputFile;
	
	private JPanel panel_3,requestedItemsPanel, descriptionPanel, middlePanel;

	JLabel itemPanel;
	private JLabel ItemListPanel, queryPanel;
	private JScrollPane searchPane, scrollPane;
	//private JList<String> ;



	private JList<Item> femaleList;
	private JList<Item> itemList, generalList, maleList, queryList;
	private JLabel lblFemaleList;
	private JLabel lblMaleList;
	private JTextArea textArea;	
	private JTextField searchRequestTextField;
	private JButton nextButton = new JButton("Skills and Traits");
	private JButton searchButton; 
	private JComboBox<String> categoryComboBox;


	public CharBuilderFrame(CharacterBuilderModel model) {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//Description Panel (Left Panel)
		descriptionPanel = new JPanel();
		getContentPane().add(descriptionPanel, BorderLayout.WEST);
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
		JLabel lblDetail = new JLabel("Details: ");
		descriptionPanel.add(lblDetail);		
		textArea = new JTextArea(20,30);
		textArea.setLineWrap(true);		
		JScrollPane textScroller = new JScrollPane(textArea);
		descriptionPanel.add(textScroller);
				
		
		//requested Items Panel (the Right Panel)
		requestedItemsPanel = new JPanel();
		requestedItemsPanel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel femaleListPanel = new JPanel();
		femaleListPanel.setLayout(new BoxLayout(femaleListPanel, BoxLayout.Y_AXIS));
		lblFemaleList = new JLabel("female list");
		femaleListPanel.add(lblFemaleList);
		femaleList = new JList<Item>(model.getFemaleList());
		femaleList.setDragEnabled(true);
		femaleList.setModel((ListModel<Item>) model.getFemaleList());
		//femaleList.setTransferHandler(new ImportTransferHandler(femaleList, model.getFemaleList()));
		femaleList.setDropMode(DropMode.INSERT);
		JScrollPane femalescrollPane = new JScrollPane(femaleList);
		femalescrollPane.setViewportView(femaleList);
		femalescrollPane.setPreferredSize(new Dimension(400, 100));
		femaleListPanel.add(femalescrollPane);
		requestedItemsPanel.add(femaleListPanel);
		
		JPanel maleListPanel = new JPanel();
		maleListPanel.setLayout(new BoxLayout(maleListPanel, BoxLayout.Y_AXIS));
		lblMaleList = new JLabel("male list");
		maleListPanel.add(lblMaleList);
		maleList = new JList<Item>(model.getMaleList());
		maleList.setDragEnabled(true);
		//maleList.setTransferHandler(new ListTransferHandler());
		//maleList.setTransferHandler(new ImportTransferHandler(maleList, model.getMaleList()));
		maleList.setDropMode(DropMode.INSERT);
		JScrollPane malescrollPane = new JScrollPane(maleList);
		malescrollPane.setViewportView(maleList);
		malescrollPane.setPreferredSize(new Dimension(400, 100));
		maleListPanel.add(malescrollPane);
		requestedItemsPanel.add(maleListPanel);
		

		JPanel generalListPanel = new JPanel();
		generalListPanel.setLayout(new BoxLayout(generalListPanel, BoxLayout.Y_AXIS));
		JLabel lblGeneralList = new JLabel("general list");
		generalListPanel.add(lblGeneralList);
		generalList = new JList<Item>(model.getGeneralList());
		generalList.setDragEnabled(true);
		//generalList.setTransferHandler(new ImportTransferHandler(generalList, model.getGeneralList()));
		generalList.setDropMode(DropMode.INSERT);
		JScrollPane generalscrollPane = new JScrollPane(generalList);
		generalscrollPane.setViewportView(generalList);
		generalscrollPane.setPreferredSize(new Dimension(400, 100));
		generalListPanel.add(generalscrollPane);
		requestedItemsPanel.add(generalListPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(nextButton);
		
		requestedItemsPanel.add(buttonPanel);


		getContentPane().add(requestedItemsPanel, BorderLayout.EAST);
		
		
 		middlePanel = new JPanel();
 		
		
		itemPanel = new JLabel();
 		itemList = new JList<Item>(new Vector<Item>(model.getItemList()) );
		itemList.setVisibleRowCount(10);
		itemList.setCellRenderer(new DefaultListCellRenderer());
		itemList.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		itemList.setDragEnabled(true);
		itemList.setTransferHandler(new ExportTransferHandler());
		
		scrollPane = new JScrollPane(itemList);
 		scrollPane.setPreferredSize(new Dimension(500, 300));
		middlePanel.add(scrollPane);
 		
		
		
		queryPanel = new JLabel();
 		queryList = new JList<Item>(model.getSearchList());
		queryList.setVisibleRowCount(10);
		queryList.setCellRenderer(new DefaultListCellRenderer());
		queryList.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		queryList.setDragEnabled(true);
		queryList.setTransferHandler(new ExportTransferHandler());
		
		searchPane = new JScrollPane(queryList);
 		searchPane.setPreferredSize(new Dimension(500, 300));
		
	    scrollPane.setVisible(true);

	    
	    getContentPane().add(middlePanel, BorderLayout.CENTER);
		

		//NORTH PANEL
	    JPanel searchEnginePanel = new JPanel();
	    searchEnginePanel.add(new JLabel("Search"));
	    getContentPane().add(searchEnginePanel, BorderLayout.NORTH);
	    
	    searchRequestTextField = new JTextField(10);
	    searchRequestTextField.setMaximumSize(new Dimension(300, 100));
	    searchEnginePanel.add(searchRequestTextField);
	    
	    searchButton = new JButton("Search");
	    searchEnginePanel.add(searchButton);
	    
	    
	    categoryComboBox = new JComboBox<String>(model.getCategoryList().toArray(new String[model.getCategoryList().size()] ));
	    searchEnginePanel.add(categoryComboBox);
	    //categoryComboBox.add();
	    //itemPanel.add(searchEnginePanel);

	}
		

	public void addItemList() {
		
		//itemPanel = new JLabel();
 		//itemList = new JList<Item>(new Vector<Item>(model.getItemList()) );
		itemList.setVisibleRowCount(10);
		itemList.setCellRenderer(new DefaultListCellRenderer());
		itemList.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		itemList.setDragEnabled(true);
		itemList.setTransferHandler(new ExportTransferHandler());
		
		scrollPane = new JScrollPane(itemList);
 		scrollPane.setPreferredSize(new Dimension(500, 300));
		middlePanel.add(scrollPane);

	}
	
	public void addQueryList() {
		
		//queryPanel = new JLabel();
 		//queryList = new JList<Item>(model.getSearchList());
		queryList.setVisibleRowCount(10);
		queryList.setCellRenderer(new DefaultListCellRenderer());
		queryList.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		queryList.setDragEnabled(true);
		queryList.setTransferHandler(new ExportTransferHandler());
		
		searchPane = new JScrollPane(queryList);
 		searchPane.setPreferredSize(new Dimension(500, 300));
 		middlePanel.add(searchPane);

	}
	
	public JComboBox<String> getCategoryComboBox() {
		return categoryComboBox;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public JPanel getMiddlePanel(){
		return middlePanel;
	}
	
	
	public JList<Item> getQueryList(){
		return queryList;
	}

	public JLabel getQueryPanel() {
		return queryPanel;
	}
	
	public JLabel getItemListPanel() {
		return itemPanel;
	}
	
	public JTextField getSearchRequestTextField() {
		return searchRequestTextField;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	
	public JButton getNextButton() {
		return nextButton;
	}

	public JList<Item> getMaleList() {
		return maleList;
	}

	public void setMaleList(JList<Item> maleList) {
		this.maleList = maleList;
	}

	public JList<Item> getFemaleList() {
		return femaleList;
	}

	public void setFemaleList(JList<Item> femaleList) {
		this.femaleList = femaleList;
	}

	public JList<Item> getGeneralList() {
		return generalList;
	}


	public void setGeneralList(JList<Item> generalList) {
		this.generalList = generalList;
	}
	
	public JList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(JList<Item> itemList) {
		this.itemList = itemList;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
    private class ExportTransferHandler extends TransferHandler {
        public int getSourceActions(JComponent c){
            return TransferHandler.COPY_OR_MOVE;
        }
     
        public Transferable createTransferable(JComponent c) {
        	if(itemList.isSelectionEmpty())
        		return new StringSelection(queryList.getSelectedValue().getName());
        	else
        		return new StringSelection(itemList.getSelectedValue().getName());
        }
    }
 
    /**
     * TODO
     * @author sentinal
     *
     
    private class ImportTransferHandler extends TransferHandler {

    	private JList<Item> target;
    	private DefaultListModel model;
    	
    	public ImportTransferHandler(JList<Item> target, ArrayList<Item> array){
    		this.target = target;
    		DefaultListModel<Item> model = new DefaultListModel<>();
    		
			   for(Item val : array){
			         model.addElement(val);
			   }
			   
			   target.setModel(model);
    	}
    	

		public boolean canImport(TransferHandler.TransferSupport supp) {
            if (!supp.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            	System.out.print("Not making it");
                return false;
            }
            return true;
        }
     
        public boolean importData(TransferHandler.TransferSupport supp) {
            // Fetch the Transferable and its data
            Transferable t = supp.getTransferable();
            String data = "";
            
            try {
                data = (String)t.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
            

            // Fetch the drop location
            JList.DropLocation loc = target.getDropLocation();
            int row = loc.getIndex();
            mod
            target = new JList<Item>(new Vector<Item>(model.getItemList()) );
            target.validate();
            return true;
        }
    }

	*/
	
}
