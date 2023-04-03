package tax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Brandon Yaeck
 */
public class UserList {

	ArrayList<User> userList = new ArrayList<User>();

	public UserList() {
		readFromFile();
	}

	public User createUser(boolean write, String ... input) {
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
			user.setEmailAddress(input[8]);
			user.setPassword(input[9]);

			userList.add(user);

			if (write) {
				writeToFile(user);
			}
		}
		catch (IllegalArgumentException exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error importing users");
			alert.setHeaderText("");

			alert.setContentText("Failed to process some users: " + exception.getMessage());
			alert.showAndWait();
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error importing users");
			alert.setHeaderText("");

			System.out.println(exception.getMessage());
			alert.setContentText("Failed to process some users: users with incorrect amount of entries not processed.");
			alert.showAndWait();
		}

		return user;
	}

	private void writeToFile(User user) {
		try (
			FileWriter file = new FileWriter("users.txt", true);
			BufferedWriter buffer = new BufferedWriter(file);
			PrintWriter writer = new PrintWriter(buffer);
		) {
			writer.println(user);
			System.out.println(user);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readFromFile() {
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
			exception.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error reading users file");
			alert.setHeaderText("");

			alert.setContentText(exception.getMessage());
			alert.showAndWait();
		}


		for (User each: userList) {
			System.out.println(each);
		}
		System.out.println();

	}
}
