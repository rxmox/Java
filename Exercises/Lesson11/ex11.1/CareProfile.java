package edu.ucalgary.oop;

public class CareProfile {
	private String[] medList;
	private String medInstructions;
	private String feedingInstructions;
	
	public CareProfile(String[] medList, String meds, String feeding) {
		this.medList = medList;
		this.medInstructions = meds;
		this.feedingInstructions = feeding;
	}
	
	public String summarizeCareInstructions() {
		String medications = "";
		for(int i = 0; i < medList.length - 1; i++){
			medications += medList[i] + ", ";
		}
		medications += medList[medList.length - 1];
		medications += "\n" + medInstructions + "\n" + feedingInstructions;
		return medications;

	}

}