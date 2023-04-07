package tax;

import java.util.Arrays;

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
	private String passwordSalt;
	private String passwordHash;

	public User() {
		//intentionally blank
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = firstName;
		} else {
			throw new IllegalArgumentException("First name cannot be empty.");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException("Error: Last name cannot be empty.");
		}
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		if (dateOfBirth != null && dateOfBirth.matches("[0-9]{4}-?[0-9]{2}-?[0-9]{2}")) {
			this.dateOfBirth = Integer.parseInt(dateOfBirth.replaceAll("-",""));
		} else {
			throw new IllegalArgumentException("Date of birth must be yyyy-mm-dd.");
		}
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		if (streetAddress != null && !streetAddress.trim().isEmpty()) {
			this.streetAddress = streetAddress;
		} else {
			throw new IllegalArgumentException("Street address cannot be empty.");
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city != null && !city.trim().isEmpty()) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("City cannot be empty.");
		}
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		if (region != null && Arrays.asList(InputValidator.regionList).contains(region)) {
			this.region = region;
		} else {
			throw new IllegalArgumentException("Region must be a valid Canadian province or territory.");
		}
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		if (postalCode != null && postalCode.matches("[A-Z][0-9][A-Z] [0-9][A-Z][0-9]")) {
			this.postalCode = postalCode;
		} else {
			throw new IllegalArgumentException("Postal code must be in format A1A 1A1.");
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber != null && phoneNumber.trim().length() >= 7 && phoneNumber.trim().length() <= 15 && phoneNumber.matches("[0-9]*")) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new IllegalArgumentException("Phone number must contain 7-15 digits.");
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		if (emailAddress != null && emailAddress.trim().matches(".+@.+")) {
			this.emailAddress = emailAddress;
		} else {
			throw new IllegalArgumentException("Email address must be formatted as something@something.");
		}
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		if (passwordSalt != null && !passwordSalt.trim().isEmpty()) {
			this.passwordSalt = passwordSalt;
		} else {
			throw new IllegalArgumentException("Password salt missing.");
		}
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		if (passwordHash != null && !passwordHash.trim().isEmpty()) {
			this.passwordHash = passwordHash;
		} else {
			throw new IllegalArgumentException("Password hash missing.");
		}
	}

	@Override
	public String toString() {
		return firstName + "\t" + lastName + "\t" + dateOfBirth + "\t" + streetAddress + "\t" + city + "\t" + region + "\t" + postalCode + "\t" + phoneNumber + "\t" + emailAddress + "\t" + passwordSalt + "\t" + passwordHash;
	}
}
