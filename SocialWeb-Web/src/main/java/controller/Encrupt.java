package controller;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.DigestUtils;

public class Encrupt {

  public String getEncryptedMd5ApacheAndAES(String data) {
    //md5Apache
    String keyEncrypt = "Lig12345Gil12345";
    String md5Hex = DigestUtils.md5Hex(data);
    String encrypt = null;

    try {
      String key = "Bar12345Bar12345"; // 128 bit key
      // Create key and cipher
      Key aesKey = new SecretKeySpec(keyEncrypt.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      // encrypt the text
      cipher.init(Cipher.ENCRYPT_MODE, aesKey);
      byte[] encrypted = cipher.doFinal(md5Hex.getBytes());
      encrypt = (new String(encrypted));
      // decrypt the text
//      cipher.init(Cipher.DECRYPT_MODE, aesKey);
//      String decrypted = new String(cipher.doFinal(encrypted));
//      System.err.println(decrypted);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return encrypt;
  }
}