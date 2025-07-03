package com.meesho.smssystem.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioSMSService {

    // Replace with real Twilio credentials
    private static final String ACCOUNT_SID = "ACc29ded2f1f0e6643f4081608a7df8392";
    private static final String AUTH_TOKEN = "936aec272382085922a9028cb8d41ea1";
    private static final String FROM_PHONE = "+18564925332"; // Your Twilio phone number

    public static String sendSMS(String to, String body) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(FROM_PHONE),
                    body
            ).create();

            return "✅ SMS sent! SID: " + message.getSid();
        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Error sending SMS: " + e.getMessage();
        }
    }
}