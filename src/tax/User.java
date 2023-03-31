package tax;

/**
 *
 * @author Brandon Yaeck
 */
public class User {

	private String firstName;
	private String lastName;
	private int dateOfBirth;
	private String streetAddress;
	private String city;
	private String region;
	private String postalCode;
	// phone numbers should be String due to the possibility of leading 0s
	private String phoneNumber;
	private String emailAddress;
	private String password;

	public User() {

	}

	/*
	public User(String firstName, String lastName, int dateOfBirth, String streetAddress, String city, String region, String postalCode, String phoneNumber, String emailAddress, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.streetAddress = streetAddress;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		if (dateOfBirth.length() > 0) {
			this.dateOfBirth = Integer.parseInt(dateOfBirth.replaceAll("-",""));
		}
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return firstName + "," + lastName + "," + dateOfBirth + "," + streetAddress + "," + city + "," + region + "," + postalCode + "," + phoneNumber + "," + emailAddress + "," + password;
	}


	
}
