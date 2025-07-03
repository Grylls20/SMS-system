package com.meesho.smssystem.dtos.requests.smsRequests;

import com.meesho.smssystem.constants.Constants;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
public class SendSMSRequest {
    @Pattern(regexp = Constants.regexpForPhoneNumber)
    private String phone_number;
    @NotNull(message = "Message must not be null")
    private String message;
    private String email; // Optional: for email delivery
    private DeliveryChannel deliveryChannel; // SMS, EMAIL, BOTH

    public enum DeliveryChannel {
        SMS, EMAIL, BOTH
    }

    // Conditional validation for phone_number and email
    @AssertTrue(message = "phone_number is required for SMS or BOTH delivery")
    private boolean isPhoneNumberValid() {
        if (deliveryChannel == DeliveryChannel.SMS || deliveryChannel == DeliveryChannel.BOTH) {
            return phone_number != null && !phone_number.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "email is required for EMAIL or BOTH delivery")
    private boolean isEmailValid() {
        if (deliveryChannel == DeliveryChannel.EMAIL || deliveryChannel == DeliveryChannel.BOTH) {
            return email != null && !email.isEmpty();
        }
        return true;
    }
}
