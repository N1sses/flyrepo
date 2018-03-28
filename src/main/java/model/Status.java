package model;

public enum Status {
	
	LANDED("Landed"), DEPARTED("Departed"), SCHEDULED("Scheduled"), COMPLETED("Completed");
	
	private String fDisplayedStatus;
	
	
	private Status(String pDisplayedStatus) {
		this.fDisplayedStatus = pDisplayedStatus;
	}
	
	public String getDisplayedStatus() {
		return this.fDisplayedStatus;
	}

}
