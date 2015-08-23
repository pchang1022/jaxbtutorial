package com.phoebe.chang.mockito.arguement.capture;

import org.mockito.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

/**
 * Created by phoebe on 8/23/15.
 */
@Test
public class MailDelivererTest2 {
    @Mock
    private ExternalMailSystem externalMailSystem;

    @InjectMocks
    private MailDeliverer mailDeliverer;

    @Captor
    ArgumentCaptor<Email> emailCaptor;

    @Captor
    ArgumentCaptor<Boolean> receiptRequestedCaptor;




    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    public void sendsEmailByConstructingEmailObject() {
        String expectedUser = "tim";
        String expectedDomain = "wingfield.com";
        String expectedBody = "Hi Tim!";
        Boolean receiptRequested = true;

        mailDeliverer.deliver(expectedUser+"@"+expectedDomain,expectedBody, receiptRequested);

        verify(externalMailSystem).send(emailCaptor.capture(), receiptRequestedCaptor.capture());
        Email email = emailCaptor.getValue();

        assertThat(email.getUser()).isEqualTo(expectedUser);
        assertThat(email.getDomain()).isEqualTo(expectedDomain);
        assertThat(email.getBody()).isEqualTo(expectedBody);

        assertThat(receiptRequestedCaptor.getValue()).isEqualTo(receiptRequested);
    }

}