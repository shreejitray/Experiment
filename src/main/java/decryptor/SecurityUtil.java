package decryptor;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Created by skum150 on 28/12/16.
 */
public class SecurityUtil {

    private static final String ALGO_NAME = "PBEWithMD5AndDES";
    private static final String UTF_ENCODING = "UTF-8";

    private static final char[] PASSWORD =  "partnerservice-app".toCharArray();  // This PASSWORD should be passed as System.property (-D) to make it more secure
    private static final int ITERATION_COUNT = 128;
    private static final byte[] SALT = {
            (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
            (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };

    private static Cipher getCipher(int cipherMode) throws
            NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, InvalidAlgorithmParameterException,
            InvalidKeyException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGO_NAME);
        SecretKey secretKey = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));

        Cipher pbeCipher = Cipher.getInstance(ALGO_NAME);
        pbeCipher.init(cipherMode, secretKey, new PBEParameterSpec(SALT, ITERATION_COUNT));

        return pbeCipher;
    }

  
    public static String encrypt(String plainText) throws Exception {
        try {
            Cipher pbeCipher = getCipher(Cipher.ENCRYPT_MODE);

            // Encrypt PlainText
            byte[] plainTextBytes = plainText.getBytes(UTF_ENCODING);
            byte[] enryptedByte = pbeCipher.doFinal(plainTextBytes);

            // Return Base64 encoded String
            return base64Encode(enryptedByte);
        } catch (Exception excp) {
            throw new Exception(excp);
        }
    }

    
    public static String decrypt(String encryptedText) throws Exception {
        try {
            Cipher pbeCipher = getCipher(Cipher.DECRYPT_MODE);

            // Decode to Base64
            byte[] decodedBytes = base64Decode(encryptedText);

            // Decrypt
            byte[] decryptedBytes = pbeCipher.doFinal(decodedBytes);

            return new String(decryptedBytes, UTF_ENCODING);
        } catch(Exception excp) {
            throw new Exception(excp);
        }
    }

    private static String base64Encode(byte[] bytes) throws UnsupportedEncodingException{
        String encodedString = new String(Base64.getEncoder().encode(bytes));
        return encodedString;
    }


    private static byte[] base64Decode(String encodedText) {
         return Base64.getDecoder().decode(encodedText);
    }
    
}
