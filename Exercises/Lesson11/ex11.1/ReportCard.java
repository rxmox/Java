package edu.ucalgary.oop;

public class ReportCard {
	public final Booking REPORT;
	
	public ReportCard(Booking reportInfo) {
		this.REPORT = reportInfo;
	}
	public String printReport() {
		String report = REPORT.getCaregiver().getName() + " enjoyed taking care of " + REPORT.getBookedPet().getName() + ". See you next time!";
		return report;
	}

}