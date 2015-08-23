package com.phoebe.chang.mockito.arguement.capture;

/**
 * Created by phoebe on 8/23/15.
 */
public interface ExternalMailSystem {

    void send(String domain, String user, String body);

    void send(Email email);

    void send(Email email, Boolean receiptRequested);
}
