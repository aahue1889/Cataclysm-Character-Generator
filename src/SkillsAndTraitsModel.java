import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class SkillsAndTraitsModel{

	/**
	 * These are a list of skills that can be a maximum of 10 (I don't know the actual max)
	 */
	private int archery = 0;
	private int bartering = 0;
	private int bashing_weapons = 0;
	private int computers = 0;
	private int construction = 0;
	private int cooking = 0;
	private int cutting_weapons = 0;
	private int dodging = 0;
	private int driving = 0;
	private int electronics = 0;
	private int fabrication = 0;
	private int first_aid = 0;
	private int handguns = 0;
	private int launchers_marksmanship = 0;
	private int mechanics = 0;
	private int melee = 0;
	private int piercing_weapons = 0;
	private int rifles = 0;
	private int speaking = 0;
	private int submachine_guns = 0;
	private int survival = 0;
	private int swimming  = 0;
	private int tailoring = 0;
	private int throwing = 0;
	private int trapping = 0;
	private int unarmed_combat = 0;
	
	DefaultListModel<Trait> traitList;
	DefaultListModel<Trait> exportedTraitList;
	
/*	private String[] goodTraits = { "Accomplished Sleeper",
			"Addiction Resistant",
			"Animal Empathy",
			"Cannibal",
			"Deft",
			"Disease Resistant",
			"Drunken Master" , 
			"Fast Healer",
			"Fast Learner",
			"Fleet-Footed",
			"Good Hearing",
			"Gourmand",
			"High Adrenaline",
			"Indefatigable",
			"Infection Resistant",
			"Less Sleep",
			"Light Eater",
			"Light Step",
			"Martial_Arts_Training",  //(SPECIAL LOOK IT UP)
			"Masochist",
			"Melee_Weapon_Training",
			"Night Vision",
			"Optimist",
			"Outdoorsman",
			"Packmule",
			"Pain resistant",
			"Parkour Expert",
			"Poison Resistant",
			"Pretty",
			"PSychopath",
			"Quick",
			"Robust Genetics",
			"Scout",
			"Self-Aware",
			"Self-Defense Classes" , //(SPECIAL LOOK IT UP)
			"Shaolin Adept" , //(SPECIAL LOOK IT UP)
			"Skilled Liar",
			"Spiritual",
			"Strong Back",
			"Strong Stomach",
			"Stylish",
			"Substance Tolerance",
			"Terrifying",
			"Tough_Tough_Feet",
			"Venom_Mob_Protege", //(SPECIAL LOOK IT UP)
			"Weak_Scent"
	}; //This unorthodox way of listing is only temporary
	
	private String[] badTraits = {
			"addicitive personality",
			"albino",
			"animal discord",
			"asthmatic",
			"bad back",
			"bad knees",
			"bad temper",
			"chemical imbalance",
			"clumsy",
			"disorganized",
			"far-sighted",
			"fast metabolism",
			"flimsy",
			"forgetful",
			"fragile",
			"frail",
			"glass jaw",
			"hates fruit",
			"hates vegetables",
			"heavy sleeper",
			"high thirst",
			"hoarder",
			"illiterate",
			"insomniac",
			"jittery",
			"junkfood intolerance",
			"lactose intolerance",
			"languorous",
			"lightweight",
			"meat intolerance",
			"mood swings",
			"near-sighted",
			"pacifist",
			"poor hearing",
			"savant",
			"schizophrenic",
			"sleepy",
			"slow healer",
			"slow learner",
			"slow reader",
			"slow runner",
			"strong scent",
			"thin-skinned",
			"trigger happy",
			"truth teller",
			"ugly",
			"weak stomach",
			"wheat allergy",
			"wool allergy",

	};//This unorthodox way of listing is only temporary
	*/
	//private ArrayList<Traits> goodList;
	
	
	
	/**
	 * Needs to list traits
	 * Needs to list Skills 
	 * -- The main purpose of this model is to store trait values and chosen skills
	 * 
	 */
	public SkillsAndTraitsModel(){
		//Load traits from -- mutations.json
		// if mutation listed has -  "starting_trait" : true,
		// Then it will be added to the list
		// currently we have no way of discerning good traits or bad traits
		// I need to create Trait object which is just id (Game name) and Description to help user make a decision
	}
	
	public void openJsonFile( String fileName, ArrayList<Trait> traitList){
		String line = "";
		//itemList = genericList; //TODO This should be in the constructor
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
                	
	                	Trait newTrait = new Trait();
	                	isCorrect = newTrait.buildItem(bufferedReader);
	                	if(newTrait.isStartingTrait())
	                		traitList.add(newTrait);
	                	if(isCorrect == 0) 
	                		continue;
	                		
	                	break;
                	}
                }
                                
            }// End of while   

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
	
	public int getArchery() {
		return archery;
	}

	public void setArchery(int archery) {
		this.archery = archery;
	}

	public int getBartering() {
		return bartering;
	}

	public void setBartering(int bartering) {
		this.bartering = bartering;
	}

	public int getBashing_weapons() {
		return bashing_weapons;
	}

	public void setBashing_weapons(int bashing_weapons) {
		this.bashing_weapons = bashing_weapons;
	}

	public int getComputers() {
		return computers;
	}

	public void setComputers(int computers) {
		this.computers = computers;
	}

	public int getConstruction() {
		return construction;
	}

	public void setConstruction(int construction) {
		this.construction = construction;
	}

	public int getCooking() {
		return cooking;
	}

	public void setCooking(int cooking) {
		this.cooking = cooking;
	}

	public int getCutting_weapons() {
		return cutting_weapons;
	}

	public void setCutting_weapons(int cutting_weapons) {
		this.cutting_weapons = cutting_weapons;
	}

	public int getDodging() {
		return dodging;
	}

	public void setDodging(int dodging) {
		this.dodging = dodging;
	}

	public int getDriving() {
		return driving;
	}

	public void setDriving(int driving) {
		this.driving = driving;
	}

	public int getElectronics() {
		return electronics;
	}

	public void setElectronics(int electronics) {
		this.electronics = electronics;
	}

	public int getFabrication() {
		return fabrication;
	}

	public void setFabrication(int fabrication) {
		this.fabrication = fabrication;
	}

	public int getFirst_aid() {
		return first_aid;
	}

	public void setFirst_aid(int first_aid) {
		this.first_aid = first_aid;
	}

	public int getHandguns() {
		return handguns;
	}

	public void setHandguns(int handguns) {
		this.handguns = handguns;
	}

	public int getLaunchers_marksmanship() {
		return launchers_marksmanship;
	}

	public void setLaunchers_marksmanship(int launchers_marksmanship) {
		this.launchers_marksmanship = launchers_marksmanship;
	}

	public int getMechanics() {
		return mechanics;
	}

	public void setMechanics(int mechanics) {
		this.mechanics = mechanics;
	}

	public int getMelee() {
		return melee;
	}

	public void setMelee(int melee) {
		this.melee = melee;
	}

	public int getPiercing_weapons() {
		return piercing_weapons;
	}

	public void setPiercing_weapons(int piercing_weapons) {
		this.piercing_weapons = piercing_weapons;
	}

	public int getRifles() {
		return rifles;
	}

	public void setRifles(int rifles) {
		this.rifles = rifles;
	}

	public int getSpeaking() {
		return speaking;
	}

	public void setSpeaking(int speaking) {
		this.speaking = speaking;
	}

	public int getSubmachine_guns() {
		return submachine_guns;
	}

	public void setSubmachine_guns(int submachine_guns) {
		this.submachine_guns = submachine_guns;
	}

	public int getSurvival() {
		return survival;
	}

	public void setSurvival(int survival) {
		this.survival = survival;
	}

	public int getSwimming() {
		return swimming;
	}

	public void setSwimming(int swimming) {
		this.swimming = swimming;
	}

	public int getTailoring() {
		return tailoring;
	}

	public void setTailoring(int tailoring) {
		this.tailoring = tailoring;
	}

	public int getThrowing() {
		return throwing;
	}

	public void setThrowing(int throwing) {
		this.throwing = throwing;
	}

	public int getTrapping() {
		return trapping;
	}

	public void setTrapping(int trapping) {
		this.trapping = trapping;
	}

	public int getUnarmed_combat() {
		return unarmed_combat;
	}

	public void setUnarmed_combat(int unarmed_combat) {
		this.unarmed_combat = unarmed_combat;
	}

	
	
	

}
