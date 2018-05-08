package decryptor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

import com.walmart.services.security.encryption.EncryptionUtil;

import javax.crypto.Cipher;

public class AES {
    public static void main(String[] args) throws Exception {
            System.setProperty("keystore", "/Users/schaud3/test/ebf0/ebf/portal-aes-keystore.jck");
            System.setProperty("storepass", "mpportal");
            System.setProperty("alias", "jceksaes");
            System.setProperty("keypass", "mpportal");
            String encryptedString = "wd2yOmabEubf00tNfpmJGg==";
            //System.out.println(EncryptionUtil.decrypt(String.valueOf(Base64.getEncoder().encode(encryptedString.getBytes()))));
        System.out.println(SecurityUtil.decrypt(encryptedString));
    }

}
