import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App{

   public static String getIP()
   {
       String sip="";
       try {
           InetAddress ip;
           
           ip = InetAddress.getLocalHost();
           sip=(ip.getHostAddress().toString());
       } catch (UnknownHostException ex) {
           Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
       }
       return sip;
        }
 public static String getMAC()
 {
      String macadd="";
       try {
          
           
           InetAddress ip;
           
           ip = InetAddress.getLocalHost();
           
           NetworkInterface network = NetworkInterface.getByInetAddress(ip);
           
           byte[] mac;
           mac = network.getHardwareAddress();
           
           System.out.print("Current MAC address : ");
           
           StringBuilder sb = new StringBuilder();
           for (int i = 0; i < mac.length; i++) {
               sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
           }
           macadd=sb.toString();
       } catch (UnknownHostException | SocketException ex) {
           Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
       }

	return macadd;
 }

}