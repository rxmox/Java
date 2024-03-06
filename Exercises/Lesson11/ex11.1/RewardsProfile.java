package edu.ucalgary.oop;


public class RewardsProfile {
	private String rewardsNum = "Not enrolled";
	private int pointsTotal = 10;
	
	public RewardsProfile(String newNumber) throws InvalidRewardsNumException {
    if (newNumber.length() == 7) {
        try {
            Integer.parseInt(newNumber);
            this.rewardsNum = newNumber;
        } catch (NumberFormatException e) {
            throw new InvalidRewardsNumException();
        }
    } else {
        throw new InvalidRewardsNumException();
    }
	}


	public void setPoints(int addPoints) {
		this.pointsTotal += addPoints;
	}

	public int getPoints() {
		return this.pointsTotal;
	}

	public String getNumber() {
		return rewardsNum;
	}


}