import java.security.SecureRandom;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
class Des {
private static final String ALGORITHM = "DES/CBC/PKCS5Padding";
private static final String KEY_ALGORITHM = "DES";
private Cipher encryptCipher;
private Cipher decryptCipher;
public Des(byte[] key, byte[] iv) throws Exception {
SecretKeySpec keySpec = new SecretKeySpec(key, KEY_ALGORITHM);
IvParameterSpec ivSpec = new IvParameterSpec(iv);
encryptCipher = Cipher.getInstance(ALGORITHM);
encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
decryptCipher = Cipher.getInstance(ALGORITHM);
decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
}
public String encrypt(String str) throws Exception {
byte[] utf8 = str.getBytes("UTF-8");
byte[] encrypted = encryptCipher.doFinal(utf8);
return Base64.getEncoder().encodeToString(encrypted);
}
public String decrypt(String str) throws Exception {

byte[] dec = Base64.getDecoder().decode(str);
byte[] decrypted = decryptCipher.doFinal(dec);
return new String(decrypted, "UTF-8");
}
public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
final String secretText = sc.nextLine();
System.out.println("Secret Text: " + secretText);

SecureRandom random = new SecureRandom();
byte[] key = new byte[8];
random.nextBytes(key);

byte[] iv = new byte[8];
random.nextBytes(iv);
Des encrypter = new Des(key, iv);
String encrypted = encrypter.encrypt(secretText);
System.out.println("Encrypted Value: " + encrypted);
String decrypted = encrypter.decrypt(encrypted);
System.out.println("Decrypted: " + decrypted);
sc.close();
}
}
