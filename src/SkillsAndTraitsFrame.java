import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class SkillsAndTraitsFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SkillsAndTraitsFrame(){
		super("Skills and Traits");
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel larchery = new JLabel("Archery");
		JLabel lbartering  = new JLabel("Bartering");
		JLabel lbashing_weapons  = new JLabel("Bashing Weapons");
		JLabel lcomputers = new JLabel("Computers");
		JLabel lconstruction  = new JLabel("Construction");
		JLabel lcooking  = new JLabel("Cooking");
		JLabel lcutting_weapons  = new JLabel("Cutting Weapons");
		JLabel ldodging  = new JLabel("Dodging");
		JLabel ldriving = new JLabel("Driving");
		JLabel lectronics  = new JLabel("Electronics");
		JLabel lfabrication  = new JLabel("Fabrication");
		JLabel lfirst_aid  = new JLabel("First Aid");
		JLabel lhandguns = new JLabel("Handguns");
		JLabel llaunchers  = new JLabel("Launchers");
		JLabel lmechanics  = new JLabel("Mechanics");
		JLabel lmelee  = new JLabel("Melee");
		JLabel lpiercing = new JLabel("Piercing Weapons");
		JLabel lrifles  = new JLabel("Rifles");
		JLabel lspeaking  = new JLabel("Speaking");
		JLabel lsubmachguns  = new JLabel("Sub Machine Guns");
		JLabel lsurvival = new JLabel("Survival");
		JLabel lswimming  = new JLabel("Swimming");
		JLabel lTailoring  = new JLabel("Tailoring");
		JLabel lthrowing = new JLabel("Throwing");
		JLabel ltrapping  = new JLabel("Trapping");
		JLabel lunarmedcomb  = new JLabel("Unarmed Combat");
	    
	    
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


	    JSpinner spinarchery = new JSpinner(model1);
	    JSpinner spinbartering  = new JSpinner(model2);
	    JSpinner spinbashing_weapons  = new JSpinner(model3);;
	    JSpinner spincomputers = new JSpinner(model4);;
	    JSpinner spinlconstruction  = new JSpinner(model5);;
	    JSpinner spincooking  = new JSpinner(model6);
	    JSpinner spincutting_weapons  = new JSpinner(model7);
	    JSpinner spindodging  = new JSpinner(model8);
	    JSpinner spindriving = new JSpinner(model9);
	    JSpinner spinectronics  = new JSpinner(model10);
	    JSpinner spinfabrication  = new JSpinner(model11);
	    JSpinner spinfirst_aid  = new JSpinner(model12);
	    JSpinner spinhandguns = new JSpinner(model13);
	    JSpinner spinlaunchers  = new JSpinner(model14);
	    JSpinner spinmechanics  = new JSpinner(model15);
	    JSpinner spinmelee  = new JSpinner(model1);
	    JSpinner spinpiercing = new JSpinner(model1);
	    JSpinner  spinrifles  = new JSpinner(model1);
	    JSpinner  spinspeaking  = new JSpinner(model1);;
	    JSpinner  spinsubmachguns  = new JSpinner(model1);
	    JSpinner  spinsurvival = new JSpinner(model1);
	    JSpinner  spinswimming  = new JSpinner(model1);
	    JSpinner  spinTailoring  = new JSpinner(model1);
	    JSpinner  spinthrowing = new JSpinner(model1);
	    JSpinner  spintrapping  = new JSpinner(model1);
	    JSpinner  spinunarmedcomb  = new JSpinner(model1);

	    
	    JPanel panel1 = new JPanel(new BorderLayout());
	    JPanel labelList = new JPanel();
	    JPanel spinnerList = new JPanel();
	    JPanel otherList = new JPanel();
	    JPanel finalList = new JPanel();
	    //spinnerList.setLayout(new BoxLayout(spinnerList, BoxLayout.Y_AXIS));
        labelList.setLayout(new BoxLayout(labelList, BoxLayout.Y_AXIS));

        spinnerList.add(larchery);
        spinnerList.add(spinarchery);
        labelList.add(spinnerList);

        otherList.add(lswimming);
        otherList.add(spinswimming);
        labelList.add(otherList);

        finalList.add(lspeaking);
        finalList.add(spinspeaking);
        labelList.add(finalList);


 //       panel1.add(labelList, BorderLayout.WEST);
//		labelList.setBorder(new EmptyBorder(10, 10, 10, 10));

	    panel1.add(labelList, BorderLayout.CENTER);
	    
	    add(panel1, BorderLayout.SOUTH);

	 

	    setSize(300, 300);
	    setVisible(true);

	}

}
