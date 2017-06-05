/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author rahul
 */




public class MobileSms {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACca407bcfde3347533f09a01c082028d1";
  public static final String AUTH_TOKEN = "38fee3e1190a10676cccd60ebf5c9c3e";

  public static void sendMsg(String msg){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message;
      message = Message.creator(new PhoneNumber("+919525926191"),new PhoneNumber("+13369398876"), msg).create();

   // System.out.println(message.getSid());
  }
}