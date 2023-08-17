package server.util_server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
    private static final int RADIX = 16;
    private static final int MIN_LENGTH = 32;

    private PasswordEncryptor(){
    }
    public static String encryptPassword(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder(no.toString(RADIX));
            while (hashText.length() < MIN_LENGTH) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
