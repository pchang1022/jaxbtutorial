package com.phoebe.chang.mockito.arguement.capture;

/**
 * Created by phoebe on 8/23/15.
 */
public class MailDeliverer {

    private ExternalMailSystem externalMailSystem;

    public void deliver(String address, String body) {
        Email email = new Email();
        email.setBody(body);
        applyUserAndDomainUsingProvidedAddress(address, email);
        externalMailSystem.send(email);
    }

    public void deliver(String address, String body, Boolean receiptRequested) {
        Email email = new Email();
        email.setBody(body);
        applyUserAndDomainUsingProvidedAddress(address, email);
        externalMailSystem.send(email, receiptRequested);
    }

    private void applyUserAndDomainUsingProvidedAddress(String address, Email email) {
        //TODO - refactor this into the Email class (constructor? smart accessor?)
        String[] addressComponents = address.split("@");
        email.setUser(addressComponents[0]);
        email.setDomain(addressComponents[1]);
    }

    public void setExternalMailSystem(ExternalMailSystem externalMailSystem) {
        this.externalMailSystem = externalMailSystem;
    }
}

