package tax;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Brandon Yaeck
 */
public class PasswordHandler {

	public byte[] createSalt() {
		byte[] salt = new byte[16];

		// changes the values of salt array with random bytes
		new SecureRandom().nextBytes(salt);

		return salt;
	}

	public byte[] createPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// creating a key from the user's password and salt to be encrypted
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);

		// encrypt the key
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = factory.generateSecret(spec).getEncoded();

		// destroying original password by filling it with 0s for security
		Arrays.fill(password.toCharArray(), Character.MIN_VALUE);
		// clear the internal copy of the password for security
		spec.clearPassword();

		return hash;
	}

	public boolean passwordMatches(String passwordInput, User user) {
		// get the saved password hash and salt
		String matchedUserPasswordHash = user.getPasswordHash();
		String matchedUserSalt = user.getPasswordSalt();
		byte[] passwordInputHash;

		try {
			// hash the input password with the saved salt
			passwordInputHash = createPasswordHash(passwordInput, Base64.getDecoder().decode(matchedUserSalt));
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
			System.out.println(exception.getMessage());
			Popup.error(exception, "Error creating password hash", "Failed to create password hash: ");
			return false;
		}

		// if the input password hash matches the saved password hash
		return Base64.getEncoder().encodeToString(passwordInputHash).equals(matchedUserPasswordHash);
	}
}
