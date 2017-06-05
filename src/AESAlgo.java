import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.util.Scanner;
public class AESAlgo
{
public static String algo="AES";
public static  byte[] keyValue;


//elaspsed time in seconds

public static Key generateKey() throws Exception
{
    String text="lv39ertyrertyuie";
    keyValue=text.getBytes();
Key key=new SecretKeySpec(keyValue,algo);
return key;
}
public static String encrypt(String msg) throws Exception
{
Key key=generateKey();
Cipher c=Cipher.getInstance(algo);
c.init(Cipher.ENCRYPT_MODE,key);
byte[] encVal=c.doFinal(msg.getBytes());
String encryptedValue= new BASE64Encoder().encode(encVal);
return encryptedValue;
}
public static String decrypt(String msg) throws Exception
{
Key key=generateKey();
Cipher c=Cipher.getInstance(algo);
c.init(Cipher.DECRYPT_MODE,key);
byte[] decordedValue;
    decordedValue = new BASE64Decoder().decodeBuffer(msg);
byte[] decVal=c.doFinal(decordedValue);
String decryptedValue=new String(decVal);
return decryptedValue;
}
}
