import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class SkillsAndTraitsFrame extends JFrame{
	
	final int numberOfSkillsinGame = 26;
	
	private JPanel[] skillPanelList = new JPanel[26];
	
    private JSpinner spinarchery, spinbartering, spinbashing_weapons,  spincomputers, spinlconstruction
    , spincooking , spincutting_weapons  , spindodging  , spindriving  , spinectronics  , spinfabrication  
    , spinfirst_aid  , spinhandguns   , spinlaunchers   , spinmechanics  , spinmelee  
    , spinpiercing  ,  spinrifles   ,  spinspeaking   ,  spinsubmachguns   ,  spinsurvival  
    ,  spinswimming   ,  spinTailoring  ,  spinthrowing  ,  spintrapping   ,  spinunarmedcomb, classCostSpinner;
    
    /**
     * TODO This information should be read from a file - but its not important
     */
    private String[] skillStringList = {
        "Archery", "Bartering", "Bashweap", "Computers",
        "Construction", "Cooking", "Cutting Weapons", "Dodging",
        "Driving", "Electronics", "Fabrication", "First Aid",
        "Handguns", "Launchers", "Mechanics", "Melee",
        "Piercing Weapons", "Rifles", "Speaking", "SubMachine Guns",
        "Survival", "Swimming", "Tailoring", "Throwing",
        "Trapping", "Unarmed"
    };
	

	private ArrayList<JSpinner> spinnerList = new ArrayList<JSpinner>();
    

	private JTextArea descriptionTextBox;
	private JTextArea classDescriptionBox = new JTextArea("You are Dovakiin, a mighty warrior and slayer of dragons!");
	private JTextField className = new JTextField(10);
	private JTextField maleName = new JTextField(10);
	private JTextField femaleName = new JTextField(10);
	private JList<Trait> traitsList;
	private JList<Trait> chosentraitsList;
	private JButton addButton = new JButton("Add");
	private JButton removeButton = new JButton("Remove");
	private JButton backButton = new JButton("Back to Items");
	private JButton exportButton = new JButton("Save and Export");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SkillsAndTraitsFrame( SkillsAndTraitsModel model ){
		super("Skills and Traits");
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	  /*  
	    SpinnerModel model1 = new SpinnerNumberModel();
	    SpinnerModel model2 = new SpinnerNumberModel();
	    SpinnerModel model3 = new SpinnerNumberModel();
	    SpinnerModel model4 = new SpinnerNumberModel();
	    SpinnerModel model5 = new SpinnerNumberModel();
	    SpinnerModel model6 = new SpinnerNumberModel();
	    SpinnerModel model7 = new SpinnerNumberModel();
	    SpinnerModel model8 = new SpinnerNumberModel();
	    SpinnerModel model9 = new SpinnerNumberModel();
	    SpinnerModel model10 = new SpinnerNumberModel();
	    SpinnerModel model11 = new SpinnerNumberModel();
	    SpinnerModel model12 = new SpinnerNumberModel();
	    SpinnerModel model13 = new SpinnerNumberModel();
	    SpinnerModel model14 = new SpinnerNumberModel();
	    SpinnerModel model15 = new SpinnerNumberModel();
	    SpinnerModel model16 = new SpinnerNumberModel();
	    SpinnerModel model17 = new SpinnerNumberModel();
	    SpinnerModel model18 = new SpinnerNumberModel();
	    SpinnerModel model19 = new SpinnerNumberModel();
	    SpinnerModel model20 = new SpinnerNumberModel();
	    SpinnerModel model21 = new SpinnerNumberModel();
	    SpinnerModel model22 = new SpinnerNumberModel();
	    SpinnerModel model23 = new SpinnerNumberModel();
	    SpinnerModel model24 = new SpinnerNumberModel();
	    SpinnerModel model25 = new SpinnerNumberModel();
	    SpinnerModel model26 = new SpinnerNumberModel();
*/
	    SpinnerModel classPointCost = new SpinnerNumberModel();

/*	     spinarchery = new JSpinner(model1);
	     spinarchery.addChangeListener(new SpinnerController());
	     
	     spinbartering  = new JSpinner(model2);
	     spinbartering.addChangeListener(new SpinnerController());
	     
	     spinbashing_weapons  = new JSpinner(model3);
	     spinbashing_weapons.addChangeListener(new SpinnerController());
	     
	     spincomputers = new JSpinner(model4);
	     spincomputers.addChangeListener(new SpinnerController());

	     spinlconstruction  = new JSpinner(model5);
	     spinlconstruction.addChangeListener(new SpinnerController());

	     spincooking  = new JSpinner(model6);
	     spincooking.addChangeListener(new SpinnerController());

	     spincutting_weapons  = new JSpinner(model7);
	     spincutting_weapons.addChangeListener(new SpinnerController());

	     spindodging  = new JSpinner(model8);
	     spindodging.addChangeListener(new SpinnerController());

	     spindriving = new JSpinner(model9);
	     spindriving.addChangeListener(new SpinnerController());

	     spinectronics  = new JSpinner(model10);
	     spinectronics.addChangeListener(new SpinnerController());

	     spinfabrication  = new JSpinner(model11);
	     spinfabrication.addChangeListener(new SpinnerController());

	     spinfirst_aid  = new JSpinner(model12);
	     spinfirst_aid.addChangeListener(new SpinnerController());

	     spinhandguns = new JSpinner(model13);
	     spinhandguns.addChangeListener(new SpinnerController());

	     spinlaunchers  = new JSpinner(model14);
	     spinlaunchers.addChangeListener(new SpinnerController());

	     spinmechanics  = new JSpinner(model15);
	     spinmechanics.addChangeListener(new SpinnerController());

	     spinmelee  = new JSpinner(model16);
	     spinmelee.addChangeListener(new SpinnerController());

	     spinpiercing = new JSpinner(model17);
	     spinpiercing.addChangeListener(new SpinnerController());

	     spinrifles  = new JSpinner(model18);
	     spinrifles.addChangeListener(new SpinnerController());

	     spinspeaking  = new JSpinner(model19);;
	     spinspeaking.addChangeListener(new SpinnerController());

	     spinsubmachguns  = new JSpinner(model20);
	     spinsubmachguns.addChangeListener(new SpinnerController());

	     spinsurvival = new JSpinner(model21);
	     spinsurvival.addChangeListener(new SpinnerController());

	     spinswimming  = new JSpinner(model22);
	     spinswimming.addChangeListener(new SpinnerController());

	     spinTailoring  = new JSpinner(model23);
	     spinTailoring.addChangeListener(new SpinnerController());

	     spinthrowing = new JSpinner(model24);
	     spinthrowing.addChangeListener(new SpinnerController());

	     spintrapping  = new JSpinner(model25);
	     spintrapping.addChangeListener(new SpinnerController());
	     
	     spinunarmedcomb  = new JSpinner(model26);
	     spinunarmedcomb.addChangeListener(new SpinnerController());
	     
*/

	     classCostSpinner = new JSpinner(classPointCost);
	     classCostSpinner.addChangeListener(new SpinnerController());
	     
	     for(int x = 0; x < numberOfSkillsinGame; x++){
	    	 spinnerList.add(new JSpinner( new SpinnerNumberModel() ));
	    	 spinnerList.get(x).addChangeListener(new SpinnerController());
	     }

	    
	    JPanel mainPanel = new JPanel(new BorderLayout());
	    JPanel skillListPanel = new JPanel();

	    
	    skillListPanel.setLayout( new GridLayout(10, 0, 0, 0) );

	    /**
	     * Creates panels with a label and spinner in each
	     */
	     for(int x = 0; x < numberOfSkillsinGame; x++){
	    	skillPanelList[x] = new JPanel();
	    	skillPanelList[x].add(new JLabel(skillStringList[x]));
	    	skillPanelList[x].add(spinnerList.get(x));
	    	skillListPanel.add(skillPanelList[x]);
	     }

/*	    JPanel archerPanel = new JPanel();
        archerPanel.add(new JLabel("Archery"));
        archerPanel.add(spinnerList.get(Skills.ARCHERY.ordinal()));
        skillListPanel.add(archerPanel);

	    JPanel barterPanel = new JPanel();
        barterPanel.add(new JLabel("Bartering"));
        barterPanel.add(spinnerList.get(Skills.BARTERING.ordinal()));
        skillListPanel.add(barterPanel);

	    JPanel bashPanel = new JPanel();
        bashPanel.add(new JLabel("Bashing Weapons"));
        bashPanel.add(spinnerList.get(Skills.BASHWEAP.ordinal()));
        skillListPanel.add(bashPanel);
        
        JPanel computerPanel = new JPanel();
        computerPanel.add(new JLabel("Computers"));
        computerPanel.add(spinnerList.get(Skills.COMPUTERS.ordinal()));
        skillListPanel.add(computerPanel);
        
        JPanel constructionPanel = new JPanel();
        constructionPanel.add(new JLabel("Construction"));
        constructionPanel.add(spinnerList.get(Skills.CONSTRUCT.ordinal()));
        skillListPanel.add(constructionPanel);
        
        JPanel cookingPanel = new JPanel();
        cookingPanel.add(new JLabel("Cooking"));
        cookingPanel.add(spinnerList.get(Skills.COOKING.ordinal()));
        skillListPanel.add(cookingPanel);

        JPanel cuttingPanel = new JPanel();
        cuttingPanel.add(new JLabel("Cutting Weapons"));
        cuttingPanel.add(spinnerList.get(Skills.CUTWEAP.ordinal()));
        skillListPanel.add(cuttingPanel);
        
        JPanel dodgePanel = new JPanel();
        dodgePanel.add(new JLabel("Dodging"));
        dodgePanel.add(spinnerList.get(Skills.DODGING.ordinal()));
        skillListPanel.add(dodgePanel );

        JPanel drivingPanel = new JPanel();
        drivingPanel.add(new JLabel("Driving"));
        drivingPanel.add(spinnerList.get(Skills.DRIVING.ordinal()));
        skillListPanel.add(drivingPanel);
        
        JPanel electronicsPanel = new JPanel();
        electronicsPanel.add(new JLabel("Electronics"));
        electronicsPanel.add(spinnerList.get(Skills.ELECTRONICS.ordinal()));
        skillListPanel.add(electronicsPanel);

        JPanel fabricationPanel = new JPanel();
        fabricationPanel .add(new JLabel("Fabrication"));
        fabricationPanel .add(spinnerList.get(10));
        skillListPanel.add(fabricationPanel );

        
        JPanel firstAidPanel = new JPanel();
        firstAidPanel.add(new JLabel("First-Aid"));
        firstAidPanel.add(spinnerList.get(11));
        skillListPanel.add(firstAidPanel);

        JPanel handgunPanel = new JPanel();
        handgunPanel.add(new JLabel("Handguns"));
        handgunPanel.add(spinnerList.get(12));
        skillListPanel.add(handgunPanel);

        JPanel launcherPanel = new JPanel();
        launcherPanel.add(new JLabel("Launchers"));
        launcherPanel.add(spinnerList.get(13));
        skillListPanel.add(launcherPanel);

        JPanel mechanicsPanel = new JPanel();
        mechanicsPanel.add(new JLabel("Mechanics"));
        mechanicsPanel.add(spinnerList.get(14));
        skillListPanel.add(mechanicsPanel);

        JPanel meleePanel = new JPanel();
        meleePanel.add(new JLabel("Melee"));
        meleePanel.add(spinnerList.get(15));
        skillListPanel.add(meleePanel);

        JPanel piercingPanel = new JPanel();
        piercingPanel.add(new JLabel("Piercing Weapons"));
        piercingPanel.add(spinnerList.get(16));
        skillListPanel.add(piercingPanel);

        JPanel riflesPanel = new JPanel();
        riflesPanel.add(new JLabel("Rifles"));
        riflesPanel.add(spinnerList.get(17));
        skillListPanel.add(riflesPanel);

        JPanel speakingPanel = new JPanel();
        speakingPanel.add(new JLabel("Speaking"));
        speakingPanel.add(spinnerList.get(18));
        skillListPanel.add(speakingPanel);

        JPanel submachinePanel = new JPanel();
        submachinePanel.add(new JLabel("Sub Machine Guns"));
        submachinePanel.add(spinnerList.get(19));
        skillListPanel.add(submachinePanel);

        JPanel survivalPanel = new JPanel();
        survivalPanel.add(new JLabel("Survival"));
        survivalPanel.add(spinnerList.get(20));
        skillListPanel.add(survivalPanel);

        JPanel swimmingPanel = new JPanel();
        swimmingPanel.add(new JLabel("Swimming"));
        swimmingPanel.add(spinnerList.get(21));
        skillListPanel.add(swimmingPanel);

        JPanel tailoringPanel = new JPanel();
        tailoringPanel.add(new JLabel("Tailoring"));
        tailoringPanel.add(spinnerList.get(22));
        skillListPanel.add(tailoringPanel);

        JPanel throwingPanel = new JPanel();
        throwingPanel.add(new JLabel("Throwing"));
        throwingPanel.add(spinnerList.get(23));
        skillListPanel.add(throwingPanel);

        JPanel trappingPanel = new JPanel();
        trappingPanel.add(new JLabel("Trapping"));
        trappingPanel.add(spinnerList.get(24));
        skillListPanel.add(trappingPanel);

        JPanel unarmedPanel = new JPanel();
        unarmedPanel.add(new JLabel("Unarmed Combat"));
        unarmedPanel.add(spinnerList.get(25));
        skillListPanel.add(unarmedPanel);
*/        
        
        //--------
        
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Name of Class: "));
        northPanel.add(className);
        northPanel.add(new JLabel("| Cost of Class"));
        northPanel.add(classCostSpinner);

	    mainPanel.add(northPanel, BorderLayout.NORTH);
 
	    //----- TraitsPanel
	    JPanel traitsPanel = new JPanel();
	    traitsPanel.setLayout(new BoxLayout(traitsPanel, BoxLayout.Y_AXIS));

	    //---- Traits portion
	    traitsPanel.add(new JLabel("Traits"));
	    traitsList = new JList<Trait>(new Vector<Trait>(model.getTraitList()) );
	    traitsList.setVisibleRowCount(5);
	    traitsList.setCellRenderer(new DefaultListCellRenderer());
	    traitsList.setBorder(new EmptyBorder(10, 10, 10, 10));

		JScrollPane scrollPane = new JScrollPane(traitsList);
		scrollPane.setViewportView(traitsList);
		scrollPane.setPreferredSize(new Dimension(50, 100));
		traitsPanel.add(scrollPane);

		traitsPanel.add(addButton);

		
	    //---- Chosen traits portion
	    traitsPanel.add(new JLabel("\nChosen Traits: "));
	    chosentraitsList = new JList<Trait>(model.getExportedTraitList());
	    chosentraitsList.setVisibleRowCount(5);
	    chosentraitsList.setCellRenderer(new DefaultListCellRenderer());
	    chosentraitsList.setBorder(new EmptyBorder(10, 10, 10, 10));

	    JScrollPane exportScroll = new JScrollPane(chosentraitsList);
		exportScroll.setViewportView(chosentraitsList);
		exportScroll.setPreferredSize(new Dimension(50, 100));
		traitsPanel.add(exportScroll);

		traitsPanel.add(removeButton);

	    //---- Description Box
	    traitsPanel.add(new JLabel("\nTrait Description: "));
		descriptionTextBox = new JTextArea(20,30);
		descriptionTextBox.setLineWrap(true);		
		JScrollPane textScroller = new JScrollPane(descriptionTextBox);
		traitsPanel.add(textScroller);
		
	    
		mainPanel.add(traitsPanel, BorderLayout.EAST);
		
		//------ Buttons on the Southern border
	    JPanel buttonChangePanel = new JPanel();
	    buttonChangePanel.setLayout(new BoxLayout(buttonChangePanel, BoxLayout.X_AXIS));
	    buttonChangePanel.add(exportButton);
	    buttonChangePanel.add(backButton);
	    mainPanel.add(buttonChangePanel, BorderLayout.SOUTH);
	    
	  //------ Description on west border TODO
	    JPanel descriptionPanel = new JPanel();
	    
	    
	    descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
	   
	    
	    descriptionPanel.add(new JLabel("Class Description"));
	    classDescriptionBox.setBorder(BorderFactory.createLineBorder(Color.PINK, 5 , true));
	    descriptionPanel.add(classDescriptionBox);
	    
	    JPanel malePanel = new JPanel();
	    malePanel.setLayout( new FlowLayout(FlowLayout.LEFT));
	    malePanel.add(new JLabel("Male/Plain Class Name: \n"));
	    maleName.setMaximumSize( new Dimension( 300, 100 ) );
	    malePanel.add(maleName);
	    descriptionPanel.add(malePanel);
	    
	    
	    JPanel femalePanel = new JPanel();
	    femalePanel.setLayout( new FlowLayout(FlowLayout.LEFT));
	    femalePanel.add(new JLabel("Female Class Name: \n"));
	    femaleName.setText("(This is optional)");
	    femaleName.setMaximumSize(new Dimension(300, 100));
	    femalePanel.add(femaleName);
	    descriptionPanel.add(femalePanel);
	    
	    
	    mainPanel.add(descriptionPanel, BorderLayout.WEST);
	    
	    //model.getGeneralList()
	    mainPanel.add(skillListPanel, BorderLayout.CENTER);
	    
	    add(mainPanel, BorderLayout.CENTER);
	    pack();
	 

	    setVisible(false);

	}
	
    public String[] getSkillStringList() {
		return skillStringList;
	}

	public JTextField getMaleInGameName() {
		return maleName;
	}

	public JTextField getFemaleInGameName() {
		return femaleName;
	}

	public JTextArea getClassDescriptionBox() {
		return classDescriptionBox;
	}

	public JTextField getClassName() {
		return className;
	}

	public JTextArea getDescriptionTextBox() {
		return descriptionTextBox;
	}

	public void setDescriptionTextBox(JTextArea descriptionTextBox) {
		this.descriptionTextBox = descriptionTextBox;
	}

	public JList<Trait> getTraitsList() {
		return traitsList;
	}

	public void setTraitsList(JList<Trait> traitsList) {
		this.traitsList = traitsList;
	}

	public JList<Trait> getChosentraitsList() {
		return chosentraitsList;
	}

	public void setChosentraitsList(JList<Trait> chosentraitsList) {
		this.chosentraitsList = chosentraitsList;
	}
	
	public JButton getAddButton() {
		return addButton;
	}
	
	public JButton getRemoveButton() {
		return removeButton;
	}
	
	public JButton getBackButton() {
		return backButton;
	}

	public JButton getExportButton() {
		return exportButton;
	}
	
	public ArrayList<JSpinner> getSpinnerList() {
		return spinnerList;
	}


	public JSpinner getSpinarchery() {
		return spinarchery;
	}

	public JSpinner getSpinbartering() {
		return spinbartering;
	}

	public JSpinner getSpinbashing_weapons() {
		return spinbashing_weapons;
	}

	public JSpinner getSpincomputers() {
		return spincomputers;
	}

	public JSpinner getSpinlconstruction() {
		return spinlconstruction;
	}

	public JSpinner getSpincooking() {
		return spincooking;
	}

	public JSpinner getSpincutting_weapons() {
		return spincutting_weapons;
	}

	public JSpinner getSpindodging() {
		return spindodging;
	}

	public JSpinner getSpindriving() {
		return spindriving;
	}

	public JSpinner getSpinectronics() {
		return spinectronics;
	}

	public JSpinner getSpinfabrication() {
		return spinfabrication;
	}

	public JSpinner getSpinfirst_aid() {
		return spinfirst_aid;
	}

	public JSpinner getSpinhandguns() {
		return spinhandguns;
	}

	public JSpinner getSpinlaunchers() {
		return spinlaunchers;
	}

	public JSpinner getSpinmechanics() {
		return spinmechanics;
	}

	public JSpinner getSpinmelee() {
		return spinmelee;
	}

	public JSpinner getSpinpiercing() {
		return spinpiercing;
	}

	public JSpinner getSpinrifles() {
		return spinrifles;
	}

	public JSpinner getSpinspeaking() {
		return spinspeaking;
	}

	public JSpinner getSpinsubmachguns() {
		return spinsubmachguns;
	}

	public JSpinner getSpinsurvival() {
		return spinsurvival;
	}

	public JSpinner getSpinswimming() {
		return spinswimming;
	}

	public JSpinner getSpinTailoring() {
		return spinTailoring;
	}

	public JSpinner getSpinthrowing() {
		return spinthrowing;
	}

	public JSpinner getSpintrapping() {
		return spintrapping;
	}

	public JSpinner getSpinunarmedcomb() {
		return spinunarmedcomb;
	}

	public JSpinner getClassCostSpinner() {
		return classCostSpinner;
	}

}
