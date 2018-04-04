package model;

import java.io.Serializable;

public enum Status implements Serializable {
	
	LANDED("Landed"), DEPARTED("Departed"), SCHEDULED("Scheduled"), COMPLETED("Completed");
	
	private String fDisplayedStatus;
	
	private Status(String pDisplayedStatus) {
		this.fDisplayedStatus = pDisplayedStatus;
	}
	
	public String getDisplayedStatus() {
		return this.fDisplayedStatus;
	}

}
