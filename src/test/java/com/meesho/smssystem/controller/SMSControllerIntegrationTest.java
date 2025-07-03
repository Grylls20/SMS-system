package com.meesho.smssystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meesho.smssystem.dtos.requests.smsRequests.SendSMSRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.anyString;
import com.meesho.smssystem.util.EmailService;
import com.meesho.smssystem.util.TwilioSMSService;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

@SpringBootTest
@AutoConfigureMockMvc
public class SMSControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmailService emailService;
    @MockBean
    private TwilioSMSService twilioSMSService;

    @Test
    void sendSMS_onlySMS_success() throws Exception {
        SendSMSRequest req = new SendSMSRequest();
        req.setPhone_number("1234567890");
        req.setMessage("Test SMS");
        req.setDeliveryChannel(SendSMSRequest.DeliveryChannel.SMS);
        try (MockedStatic<TwilioSMSService> twilioMock = Mockito.mockStatic(TwilioSMSService.class)) {
            twilioMock.when(() -> TwilioSMSService.sendSMS(Mockito.anyString(), Mockito.anyString())).thenReturn("MOCKED");
            mockMvc.perform(post("/v1/sms/send")
                    .header("Authorization", "piyush123")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(req)))
                    .andExpect(status().isCreated());
        }
    }

    @Test
    void sendSMS_onlyEmail_success() throws Exception {
        SendSMSRequest req = new SendSMSRequest();
        req.setPhone_number("1234567890");
        req.setMessage("Test Email");
        req.setEmail("test@example.com");
        req.setDeliveryChannel(SendSMSRequest.DeliveryChannel.EMAIL);
        doNothing().when(emailService).sendEmail(anyString(), anyString(), anyString());
        mockMvc.perform(post("/v1/sms/send")
                .header("Authorization", "piyush123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated());
    }

    @Test
    void sendSMS_both_success() throws Exception {
        SendSMSRequest req = new SendSMSRequest();
        req.setPhone_number("1234567890");
        req.setMessage("Test Both");
        req.setEmail("test@example.com");
        req.setDeliveryChannel(SendSMSRequest.DeliveryChannel.BOTH);
        doNothing().when(emailService).sendEmail(anyString(), anyString(), anyString());
        try (MockedStatic<TwilioSMSService> twilioMock = Mockito.mockStatic(TwilioSMSService.class)) {
            twilioMock.when(() -> TwilioSMSService.sendSMS(Mockito.anyString(), Mockito.anyString())).thenReturn("MOCKED");
            mockMvc.perform(post("/v1/sms/send")
                    .header("Authorization", "piyush123")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(req)))
                    .andExpect(status().isCreated());
        }
    }

    @Test
    void sendSMS_emailMissingForEmailChannel_badRequest() throws Exception {
        SendSMSRequest req = new SendSMSRequest();
        req.setPhone_number("1234567890");
        req.setMessage("Test Email");
        req.setDeliveryChannel(SendSMSRequest.DeliveryChannel.EMAIL);
        mockMvc.perform(post("/v1/sms/send")
                .header("Authorization", "piyush123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void sendSMS_emailMissingForBothChannel_badRequest() throws Exception {
        SendSMSRequest req = new SendSMSRequest();
        req.setPhone_number("1234567890");
        req.setMessage("Test Both");
        req.setDeliveryChannel(SendSMSRequest.DeliveryChannel.BOTH);
        mockMvc.perform(post("/v1/sms/send")
                .header("Authorization", "piyush123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isBadRequest());
    }
}
