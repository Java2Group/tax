package tax;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author Brandon Yaeck
 */
public class InputValidator {

	final static int OLDEST_BIRTH_YEAR = 1907;
	final static String[] regionList = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon"};

	private boolean noEmpty;
	private boolean dobValid;
	private boolean postValid;
	private boolean phoneValid;
	private boolean emailValid;
	private boolean passwordValid;


	public boolean allValid(Label error, CheckBox tos, TextField dobField, Label dobError, TextField postField, Label postError, ComboBox region, TextField ... fields) {
		error.setText("");
		noEmpty = true;

		if (!tos.isSelected()) {
			error.setText("You must agree to the terms of service.");
		}

		for (TextField field: fields) {
			if (field.getText().trim().isEmpty()) {
				field.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
				error.setText("All fields required.");
				noEmpty = false;
			} else {
				field.setStyle("");
			}
		}

		if (region.getValue() == null) {
			region.setStyle("-fx-inner-border: red");
			error.setText("All fields required.");
			noEmpty = false;
		} else {
			region.setStyle("");
		}


		// prevent partially typed date/postal (not done in other validation to prevent spamming user with error when they aren't done typing)
		if (dobField.getText().length() < 10) {
			dobField.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
			dobError.setText("Invalid Date");
		}
		if (postField.getText().length() < 7) {
			postField.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
			postError.setText("Invalid Postal Code");
		}
		


		return noEmpty && dobValid && postValid && phoneValid && emailValid && passwordValid && tos.isSelected();
	}


	class PreventInfinite extends TextFormatter<String> {
		public PreventInfinite() {
			super((TextFormatter.Change change) -> {
				// limit text field to 100 characters (arbitrary number to prevent infinitely long input) by blocking input changes
				if (change.getControlNewText().length() > 100) {
					return null;
				} else {
					return change;
				}
			});
		}
	}

	TextFormatter<String> firstNameFormatter = new PreventInfinite();
	TextFormatter<String> lastNameFormatter = new PreventInfinite();
	TextFormatter<String> streetFormatter = new PreventInfinite();
	TextFormatter<String> cityFormatter = new PreventInfinite();
	TextFormatter<String> emailFormatter = new PreventInfinite();
	TextFormatter<String> passwordFormatter = new PreventInfinite();


	
	TextFormatter<String> isoDateFormatter = new TextFormatter<String>((TextFormatter.Change change) -> {
		// limit text field to 10 characters by blocking input changes
		if (change.getControlNewText().length() > 10) {
			return null;
		// if input text doesn't match the date format then block input changes
		} else if (!change.getText().matches("[0-9]*-*[0-9]*-*[0-9]*")) {
			return null;
		// otherwise, allow the changes to be applied
		} else {
			return change;
		}
	});
	TextFormatter<String> postFormatter = new TextFormatter<String>((TextFormatter.Change change) -> {
		// limit text field to 7 characters by blocking input changes
		if (change.getControlNewText().length() > 7) {
			return null;
		// if input text doesn't match alphanumeric + space in between then block input
		} else if (!change.getText().matches("[a-zA-Z0-9]* *[a-zA-Z0-9]*")) {
			return null;
		// otherwise, allow the changes to be applied
		} else {
			return change;
		}
	});
	TextFormatter<String> phoneFormatter = new TextFormatter<String>((TextFormatter.Change change) -> {
		// limit text field to 15 digits (limit specified by International Telecommunication Union)
		if (change.getControlNewText().length() > 15) {
			return null;
		// block input if not numbers
		} else if (!change.getText().matches("[0-9]*")) {
			return null;
		// otherwise, allow the changes to be applied
		} else {
			return change;
		}
	});


	public void validateDate(TextField field, Label error) {
		dobValid = false;

		// preserve original cursor position, as updating the text field through setText() will place cursor at beginning
		int originalCaretPosition = field.getCaretPosition();

		// remove any hyphens first to reformat
		String input = field.getText();
		input = input.replaceAll("-", "");

		// Insert hyphens when input is long enough
		if (input.length() > 6) {
			input = new StringBuilder(input).insert(4, "-").insert(7, "-").toString();
		} else if (input.length() > 4) {
			input = new StringBuilder(input).insert(4, "-").toString();
		}
		field.setText(input);

		// restore original cursor position after updating text field
		if ((field.getText().length() == 6 || field.getText().length() == 9) && originalCaretPosition == (field.getText().length() - 1)) {
			// if hyphen is being inserted then move cursor past it (only if typing at the end of the input, to not interfere with edits)
			field.positionCaret(originalCaretPosition + 1);
		} else {
			field.positionCaret(originalCaretPosition);
		}

		// only allow year to be between oldest living person's birth year and the current year
		if (input.matches("[0-9]{4}.*")) {
			error.setText("Invalid Date");
			field.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
			if (Integer.parseInt(input.substring(0, 4)) > Year.now().getValue()) {
				System.out.println("Year cannot be greater than the current year.");
				return;

			} else if (Integer.parseInt(input.substring(0, 4)) < OLDEST_BIRTH_YEAR) {
				System.out.println("Year cannot be before " + OLDEST_BIRTH_YEAR + ".");
				return;
			} else {
				error.setText("");
				field.setStyle("");
			}
		}

		// check if actual valid date
		if (input.length() == 10) {
			try {
				LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
				error.setText("");
				field.setStyle("");
				dobValid = true;
			}
			catch (DateTimeParseException exception) {
				System.out.println(exception.getMessage());
				error.setText("Invalid Date");
				field.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
			}
		}
	}

	public void validatePost(TextField field, Label error) {
		// preserve original cursor position, as updating the text field through setText() will place cursor at beginning
		int originalCaretPosition = field.getCaretPosition();

		// remove any spaces first to reformat
		String input = field.getText();
		input = input.replaceAll(" ", "");

		// convert lowercase letters to uppercase
		input = input.toUpperCase();

		// Insert spaces when input is long enough
		if (input.length() > 3) {
			input = new StringBuilder(input).insert(3, " ").toString();
		}
		field.setText(input);

		// restore original cursor position after updating text field
		if (field.getText().length() == 5 && originalCaretPosition == (field.getText().length() - 1)) {
			// if space is being inserted then move cursor past it (only if typing at the end of the input, to not interfere with edits)
			field.positionCaret(originalCaretPosition + 1);
		} else {
			field.positionCaret(originalCaretPosition);
		}

		// check if valid postal code
		if (input.length() == 7) {
			if (input.matches("[A-Z][0-9][A-Z] [0-9][A-Z][0-9]")) {
				error.setText("");
				field.setStyle("");
				postValid = true;
			} else {
				error.setText("Invalid Postal Code");
				field.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
				postValid = false;
			}
		}
	}
	public void validatePhone(TextField field, Label error) {
		// minimum number + country code that exists is 7 digits (island country Niue)
		// max digits already checked in TextFormatter

		if (field.getText().trim().length() >= 7) {
				error.setText("");
				field.setStyle("");
				phoneValid = true;
		} else {
				error.setText("Invalid Phone Number");
				field.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
				phoneValid = false;
		}

	}

	public void validateEmail(TextField field, Label error) {
		field.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
		emailValid = false;

		// check if email taken
		if (new UserList().matchEmail(field.getText()) != null) {
			error.setText("Email address in use.");
		// NOTE: Email validation is actually very complex. The only consistent requirement is that it contains something@something. Beyond that, the best way to validate is to send an email with a verification code.
		} else if (!field.getText().matches(".+@.+")) {
			error.setText("Invalid email format.");
		} else {
			error.setText("");
			field.setStyle("");
			emailValid = true;
		}
	}

	public void validatePassword(TextField password1, TextField password2, Label error) {
		password1.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
		password2.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
		passwordValid = false;

		if (password1.getText().trim().length() < 8) {
			error.setText("Password less than 8 characters.");
		} else if (!password1.getText().equals(password2.getText())) {
			error.setText("Passwords don't match.");
		} else {
			error.setText("");
			password1.setStyle("");
			password2.setStyle("");
			passwordValid = true;
		}
	}
}
