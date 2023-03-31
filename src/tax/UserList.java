package tax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
				String[] fields = reader.nextLine().split(",");
				createUser(false, fields);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}


		for (User each: userList) {
			System.out.println(each);
		}
		System.out.println();

	}
}
