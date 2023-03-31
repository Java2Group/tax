package tax;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author Brandon Yaeck
 */
public class InputValidator {

	final static int OLDEST_BIRTH_YEAR = 1907;
	
	TextFormatter<String> isoDateFormatter = new TextFormatter<String>((TextFormatter.Change change) -> {
		// limit text field to 10 characters by blocking input changes
		if (change.getControlNewText().length() > 10) {
			return null;
		// if input text doesn't match the date format then block input changes
		} else if (!change.getText().matches("[0-9]*-*[0-9]*-*[0-9]*")) {
			return null;
		} else if (change.isContentChange()) {
		}

		// otherwise, allow the changes to be applied
		return change;
	});

	public void validateDate(TextField field) {
		System.out.println();
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
			if (Integer.parseInt(input.substring(0, 4)) > Year.now().getValue()) {
				System.out.println("Year cannot be greater than the current year.");

			} else if (Integer.parseInt(input.substring(0, 4)) < OLDEST_BIRTH_YEAR) {
				System.out.println("Year cannot be before " + OLDEST_BIRTH_YEAR + ".");
			}
		}

		// check if actual valid date
		if (input.length() == 10) {
			try {
				LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
				System.out.println("GOODFORMAT");
			}
			catch (DateTimeParseException exception) {
				System.out.println(exception.getMessage());
			}

		}
	}
}
