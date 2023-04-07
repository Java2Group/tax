package tax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

/**
 * Handles creating User objects and loading them from a text file into an ArrayList
 *
 * @author Brandon Yaeck
 */
public class UserList {

	// same ArrayList is shared as only one is ever used
	static ArrayList<User> userList = new ArrayList<User>();

	PasswordHandler passwordHandler = new PasswordHandler();

	public void createUser(boolean write, String ... input) {
		User user = new User();

		try {
			user.setFirstName(input[0]);
			user.setLastName(input[1]);
			user.setDateOfBirth(input[2]);
			user.setStreetAddress(input[3]);
			user.setCity(input[4]);
			user.setRegion(input[5]);
			user.setPostalCode(input[6]);
			user.setPhoneNumber(input[7]);

			if (matchEmail(input[8]) == null) {
				user.setEmailAddress(input[8]);
			} else {
				throw new IllegalArgumentException("Duplicate email address found: " + input[8]);
			}

			if (write) {
				// base64 uses a-zA-Z0-9 + / =
				byte[] salt = passwordHandler.createSalt();
				user.setPasswordSalt(Base64.getEncoder().encodeToString(salt));

				try {
					byte[] passwordHash = passwordHandler.createPasswordHash(input[9], salt);
					user.setPasswordHash(Base64.getEncoder().encodeToString(passwordHash));
				}
				catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
					Popup.error(exception, "Error creating password hash", "Failed to create password hash: ");
				}

				userList.add(user);
				writeToFile(user);
			} else {
				user.setPasswordSalt(input[9]);
				user.setPasswordHash(input[10]);
				userList.add(user);
			}
		}
		catch (IllegalArgumentException exception) {
			Popup.error(exception, "Error importing users", "Failed to process some users: ");
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			Popup.error(exception, "Error importing users", "Failed to process some users: users with incorrect amount of entries not processed.\n");
		}
	}

	private void writeToFile(User user) {
		try (
			FileWriter file = new FileWriter("users.txt", true);
			BufferedWriter buffer = new BufferedWriter(file);
			PrintWriter writer = new PrintWriter(buffer);
		) {
			writer.println(user);
		}
		catch (IOException exception) {
			Popup.error(exception, "Error writing users file", "");
		}
	}

	public void readFromFile() {
		userList.clear();

		File file = new File("users.txt");
		if (!file.exists()) {
			return;
		}

		try (Scanner reader = new Scanner(file);) {
			while (reader.hasNext()) {
				String[] fields = reader.nextLine().split("\t");
				createUser(false, fields);
			}
		}
		catch (IOException exception) {
			Popup.error(exception, "Error reading users file", "");
		}
	}

	public User matchEmail(String emailInput) {
		for (User user: UserList.userList) {
			if (user.getEmailAddress().equals(emailInput)) {
				return user;
			}
		}
		return null;
	}
}
