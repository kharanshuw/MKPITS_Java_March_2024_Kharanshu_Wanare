package vehiclerentalsystem;

public class RentalVehical {
	String verhicalnameString;
	String dateString;
	String returnString;
	public RentalVehical(String verhicalnameString, String dateString, String returnString) {
		super();
		this.verhicalnameString = verhicalnameString;
		this.dateString = dateString;
		this.returnString = returnString;
	}
	public String getVerhicalnameString() {
		return verhicalnameString;
	}
	public void setVerhicalnameString(String verhicalnameString) {
		this.verhicalnameString = verhicalnameString;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public String getReturnString() {
		return returnString;
	}
	public void setReturnString(String returnString) {
		this.returnString = returnString;
	}
	
	public void calculateRentalFees() {
		
	}
	
	public void trackVehical() {
		
	}
	
	public void rentalAvailability() {
		
	}
}
