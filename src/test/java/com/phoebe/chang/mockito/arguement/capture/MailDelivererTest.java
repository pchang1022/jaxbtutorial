package com.phoebe.chang.mockito.arguement.capture;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

/**
 * Created by phoebe on 8/23/15.
 */
@Test
public class MailDelivererTest {

    private ExternalMailSystem externalMailSystem;

    private MailDeliverer mailDeliverer;

    @BeforeMethod
    public void setUp() throws Exception {
        mailDeliverer = new MailDeliverer();
        externalMailSystem = Mockito.mock(ExternalMailSystem.class);

        mailDeliverer.setExternalMailSystem(externalMailSystem);
    }

    public void sendsEmailByConstructingEmailObject() {
        String expectedUser = "tim";
        String expectedDomain = "wingfield.com";
        String expectedBody = "Hi Tim!";
        ArgumentCaptor<Email> emailCaptor = ArgumentCaptor.forClass( Email.class );

        mailDeliverer.deliver(expectedUser+"@"+expectedDomain,expectedBody);

        verify(externalMailSystem).send(emailCaptor.capture());
        Email email = emailCaptor.getValue();

        assertThat(email.getUser()).isEqualTo(expectedUser);
        assertThat(email.getDomain()).isEqualTo(expectedDomain);
        assertThat(email.getBody()).isEqualTo(expectedBody);
    }

}