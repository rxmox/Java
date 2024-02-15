package edu.ucalgary.oop;

public class Client {
	private String name;
	private String phoneNumber;
	private String address;
	private RewardsProfile rewardsInfo;
	
	public Client(String name,String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public boolean enrollRewards(String newNumber) {
		try{
			rewardsInfo = new RewardsProfile(newNumber);
			return true;
		}
		catch(InvalidRewardsNumException e){
			return false;
		}
	}

	public int getRewardsPoints() {
		return rewardsInfo.getPoints();
	}


	public String getRewardsNumber() {
		if (rewardsInfo != null){
			return rewardsInfo.getNumber();
		}
		else{
			return "Not enrolled";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String num) {
		this.phoneNumber = num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void updatePoints(int addPoints) {
		rewardsInfo.setPoints(addPoints);
	}

}
